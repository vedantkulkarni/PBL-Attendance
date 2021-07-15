package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent ;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendanceapp.Models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity<_button> extends AppCompatActivity {

    Button signup_button, signin_button, signinQ_button;
    Animation scaleup, scaledown;


    private FirebaseDatabase mDatabase;
    //private FirebaseDatabase ref;
    private Button bt;
    private Button bt2;
    private EditText username;
    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Toast.makeText(this, "Hellllo this is on create ", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar();
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.button);
        bt2=findViewById(R.id.button2);
        username=findViewById(R.id.editTextTextPersonName);
        email=findViewById(R.id.editTextTextEmailAddress);
        password=findViewById(R.id.editTextNumberPassword);
        mAuth = FirebaseAuth.getInstance();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                mAuth.createUserWithEmailAndPassword(email.getText().toString() , password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                            Users user = new Users(username.getText().toString() , email.getText().toString() ,password.getText().toString());
                            mDatabase=FirebaseDatabase.getInstance( "https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
                            String id= task.getResult().getUser().getUid();

//                            mDatabase.child("Users").child(id).setValue(user);
                            mDatabase.getReference().child("Users").child(id).setValue(user);

                        }
                        else {
                            Toast.makeText(MainActivity.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this , SignIn_Activity.class);
                startActivity(intent);
            }
        });



    }
}


