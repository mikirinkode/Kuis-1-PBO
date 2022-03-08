package com.mikirinkode.libraryapp.user;

class User {
    private String fullName;
    private String username;
    private String password;

    User(String fullName, String username, String password){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    void printUserDetail(){
        System.out.println("Full Name: " + fullName);
        System.out.println("Username: " + username);
    }

    void setFullName(String name){
        this.fullName = name;
    }

    String getFullName(){
        return this.fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}