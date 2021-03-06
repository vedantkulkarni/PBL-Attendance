package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignIn_Activity extends AppCompatActivity {
    private FirebaseDatabase Database;
    private Button btSignIn;
    private EditText emailSignIn;
    private EditText passwordSignIn;
    private FirebaseAuth Auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar();
        setContentView(R.layout.activity_sign_in_);
        btSignIn=findViewById(R.id.buttonSignIn);
        emailSignIn=findViewById(R.id.editTextTextEmailAddressSignIn);
        passwordSignIn=findViewById(R.id.editTextNumberPasswordSignIn);
        Auth = FirebaseAuth.getInstance();
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth.signInWithEmailAndPassword(emailSignIn.getText().toString() , passwordSignIn.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignIn_Activity.this, "SignIn Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignIn_Activity.this , Home.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(SignIn_Activity.this, "SignIn Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}