package com.mikirinkode.libraryapp.user;

import com.mikirinkode.libraryapp.library.Book;

// inherit kelas User
public class Admin extends User {

    // constructor kelas Admin yang memanggil constructor kelas Parent nya
    public Admin(String fullName, String username, String password) {
        super(fullName, username, password, "Admin");
    }

    void updateBookProperties(Book book, String title, String category, String authorName, int releaseDate) {
        book.updateDetail(title, category, authorName, releaseDate);
        System.out.println("Buku " + title + " berhasil diperbaharui");
    }

    void addNewBook(String bookTitle, String bookCategory, String authorName, int releaseDate) {
        Book book = new Book(bookTitle, bookCategory, authorName, releaseDate);
        System.out.println("Berhasil menambahkan " + bookTitle + " ke data Perpustakaan.");
    }
}
