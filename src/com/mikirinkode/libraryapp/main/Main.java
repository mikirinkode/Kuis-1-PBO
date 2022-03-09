/*
 * Copyright (c) 2022. Muhammad Wafa
 */

package com.mikirinkode.libraryapp.main;

import com.mikirinkode.libraryapp.library.Library;
import com.mikirinkode.libraryapp.library.LoginManager;

public class Main {

    public static void main(String[] args) {
        String libraryName = "Perpustakaan Hijau";
        Library library = new Library(libraryName);

        // menu untuk login atau signup
        LoginManager.menu(library);
    }


}
