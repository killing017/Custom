package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class Add_address extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    String dateselected;
    String timeSlotSelected;

    TextView textView,textView2,textView3,textView4;
    TextView time1,time2,time3,time4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        if(ContextCompat.checkSelfPermission(Add_address.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Add_address.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }

        textView=findViewById(R.id.textview1);
        textView2=findViewById(R.id.textview2);
        textView3=findViewById(R.id.textview3);
        textView4=findViewById(R.id.textview4);

        time1=findViewById(R.id.morning);
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
    public void gps(View view) {

        getLocation();
    }

    @SuppressLint("MissingPermission")
    private  void  getLocation(){
        try{
            locationManager=(LocationManager)getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,6000,0, Add_address.this);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void onLocationChanged(android.location.Location location) {
        try{
            Geocoder geocoder=new Geocoder(Add_address.this, Locale.getDefault());
            List<Address> addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),3);
            String address=addresses.get(0).getAddressLine(0);
            Toast.makeText(this, address, Toast.LENGTH_LONG).show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
