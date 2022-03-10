package com.mikirinkode.libraryapp.dummy;
import com.mikirinkode.libraryapp.library.Book;
import java.util.ArrayList;


/**
 *  Kelas ini berguna untuk menghasilkan data dummy Buku untuk sistem Perpustakaan
 */
public final class DummyData {

    /*
        method static agar dapat di akses tanpa harus membuat objeknya terlebih dahulu
     */
    public static ArrayList<Book> generateBookList() {
        // menampung data dalam array list
        ArrayList<Book> bookList = new ArrayList<>();

        // membuat objek buku baru sekaligus menambahkannya ke list buku
        bookList.add(new Book(
                "Keluh Kesah Programmer",
                "Motivasi",
                "Muhammad Wafa",
                2083));
        bookList.add(new Book(
                "Programmer adalah Makhluk Malam",
                "Fiksi",
                "Muhammad Wafa",
                2082));
        bookList.add(new Book(
                "Pusing Ketika Ngoding ? mata panas, punggung sakit? - Bagaimana Menjadi Programmer Sehat",
                "Kesehatan Programmer",
                "Muhammad Wafa",
                2081));
        bookList.add(new Book(
                "10 Tips Jitu Ngoding 24 Jam Non-Stop!",
                "Tips & Trik",
                "Muhammad Wafa",
                2080));
        bookList.add(new Book(
                "Memahami Konsep OOP",
                "Panduan",
                "Muhammad Wafa",
                2079));
        bookList.add(new Book(
                "Dasar Dasar Pemrograman - Semua Bahasa Pemrograman itu konsepnya sama",
                "Dasar Dasar Pemrograman",
                "Muhammad Wafa",
                2078));
        bookList.add(new Book(
                "Hello World! - Memulai pemrograman dengan Java",
                "Panduan",
                "Muhammad Wafa",
                2077));

        return bookList;
    }

}
