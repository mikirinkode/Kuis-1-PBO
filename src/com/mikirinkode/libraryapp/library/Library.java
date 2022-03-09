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
        System.out.println("Menu:");
        System.out.println("1. Update Informasi Buku");
        System.out.println("2. List Buku yang terdaftar");
        System.out.println("3. Tambah Admin");
        System.out.println("4. logout");
        System.out.print("Pilihan [1-4]: ");

        while (menuActiveStatus) {
            try {
                int userChoice = input.nextInt();
                input.nextLine();  // untuk ambil input hingga akhir baris pada nextInt sebelumnya
                switch (userChoice) {
                    case 1 -> updateBookDetail();
                    case 2 -> displayBookList();
                    case 3 -> addNewAdmin();
                    case 4 -> logout();
                    default -> System.out.println("Invalid Input!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! \n");
                System.out.println("1. Update Informasi Buku");
                System.out.println("2. Daftar Buku");
                System.out.println("3. Tambah Admin");
                System.out.println("4. logout");
                System.out.print("Pilihan [1-4]: ");
                input.nextLine();
            }
        } // akhir while loop
    }

    private void updateBookDetail() {
    }

    private void displayBookList() {
        System.out.println("Menampilkan Daftar Buku");
    }


    private void addNewAdmin() {
    }

    public void memberMenu() {
        System.out.println("Anda berhasil login sebagai member.");
    }

    void logout() {
        input.close();
        menuActiveStatus = false;
    }
    
    /*
        Getter Setter
     */
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

