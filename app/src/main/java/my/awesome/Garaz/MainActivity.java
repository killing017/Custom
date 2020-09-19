package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

//import com.example.custom7.R;

public class MainActivity extends AppCompatActivity {
    private static int splash_time=1500;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences2 = this.getSharedPreferences("MySharedPref2", MODE_PRIVATE);
        s= sharedPreferences2.getString("login",null);
       // Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                if(s!=null){
                    Intent intent=new Intent(MainActivity.this,Mainscreen.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, Signup.class);
                    startActivity(intent);
                }
            }
        },splash_time);

    }
}
