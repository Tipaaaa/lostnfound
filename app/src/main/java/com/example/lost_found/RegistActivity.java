package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lost_found.model.RegisResponse;
import com.example.lost_found.retrofit.PortalClient;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
    }

    public void setStatusRgs(int statusbar){
        ProgressBar rg = findViewById(R.id.progressBarRgs);
        //Button login = imageview23
        Button rgBtn = findViewById(R.id.buttonRgs);
        if (statusbar == 1){
            rg.setVisibility(View.VISIBLE);
            rgBtn.setVisibility(View.GONE);
        } else if (statusbar == 0){
            rg.setVisibility(View.GONE);
            rgBtn.setVisibility(View.VISIBLE);
        }
    }



    public void daftarRegis(View view){
        //inisialisasi
        EditText editNamaRegis;
        EditText editUsernameRegis;
        EditText editPasswordRegis;
        EditText editKontakRegis;

        editNamaRegis = findViewById(R.id.editNamaRegist);
        editUsernameRegis = findViewById(R.id.editUsernameRegist);
        editPasswordRegis = findViewById(R.id.editPasswordRegis);
        editKontakRegis = findViewById(R.id.editKontakRegist);

        String namaRegis = editNamaRegis.getText().toString();
        String usernameRegis = editUsernameRegis.getText().toString();
        String passwordRegis = editPasswordRegis.getText().toString();
        String kontakRegis = editKontakRegis.getText().toString();

        //buat objek klien
        String API_BASE_URL = "https://f75a-36-69-9-69.ngrok.io/";

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

        Call<RegisResponse> call = client.daftarRegis(namaRegis, usernameRegis, passwordRegis, kontakRegis);

        setStatusRgs(1);
        call.enqueue(new Callback<RegisResponse>() {
            @Override
            public void onResponse(Call<RegisResponse> call, Response<RegisResponse> response) {
                setStatusRgs(0);
                Toast.makeText(getApplicationContext(), "Registrasi Berhasil | Silahkan Login", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);

            }

            @Override
            public void onFailure(Call<RegisResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Regis Gagal", Toast.LENGTH_SHORT).show();
                setStatusRgs(0);
            }
        });


    }

}