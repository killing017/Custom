package com.example.custom7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.HashMap;

public class Signup extends AppCompatActivity {
    String HttpURL = "https://www.cakiweb.com/mechanic/json-api/api.php";
    EditText email,password;
    Button signin;
    String stremail, strpassword;
    String finalResult ;
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
   // public static final String UserEmail = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signin=findViewById(R.id.signin);


//        stremail=email.getText().toString();
//        strpassword=password.getText().toString();


    }

    public void SignUpPageClick(View view) {
        startActivity(new Intent(Signup.this,Custom19.class));
    }

    public void onClickSignInBtn(View view) {
        CheckEditTextIsEmptyOrNot();

        if(CheckEditText){


            UserLoginFunction("login",stremail,strpassword);

        }
        else {

            Toast.makeText(Signup.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

        }

    }


    public void CheckEditTextIsEmptyOrNot(){

        stremail = email.getText().toString();
        strpassword = password.getText().toString();

        if(TextUtils.isEmpty(stremail) || TextUtils.isEmpty(strpassword))
        {
        CheckEditText = false;
        }
        else {

        CheckEditText = true ;
        }
        }

        public void UserLoginFunction(final String method,final String Email, final String Password){



        class UserLoginClass extends AsyncTask<String,Void,String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(Signup.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(Signup.this, httpResponseMsg, Toast.LENGTH_SHORT).show();

                if(httpResponseMsg.contains("200")){
                    Toast.makeText(Signup.this, "200", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Signup.this, "empty", Toast.LENGTH_SHORT).show();
                }






            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("method",params[0]);
                hashMap.put("customer_email",params[1]);
                hashMap.put("customer_password",params[2]);

                Toast.makeText(Signup.this, hashMap.toString(), Toast.LENGTH_SHORT).show();

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

            UserLoginClass userLoginClass = new UserLoginClass();

                userLoginClass.execute(method,Email,Password);
                        }

                        }

