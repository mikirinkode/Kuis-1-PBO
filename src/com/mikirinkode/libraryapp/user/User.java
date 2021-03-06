package com.mikirinkode.libraryapp.user;

class User {
    private final String userId;
    private String fullName;
    private String username;
    private String password;
    private String userType;
    private static long idCounter = 0;  // untuk pembuatan ID

    User(String fullName, String username, String password, String userType) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.userType = userType;

        // pembuatan ID dilakukan secara otomatis di dalam kelas ini ketika objek dibuat
        this.userId = createId();
    }

    private static String createId() {
        return "UID00" + idCounter++;
    }

    /*
        Getter Setter
    */

    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String name) {
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}