package com.mikirinkode.libraryapp.user;

import com.mikirinkode.libraryapp.library.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.mikirinkode.libraryapp.user.InputBookType.*;

/*
    enum / enumerations yaitu special class yang merepresentasikan grup dari constant value
    pada kasus ini saya gunakan untuk mengecek input user pada method checkInput()
    supaya dapat meminimalisir kesalahan saya dalam penulisan type saat pemanggilan method dan pengecekan di switch
*/
enum InputBookType {
    TITLE,
    CATEGORY,
    AUTHOR_NAME,
    RELEASE_DATE
}

// inherit kelas User
public class Admin extends User {
    // inisialisasi kelas scanner untuk Input User
    private final Scanner input = new Scanner(System.in);
    private boolean menuActiveStatus = true;

    // constructor kelas Admin yang memanggil constructor kelas Parent nya
    public Admin(String fullName, String username, String password) {
        super(fullName, username, password, "Admin");
    }

    /*
        method tambah buku baru
     */
    public void addNewBook(ArrayList<Book> libraryBooks) {
        System.out.print("Judul Buku: ");
        String bookTitle = input.nextLine();
        System.out.print("Kategori: ");
        String bookCategory = input.nextLine();
        System.out.print("Penulis: ");
        String authorName = input.nextLine();
        System.out.print("Tahun Rilis: ");
        int releaseDate = input.nextInt();
        input.nextLine();

        // membuat objek buku baru dan menambahkannya ke ArrayList
        libraryBooks.add(new Book(bookTitle, bookCategory, authorName, releaseDate));
        System.out.println("Berhasil menambahkan buku \"" + bookTitle + "\" ke data Perpustakaan.");
    }

    /*
        method update informasi buku
     */
    public void updateBookProperties(ArrayList<Book> bookList) {
        menuActiveStatus = true; // agar dapat mengakses menu
        while (menuActiveStatus) {
            System.out.println("\n=== Menu Update Buku ===");
            System.out.println("Silahkan temukan buku yang akan dirubah.");
            System.out.println("1. Tampilkan seluruh buku");
            System.out.println("2. Tampilkan buku berdasarkan Abjad");
            System.out.println("3. Batal dan kembali");
            System.out.print("Masukkan Pilihan [1-3]: ");
            // try catch untuk mengatasi jika user salah input
            try {
                int userChoice = input.nextInt();
                input.nextLine();  // untuk ambil input hingga akhir baris pada nextInt sebelumnya
                switch (userChoice) {
                    case 1 -> displayAllBooks(bookList);
                    case 2 -> showByAlphabet(bookList);
                    case 3 -> menuActiveStatus = false;
                    default -> System.out.println("Invalid Input!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! \n");
                input.nextLine(); // untuk meminta input kembali
            }
        }
    }

    private void displayAllBooks(ArrayList<Book> bookList) {
        // menampilkan seluruh buku menggunakan forEach() dan lambda expression
        bookList.forEach(book -> {
            System.out.print("ID: " + book.getBookId());
            System.out.println(" - Title: " + book.getBookTitle());
        });
        // user diminta memilih buku
        choosingBookToUpdate(bookList);
    }

    private void showByAlphabet(ArrayList<Book> bookList) {
        boolean isAvailable = false;
        System.out.print("Masukkan huruf alphabet: ");
        String alphabet = input.nextLine();
        for (Book book : bookList) {
            // mengecek apakah ada buku yang dimulai dengan huruf yang diinput user
            if (book.getBookTitle().toLowerCase().charAt(0) == alphabet.toLowerCase().charAt(0)) {
                System.out.print("ID: " + book.getBookId());
                System.out.println(" - Title: " + book.getBookTitle());
                isAvailable = true;
            }
        }

        // jika ada maka admin diminta memilih buku
        if (isAvailable) {
            choosingBookToUpdate(bookList);
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    private void choosingBookToUpdate(ArrayList<Book> bookList) {
        boolean isIdMatched = false;
        System.out.println("Info: input '0' untuk batal.");
        System.out.print("ID buku pilihan anda: ");
        String userChoice = input.nextLine();
        if (!userChoice.equals("0")) {
            for (Book book : bookList) {
                // jika id yang diinputkan user == id buku
                if (userChoice.equals(book.getBookId())) {
                    isIdMatched = true;
                    updateBook(book);
                }
            }
        }

        if (!userChoice.equals("0") && !isIdMatched) {
            System.out.println("Invalid input");
        }
    }

    private void updateBook(Book book) {
        System.out.println("\nMenampilkan informasi sebelum diubah");
        book.printBookDetail();

        System.out.println("\n== [NOTE] Input '-' (strip) jika tidak ingin merubah. ==");
        // menerima input
        System.out.print("Judul Buku: ");
        String bookTitle = input.nextLine();
        System.out.print("Kategori: ");
        String bookCategory = input.nextLine();
        System.out.print("Penulis: ");
        String authorName = input.nextLine();
        System.out.print("Tahun Rilis: ");
        String releaseDate = input.nextLine();

        System.out.println("Anda ingin mengubah informasi buku:");
        System.out.println("\"" + book.getBookTitle() + "\"");
        System.out.print("Konfimasi [Y/N]: ");
        String userInput = input.nextLine();
        if (userInput.equals("Y") || userInput.equals("y")) {
            // jika user menginput Y atau y, maka buku akan di-update
            book.updateDetail(
                    // melakukan check apakah input nya '-' jika iya maka tidak ada perubahan
                    checkInput(book, bookTitle, TITLE),
                    checkInput(book, bookCategory, CATEGORY),
                    checkInput(book, authorName, AUTHOR_NAME),
                    Integer.parseInt(checkInput(book, releaseDate, RELEASE_DATE))
            );
            System.out.println("Buku " + bookTitle + " berhasil diperbaharui");
            menuActiveStatus = false;
        } else if (userInput.equals("N") || userInput.equals("n")) {
            System.out.println("Kembali ke menu sebelumnya.");
        }
    }

    private String checkInput(Book book, String inputUser, InputBookType type) {
        if (inputUser.equals("-")) {
            return switch (type) {
                case TITLE -> book.getBookTitle();
                case CATEGORY -> book.getBookCategory();
                case AUTHOR_NAME -> book.getAuthorName();
                case RELEASE_DATE -> String.valueOf(book.getReleaseDate());
            };
        }
        return inputUser;
    }
}
