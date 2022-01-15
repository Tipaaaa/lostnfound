package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lost_found.model.Barang;
import com.example.lost_found.model.BarangItem;
import com.example.lost_found.model.DataUserItem;
import com.example.lost_found.model.ProfileResponse;
import com.example.lost_found.retrofit.PortalClient;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    TextView textNamaProfile;
    TextView textKontakProfile;
    TextView textEmailProfile;
    TextView textNamapp;
    TextView textKontakpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        textNamaProfile = findViewById(R.id.textNamaProfile);
        textEmailProfile = findViewById(R.id.textEmailP);
        textKontakProfile = findViewById(R.id.textNoHP);
        textNamapp = findViewById(R.id.textNamaP);
        textKontakpp = findViewById(R.id.textKontakP);

        SharedPreferences simpan = getSharedPreferences("com.example.lost_found.SIMP", MODE_PRIVATE);
        String nama = simpan.getString("nama", "");
        String token = simpan.getString("token", "");

        //buat objek klien
        String API_BASE_URL = "https://88a6-114-125-26-161.ngrok.io/";

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

        //call
        Call<ProfileResponse> call = client.getProfile(token);

        setStatus(1);
        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                ProfileResponse pr = response.body();
                if (pr != null) {
                    List<DataUserItem> dataUserItem = pr.getDataUser();
                    //perulangan ambil data
                    for (DataUserItem dta : dataUserItem) {
                        textNamaProfile.setText(dta.getNama());
                        textKontakProfile.setText(dta.getKontak());
                        textEmailProfile.setText(dta.getEmail());
                        textNamapp.setText(dta.getNama());
                        textKontakpp.setText(dta.getKontak());
                    }
                    setStatus(0);
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Upss... Gagal Nih", Toast.LENGTH_SHORT).show();
                setStatus(0);
            }
        });





    }

    public void setStatus(int statusbar){
        ProgressBar loa = findViewById(R.id.progressBarP);
        //Button login = imageview23
        //Button loginBtn = findViewById(R.id.buttonlogin);
        if (statusbar == 1){
            loa.setVisibility(View.VISIBLE);
           // loginBtn.setVisibility(View.GONE);
        } else if (statusbar == 0){
            loa.setVisibility(View.GONE);
           // loginBtn.setVisibility(View.VISIBLE);
        }
    }

    public void toHistory(View view){
        //Toast.makeText(this, "Anda Memasuki Page History", Toast.LENGTH_SHORT).show();
        Intent historyIntent = new Intent(this, HistoryActivity.class);
        startActivity(historyIntent);
    }

    public void toFoundItem(View view){
        //Toast.makeText(this, "Anda Memasuki Page Found Item", Toast.LENGTH_SHORT).show();
        Intent foundItemIntent = new Intent(this, FounditemActivity.class);
        startActivity(foundItemIntent);
    }

    public void logoutt(View view){
        //Toast.makeText(this, "Anda Memasuki Page Found Item", Toast.LENGTH_SHORT).show();
        Intent logoutIntent = new Intent(this, LoginActivity.class);
        startActivity(logoutIntent);
        Toast.makeText(getApplicationContext(), "Anda Telah Logout", Toast.LENGTH_SHORT).show();
    }

    public void toAccount(View view){
        Toast.makeText(this, "Anda Memasuki Page Account", Toast.LENGTH_SHORT).show();
    }

    public void toChangePass(View view){
        //Toast.makeText(this, "Anda Memasuki Page Change Password", Toast.LENGTH_SHORT).show();
        Intent changepassIntent = new Intent(this, ChangeActivity.class);
        startActivity(changepassIntent);
    }
}