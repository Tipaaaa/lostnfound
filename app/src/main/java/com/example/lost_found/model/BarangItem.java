package com.example.lost_found.model;

import com.google.gson.annotations.SerializedName;

public class BarangItem{

    @SerializedName("id_penemu")
    private int idPenemu;

    @SerializedName("id_kategori")
    private int idKategori;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("latitude")
    private Double latitude;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("nama_barang")
    private String namaBarang;

    @SerializedName("nama")
    private String nama;

    @SerializedName("kontak")
    private String kontak;

    @SerializedName("lokasi")
    private String lokasi;

    @SerializedName("id_barang")
    private String id_barang;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("gambar")
    private String gambar;

    @SerializedName("status")
    private int status;

    @SerializedName("longitude")
    private Double longitude;

    public void setIdPenemu(int idPenemu){
        this.idPenemu = idPenemu;
    }

    public int getIdPenemu(){
        return idPenemu;
    }

    public void setIdKategori(int idKategori){
        this.idKategori = idKategori;
    }

    public int getIdKategori(){
        return idKategori;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    public Double getLatitude(){
        return latitude;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setNamaBarang(String namaBarang){
        this.namaBarang = namaBarang;
    }

    public String getNamaBarang(){
        return namaBarang;
    }

    public String getNama(){
        return nama;
    }

    public String getKontak(){
        return kontak;
    }

    public void lokasi(String lokasi){
        this.lokasi = lokasi;
    }
    public String getLokasi(){return lokasi;}

    public void setId(String id_barang){
        this.id_barang = id_barang;
    }

    public String getId(){
        return id_barang;
    }

    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public void setGambar(String gambar){
        this.gambar = gambar;
    }

    public String getGambar(){
        return gambar;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }

    public Double getLongitude(){
        return longitude;
    }
}