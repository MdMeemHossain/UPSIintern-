package com.example.upsiintern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomepageActivity3 extends AppCompatActivity {
    private View StudentProfile;
    private View CompanyProfile;CardView cardprofile;
CardView cardhome;
CardView carddocument;
CardView cardchat;
CardView cardcontact;
CardView cardlogout;
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage3);

        Toolbar toolbar = findViewById(R.id.toolbarh);
        cardprofile = (CardView) findViewById(R.id.cardprofile);
        carddocument= (CardView) findViewById(R.id.carddocument);
        cardchat = (CardView) findViewById(R.id.cardchat);
        cardlogout = (CardView) findViewById(R.id.cardlogout);
        cardcontact = (CardView) findViewById(R.id.cardcontact);
        cardhome = (CardView) findViewById(R.id.cardhome);
        StudentProfile = (View) findViewById(R.id.StudentProfile);
        CompanyProfile = (View) findViewById(R.id.CompanyProfile);

        mAuth = FirebaseAuth.getInstance();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });

        carddocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu2();
            }
        });

        cardchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity3.this, ChatActivity4.class);
                startActivity(intent);
            }
        });

        cardcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity3.this, ContactusActivity5.class);
                startActivity(intent);
            }
        });

        cardhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity3.this, CompanylistActivity6.class);
                startActivity(intent);
            }
        });

        cardlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(HomepageActivity3.this, MainActivity.class));
            }
        });
    }

    private void ShowMenu()
    {
        PopupMenu popupMenu =new PopupMenu(this,cardprofile);
        popupMenu.getMenuInflater().inflate(R.menu.home_meanu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.StudentProfile:
                        Intent intent = new Intent(HomepageActivity3.this, StudentprofileActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.CompanyProfile:

                        Intent intent2 = new Intent(HomepageActivity3.this, CompanyprofileActivity.class);
                        startActivity(intent2);

                        break;

                }
                return false;
            }
        });
        popupMenu.show();

    }

    private void ShowMenu2() {
        PopupMenu popupMenu = new PopupMenu(this, carddocument);
        popupMenu.getMenuInflater().inflate(R.menu.document_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.report:

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1ERweSYLacD-hv38y3l3zmKOYzNr2eud9?usp=sharing"));
                        startActivity(intent);

                        break;
                    case R.id.form:
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1iOoeTStV2u5FQOARZvqYBiFdq0vTDXZS?usp=sharing"));
                        startActivity(intent2);

                        break;

                    case R.id.internshipDocument:
                        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1qS4Jhsb3wkGDeuRIidr-DdIoCs-xA-RQ?usp=sharing"));
                        startActivity(intent3);

                        break;

                }
                return false;
            }
        });
        popupMenu.show();


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(HomepageActivity3.this, MainActivity.class));
        }

    }
}