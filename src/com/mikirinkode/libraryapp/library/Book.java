package com.mikirinkode.libraryapp.library;

public class Book {
    private final String bookId;
    private String bookTitle;
    private String bookCategory;
    private String authorName;
    private int releaseDate;
    private int idCounter = 0;

    public Book(String bookTitle, String bookCategory, String authorName, int releaseDate) {
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
        this.bookId = "0" + idCounter;
        this.idCounter++;
    }

    public void updateDetail(String bookTitle, String bookCategory, String authorName, int releaseDate){
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    void printBookDetail() {
        System.out.println("ID Buku \t: " + bookId);
        System.out.println("Nama Buku \t: " + bookTitle);
        System.out.println("Kategori Buku \t: " + bookCategory);
        System.out.println("Nama Penulis \t: " + authorName);
        System.out.println("Tanggal Rilis \t: " + releaseDate);
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getbookCategory() {
        return bookCategory;
    }

    public void setbookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
}
