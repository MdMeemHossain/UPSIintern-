package com.example.upsiintern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class CompanylistActivity6 extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companylist6);
        pdfView = (PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("listofcompany.pdf").load();
    }
}