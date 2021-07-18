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
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    private BottomNavigationView bnv;

    private FirebaseDatabase aDatabase = FirebaseDatabase.getInstance( "https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private Button attendanceBt ;
    private TextView textView17;
    private TextView textView18;
    private TextView textView19;
    private TextView textView20;
    private TextView textView21;
    private TextView textView22;
    private TextView textView23;
    private TextView textView24;
    private TextView textView25;
    private TextView textView26;
    private TextView textView27;
    private TextView textView28;
    private TextView textView29;
    private TextView textView30;

    public Home() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer, new menuHome(attendanceBt, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30)).commit();
        textView17=findViewById(R.id.textView17);
        textView18=findViewById(R.id.textView18);
        textView19=findViewById(R.id.textView19);
        textView20=findViewById(R.id.textView20);
        textView21=findViewById(R.id.textView21);
        textView22=findViewById(R.id.textView22);
        textView23=findViewById(R.id.textView23);
        textView24=findViewById(R.id.textView24);
        textView25=findViewById(R.id.textView25);
        textView26=findViewById(R.id.textView26);
        textView27=findViewById(R.id.textView27);
        textView28=findViewById(R.id.textView28);
        textView29=findViewById(R.id.textView29);
        textView30=findViewById(R.id.textView30);
        attendanceBt=findViewById(R.id.button3);

        bnv=(BottomNavigationView)findViewById(R.id.bottomNavigation);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment temp=null;
//                temp= new menuHome(attendanceBt, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30);
//                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp).commit();
                switch (item.getItemId())
                {
                    case R.id.homeid: temp= new menuHome(attendanceBt, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30);
                        break;
                    case R.id.profileid: temp= new profileFragment();
                        break;
                    case R.id.aboutid: temp= new aboutFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp).commit();
                return true;
            }
        });}}
//        attendanceBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                aDatabase=FirebaseDatabase.getInstance( "https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
//                String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
////               aDatabase=FirebaseDatabase.getInstance().getReference();
//                aDatabase.getReference().child("Users").child(currentuser).child("username").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DataSnapshot> task) {
//                        if (!task.isSuccessful()) {
//                            Log.e("firebase", "Error getting data", task.getException());
//                            Toast.makeText(Home.this , "failed to get value " , Toast.LENGTH_SHORT).show();
//                        }
//                        else {
//                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
////                            userattendance.setText(String.valueOf(task.getResult().getValue()));
//                              String rollNumber = String.valueOf(task.getResult().getValue());
//                              aDatabase.getReference().child("FE8").child("BASIC ELECTRICAL ENGINEERING").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                  @Override
//                                  public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                      if (!task.isSuccessful()) {
//                                          textView17.setText("0");
//                                      }
//                                      else {
//                                          Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                          textView17.setText(String.valueOf(task.getResult().getValue()));
//                                      }
//                                  }
//                              });//1
//                            aDatabase.getReference().child("FE8").child("ENGINEERING MECHANICS").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView18.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView18.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//2
//                            aDatabase.getReference().child("FE8").child("ENGINEERING PHYSICS").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView19.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView19.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//3
//                            aDatabase.getReference().child("FE8").child("ENGINEERING MATHEMATICS II").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView20.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView20.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//4
//                            aDatabase.getReference().child("FE8").child("ENGINEERING MECHANICS LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView21.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView21.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//5
//                            aDatabase.getReference().child("FE8").child("ENGINEERING PHYSICS LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView22.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView22.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//6
//                            aDatabase.getReference().child("FE8").child("BASIC ELECTRICAL ENGINEERING LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView23.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView23.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//7
//                            aDatabase.getReference().child("FE8").child("ENVIRONMENTAL STUDIES - II").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView24.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView24 .setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//8
//                            aDatabase.getReference().child("FE8").child("PROJECT BASED LEARNING LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView25.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView25.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//9
//                            aDatabase.getReference().child("FE8").child("ENGINEERING GRAPHICS").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView26.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView26.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//10
//                            aDatabase.getReference().child("FE8").child("ENGINEERING GRAPHICS LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView27.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView27.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//11
//                            aDatabase.getReference().child("FE8").child("ENGINEERING GRAPHICS TUTORIAL").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView28.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView28.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//12
//                            aDatabase.getReference().child("FE8").child("ENGINEERING MATHEMATICS II TUT").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView29.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView29.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//13
//                            aDatabase.getReference().child("FE8").child("PHYSICAL EDUCATION").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                    if (!task.isSuccessful()) {
//                                        textView30.setText("0");
//                                    }
//                                    else {
//                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                        textView30.setText(String.valueOf(task.getResult().getValue()));
//                                    }
//                                }
//                            });//14
//
//
//                        }
//                    }
//                });
//            }
//        });
//
//
//    }

//    public void setTextView20(TextView textView20) {
//        this.textView20 = textView20;
//    }
//
//    public void setTextView21(TextView textView21) {
//        this.textView21 = textView21;
//    }
//
//    public void setTextView22(TextView textView22) {
//        this.textView22 = textView22;
//    }
//
//    public void setTextView23(TextView textView23) {
//        this.textView23 = textView23;
//    }
//
//    public void setTextView24(TextView textView24) {
//        this.textView24 = textView24;
//    }
//
//    public void setTextView25(TextView textView25) {
//        this.textView25 = textView25;
//    }
//
//    public void setTextView26(TextView textView26) {
//        this.textView26 = textView26;
//    }
//
//    public void setTextView27(TextView textView27) {
//        this.textView27 = textView27;
//    }
//
//    public void setTextView28(TextView textView28) {
//        this.textView28 = textView28;
//    }
//
//    public void setTextView29(TextView textView29) {
//        this.textView29 = textView29;
//    }
//
//    public void setTextView30(TextView textView30) {
//        this.textView30 = textView30;
//    }
//
//    public void setTextView17(TextView textView17) {
//        this.textView17 = textView17;
//    }
//
//    public void setTextView18(TextView textView18) {
//        this.textView18 = textView18;
//    }
//}