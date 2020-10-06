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
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class Add_address extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        if(ContextCompat.checkSelfPermission(Add_address.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Add_address.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }

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
