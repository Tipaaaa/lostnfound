package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lost_found.adapter.BarangAdapter;
import com.example.lost_found.adapter.KategoriAdapter;
import com.example.lost_found.model.Barang;
import com.example.lost_found.model.BarangItem;
import com.example.lost_found.model.Kategori;
import com.example.lost_found.model.ListBarangObject;
import com.example.lost_found.retrofit.PortalClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements BarangAdapter.OnBarangHolderClickListener, KategoriAdapter.OnKategoriHolderClickListener{
    RecyclerView rvListBarang;
    RecyclerView rvKategoriBarang;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarangAdapter adapter = new BarangAdapter();

        adapter.setListener(this);

        //sharedpreference
        SharedPreferences simpan = getSharedPreferences("com.example.lost_found.SIMP", MODE_PRIVATE);
        String nama = simpan.getString("nama", "");
        String token = simpan.getString("token", "");
        Toast.makeText(this, nama, Toast.LENGTH_SHORT).show();


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
        //String data = mainIntent.getStringExtra("nama_user");
        //Toast.makeText(this, "Selamat Datang "+ data, Toast.LENGTH_SHORT).show();

        // minta data default
        //buat objek klien
        String API_BASE_URL = " https://2779-125-167-49-94.ngrok.io/";

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okBuilder.addInterceptor(logging);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit retrofit = builder.build();

        PortalClient client = retrofit.create(PortalClient.class);

        //method call
        Call<ListBarangObject> call = client.getBarang(token);

        call.enqueue(new Callback<ListBarangObject>() {
            @Override
            public void onResponse(Call<ListBarangObject> call, Response<ListBarangObject> response) {
                ListBarangObject listBarangObject = response.body();
                ArrayList<Barang> listBarang = new ArrayList<Barang>();
                if(listBarangObject != null){
                    List<BarangItem> listBarangItem = listBarangObject.getBarang();


                    //perulangan ambil data
                    for(BarangItem brg : listBarangItem){
                        Barang barang = new Barang(brg.getNamaBarang(),
                                brg.getNama(),
                                brg.getId(),
                                brg.getKontak(),
                                brg.getDeskripsi(),
                                brg.getLokasi(),
                                brg.getIdPenemu()
                        );
                        listBarang.add(barang);
                    }

                } else{
                    Toast.makeText(getApplicationContext(), "Data Kosong", Toast.LENGTH_SHORT).show();

                }

                adapter.setListData(listBarang);

            }

            @Override
            public void onFailure(Call<ListBarangObject> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Mengubungi Server", Toast.LENGTH_SHORT).show();

            }
        });
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
        detailBarangIntent.putExtra("deskripsiB", barang.deskripsiB);
        detailBarangIntent.putExtra("kontak", barang.kontak);
        detailBarangIntent.putExtra("Kategori", barang.Kategori);
        detailBarangIntent.putExtra("lokasi", barang.lokasi);
        detailBarangIntent.putExtra("id_barang", barang.id_barang);
        detailBarangIntent.putExtra("id_penemu", barang.id_penemu);

        startActivity(detailBarangIntent);


    }

    //on click pada profile
    public void homeToProfile(View view){
        Intent profileIntent = new Intent(this,  DetailbarangActivity.class);
        startActivity(profileIntent);
    }

    //on click pada profile

    public void addBarangi(View view){
        Intent detailIntent = new Intent(this,  DetailbarangActivity.class);
        startActivity(detailIntent);
    }

    @Override
    public void onClick(View view, Kategori kategori) {
        Intent KategoriIntent = new Intent(this, CategoryActivity.class);
        //detailKategoriIntent.putExtra("Nama_Kategori", kategori.nama);
        startActivity(KategoriIntent);



    }


}
   
    