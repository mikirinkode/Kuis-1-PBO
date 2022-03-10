package com.mikirinkode.libraryapp.library;


public class Book {
    // atribut
    private static long idCounter = 1;
    private final String bookId;
    private String bookTitle;
    private String bookCategory;
    private String authorName;
    private int releaseDate;

    // constructor
    public Book(String bookTitle, String bookCategory, String authorName, int releaseDate) {
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
        this.bookId = "0" + createId();
    }

    // method
    private static String createId() {
        return String.valueOf(idCounter++);
    }

    public void updateDetail(String bookTitle, String bookCategory, String authorName, int releaseDate) {
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    public void printBookDetail() {
        System.out.println("ID \t\t\t: " + getBookId());
        System.out.println("Judul \t\t: " + getBookTitle());
        System.out.println("Kategori \t: " + getBookCategory());
        System.out.println("Penulis \t: " + getAuthorName());
        System.out.println("Rilis \t\t: " + getReleaseDate());
    }

    /*
        Getter Setter
     */
    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
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
}
