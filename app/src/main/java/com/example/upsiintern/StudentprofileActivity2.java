package com.example.upsiintern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;

public class StudentprofileActivity2 extends AppCompatActivity {

    private EditText nameform,studentid,faculty,icpassportNo,emailcontactNo,permanentaddress,currentaddress;
    private Button savebutton;
    private Button returnbutton;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile2);
        nameform = (EditText) findViewById(R.id.nameform);
        studentid = (EditText) findViewById(R.id.studentid);
        faculty = (EditText) findViewById(R.id.faculty);
        icpassportNo= (EditText) findViewById(R.id.icpassportNo);
        emailcontactNo = (EditText) findViewById(R.id.emailcontactNo);
        permanentaddress = (EditText) findViewById(R.id.permanentaddress);
        currentaddress= (EditText) findViewById(R.id.currentaddress);
        savebutton = (Button)findViewById(R.id.savebutton);
        returnbutton = (Button)findViewById(R.id.returnbutton);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameform1 = nameform.getText().toString();
                String studentid1 = studentid.getText().toString();
                String faculty1 = faculty.getText().toString();
                String icpassportNo1 = icpassportNo.getText().toString();
                String emailcontactNo1 = emailcontactNo.getText().toString();
                String permanentaddress1 = permanentaddress.getText().toString();
                String currentaddress1 = currentaddress.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("Name", nameform1);
                userMap.put("Student Id", studentid1);
                userMap.put("Faculty", faculty1);
                userMap.put("IC or Passport No", icpassportNo1);
                userMap.put("Email or contact No", emailcontactNo1);
                userMap.put("Permanent Address", permanentaddress1);
                userMap.put("Current Address", currentaddress1);


                root.push().setValue(userMap);

            }
        });

        returnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentprofileActivity2.this, StudentprofileActivity.class));
            }
        });


    }
}