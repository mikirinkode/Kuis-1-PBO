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
    private boolean menuActiveStatus = true;

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
        while (menuActiveStatus) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Menampilkan Daftar Buku");
            System.out.println("3. LOGOUT");
            System.out.print("Pilihan [1-3]: ");
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
    }

    // method admin untuk tambah buku baru
    private void addNewBook() {
        loggedInAdmin.addNewBook(getLibraryBooks());
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
        System.out.println("Anda berhasil login sebagai member.");
    }


    void logout() {
        input.close();
        menuActiveStatus = false;
        System.out.println("\nBerhasil logout.");
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

