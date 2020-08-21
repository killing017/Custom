package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//import com.example.custom7.R;

public class MainActivity extends AppCompatActivity {
    private static int splash_time=1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent=new Intent(MainActivity.this,Mainscreen.class);
                startActivity(intent);

            }
        },splash_time);

    }
}
