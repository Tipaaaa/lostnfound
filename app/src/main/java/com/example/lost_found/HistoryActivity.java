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

public class HistoryActivity extends AppCompatActivity implements BarangAdapter.OnBarangHolderClickListener {

    RecyclerView rvHistoryBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        BarangAdapter adapterHB = new BarangAdapter();

        adapterHB.setListener(this);

        rvHistoryBarang = findViewById(R.id.rvHistoryBarang);
        rvHistoryBarang.setAdapter(adapterHB);

        RecyclerView.LayoutManager managerhistory = new GridLayoutManager(this,2);
        rvHistoryBarang.setLayoutManager(managerhistory);
    }



    @Override
    public void onClick(View v, Barang barang) {

    }
}