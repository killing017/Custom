package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.provider.ContactsContract;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Myprofile extends AppCompatActivity {
    TextView name , email , phone, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        SharedPreferences sharedPreferences1=Myprofile.this.getSharedPreferences("profie",MODE_PRIVATE);
         String Name=sharedPreferences1.getString("name",null);

         String Email=sharedPreferences1.getString("email",null);

         String Phone=sharedPreferences1.getString("phone",null);

         if(sharedPreferences1!=null){
             name.setText(Name);
             email.setText(Email);
             phone.setText(Phone);
         }

    }
}
