package com.example.upsiintern;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity2 extends AppCompatActivity {
     EditText username,password,confirm_password;
     TextView loginhere;
     Button signupbutton;
     FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirm_password = (EditText) findViewById(R.id.confirm_password);
        loginhere = (TextView)findViewById(R.id.loginhere);
        signupbutton = (Button) findViewById(R.id.signupbutton);
        mAuth = FirebaseAuth.getInstance();

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity2.this, MainActivity.class));
            }
        });

    }

    private void createUser(){
        String email = username.getText().toString();
        String password1 = password.getText().toString();
        String confirm_password1 = confirm_password.getText().toString();

        if (TextUtils.isEmpty(email)){
             username.setError("Email Cannot be empty");
             username.requestFocus();
        }else if (password1.length() <6){
            password.setError("Password Must be greater than 6 Characters");
            password.requestFocus();
        }else if (TextUtils.isEmpty(confirm_password1)){
            confirm_password.setError("Confirm Password is Required");
            confirm_password.requestFocus();
        }else {
          mAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if (task.isSuccessful()){
                      Toast.makeText(SignupActivity2.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(SignupActivity2.this, MainActivity.class));
                  }else {
                      Toast.makeText(SignupActivity2.this, "Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                  }
              }
          });

        }

    }
}