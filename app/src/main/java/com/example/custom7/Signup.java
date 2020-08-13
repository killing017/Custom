package com.example.custom7;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
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
    JsonHttpParse jsonhttpParse = new JsonHttpParse();
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

    public void onClickSignInBtn2(View view){

//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\"method\":\"login\",\"customer_email\":\"aman123@gmail.com\",\"customer_password\":\"aman@123\"}");
//        DownloadManager.Request request = new Request.Builder()
//                .url("https://www.cakiweb.com/mechanic/json-api/api.php")
//                .post(body)
//                .addHeader("content-type", "application/json")
//                .addHeader("cache-control", "no-cache")
//                .addHeader("postman-token", "da073a98-56c2-d163-a286-9ecf0d94d37e")
//                .build();
//
//        Response response = client.newCall(request).execute();

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

               // Toast.makeText(Signup.this, httpResponseMsg, Toast.LENGTH_SHORT).show();

                if(httpResponseMsg.contains("200")){
                   // Toast.makeText(Signup.this, httpResponseMsg, Toast.LENGTH_SHORT).show();
                    Toast.makeText(Signup.this, "Logged in successfully !", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Signup.this,Custom14.class));

                }else{
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(httpResponseMsg);
                        String messege = jsonObject.getString("msg");
                        Toast.makeText(Signup.this, messege, Toast.LENGTH_SHORT).show();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }






            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected String doInBackground(String... params) {

//                hashMap.put("method",params[0]);
//                hashMap.put("customer_email",params[1]);
//                hashMap.put("customer_password",params[2]);

               // Toast.makeText(Signup.this, hashMap.toString(), Toast.LENGTH_SHORT).show();

                finalResult = jsonhttpParse.postRequest(method,Email,Password, HttpURL);

                return finalResult;
            }
        }

            UserLoginClass userLoginClass = new UserLoginClass();

                userLoginClass.execute(method,Email,Password);
                        }

                        }

