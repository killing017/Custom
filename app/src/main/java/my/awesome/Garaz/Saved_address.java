package my.awesome.Garaz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

public class Saved_address extends AppCompatActivity implements PaymentResultListener {
    private static final String TAG = Mainscreen.class.getSimpleName();

    String dateselected;
    String timeSlotSelected;

    TextView textView,textView2,textView3,textView4;
    TextView time1,time2,time3,time4;

    TextView address;
    String newloc;
    TextView price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_address);

        Checkout.preload(getApplicationContext());

        // get address from the shared prefernece which is saved initially and paste in the textview whose id is address;

        textView=findViewById(R.id.textview1);
        textView2=findViewById(R.id.textview2);
        textView3=findViewById(R.id.textview3);
        textView4=findViewById(R.id.textview4);
        address=findViewById(R.id.address);

        price=findViewById(R.id.price);

        Intent intent=getIntent();

        float amount=intent.getFloatExtra("amount",0.0f);

        String str=String.valueOf(amount);
       price.append(str);

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

        SharedPreferences savelocation =Saved_address.this.getSharedPreferences("location", MODE_PRIVATE);
        String loc = savelocation.getString("location", null);
        if (loc != null) {

            address.setText(loc);
        } else{

           address.setText("Address Not found");
        }

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


    public void startPayment(Float total) {

        /**
         * Instantiate Checkout
         */
        Checkout.preload(getApplicationContext());
        Checkout checkout = new Checkout();
        //checkout.setKeyID("rzp_test_YZ0rZv8DFWccCl");

        /**
         * Set your logo here
         */
        checkout.setImage(R.drawable.logo);

        /**
         * Reference to current activity
         */
        final Saved_address activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            options.put("name", "Example name");
            options.put("description", "Payment description ");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#FF0000");
            options.put("currency", "INR");
            options.put("amount", ""+total*100);//pass amount in currency subunits
            options.put("prefill.email", "amanm1408@gmail.com");
            options.put("prefill.contact","1234567089");
            checkout.open(activity, options);
        } catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment success--"+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {

        // Toast.makeText(this, i+"-"+s, Toast.LENGTH_SHORT).show();
        try {
            Toast.makeText(this, "error is coming--"+String.valueOf(i)+"--"+s, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Exception is coming--"+e, Toast.LENGTH_SHORT).show();
        }

    }

    public void edit_address(View view) {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);


         final View view1=getLayoutInflater().inflate(R.layout.activity_initial_address,null);

        mBuilder.setView(view1);
        mBuilder.setTitle("Enter New Address");

        Button button=view1.findViewById(R.id.savebtn);
        TextView skip=view1.findViewById(R.id.skipbtn);
        RelativeLayout relativeLayout=view1.findViewById(R.id.rlUseCurrentLocation);

        button.setVisibility(Button.GONE);
        skip.setVisibility(Button.GONE);
        relativeLayout.setVisibility(Button.GONE);

        final EditText add1,city,state,country,pincode;
        add1=view1.findViewById(R.id.edtAddress1);
        city=view1.findViewById(R.id.edtCity);
        state=view1.findViewById(R.id.edtState);
        country=view1.findViewById(R.id.edtCountry);
        pincode=view1.findViewById(R.id.edtPinCode);

        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String adress1=add1.getText().toString().trim();
                String City=city.getText().toString().trim();
                String State=state.getText().toString().trim();
                String Country=country.getText().toString().trim();
                String Pincod=pincode.getText().toString().trim();
                if(adress1.isEmpty() && City.isEmpty() && State.isEmpty() &&Country.isEmpty()&& Pincod.isEmpty()) {
                    Toast.makeText(Saved_address.this, " please Fill all form field", Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences savelocation = Saved_address.this.getSharedPreferences("location", MODE_PRIVATE);
                    SharedPreferences.Editor editor = savelocation.edit();
                     newloc = "" + adress1 + "," + City + "," + State + "," + Country + "," + Pincod;
                    editor.putString("location", newloc);
                    editor.commit();
                    editor.apply();

                }

                address.setText(newloc);

            }
        });

        mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        AlertDialog mDialog = mBuilder.create();
        mDialog.show();


        //startActivity(new Intent(Saved_address.this,Add_address.class));

    }

    public void proceed_btn(View view) {
        SharedPreferences sh =Saved_address.this.getSharedPreferences("ram", MODE_PRIVATE);
        Float amount=sh.getFloat("price",0.00f);

       startPayment(amount);

        //here set amount to layout and do payment;
        // proceed to pay.


    }
}
