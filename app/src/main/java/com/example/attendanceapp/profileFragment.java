package com.example.attendanceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FirebaseDatabase aDatabase = FirebaseDatabase.getInstance("https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private static TextView profile_name ;
    private static TextView profile_email ;
    private static TextView attendance_text;
    private static Button attendanceBt;
//    private FirebaseDatabase aDatabase = FirebaseDatabase.getInstance("https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private static TextView textView17;
    private static TextView textView18;
    private static TextView textView19;
    private static TextView textView20;
    private static TextView textView21;
    private static TextView textView22;
    private static TextView textView23;
    private static TextView textView24;
    private static TextView textView25;
    private static TextView textView26;
    private static TextView textView27;
    private static TextView textView28;
    private static TextView textView29;
    private static TextView textView30;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_profile, container, false);
        profile_name=v.findViewById(R.id.nameView20);
        profile_email=v.findViewById(R.id.emailright);
        attendance_text=v.findViewById(R.id.rollno1right);
        attendanceBt = v.findViewById((R.id.button3));
        textView17 = v.findViewById(R.id.textView17);
        textView18 = v.findViewById(R.id.textView18);
        textView19 = v.findViewById(R.id.textView19);
        textView20 = v.findViewById(R.id.textView20);
        textView21 = v.findViewById(R.id.textView21);
        textView22 = v.findViewById(R.id.textView22);
        textView23 = v.findViewById(R.id.textView23);
        textView24 = v.findViewById(R.id.textView24);
        textView25 = v.findViewById(R.id.textView25);
        textView26 = v.findViewById(R.id.textView26);
        textView27 = v.findViewById(R.id.textView27);
        textView28 = v.findViewById(R.id.textView28);
        textView29 = v.findViewById(R.id.textView29);
        textView30 = v.findViewById(R.id.textView30);
        aDatabase = FirebaseDatabase.getInstance("https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        aDatabase.getReference().child("Users").child(currentuser).child("roll").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
//                            Toast.makeText(menuHome.this , "failed to get value " , Toast.LENGTH_SHORT).show();
                } else {
                    profile_name.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });
        aDatabase.getReference().child("Users").child(currentuser).child("email").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
//                            Toast.makeText(menuHome.this , "failed to get value " , Toast.LENGTH_SHORT).show();
                } else {
                    profile_email.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });
//        profileFragment onStart = new profileFragment();
//        menuHome on2start = new menuHome(attendanceBt, textView17, textView18, textView19, textView20, textView21,  textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30);

        double add=0;
        for(int i=0;i<14;i++)
        {
            add+=menuHome.sum[i];
        }
        add=add/14;
        attendance_text.setText(String.valueOf(add));
        aDatabase.getReference().child("Users").child(currentuser).child("attendance").setValue(add);


        return v;
    }
}