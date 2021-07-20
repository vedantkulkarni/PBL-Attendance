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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
    private static FloatingActionButton floatingActionButton2 , dev_info_fab , teacher_fab ;
    private static TextView dev , teacher;

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
        floatingActionButton2=findViewById(R.id.floatingActionButton2);
        dev_info_fab=findViewById(R.id.dev_info_fab);
        teacher_fab=findViewById(R.id.teacher_fab);
        dev=findViewById(R.id.dev_info_text);
        teacher=findViewById(R.id.teacher_text);


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
                    case R.id.aboutid: temp= new aboutFragment(floatingActionButton2,dev_info_fab,teacher_fab,dev ,teacher);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp).commit();
                return true;
            }
        });}}
//
//}