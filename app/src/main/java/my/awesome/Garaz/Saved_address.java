package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class Saved_address extends AppCompatActivity {
    String dateselected;
    String timeSlotSelected;

    TextView textView,textView2,textView3,textView4;
    TextView time1,time2,time3,time4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_address);


        // get address from the shared prefernece which is saved initially and paste in the textview whose id is address;

        textView=findViewById(R.id.textview1);
        textView2=findViewById(R.id.textview2);
        textView3=findViewById(R.id.textview3);
        textView4=findViewById(R.id.textview4);
        Calendar calendar= Calendar.getInstance();
        Date currentdate= calendar.getTime();
        String date=""+currentdate;
        String a[]=date.split(" ");
        textView.setText(a[2]+" "+a[0]);
        calendar.add(Calendar.DATE,1);
        Date future=calendar.getTime();
        String date1=""+future;
        String b[]=date1.split(" ");
        textView2.setText(b[2]+" "+b[0]);
        calendar.add(Calendar.DATE,1);
        Date future2=calendar.getTime();
        String date2=""+future2;
        String c[]=date2.split(" ");
        textView3.setText(c[2]+" "+c[0]);
        calendar.add(Calendar.DATE,1);
        Date future3=calendar.getTime();
        String date3=""+future3;
        String d[]=date3.split(" ");
        textView4.setText(d[2]+" "+d[0]);




        time2=findViewById(R.id.afternoon);
        time3=findViewById(R.id.evening);
        time4=findViewById(R.id.night);

        textView.setOnClickListener(new View.OnClickListener() {


            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                textView.setBackgroundResource(R.drawable.customborder);

                dateselected=textView.getText().toString();
//                textView.setBackgroundColor(R.color.colorAccent);

                textView2.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                textView3.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                textView4.setBackgroundResource(R.drawable.bg_rounded_border_edittext);

            }
        });


        textView2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                textView2.setBackgroundResource(R.drawable.customborder);

                dateselected=textView2.getText().toString();

                textView.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                textView3.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                textView4.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
//
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                textView3.setBackgroundResource(R.drawable.customborder);

                dateselected=textView3.getText().toString();

                textView2.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                textView.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                textView4.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
//
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                textView4.setBackgroundResource(R.drawable.customborder);

                dateselected=textView4.getText().toString();

                textView2.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                textView3.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                textView.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
//
            }
        });
        time1=findViewById(R.id.morning);
       // time1.setVisibility(View.INVISIBLE);
//        int t1=Integer.parseInt(time1.getText().toString());
        Calendar calendar1= Calendar.getInstance();
        int hour= calendar1.getTime().getHours();
        time1.setOnClickListener(new View.OnClickListener() {


            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                time1.setBackgroundResource(R.drawable.customborder);

                timeSlotSelected=time1.getText().toString();
//                textView.setBackgroundColor(R.color.colorAccent);

                time2.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                time3.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                time4.setBackgroundResource(R.drawable.bg_rounded_border_edittext);

            }
        });
        time2.setOnClickListener(new View.OnClickListener() {


            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                time2.setBackgroundResource(R.drawable.customborder);

                timeSlotSelected=time2.getText().toString();
//                textView.setBackgroundColor(R.color.colorAccent);

                time1.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                time3.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                time4.setBackgroundResource(R.drawable.bg_rounded_border_edittext);

            }
        });
        time3.setOnClickListener(new View.OnClickListener() {


            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                time3.setBackgroundResource(R.drawable.customborder);

                timeSlotSelected=time3.getText().toString();
//                textView.setBackgroundColor(R.color.colorAccent);

                time1.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                time2.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                time4.setBackgroundResource(R.drawable.bg_rounded_border_edittext);

            }
        });
        time4.setOnClickListener(new View.OnClickListener() {


            @SuppressLint("ResourceAsColor")
            public void onClick(View view) {
                time4.setBackgroundResource(R.drawable.customborder);

                timeSlotSelected=time4.getText().toString();
//                textView.setBackgroundColor(R.color.colorAccent);

                time1.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                time2.setBackgroundResource(R.drawable.bg_rounded_border_edittext);
                time3.setBackgroundResource(R.drawable.bg_rounded_border_edittext);

            }
        });

    }

    public void edit_address(View view) {

        startActivity(new Intent(Saved_address.this,Add_address.class));

    }

    public void proceed_btn(View view) {
        SharedPreferences sh =Saved_address.this.getSharedPreferences("ram", MODE_PRIVATE);
        Float amount=sh.getFloat("price",0.00f);
        //here set amount to layout and do payment;
        // proceed to pay.


    }
}
