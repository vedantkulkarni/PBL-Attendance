package com.example.attendanceapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link aboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class aboutFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static FloatingActionButton floatingActionButton2 , dev_info_fab , teacher_fab ;
    private static TextView dev , teacher;
    boolean isAllVisible;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public aboutFragment(FloatingActionButton floatingActionButton2 , FloatingActionButton dev_info_fab , FloatingActionButton teacher_fab , TextView dev ,TextView teacher) {
        this.floatingActionButton2 = floatingActionButton2;
        this.dev_info_fab=dev_info_fab;
        this.teacher_fab=teacher_fab;
        this.dev = dev;
        this.teacher = teacher;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment aboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static aboutFragment newInstance(String param1, String param2) {
        aboutFragment fragment = new aboutFragment(floatingActionButton2,dev_info_fab,teacher_fab,dev ,teacher);
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
        View v =inflater.inflate(R.layout.fragment_about, container, false);
        floatingActionButton2=v.findViewById(R.id.floatingActionButton2);
        dev_info_fab=v.findViewById(R.id.dev_info_fab);
        teacher_fab=v.findViewById(R.id.teacher_fab);
        dev=v.findViewById(R.id.dev_info_text);
        teacher=v.findViewById(R.id.teacher_text);

        dev_info_fab.setVisibility(View.GONE);
        teacher_fab.setVisibility(View.GONE);
        dev.setVisibility(View.GONE);
        teacher.setVisibility(View.GONE);
        isAllVisible=false;

        floatingActionButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllVisible) {

                            // when isAllFabsVisible becomes
                            // true make all the action name
                            // texts and FABs VISIBLE.
                            dev_info_fab.show();
                            teacher_fab.show();
                            dev.setVisibility(View.VISIBLE);
                            teacher.setVisibility(View.VISIBLE);

                            // make the boolean variable true as
                            // we have set the sub FABs
                            // visibility to GONE
                            isAllVisible = true;
                        } else {

                            // when isAllFabsVisible becomes
                            // true make all the action name
                            // texts and FABs GONE.
                            dev_info_fab.hide();
                            teacher_fab.hide();
                            dev.setVisibility(View.GONE);
                            teacher.setVisibility(View.GONE);

                            // make the boolean variable false
                            // as we have set the sub FABs
                            // visibility to GONE
                            isAllVisible = false;
                        }
                    }
                });

        dev_info_fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fragment temp = null;
                        temp = new Dev_contact();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp).commit();

                    }
                });
        teacher_fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fragment temp1 = null;
                        temp1=new Teacher_contact();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp1).commit();
                    }
                });
        return v ;
    }
}