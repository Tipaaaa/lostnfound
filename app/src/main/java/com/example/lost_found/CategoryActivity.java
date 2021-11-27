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
        adapter.setListData(getBarang());
        adapter.setListener(this);

        rvListBarangKategori = findViewById(R.id.rvListBarangKategori);
        rvListBarangKategori.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvListBarangKategori.setLayoutManager(layoutManager);
    }

    public ArrayList<Barang> getBarang(){
        ArrayList<Barang> listBarang = new ArrayList<Barang>();
        String nama;
        String Kategori;
        String details = "Details";
        listBarang.add(new Barang(
                nama = "Tas Converse",
                Kategori = "Tas",
                details));
        listBarang.add(new Barang(
                nama = "Tas 'False Pretense'",
                Kategori = "Tas",
                details));
        listBarang.add(new Barang(
                nama = "Kaos Merah Maroon",
                Kategori = "Pakaian",
                details));
        listBarang.add(new Barang(
                nama = "Converse Putih",
                Kategori = "Sepatu",
                details));
        listBarang.add(new Barang(
                nama = "Jam DW Coklat",
                Kategori = "Pakaian",
                details));
        listBarang.add(new Barang(
                nama = "iPhone 11 Pro",
                Kategori = "Elektronik",
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

    public void onClick(View v, Barang barang) {
        Intent detailBarangIntent = new Intent(this, DetailFoundActivity.class);
        detailBarangIntent.putExtra("NAMA_BARANG", barang.nama);
        detailBarangIntent.putExtra("Kategori", barang.Kategori);
        startActivity(detailBarangIntent);
    }

    //on click pada tombol back kategori
    public void backDetailKategori(View view){
        Intent backIntent = new Intent(this,  MainActivity.class);
        startActivity(backIntent);
    }
}