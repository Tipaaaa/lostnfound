package com.example.lost_found.model;

import java.util.ArrayList;

public class Barang {
    public String id_barang;
    public String lokasi;
    public String nama;
    public String Kategori; // nama penemu
    public  String kontak;
    public String deskripsiB;
    public int id_penemu;
    public String gambarB;


    public Barang(String nama, String Kategori, String id_barang, String kontakb, String deskripsiB,
    String lokasib, int id_penemu, String gambarB) {

        this.id_barang = id_barang;
        this.nama = nama;
        this.Kategori = Kategori;
        this.deskripsiB = deskripsiB;
        this.kontak = kontakb;
        this.lokasi = lokasib;
        this.id_penemu = id_penemu;
        this.gambarB = gambarB;
    }



}
