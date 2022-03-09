package com.mikirinkode.libraryapp.library;

import com.mikirinkode.libraryapp.dummy.DummyData;
import com.mikirinkode.libraryapp.user.Admin;
import com.mikirinkode.libraryapp.user.LibraryMember;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private final ArrayList<Book> libraryBooks = DummyData.generateBookList();
    // inisialisasi kelas scanner untuk Input User
    private Scanner sc = new Scanner(System.in);
    private final ArrayList<LibraryMember> memberList = new ArrayList<>();
    private final ArrayList<Admin> adminList = new ArrayList<>();
    private final String libraryName = "Perpustakaan Hijau";
    private boolean menuActiveStatus = true;

    public Library() {
        // inisialisasi sample member dan admin perpustakaan
        memberList.add(new LibraryMember("Muhammad Wafa", "wafa01", "12345678"));
        adminList.add(new Admin("Admin Perpus", "adminPerpus", "adminPerpus1234"));

        System.out.println("====================================");
        System.out.println("Selamat Datang di " + libraryName);
        System.out.println("====================================");
        menu();
    }

    private void menu() {
        System.out.println("1. Login");
        System.out.println("2. Daftar");
        System.out.print("Pilihan [1/2]: ");

        while (true) {
            try {
                int userChoice = sc.nextInt();
                sc.nextLine();  // untuk ambil input hingga akhir baris pada nextInt sebelumnya
                switch (userChoice) {
                    case 1 -> login();
                    case 2 -> signup();
                    default -> System.out.println("Invalid Input!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! \n");
                System.out.println("1. Login");
                System.out.println("2. Daftar");
                System.out.print("Pilihan [1/2]: ");
                sc.nextLine();
            }
        } // akhir while loop
    } // akhir function


    private void login() {
        System.out.println("\nSilahkan login terlebih dahulu.");
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        // validasi login
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                adminMenu();
                break;
            } else if (!memberList.isEmpty()){ // jika user bukan admin, maka cek memberList
                // looping setiap objek member yang telah dibuat
                for (LibraryMember member : memberList) {
                    // mengecek username dan password
                    if (member.getUsername().equals(username) && member.getPassword().equals(password)) {
                        memberMenu();
                        break;
                    }
                } // end for loop
            } else { // jika bukan admin dan member, maka login invalid
                System.out.println("Username or Password Invalid.\n");
                menu();
                break;
            }
        } // end for loop
    }

    private void signup() {
        System.out.println("\nSilahkan buat akun anda.");
        System.out.print("Nama lengkap: ");
        String fullname = sc.nextLine();

        System.out.print("Username: ");
        String username = sc.next();

        System.out.print("Password: ");
        String password = sc.next();

        // menambahkan member baru
        LibraryMember newUser = new LibraryMember(fullname, username, password);
        memberList.add(newUser);

        System.out.println("Akun berhasil dibuat.");
        login();
    }

    private void adminMenu() {
        System.out.println("Anda berhasil login sebagai admin.");
        System.out.println("Menu:");
        System.out.println("1. Update Informasi Buku");
        System.out.println("2. List Buku yang terdaftar");
        System.out.println("3. Tambah Admin");
        System.out.println("4. EXIT");
        System.out.print("Pilihan [1-4]: ");

        while (menuActiveStatus) {
            try {
                int userChoice = sc.nextInt();
                sc.nextLine();  // untuk ambil input hingga akhir baris pada nextInt sebelumnya
                switch (userChoice) {
                    case 1 -> updateBookDetail();
                    case 2 -> displayBookList();
                    case 3 -> addNewAdmin();
                    case 4 -> exit();
                    default -> System.out.println("Invalid Input!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! \n");
                System.out.println("1. Update Informasi Buku");
                System.out.println("2. Daftar Buku");
                System.out.println("3. Tambah Admin");
                System.out.println("4. EXIT");
                System.out.print("Pilihan [1-4]: ");
                sc.nextLine();
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

    private void memberMenu() {
        System.out.println("Anda berhasil login sebagai member.");
    }

    void exit() {
        sc.close();
        menuActiveStatus = false;
    }
    
    /*
        Getter Setter
     */
    public ArrayList<Book> getLibraryBooks() {
        return libraryBooks;
    }
}

