package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import static java.lang.Thread.sleep;

public class Initial_address extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;

    EditText add1,city,state,country,pincode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_address);
        add1=findViewById(R.id.edtAddress1);
        city=findViewById(R.id.edtCity);
        state=findViewById(R.id.edtState);
        country=findViewById(R.id.edtCountry);
        pincode=findViewById(R.id.edtPinCode);
        if(ContextCompat.checkSelfPermission(Initial_address.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Initial_address.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }

    }

    public void gps(View view) throws InterruptedException {
        getLocation();
        sleep(3000);
        Intent intent=new Intent(Initial_address.this,Mainscreen.class);
        startActivity(intent);
        // if clicked here then automatically go to main screen and show the loacation on enter loaction place.
        // and store it in shared preference;

    }

    public void skipclick(View view) {
        startActivity(new Intent(Initial_address.this,Mainscreen.class));
    }

    public void save_address_click(View view) {
        String adress1=add1.getText().toString().trim();
        String City=city.getText().toString().trim();
        String State=state.getText().toString().trim();
        String Country=country.getText().toString().trim();
        String Pincod=pincode.getText().toString().trim();
        if(adress1.isEmpty() && City.isEmpty() && State.isEmpty() &&Country.isEmpty()&& Pincod.isEmpty()) {
            Toast.makeText(Initial_address.this, " please Fill all form field", Toast.LENGTH_SHORT).show();
        }else {
            SharedPreferences savelocation = Initial_address.this.getSharedPreferences("location", MODE_PRIVATE);
            SharedPreferences.Editor editor = savelocation.edit();
            String newloc = "" + adress1 + "," + City + "," + State + "," + Country + "," + Pincod;
            editor.putString("location", newloc);
            editor.commit();
            editor.apply();
            Intent intent = new Intent(Initial_address.this, Mainscreen.class);
            startActivity(intent);
        }
        // save address in shared preference with uniqe name and also show it on main screen in place of enter loacation;
// and also check whether all fields are filled or not.
    }
    @SuppressLint("MissingPermission")
    private  void  getLocation(){
        try{
            locationManager=(LocationManager)getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,6000,0,Initial_address.this);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void onLocationChanged(android.location.Location location) {
        try{
            Geocoder geocoder=new Geocoder(Initial_address.this, Locale.getDefault());
            List<Address> addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),3);
            String address=addresses.get(0).getAddressLine(0);
            SharedPreferences savelocation=Initial_address.this.getSharedPreferences("location",MODE_PRIVATE);
            SharedPreferences.Editor editor=savelocation.edit();
            editor.putString("location",address);
            editor.commit();
            editor.apply();
          //  Toast.makeText(this, address, Toast.LENGTH_LONG).show();
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
