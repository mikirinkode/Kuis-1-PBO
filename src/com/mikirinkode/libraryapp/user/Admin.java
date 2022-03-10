package com.mikirinkode.libraryapp.user;

import com.mikirinkode.libraryapp.library.Book;

import java.util.ArrayList;
import java.util.Scanner;

// inherit kelas User
public class Admin extends User {
    // inisialisasi kelas scanner untuk Input User
    private Scanner input = new Scanner(System.in);

    // constructor kelas Admin yang memanggil constructor kelas Parent nya
    public Admin(String fullName, String username, String password) {
        super(fullName, username, password, "Admin");
    }

    /*
        TODO: add update book method in library class
     */
    public void updateBookProperties(Book book, String title, String category, String authorName, int releaseDate) {
        book.updateDetail(title, category, authorName, releaseDate);
        System.out.println("Buku " + title + " berhasil diperbaharui");
    }

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

        libraryBooks.add(new Book(bookTitle, bookCategory, authorName, releaseDate));
        System.out.println("Berhasil menambahkan buku \"" + bookTitle + "\" ke data Perpustakaan.");
    }
}
