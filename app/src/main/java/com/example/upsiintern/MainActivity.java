package com.example.upsiintern;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText username2, password2;
    TextView signuphere;
    Button loginbutton;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username2 = (EditText)findViewById(R.id.username2);
        password2 = (EditText)findViewById(R.id.password2);
        signuphere= (TextView) findViewById(R.id.signuphere);
        loginbutton = (Button)findViewById(R.id.loginbutton);

        mAuth= FirebaseAuth.getInstance();

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        signuphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignupActivity2.class));
            }
        });

    }

    private void loginUser(){

        String email = username2.getText().toString();
        String password1 = password2.getText().toString();

        if (TextUtils.isEmpty(email)){
            username2.setError("Email Cannot be empty");
            username2.requestFocus();
        }else if (TextUtils.isEmpty(password1)){
            password2.setError("Password cannot be empty");
            password2.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "User logged in Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, HomepageActivity3.class));
                    }else {
                        Toast.makeText(MainActivity.this, "Log in Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}