/*
 * Copyright (c) 2022. Muhammad Wafa
 */

package com.mikirinkode.libraryapp.library;

import com.mikirinkode.libraryapp.user.LibraryMember;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    // attribute
    private final String date;
    private final String transactionId;
    private final LibraryMember member;
    private final Book book;
    private final String activity;

    // atribut untuk pembuatan id
    private static long counterId = 0;

    // kelas untuk mengambil tanggal dan waktu terkini
    private final LocalDateTime localDate = LocalDateTime.now();
    // kelas untuk ubah format data tanggal dan waktu
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyy HH:mm:ss");
    private final String formattedDate = localDate.format(dateFormatter);

    /*
        constructor
     */
    public Transaction(LibraryMember member, String activity, Book book) {
        this.member = member;
        this.activity = activity;
        this.book = book;

        this.transactionId = createId();
        this.date = getCurrentDateTime();
    }

    private String getCurrentDateTime(){
        return this.formattedDate;
    }

    private String createId(){
        return "Trans#0" + counterId++;
    }

    public void printTransactionDetail(){
        System.out.println("ID Transaksi: " + getTransactionId());
        System.out.println("Tanggal dan Waktu: " + getDate());
        System.out.println("Aktivitas: " + getActivity());
        System.out.println("Oleh: " + getMember().getFullName());
        System.out.println("Buku: " + getBook().getBookTitle());
    }
    /*
        Getter Setter
     */
    public String getDate() {
        return date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LibraryMember getMember() {
        return member;
    }

    public String getActivity() {
        return activity;
    }

    public Book getBook() {
        return book;
    }
}
