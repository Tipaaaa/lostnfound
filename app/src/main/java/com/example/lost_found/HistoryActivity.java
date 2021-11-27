package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lost_found.R;
import com.example.lost_found.adapter.BarangAdapter;
import com.example.lost_found.model.Barang;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity implements BarangAdapter.OnBarangHolderClickListener {

    RecyclerView rvHistoryBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        BarangAdapter adapterHB = new BarangAdapter();
        adapterHB.setListData(getBarang());
        adapterHB.setListener(this);

        rvHistoryBarang = findViewById(R.id.rvHistoryBarang);
        rvHistoryBarang.setAdapter(adapterHB);

        RecyclerView.LayoutManager managerhistory = new GridLayoutManager(this,2);
        rvHistoryBarang.setLayoutManager(managerhistory);
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

    @Override
    public void onClick(View v, Barang barang) {

    }
    //on click pada tombol back History
    public void backHistory(View view){
        Intent backIntent = new Intent(this,  ProfileActivity.class);
        startActivity(backIntent);
    }
}