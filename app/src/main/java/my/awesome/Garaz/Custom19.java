package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.custom7.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Custom19 extends AppCompatActivity {
    EditText name , email , phone, password;
    String strname, stremail, strphone, strpassword;
    String finalResult ;
    String HttpURL = "https://www.cakiweb.com/mechanic/request-api/api.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom19);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);



    }



    public void onClickSubmit(View view) {
        //startActivity(new Intent(Custom19.this,MobileVerification.class));

        // Checking whether EditText is Empty or Not
        CheckEditTextIsEmptyOrNot();

        if(CheckEditText){

            SharedPreferences sharedPreferences1=Custom19.this.getSharedPreferences("profie",MODE_PRIVATE);
            final SharedPreferences.Editor edit=sharedPreferences1.edit();
            edit.putString("name",strname);
            edit.putString("email",stremail);
            edit.putString("phone",strphone);
            edit.apply();
            // If EditText is not empty and CheckEditText = True then this block will execute.

            UserRegisterFunction("registerUser",strname,stremail, strphone, strpassword);

        }
        else {

            // If EditText is empty then this block will execute .
            Toast.makeText(Custom19.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

        }

    }
    public void CheckEditTextIsEmptyOrNot(){

        strname = name.getText().toString();
        stremail = email.getText().toString();
        strphone = phone.getText().toString();
        strpassword = password.getText().toString();


        if(TextUtils.isEmpty(strname) || TextUtils.isEmpty(stremail) || TextUtils.isEmpty(strphone) || TextUtils.isEmpty(strpassword))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }

    }

    public void UserRegisterFunction(final String method,final String name, final String Email, final String phone, final String password){

        class UserRegisterFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(Custom19.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();
                boolean msg=httpResponseMsg.contains("200");

                if(msg){

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(httpResponseMsg);
                        String messege= jsonObject.getString("otp");

                        Intent intent=new Intent(Custom19.this,MobileVerification.class);
                        intent.putExtra("phone",strphone);
                        intent.putExtra("otp",messege);
                        startActivity(intent);

                        //Toast.makeText(Custom19.this, messege, Toast.LENGTH_SHORT).show();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(httpResponseMsg);
                        String messege = jsonObject.getString("msg");
                        Toast.makeText(Custom19.this, messege, Toast.LENGTH_SHORT).show();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("method",params[0]);

                hashMap.put("customer_name",params[1]);

                hashMap.put("customer_email",params[2]);

                hashMap.put("customer_mobile",params[3]);

                hashMap.put("customer_password",params[4]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();

        userRegisterFunctionClass.execute(method,name,Email,phone,password);
    }




}
