package com.example.upsiintern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompanyprofileActivity extends AppCompatActivity {
    Button editbuttoncp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companyprofile);
        editbuttoncp = (Button)findViewById(R.id.editbuttoncp);
        editbuttoncp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CompanyprofileActivity.this, CompanyprofileActivity2.class));
            }
        });
    }
}