//package com.example.custom7;
package my.awesome.Garaz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class Mainscreen extends AppCompatActivity implements PaymentResultListener {
    private static final String TAG = Mainscreen.class.getSimpleName();
    BottomNavigationView btn;
    float Total;
    String Name,Email,Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        btn=findViewById(R.id.bnav);
        SharedPreferences sharedPreferences12=Mainscreen.this.getSharedPreferences("profie",MODE_PRIVATE);
        if(sharedPreferences12!=null) {
            Email = sharedPreferences12.getString("email", null);
            Name = sharedPreferences12.getString("name", null);

            Phone = sharedPreferences12.getString("phone", null);
        }
//        SharedPreferences sharedPreferences1 =Mainscreen.this.getSharedPreferences("ram", MODE_PRIVATE);
//       Total=sharedPreferences1.getFloat("price",0.0f);
//       Total=Total*1000;
//        Toast.makeText(this, ""+Total, Toast.LENGTH_SHORT).show();
        Checkout.preload(getApplicationContext());

        Homefrag homefrag4=new Homefrag();
        FragmentTransaction fragmentTransaction4=getSupportFragmentManager().beginTransaction();
        fragmentTransaction4.replace(R.id.l1,homefrag4);
        fragmentTransaction4.commit();


        //NavController navController= Navigation.findNavController(MainScreen.this,R.id.l1);
        btn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.home:
                        btn=findViewById(R.id.bnav);
                        Homefrag homefrag=new Homefrag();
                        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.l1,homefrag);
                        fragmentTransaction.commit();
                        break;
                    case R.id.search:
                        searchfrag search=new searchfrag();
                        FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.l1,search);
                        fragmentTransaction1.commit();
                        break;
                    case R.id.car:
                        Carfrag carfrag=new Carfrag();
                        FragmentTransaction fragmentTransaction2=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.l1,carfrag);
                        fragmentTransaction2.commit();
                        break;
                    case R.id.account:
                        Accountfrag accountfrag=new Accountfrag();
                        FragmentTransaction fragmentTransaction3=getSupportFragmentManager().beginTransaction();

                        fragmentTransaction3.replace(R.id.l1,accountfrag);
                        fragmentTransaction3.commit();
                        break;
                    case R.id.cart:

                        Cartfrag cartfrag=new Cartfrag();
                        FragmentTransaction fragmentTransaction7=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction7.detach(cartfrag);
                        fragmentTransaction7.attach(cartfrag);
                        fragmentTransaction7.replace(R.id.l1,cartfrag);
                        fragmentTransaction7.commit();
                        SharedPreferences sh =Mainscreen.this.getSharedPreferences("MySharedPref", MODE_PRIVATE);
                        //   Toast.makeText(getActivity(), ""+sh.getAll().size(), Toast.LENGTH_SHORT).show();
                        int n=sh.getAll().size();
                        btn.getOrCreateBadge(R.id.cart).setNumber(n);
                        break;
                }
                return true;

            }
        });

        SharedPreferences sh =Mainscreen.this.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        //   Toast.makeText(getActivity(), ""+sh.getAll().size(), Toast.LENGTH_SHORT).show();
        int n=sh.getAll().size();
        btn.getOrCreateBadge(R.id.cart).setNumber(n);

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
        final Mainscreen activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            options.put("name", ""+Name);
            options.put("description", "Payment description ");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#FF0000");
            options.put("currency", "INR");
            options.put("amount", ""+total*100);//pass amount in currency subunits
            options.put("prefill.email", ""+Email);
            options.put("prefill.contact",""+Phone);
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

//    public void onBackPressed() {
//
//        new AlertDialog.Builder(this)
//                .setTitle("Really Exit?")
//                .setMessage("Are you sure you want to exit?")
//                .setNegativeButton(android.R.string.no, null)
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Mainscreen.super.onBackPressed();
//                        quit();
//                    }
//                }).create().show();
//    }
//
//
//    public void quit() {
//        Intent start = new Intent(Intent.ACTION_MAIN);
//        start.addCategory(Intent.CATEGORY_HOME);
//        start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(start);
//    }
}
