package com.example.lost_found;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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

    public void toAccount(View view){
        Toast.makeText(this, "Anda Memasuki Page Account", Toast.LENGTH_SHORT).show();
    }

    public void toChangePass(View view){
        //Toast.makeText(this, "Anda Memasuki Page Change Password", Toast.LENGTH_SHORT).show();
        Intent changepassIntent = new Intent(this, ChangeActivity.class);
        startActivity(changepassIntent);
    }
}