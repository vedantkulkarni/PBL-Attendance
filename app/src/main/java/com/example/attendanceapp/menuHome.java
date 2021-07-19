package com.example.attendanceapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Integer.valueOf;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menuHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menuHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static Button attendanceBt;
    private FirebaseDatabase aDatabase = FirebaseDatabase.getInstance("https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
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
    public static int[] sum;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public menuHome(Button attendanceBt, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30) {
        // Required empty public constructor
        this.attendanceBt = attendanceBt;
        this.textView17 = textView17;
        this.textView18 = textView18;
        this.textView19 = textView19;
        this.textView20 = textView20;
        this.textView21 = textView21;
        this.textView22 = textView22;
        this.textView23 = textView23;
        this.textView24 = textView24;
        this.textView25 = textView25;
        this.textView26 = textView26;
        this.textView27 = textView27;
        this.textView28 = textView28;
        this.textView29 = textView29;
        this.textView30 = textView30;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menuHome.
     */
    // TODO: Rename and change types and number of parameters
    public static menuHome newInstance(String param1, String param2) {
        menuHome fragment = new menuHome(attendanceBt, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30);
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

        View v = inflater.inflate(R.layout.fragment_menu_home, container, false);
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
        sum=new int[14];

        attendanceBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aDatabase = FirebaseDatabase.getInstance("https://attendanceapp-7ed22-default-rtdb.asia-southeast1.firebasedatabase.app/");
                String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
//               aDatabase=FirebaseDatabase.getInstance().getReference();
                aDatabase.getReference().child("Users").child(currentuser).child("roll").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
//                            Toast.makeText(menuHome.this , "failed to get value " , Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                            userattendance.setText(String.valueOf(task.getResult().getValue()));
                            String rollNumber = String.valueOf(task.getResult().getValue());
                            aDatabase.getReference().child("FE8").child("BASIC ELECTRICAL ENGINEERING").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView17.setText("0");//not coming here
                                    }

                                    else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView17.setText(String.valueOf(task.getResult().getValue()));
                                            try{textView17.setText(String.valueOf(task.getResult().getValue()));
//
                                                String s=String.valueOf(task.getResult().getValue());
                                                sum[0]=Integer.parseInt(s);
                                            }catch (Exception e){
                                                textView17.setText("3");
                                                sum[0]=0;
                                            }



                                    }
                                }
                            });//1
                            aDatabase.getReference().child("FE8").child("ENGINEERING MECHANICS").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView18.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView18.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[1]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView18.setText("0");
                                            sum[1]=0;
                                        }
                                    }
                                }
                            });//2
                            aDatabase.getReference().child("FE8").child("ENGINEERING PHYSICS").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView19.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView19.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[2]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView19.setText("0");
                                            sum[2]=0;
                                        }
                                    }
                                }
                            });//3
                            aDatabase.getReference().child("FE8").child("ENGINEERING MATHEMATICS II").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView20.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView20.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[3]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView20.setText("0");
                                            sum[3]=0;
                                        }
                                    }
                                }
                            });//4
                            aDatabase.getReference().child("FE8").child("ENGINEERING MECHANICS LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView21.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView21.setText(String.valueOf(task.getResult().getValue()));
                                        try{String s=String.valueOf(task.getResult().getValue());
                                            sum[4]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView21.setText("0");
                                            sum[4]=0;
                                        }
                                    }
                                }
                            });//5
                            aDatabase.getReference().child("FE8").child("ENGINEERING PHYSICS LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView22.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView22.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[5]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView22.setText("0");
                                            sum[5]=0;
                                        }
                                    }
                                }
                            });//6
                            aDatabase.getReference().child("FE8").child("BASIC ELECTRICAL ENGINEERING LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView23.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView23.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[6]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView23.setText("0");
                                            sum[6]=0;
                                        }
                                    }
                                }
                            });//7
                            aDatabase.getReference().child("FE8").child("ENVIRONMENTAL STUDIES - II").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView24.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView24.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[7]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView24.setText("0");
                                            sum[7]=0;
                                        }
                                    }
                                }
                            });//8
                            aDatabase.getReference().child("FE8").child("PROJECT BASED LEARNING LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView25.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView25.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[8]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView25.setText("0");
                                            sum[8]=0;
                                        }
                                    }
                                }
                            });//9
                            aDatabase.getReference().child("FE8").child("ENGINEERING GRAPHICS").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView26.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView26.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[9]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView26.setText("0");
                                            sum[9]=0;
                                        }
                                    }
                                }
                            });//10
                            aDatabase.getReference().child("FE8").child("ENGINEERING GRAPHICS LAB").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView27.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView27.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[10]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView27.setText("0");
                                            sum[10]=0;
                                        }
                                    }
                                }
                            });//11
                            aDatabase.getReference().child("FE8").child("ENGINEERING GRAPHICS TUTORIAL").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView28.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView28.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[11]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView28.setText("0");
                                            sum[11]=0;
                                        }
                                    }
                                }
                            });//12
                            aDatabase.getReference().child("FE8").child("ENGINEERING MATHEMATICS II TUT").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView29.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView29.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[12]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView29.setText("0");
                                            sum[12]=0;
                                        }
                                    }
                                }
                            });//13
                            aDatabase.getReference().child("FE8").child("PHYSICAL EDUCATION").child(rollNumber).child("Per(%)").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()) {
                                        textView30.setText("0");
                                    } else {
                                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                        textView30.setText(String.valueOf(task.getResult().getValue()));
                                        try{
                                            String s=String.valueOf(task.getResult().getValue());
                                            sum[13]=Integer.parseInt(s);
                                        }catch (Exception e){
                                            textView30.setText("0");
                                            sum[13]=0;
                                        }
                                    }
                                }
                            });//14



                        }
                    }
                });
            }
        });



        return v;
    }
}