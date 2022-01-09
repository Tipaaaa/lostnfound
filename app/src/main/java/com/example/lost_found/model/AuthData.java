
package com.example.lost_found.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AuthData {

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("kontak")
    @Expose
    private String kontak;

    public String getToken() {
        return token;
    }

    public int getId() {
        return id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

}
