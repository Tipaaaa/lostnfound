package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lost_found.model.AuthClass;
import com.example.lost_found.model.AuthData;
import com.example.lost_found.retrofit.PortalClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void checkLogin(View view){


        EditText editUname;
        EditText editPassword;

        editUname = findViewById(R.id.editUname);
        editPassword = findViewById(R.id.editPassword);


        String username = editUname.getText().toString();
        String password = editPassword.getText().toString();

        //buat objek klien
        String API_BASE_URL = "https://2389-125-167-48-185.ngrok.io/";

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


        //panggil method
        Call<AuthClass> call = client.checkLogin(username, password);

        call.enqueue(new Callback<AuthClass>() {
            @Override
            public void onResponse(Call<AuthClass> call, Response<AuthClass> response) {

                AuthClass authClass = response.body();

                if (authClass!= null){
                    AuthData data = authClass.getData();
                    String token = data.getToken();
                    String nama = data.getNama();

                    //simpan data
                    SharedPreferences simpandata =
                            getSharedPreferences("com.example.lost_found.SIMP", MODE_PRIVATE);
                    SharedPreferences.Editor editor = simpandata.edit();

                    editor.putString("token", token);
                    editor.putString("nama", nama);
                    editor.apply();

                    Toast.makeText(getApplicationContext(), "Selamat Datang "+nama, Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainIntent);

                } else{
                    Toast.makeText(getApplicationContext(), "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AuthClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();

            }
        });


    }

    //on click pada login
    public void loginToRegister(View view){
        Intent registIntent = new Intent(this,  RegistActivity.class);
        startActivity(registIntent);
    }
}