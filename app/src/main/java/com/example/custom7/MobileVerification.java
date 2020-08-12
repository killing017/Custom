package com.example.custom7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MobileVerification extends AppCompatActivity {

    EditText  otp;
    TextView phone;
    String strotp,strphone;
    String finalResult ;
    String HttpURL = "https://www.cakiweb.com/mechanic/request-api/api.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_verification);

        phone=findViewById(R.id.phone);
        otp=findViewById(R.id.otp);

        Intent intent=getIntent();
        String strphone =intent.getExtras().getString("phone");
        strotp=intent.getExtras().getString("otp");

        phone.setText(strphone);
        otp.setText(strotp);


    }

    public void onClickverify(View view) {

        CheckEditTextIsEmptyOrNot();

        if(CheckEditText){

            // If EditText is not empty and CheckEditText = True then this block will execute.

            UserRegisterFunction("verifyRegistration", strphone, strotp);

        }
        else {

            // If EditText is empty then this block will execute .
            Toast.makeText(MobileVerification.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

        }

    }
    public void CheckEditTextIsEmptyOrNot(){




        if(TextUtils.isEmpty(strphone) || TextUtils.isEmpty(strotp) )
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }

    }

    public void UserRegisterFunction(final String method,final String phone, final String otp){

        class UserVerificationFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(MobileVerification.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();
                boolean msg=httpResponseMsg.contains("200");

                if(msg){
                  Intent intent=new Intent(MobileVerification.this,Signup.class);
                  startActivity(intent);
                }
                else{
                    Toast.makeText(MobileVerification.this, "Something is wrong, try again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("method",params[0]);

                hashMap.put("customer_mobile",params[1]);
                hashMap.put("otp",params[2]);


                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserVerificationFunctionClass userRegisterFunctionClass = new UserVerificationFunctionClass();

        userRegisterFunctionClass.execute(method,phone,otp);
    }

}
