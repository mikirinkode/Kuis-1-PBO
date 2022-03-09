package com.mikirinkode.libraryapp.dummy;
import com.mikirinkode.libraryapp.library.Book;
import java.util.ArrayList;


/**
 *  Kelas ini berguna untuk menghasilkan data dummy Buku untuk sistem Perpustakaan
 */
public class DummyData {

    public static ArrayList<Book> generateBookList() {
        ArrayList<Book> bookList = new ArrayList<Book>();

        bookList.add(new Book(
                "Keluh Kesah Programmer",
                "Motivasi",
                "Muhammad Wafa",
                2099));
        bookList.add(new Book(
                "Programmer adalah Makhluk Malam",
                "Fiksi",
                "Muhammad Wafa",
                2077));
        bookList.add(new Book(
                "Ketika Ngoding pusing? mata panas, punggung sakit? - Bagaimana Menjadi Programmer Sehat",
                "Kesehatan Programmer",
                "Muhammad Wafa",
                2077));
        bookList.add(new Book(
                "10 Tips Jitu Ngoding 24 Jam Non-Stop!",
                "Tips & Trik",
                "Muhammad Wafa",
                2055));
        bookList.add(new Book(
                "Memahami Konsep OOP",
                "Panduan",
                "Muhammad Wafa",
                2045));
        bookList.add(new Book(
                "Dasar Dasar Pemrograman - Semua Bahasa Pemrograman itu konsepnya sama",
                "Dasar Dasar Pemrograman",
                "Muhammad Wafa",
                2045));

        return bookList;
    }

}
