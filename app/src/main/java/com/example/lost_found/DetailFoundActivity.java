package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailFoundActivity extends AppCompatActivity {

    TextView textNamaBarang;
    TextView textkategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_found);

        Intent detailBarangIntent = getIntent();
        String namaBarang = detailBarangIntent.getStringExtra("NAMA_BARANG");
        String kategori = detailBarangIntent.getStringExtra("Kategori");
        textNamaBarang = findViewById(R.id.textNamaBarang);
        textNamaBarang.setText(namaBarang);

        textkategori= findViewById(R.id.textkategori);
        textkategori.setText(kategori);
    }
}