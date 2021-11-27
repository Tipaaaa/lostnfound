package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lost_found.adapter.BarangAdapter;
import com.example.lost_found.adapter.KategoriAdapter;
import com.example.lost_found.model.Barang;
import com.example.lost_found.model.Kategori;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements BarangAdapter.OnBarangHolderClickListener, KategoriAdapter.OnKategoriHolderClickListener{
    RecyclerView rvListBarang;
    RecyclerView rvKategoriBarang;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarangAdapter adapter = new BarangAdapter();
        adapter.setListData(getBarang());
        adapter.setListener(this);


        rvListBarang = findViewById(R.id.rvListBarang);
        rvListBarang.setAdapter(adapter);

        KategoriAdapter kategoriAdapter = new KategoriAdapter();
        kategoriAdapter.setListData(getKategori());
        kategoriAdapter.setListener(this);

        rvKategoriBarang = findViewById(R.id.rvKategoriBarang);
        rvKategoriBarang.setAdapter(kategoriAdapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        rvKategoriBarang.setLayoutManager(manager);



        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvListBarang.setLayoutManager(layoutManager);


        Intent mainIntent = getIntent();
        String data = mainIntent.getStringExtra("nama_user");

        Toast.makeText(this, "Selamat Datang "+ data, Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Barang> getBarang(){
        ArrayList<Barang> listBarang = new ArrayList<Barang>();
        String nama;
        String Kategori;
        String details = "Details";
        listBarang.add(new Barang(
                nama = "Tumbler",
                Kategori = "Lain-lain",
                details));
        listBarang.add(new Barang(
                nama = "Tas Converse",
                Kategori = "Tas",
                details));
        listBarang.add(new Barang(
                nama = "Laptop HP Envy",
                Kategori = "Elektronik",
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

    public ArrayList<Kategori> getKategori(){
        ArrayList<Kategori> listKategory = new ArrayList<Kategori>();
        String nama;
        listKategory.add(new Kategori(
                nama = "Tas"
        ));
        listKategory.add(new Kategori(
                nama = "Elektronik"
        ));
        listKategory.add(new Kategori(
                nama = "Pakaian"
        ));
        listKategory.add(new Kategori(
                nama = "Sport"
        ));
        listKategory.add(new Kategori(
                nama = "Dokumen"
        ));
        listKategory.add(new Kategori(
                nama = "Lain-lain"
        ));
        return listKategory;
    }

    @Override
    //on click pada list barang
    public void onClick(View v, Barang barang) {
        Intent detailBarangIntent = new Intent(this, DetailFoundActivity.class);
        detailBarangIntent.putExtra("NAMA_BARANG", barang.nama);
        detailBarangIntent.putExtra("Kategori", barang.Kategori);
        startActivity(detailBarangIntent);


    }

    //on click pada profile
    public void homeToProfile(View view){
        Intent profileIntent = new Intent(this,  ProfileActivity.class);
        startActivity(profileIntent);
    }


    @Override
    public void onClick(View view, Kategori kategori) {
        Intent KategoriIntent = new Intent(this, CategoryActivity.class);
        //detailKategoriIntent.putExtra("Nama_Kategori", kategori.nama);
        startActivity(KategoriIntent);



    }


}
   
    