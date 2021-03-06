/*
 * Copyright (c) 2022. Muhammad Wafa
 */

package com.mikirinkode.libraryapp.library;

import com.mikirinkode.libraryapp.user.Admin;
import com.mikirinkode.libraryapp.user.LibraryMember;

import java.util.Scanner;

/*
    Class untuk menangani login dan signup user
    Class ini disimulasikan sebagai static class, jadi
    Class dibuat final untuk mencegah perluasan
 */
public final class LoginManager {
    private static final Scanner input = new Scanner(System.in);
    private static boolean isLogManagerActive = true;

    // private constructor agar tidak dapat dibuat objek
    private LoginManager(){ }

    /*
        Method static agar dapat diakses langsung dari luar
        tanpa membuat objeknya dulu
     */
    public static void menu(Library library) {
        setIsLogManagerActive(true);
        while (isLogManagerActive()) {
            System.out.println("1. Login");
            System.out.println("2. Daftar");
            System.out.println("3. Exit");
            System.out.print("Masukkan Pilihan [1-3]: ");
            String userChoice = input.nextLine();
            switch (userChoice) {
                case "1" -> login(library);
                case "2" -> signup(library);
                case "3" -> {
                    setIsLogManagerActive(false);
                    System.out.println("\nKeluar program.");
                }
                default -> System.out.println("Invalid Input! \n");
            }
        } // akhir while loop
    } // akhir function


    private static void login(Library library) {
        boolean loginSuccess = false;
        System.out.println("\nSilahkan login terlebih dahulu.");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();

        // validasi login
        for (Admin admin : library.getAdminList()) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                setIsLogManagerActive(false);   // keluar dari loop pada method menu LoginManager
                library.setLoggedAdmin(admin); // menetapkan admin yang login
                library.adminMenu();    // masuk ke menu admin
                loginSuccess = true;
                break;
            } else if (!library.getMemberList().isEmpty()) { // jika user bukan admin dan memberListtidak kosong, maka cek memberList
                // looping setiap objek member yang telah dibuat
                for (LibraryMember member : library.getMemberList()) {
                    // mengecek username dan password
                    if (member.getUsername().equals(username) && member.getPassword().equals(password)) {
                        setIsLogManagerActive(false);   // keluar dari loop pada method menu LoginManager
                        library.setLoggedMember(member); // menetapkan user yang login
                        library.memberMenu();   // masuk ke menu member
                        loginSuccess = true;
                        break;
                    }
                } // end for loop
            }
        }
        if (!loginSuccess) { // jika gagal login
            System.out.println("Username or Password Invalid.\n");
            menu(library);
        }// end for loop
    }

    private static void signup(Library library) {
        System.out.println("\nSilahkan buat akun anda.");
        System.out.print("Nama lengkap: ");
        String fullname = input.nextLine();

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        // menambahkan member baru
        LibraryMember newUser = new LibraryMember(fullname, username, password);
        library.getMemberList().add(newUser);

        System.out.println("Akun berhasil dibuat.");
        login(library);
    }


    /*
        Getter Setter
     */
    public static boolean isLogManagerActive() {
        return isLogManagerActive;
    }

    public static void setIsLogManagerActive(boolean isLogManagerActive) {
        LoginManager.isLogManagerActive = isLogManagerActive;
    }
}
