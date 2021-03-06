package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lost_found.adapter.BarangAdapter;
import com.example.lost_found.model.Barang;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements BarangAdapter.OnBarangHolderClickListener{
    RecyclerView rvListBarangKategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        BarangAdapter adapter = new BarangAdapter();

        adapter.setListener(this);

        rvListBarangKategori = findViewById(R.id.rvListBarangKategori);
        rvListBarangKategori.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvListBarangKategori.setLayoutManager(layoutManager);
    }



    public void onClick(View v, Barang barang) {
        Intent detailBarangIntent = new Intent(this, DetailFoundActivity.class);
        detailBarangIntent.putExtra("NAMA_BARANG", barang.nama);
        detailBarangIntent.putExtra("Kategori", barang.Kategori);
        startActivity(detailBarangIntent);
    }
}