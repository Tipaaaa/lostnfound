package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.lost_found.R;
import com.example.lost_found.adapter.BarangAdapter;
import com.example.lost_found.model.Barang;

import java.util.ArrayList;

public class FounditemActivity extends AppCompatActivity implements BarangAdapter.OnBarangHolderClickListener {

    RecyclerView rvFoundBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_founditem);

        BarangAdapter adapterFI = new BarangAdapter();

        adapterFI.setListener(this);

        rvFoundBarang = findViewById(R.id.rvFoundBarang);
        rvFoundBarang.setAdapter(adapterFI);

        RecyclerView.LayoutManager managerfounditem = new GridLayoutManager(this, 2);
        rvFoundBarang.setLayoutManager(managerfounditem);


    }



    @Override
    public void onClick(View v, Barang barang) {

    }
}