package com.mikirinkode.libraryapp.dummy;

import com.mikirinkode.libraryapp.library.Book;

import java.util.ArrayList;

public class DummyData {
    ArrayList<Book> generateBooksData() {
        ArrayList<Book> bookList = new ArrayList<Book>();

        bookList.add(new Book(
                "Keluh Kesah Programmer",
                "Motivasi",
                "Muhammad Wafa",
                "2099"));
        bookList.add(new Book(
                "Programmer adalah Makhluk Malam",
                "Fiksi",
                "Muhammad Wafa",
                "2077"));
        bookList.add(new Book(
                "10 Tips Jitu Ngoding 24 Jam Non-Stop!",
                "Tips & Trik",
                "Muhammad Wafa",
                "2055"));

        return bookList;
    }
}
