package com.example.lost_found.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListBarangObject{

    @SerializedName("barang")
    private List<BarangItem> barang;

    @SerializedName("jumlahdata")
    private int jumlahdata;

    @SerializedName("tanggal")
    private String tanggal;

    public void setBarang(List<BarangItem> barang){
        this.barang = barang;
    }

    public List<BarangItem> getBarang(){
        return barang;
    }

    public void setJumlahdata(int jumlahdata){
        this.jumlahdata = jumlahdata;
    }

    public int getJumlahdata(){
        return jumlahdata;
    }

    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }

    public String getTanggal(){
        return tanggal;
    }
}