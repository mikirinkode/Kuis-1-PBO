package com.mikirinkode.libraryapp.library;

public class Book {
    private String bookId;
    private String bookTitle;
    private String category;
    private String authorName;
    private String releaseDate;


    public Book(String bookTitle, String category, String authorName, String releaseDate) {
        this.bookTitle = bookTitle;
        this.category = category;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    void printBookDetail() {
        System.out.println("Nama Buku \t: " + bookTitle);
        System.out.println("Kategori Buku \t: " + category);
        System.out.println("Nama Penulis \t: " + authorName);
        System.out.println("Tanggal Rilis \t: " + releaseDate);
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
