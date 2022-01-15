package com.example.lost_found;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lost_found.R;
import com.example.lost_found.model.AddBarangResponse;
import com.example.lost_found.retrofit.PortalClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailbarangActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1234;
    Button btnAdd;
    private FusedLocationProviderClient fusedLocation;

    Double lat, longii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailbarang);

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[] {
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, REQUEST_CODE);
            }
        }
        getLokasi();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLokasi();
            }
            return;

        }
    }

    public void getLokasi() {
        fusedLocation = LocationServices.getFusedLocationProviderClient(this);
        fusedLocation.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(@NonNull Location location) {
                lat = location.getLatitude();
                longii = location.getLongitude();

            }
        });
    }




    //on click pada profile
    public void homeToProfile(View view){
        Intent profileIntent = new Intent(this,  ProfileActivity.class);
        startActivity(profileIntent);
    }


    public void addTemuan(View view){
        EditText addNamab = findViewById(R.id.editInputNamaBarang);
        EditText addDeskripsi = findViewById(R.id.editDeskripsiInput);
        EditText addLokasi = findViewById(R.id.editLokasiInput);

        String namaB = addNamab.getText().toString();
        String deskripsiB = addDeskripsi.getText().toString();
        String lokasiB = addLokasi.getText().toString();

        //
        SharedPreferences simpan = getSharedPreferences("com.example.lost_found.SIMP", MODE_PRIVATE);
        String nama = simpan.getString("nama", "");
        String token = simpan.getString("token", "");
        int i_user = simpan.getInt("i_user", 0);

        //buat objek klien
        String API_BASE_URL = "https://2831-114-125-11-219.ngrok.io/";

        //buka ngrok ny lagi
        //add nya berhasil ga??
        //dtaa masuk db??
        //masalah internet

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
        //
        Call<AddBarangResponse> call = client.addBarang(namaB, deskripsiB,
                lokasiB, i_user,
                lat, longii);

        call.enqueue(new Callback<AddBarangResponse>() {
            @Override
            public void onResponse(Call<AddBarangResponse> call, Response<AddBarangResponse> response) {
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);

            }

            @Override
            public void onFailure(Call<AddBarangResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "gagal terhubung", Toast.LENGTH_SHORT).show();
            }
        });

    }
}