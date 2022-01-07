package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        String API_BASE_URL = "https://a61d-125-167-48-26.ngrok.io/";

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

        Call<RegisResponse> call = client.daftarRegis(namaRegis, usernameRegis, passwordRegis, kontakRegis);

        call.enqueue(new Callback<RegisResponse>() {
            @Override
            public void onResponse(Call<RegisResponse> call, Response<RegisResponse> response) {
                Toast.makeText(getApplicationContext(), "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Regis Gagal", Toast.LENGTH_SHORT).show();
            }
        });


    }

}