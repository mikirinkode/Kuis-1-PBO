package com.mikirinkode.libraryapp.user;

class User {
    private final String userId;
    private String fullName;
    private String username;
    private String password;
    private String userType;
    private int idCounter = 0;  // untuk pembuatan ID

    User(String fullName, String username, String password, String userType) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.userType = userType;

        // pembuatan ID dilakukan secara otomatis di dalam kelas ini ketika objek dibuat
        this.userId = "" + idCounter;
        idCounter++;
    }

    void printUserDetail() {
        System.out.println("User ID: " + userId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Username: " + username);
    }

    /*
        Getter Setter
    */
    String getFullName() {
        return this.fullName;
    }

    void setFullName(String name) {
        this.fullName = name;
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