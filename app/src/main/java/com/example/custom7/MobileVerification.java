package com.example.custom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MobileVerification extends AppCompatActivity {

    EditText  otp;
    TextView phone;
    String otpno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_verification);

        phone=findViewById(R.id.phone);
        otp=findViewById(R.id.otp);

        Intent intent=getIntent();
        String phoneno =intent.getExtras().getString("phone");
        otpno=intent.getExtras().getString("otp");

        phone.setText(phoneno);
        otp.setText(otpno);


    }

    public void onClickverify(View view) {

        String pass=otp.getText().toString();
        if(pass.equals(otpno)){
            Toast.makeText(this, "Otp verified !", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Please enter correct otp", Toast.LENGTH_SHORT).show();
        }
    }
}
