package com.example.custom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Custom19 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom19);
    }

    public void onclicksignup(View view) {
        startActivity(new Intent(Custom19.this,MobileVerification.class));
    }
}
