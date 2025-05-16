package com.decodeil.inputapp.test;

public class Student {
    private String nim, nama, hobby;

    public Student(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public Student(String nim, String nama, String hobby) {
        this.nim = nim;
        this.nama = nama;
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
}
