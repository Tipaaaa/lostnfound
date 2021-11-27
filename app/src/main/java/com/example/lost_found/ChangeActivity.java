package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
    }
    //on click pada tombol back Change Password
    public void backChangePassword(View view){
        Intent backIntent = new Intent(this,  ProfileActivity.class);
        startActivity(backIntent);
    }
}