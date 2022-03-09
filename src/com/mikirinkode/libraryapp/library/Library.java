package com.mikirinkode.libraryapp.library;

import com.mikirinkode.libraryapp.dummy.DummyData;
import com.mikirinkode.libraryapp.user.Admin;
import com.mikirinkode.libraryapp.user.LibraryMember;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<LibraryMember> libraryMemberList = new ArrayList<LibraryMember>();
    private ArrayList<Admin> libraryAdmin = new ArrayList<Admin>();
    private ArrayList<Book> libraryBooks = DummyData.generateBookList();
    private String userLoggedType = "Member";
    private String libraryName = "Perpustakaan Hijau";

    // inisialisasi kelas scanner untuk Input User
    Scanner sc = new Scanner(System.in);

    public Library() {
        // inisialisasi sample member dan admin perpustakaan
        libraryMemberList.add(new LibraryMember("Muhammad Wafa", "wafa01", "12345678"));
        libraryAdmin.add(new Admin("Admin Perpus", "adminPerpus", "adminPerpus1234"));

        System.out.println("===================================");
        System.out.println("Selamat Datang di " + libraryName);
        System.out.println("===================================");
        System.out.println("1. Login");
        System.out.println("2. Daftar");
        System.out.print("Pilihan [1/2]: ");
        int userChoice = sc.nextInt();
        switch (userChoice) {
            case 1 -> login();
            case 2 -> signup();
            default -> System.out.println("Invalid Input!");
        }

        menu();
    }
    private void menu() {

    }


    private void login(){
        System.out.println("Silahkan login terlebih dahulu.");
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        // validasi login
        // TODO: Pke for each
    }


    private void signup() {
        System.out.println("Silahkan buat akun anda");
        System.out.print("Nama lengkap: ");
        String fullname = sc.nextLine();

        System.out.print("Username: ");
        String username = sc.next();

        System.out.print("Password: ");
        String password = sc.next();
        LibraryMember newUser = new LibraryMember(fullname, username, password);
        libraryMemberList.add(newUser);

        System.out.println("Akun berhasil dibuat.\n");
        login();
    }

    private void adminMenu(){

    }

    private void memberMenu(){

    }
}

