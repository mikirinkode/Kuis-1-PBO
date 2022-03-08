package com.mikirinkode.libraryapp.user;


import com.mikirinkode.libraryapp.library.Book;

public class Admin extends User {
    private int id;

    public Admin(int id, String fullName, String username, String password) {
        super(fullName, username, password);
        this.id = id;
    }

    void updateBookProperties(Book book){

    }
}
