package com.example.attendanceapp.Models;

import android.widget.Toast;

import com.example.attendanceapp.MainActivity;

public class Users {
    String roll;
    String email;
    String password ;
    double attendance;



    public Users(String roll, String email, String password) {
        this.roll = roll;
        this.email = email;
        this.password = password;
        this.attendance= 100.0;

    }
    public Users(){}

    public String getRoll() {
        return roll;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
