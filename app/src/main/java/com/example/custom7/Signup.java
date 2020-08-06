package com.example.custom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void SignUpPageClick(View view) {
        startActivity(new Intent(Signup.this,Custom19.class));
    }

    public void onClickSignInBtn(View view) {
        Toast.makeText(this, " Create New Account ", Toast.LENGTH_SHORT).show();
    }
}
