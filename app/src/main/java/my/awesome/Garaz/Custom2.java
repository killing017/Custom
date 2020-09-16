package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

//import com.example.custom7.R;

public class Custom2 extends AppCompatActivity {
    float x1,y1,x2,y2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom2);
button=findViewById(R.id.skip);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Custom2.this,Signup.class);
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
                    Intent intent=new Intent(Custom2.this,Custom3.class);

                    startActivity(intent);

                }else if(x1>x2){
                    Intent intent=new Intent(Custom2.this,Custom6.class);

                    startActivity(intent);

                }
                break;
        }
        return true;
    }
}
