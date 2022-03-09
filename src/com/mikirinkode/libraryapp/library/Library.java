package com.mikirinkode.libraryapp.library;

import com.mikirinkode.libraryapp.dummy.DummyData;
import com.mikirinkode.libraryapp.user.Admin;
import com.mikirinkode.libraryapp.user.LibraryMember;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private final ArrayList<Book> libraryBooks = DummyData.generateBookList();
    private final ArrayList<LibraryMember> memberList = new ArrayList<>();
    private final ArrayList<Admin> adminList = new ArrayList<>();
    private final String libraryName;
    private Admin loggedInAdmin;
    private LibraryMember loggedInMember;
    private boolean isMenuActive = true;

    // inisialisasi kelas scanner untuk Input User
    private Scanner input = new Scanner(System.in);

    public Library(String libraryName) {
        // inisialisasi sample member dan admin perpustakaan
        memberList.add(new LibraryMember("Muhammad Wafa", "wafa01", "12345678"));
        adminList.add(new Admin("Admin Perpus", "adminPerpus", "adminPerpus1234"));
        this.libraryName = libraryName;

        System.out.println("====================================");
        System.out.println("Selamat Datang di " + getLibraryName());
        System.out.println("====================================");
    }

    public void adminMenu() {
        System.out.println("Anda berhasil login sebagai admin.");
        isMenuActive = true;
        while (isMenuActive) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Daftar Buku");
            System.out.println("3. LOGOUT");
            System.out.print("Masukkan Pilihan [1-3]: ");
            try {
                int userChoice = input.nextInt();
                input.nextLine();  // untuk ambil input hingga akhir baris pada nextInt sebelumnya
                switch (userChoice) {
                    case 1 -> addNewBook();
                    case 2 -> displayBookList();
                    case 3 -> logout();
                    default -> System.out.println("Invalid Input!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! \n");
                input.nextLine();
            }
        } // akhir while loop
    } // akhir method

    /*
        method admin untuk menambahkan buku baru
        memanggil fungsi bawaan kelas admin yaitu addNewBook()
        dengan argumen list book -> getLibraryBook()
     */
    private void addNewBook() {
        getLoggedAdmin().addNewBook(getLibraryBooks());
    }

    // method nampilin seluruh buku yang ada
    private void displayBookList() {
        System.out.println("\n=======================");
        System.out.println("Menampilkan Daftar Buku");
        System.out.println("=======================");
        for (Book book : getLibraryBooks()) {
            System.out.println();
            book.printBookDetail();
        }
    }

    public void memberMenu() {
        System.out.println("Anda berhasil login.");
        isMenuActive = true;
        while (isMenuActive) {
            System.out.println("\nMenu Member:");
            System.out.println("1. Tampilkan Daftar Buku");
            System.out.println("2. Menu Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Riwayat Peminjaman");
            System.out.println("5. LOGOUT");
            System.out.print("Masukkan Pilihan [1-5]: ");
            try {
                int userChoice = input.nextInt();
                input.nextLine();  // untuk ambil input hingga akhir baris pada nextInt sebelumnya
                switch (userChoice) {
                    case 1 -> displayBookList();
                    case 2 -> bookBorrowing();
                    case 3 -> bookReturning();
                    case 4 -> displayUserBorrowingHistory();
                    case 5 -> logout();
                    default -> System.out.println("Invalid Input!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! \n");
                input.nextLine();
            }
        } // akhir while loop
    } // akhir method

    /*
        method untuk member meminjam buku
        memanggil fungsi bawaan kelas LibraryMember yaitu borrowOneBook()
        dengan argumen list book -> getLibraryBook()
     */
    private void bookBorrowing() {
        getLoggedMember().borrowOneBook(getLibraryBooks());
    }

    // method untuk member mengembalikan
    private void bookReturning() {
        getLoggedMember().returnBook();
    }

    // method untuk menampilkan riwayat peminjaman buku
    private void displayUserBorrowingHistory() {
        getLoggedMember().displayBorrowingHistory();
    }

    void logout() {
        setLoggedMember(null); // set ke null
        setLoggedAdmin(null); // set ke null
        LoginManager.setIsLogManagerActive(true); // mengaktifkan menu pada kelas LoginManager
        System.out.println("\nBerhasil logout.");
        isMenuActive = false;
    }


    /*
        Getter Setter
     */
    public Admin getLoggedAdmin() {
        return loggedInAdmin;
    }

    public void setLoggedAdmin(Admin loggedInAdmin) {
        this.loggedInAdmin = loggedInAdmin;
    }

    public LibraryMember getLoggedMember() {
        return loggedInMember;
    }

    public void setLoggedMember(LibraryMember loggedInMember) {
        this.loggedInMember = loggedInMember;
    }

    public ArrayList<Book> getLibraryBooks() {
        return libraryBooks;
    }

    public ArrayList<LibraryMember> getMemberList() {
        return memberList;
    }

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }

    public String getLibraryName() {
        return libraryName;
    }
}

