package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Myprofile extends AppCompatActivity {
    TextView name2 , email2 , phone2, password;
    String name,email,phone,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        name2=findViewById(R.id.name);
        email2=findViewById(R.id.email);
        phone2=findViewById(R.id.phone);

        SharedPreferences sharedPreferences2 = Myprofile.this.getSharedPreferences("MySharedPref2", MODE_PRIVATE);

        String httpResponseMsg=sharedPreferences2.getString("login","");
        JSONObject jsonObject = null;
       
        try {
            jsonObject = new JSONObject(httpResponseMsg);

            JSONArray array = jsonObject.getJSONArray("result");



            for (int i = 0; i < array.length(); i++) {
                            JSONObject ob = array.getJSONObject(i);
                             id=ob.getString("id");
                            name=ob.getString("customer_name");
                            email=ob.getString("customer_email");
                            phone=ob.getString("customer_mobile");

                        }

            Toast.makeText(this, ""+email+"--"+phone, Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        SharedPreferences sharedPreferences1=Myprofile.this.getSharedPreferences("profie",MODE_PRIVATE);
//         String Name=sharedPreferences1.getString("name",null);
//
//         String Email=sharedPreferences1.getString("email",null);
//
//         String Phone=sharedPreferences1.getString("phone",null);
//
//

//         if(sharedPreferences1!=null){

//         }
        SharedPreferences sharedPreferences3 = Myprofile.this.getSharedPreferences("id", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences3.edit();
        editor.putString("id",id);
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("phone",phone);
        editor.apply();
        name2.setText(name);
        email2.setText(email);
        phone2.setText(phone);

    }
}
