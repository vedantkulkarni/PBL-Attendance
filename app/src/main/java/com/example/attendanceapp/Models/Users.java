package com.example.attendanceapp.Models;

import android.widget.Toast;

import com.example.attendanceapp.MainActivity;

public class Users {
    String roll;
    String email;

    public Users(String roll, String email, String password) {
        this.roll = roll;
        this.email = email;
        this.password = password;

    }
    public Users(){}

    public String getUsername() {
        return roll;
    }

    public void setroll(String roll) {
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

    String password ;
}
