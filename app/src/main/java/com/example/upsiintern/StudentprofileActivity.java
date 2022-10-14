package com.example.upsiintern;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class StudentprofileActivity extends AppCompatActivity {

    private TextView nameformtv,studentidtv,facultytv,icpassportNotv,emailcontactNotv,permanentaddresstv,currentaddresstv;

    private FirebaseDatabase db;
    private DatabaseReference root;
    private Button editbutton;
    private static final String USERS = "Users";
    String  currentaddress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile);
        Intent intent = getIntent();
        currentaddress2 = intent.getStringExtra("Current Address");

        nameformtv = (TextView)findViewById(R.id.nameformtv);
        studentidtv = (TextView)findViewById(R.id.studentidtv);
        facultytv = (TextView)findViewById(R.id.facultytv);
        icpassportNotv = (TextView)findViewById(R.id.icpassportNotv);
        emailcontactNotv = (TextView)findViewById(R.id.emailcontactNotv);
        permanentaddresstv = (TextView)findViewById(R.id.permanentaddresstv);
        currentaddresstv = (TextView)findViewById(R.id.currentaddresstv);
        editbutton = (Button)findViewById(R.id.editbutton);
        db = FirebaseDatabase.getInstance();
        root= db.getReference(USERS);
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren()){
                 if (ds.child("Current Address").getValue().equals(currentaddress2)){
                     nameformtv.setText(ds.child("Name").getValue(String.class));
                     studentidtv.setText(ds.child("Student Id").getValue(String.class));
                     facultytv.setText(ds.child("Faculty").getValue(String.class));
                     icpassportNotv.setText(ds.child("IC or Passport No").getValue(String.class));
                     emailcontactNotv.setText(ds.child("Email or contact No").getValue(String.class));
                     permanentaddresstv.setText(ds.child("Permanent Address").getValue(String.class));
                     currentaddresstv.setText(currentaddress2);
                 }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    editbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(StudentprofileActivity.this, StudentprofileActivity2.class));
        }
    });

    }

}