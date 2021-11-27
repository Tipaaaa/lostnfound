package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editUname;
    EditText editPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void checkLogin(View view){

        editUname = findViewById(R.id.editUname);
        editPassword = findViewById(R.id.editPassword);
        //cek value

        if (editUname.getText().toString().equals("halo") &&
        editPassword.getText().toString().equals("ada123")){
            Intent mainIntent = new Intent(this, MainActivity.class);
            //bikin data
            mainIntent.putExtra("nama_user", "JOHN");
            startActivity(mainIntent);
        }else{
        Toast.makeText(this, "Upss. . .  Akun Tidak Sesuai", Toast.LENGTH_SHORT).show();
        editUname.setText("");
        editPassword.setText("");
        }

    }
    //on click pada register
    public void loginToRegister(View view){
        Intent registIntent = new Intent(this,  RegistActivity.class);
        startActivity(registIntent);
    }
}