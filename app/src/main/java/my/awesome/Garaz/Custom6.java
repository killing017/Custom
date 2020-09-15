package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

//import com.example.custom7.R;

public class Custom6 extends AppCompatActivity {
    float x1,y1,x2,y2;
    Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom6);
        button=findViewById(R.id.skip);
        button1=findViewById(R.id.start);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Custom6.this,Signup.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Custom6.this,Signup.class);
                startActivity(intent);
            }
        });
    }
    public boolean onTouchEvent( MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1=event.getX();
                y1=event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2=event.getX();
                y2=event.getY();
                if(x1<x2){
                    Intent intent=new Intent(Custom6.this,Custom2.class);
                    startActivity(intent);
                }
                break;
        }
        return true;
    }
}
