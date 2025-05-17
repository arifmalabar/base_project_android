package com.decodeil.inputapp.test;

public class Student {
    private String nim, nama, hobby, kecamatan;

    public Student() {
    }

    public Student(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public Student(String nim, String nama, String hobby) {
        this.nim = nim;
        this.nama = nama;
        this.hobby = hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
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
