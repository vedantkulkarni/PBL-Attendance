package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    private BottomNavigationView bnv;

    private FirebaseDatabase aDatabase = FirebaseDatabase.getInstance( "https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private Button attendanceBt ;
    private TextView userattendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        userattendance=findViewById(R.id.attendance);
        attendanceBt=findViewById(R.id.button3);
        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new Fragment()).commit();
        bnv=(BottomNavigationView)findViewById(R.id.bottomNavigation);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment temp=null;
                switch (item.getItemId())
                {
                    case R.id.homeid: temp= new Fragment();
                        break;
                    case R.id.profileid: temp= new profileFragment();
                        break;
                    case R.id.aboutid: temp= new aboutFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp).commit();
                return true;
            }
        });
        attendanceBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aDatabase=FirebaseDatabase.getInstance( "https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
                String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
//               aDatabase=FirebaseDatabase.getInstance().getReference();
                aDatabase.getReference().child("Users").child(currentuser).child("username").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                            Toast.makeText(Home.this , "failed to get value " , Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                            userattendance.setText(String.valueOf(task.getResult().getValue()));
                              String rollNumber = String.valueOf(task.getResult().getValue());
                              aDatabase.getReference().child("FE8").child("Engineering Physics").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                  @Override
                                  public void onComplete(@NonNull Task<DataSnapshot> task) {
                                      if (!task.isSuccessful()) {
                                          Log.e("firebase", "Error getting data", task.getException());
                                          Toast.makeText(Home.this , "failed to get value " , Toast.LENGTH_SHORT).show();
                                      }
                                      else {
                                          Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                          userattendance.setText(String.valueOf(task.getResult().getValue()));
                                      }
                                  }
                              });
                        }
                    }
                });
            }
        });


    }
}