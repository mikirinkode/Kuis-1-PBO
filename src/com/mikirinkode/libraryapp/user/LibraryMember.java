package com.mikirinkode.libraryapp.user;

import com.mikirinkode.libraryapp.library.Book;

import java.util.ArrayList;

// inherit kelas User
public class LibraryMember extends User{
    private ArrayList<Book> borrowingHistory = new ArrayList<Book>();
    private Book currentBorrowedBook = null;

    // constructor kelas Member yang memanggil constructor kelas Parent nya
    public LibraryMember(String fullName, String username, String password) {
        super(fullName, username, password, "Member");
    }

    void borrowBook(Book book){
        // TODO : User meminjam buku

        // User dapat meminjam buku, jika tidak ada buku yang ia pinjam
        if (currentBorrowedBook == null){
            currentBorrowedBook = book;
            borrowingHistory.add(book);
        } else {
            System.out.println("Setiap anggota hanya diperbolehkan meminjam 1 Buku dalam 1 waktu.");
            System.out.println("Anda sedang meminjam buku: " + this.currentBorrowedBook.getBookTitle());
            System.out.println("Harap kembalikan buku yang dipinjam terlebih dahulu sebelum meminjam kembali.");
        }
    }

    void retrieveBook(Book book){
        // TODO : User mengembalikan buku yang dipinjam
        currentBorrowedBook = null;
    }


    /*
        Getter Setter
     */
    public ArrayList<Book> getborrowingHistory() {
        return borrowingHistory;
    }

    public void setborrowingHistory(ArrayList<Book> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }
}
