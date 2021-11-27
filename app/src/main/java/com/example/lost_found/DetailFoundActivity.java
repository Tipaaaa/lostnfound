package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lost_found.model.Barang;

import java.util.ArrayList;

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

    public ArrayList<Barang> getBarang(){
        ArrayList<Barang> listBarang = new ArrayList<Barang>();
        String nama;
        String Kategori;
        String details = "Details";
        listBarang.add(new Barang(
                nama = "Kaos Merah Maroon",
                Kategori = "Pakaian",
                details));
        listBarang.add(new Barang(
                nama = "Jam DW Coklat",
                Kategori = "Pakaian",
                details));
        listBarang.add(new Barang(
                nama = "Jaket Hitam",
                Kategori = "Pakaian",
                details));
        listBarang.add(new Barang(
                nama = "Dompet Coklat",
                Kategori = "Pakaian",
                details));

        return listBarang;
    }
    //on click pada tombol back Detail Found Item
    public void backDetailFound(View view){
        Intent backIntent = new Intent(this,  MainActivity.class);
        startActivity(backIntent);
    }
}