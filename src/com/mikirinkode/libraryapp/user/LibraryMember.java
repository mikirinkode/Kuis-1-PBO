package com.mikirinkode.libraryapp.user;

import com.mikirinkode.libraryapp.library.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// inherit kelas User
public class LibraryMember extends User {
    private final ArrayList<Book> borrowingHistory = new ArrayList<Book>();
    private Book currentBorrowedBook = null;
    private boolean menuActiveStatus = true;
    // inisialisasi kelas scanner untuk Input User
    private Scanner input = new Scanner(System.in);

    // constructor kelas Member yang memanggil constructor kelas Parent nya
    public LibraryMember(String fullName, String username, String password) {
        super(fullName, username, password, "Member");
    }

    public void borrowOneBook(ArrayList<Book> bookList) {
        // User dapat meminjam buku, jika tidak ada buku yang ia pinjam
        if (currentBorrowedBook == null) {
            menuActiveStatus = true; // agar dapat mengakses menu
            while (menuActiveStatus) {
                System.out.println("\n=== Menu Peminjaman Buku ===");
                System.out.println("Silahkan pilih buku yang ingin anda pinjam terlebih dahulu.");
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
        } else {
            System.out.println("Setiap anggota hanya diperbolehkan meminjam 1 Buku dalam 1 waktu.");
            System.out.println("Anda sedang meminjam buku: \"" + this.currentBorrowedBook.getBookTitle() + "\".");
            System.out.println("Harap kembalikan buku yang dipinjam terlebih dahulu sebelum meminjam kembali.");
        }
    }

    private void displayAllBooks(ArrayList<Book> bookList) {
        // menampilkan seluruh buku menggunakan forEach() dan lambda expression
        bookList.forEach(book -> {
            System.out.print("ID: " + book.getBookId());
            System.out.println(" - Title: " + book.getBookTitle());
        });
        // user diminta memilih buku
        choosingBookToBorrow(bookList);
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

        // jika ada maka user diminta memilih buku
        if (isAvailable) {
            choosingBookToBorrow(bookList);
        } else {
            System.out.println("Maaf Buku tidak tersedia.");
        }
    }

    private void choosingBookToBorrow(ArrayList<Book> bookList) {
        System.out.println("Info: input '0' untuk batal.");
        System.out.print("ID buku pilihan anda: ");
        String userChoice = input.nextLine();
        if (!userChoice.equals("0")) {
            bookList.forEach(book -> {
                // jika id yang diinputkan user == id buku
                if (userChoice.equals(book.getBookId())) {
                    System.out.println("Anda ingin meminjam buku:");
                    System.out.println("\""+ book.getBookTitle() + "\"");
                    System.out.print("Konfimasi [Y/N]: ");
                    String userInput = input.nextLine();
                    if (userInput.equals("Y") || userInput.equals("y")) {
                        currentBorrowedBook = book;
                        borrowingHistory.add(book); // menambahkan riwayat peminjaman
                        System.out.println("Selamat anda berhasil meminjam buku \"" + book.getBookTitle() + "\"");
                        System.out.println("Batas waktu pengembalian adalah maks 30 hari setelah peminjaman.");
                        System.out.println("Terima kasih & Selamat Membaca.");
                        menuActiveStatus = false;
                    } else if (userInput.equals("N") || userInput.equals("n")){
                        System.out.println("Kembali ke menu sebelumnya.");
                    }
                }
            });
        }

        // jika input user buka 0 dan buku yang dipinjam == null
        if (currentBorrowedBook == null && !userChoice.equals("0")) {
            System.out.println("Invalid input");
        }
    }


    public Book returnBook() {
        Book borrowedBook = getCurrentBorrowedBook();
        if (borrowedBook == null) {
            System.out.println("\nAnda sedang tidak meminjam buku, yuk pinjam buku.");
        } else {
            System.out.println("Anda ingin mengembalikan buku:");
            System.out.println(borrowedBook.getBookTitle());
            System.out.print("Konfimasi [Y/N]: ");
            String userInput = input.nextLine();

            if (userInput.equals("Y") || userInput.equals("y")) {
                setCurrentBorrowedBook(null);
                System.out.println("Buku berhasil dikembalikan.");
                System.out.println("Sekarang anda dapat meminjam buku lagi.");
                return borrowedBook;

            } else if (userInput.equals("N") || userInput.equals("n")){
                System.out.println("Pengembalian dibatalkan");
            } else {
                System.out.println("Invalid Input!");
            }
        }
        return null;
    }


    public void displayBorrowingHistory() {
        if (getBorrowingHistory().isEmpty()) {
            System.out.println("\nBelum ada Peminjaman Buku yang anda lakukan.");
        } else {
            System.out.println("\nRiwayat Peminjaman Buku:");
            for (int i = 0; i < getBorrowingHistory().size(); i++) {
                System.out.print((i + 1) + ". ");
                System.out.println(getBorrowingHistory().get(i).getBookTitle());
            }
        }
    }

    /*
        Getter Setter
     */
    public ArrayList<Book> getBorrowingHistory() {
        return borrowingHistory;
    }

    public Book getCurrentBorrowedBook() {
        return currentBorrowedBook;
    }

    public void setCurrentBorrowedBook(Book currentBorrowedBook) {
        this.currentBorrowedBook = currentBorrowedBook;
    }
}
