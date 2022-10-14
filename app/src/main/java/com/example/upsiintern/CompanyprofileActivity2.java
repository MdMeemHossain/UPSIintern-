package com.example.upsiintern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompanyprofileActivity2 extends AppCompatActivity {
    Button returnbuttoncp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companyprofile2);
        returnbuttoncp = (Button)findViewById(R.id.returnbuttoncp);
        returnbuttoncp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CompanyprofileActivity2.this, CompanyprofileActivity.class));
            }
        });
    }
}