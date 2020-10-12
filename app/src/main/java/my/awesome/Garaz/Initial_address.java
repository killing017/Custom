package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Initial_address extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_address);
    }

    public void gps(View view) {

        // if clicked here then automatically go to main screen and show the loacation on enter loaction place.
        // and store it in shared preference;

    }

    public void skipclick(View view) {
        startActivity(new Intent(Initial_address.this,Mainscreen.class));
    }

    public void save_address_click(View view) {

        // save address in shared preference with uniqe name and also show it on main screen in place of enter loacation;
// and also check whether all fields are filled or not.
    }
}
