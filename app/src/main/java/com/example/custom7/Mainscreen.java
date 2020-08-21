package com.example.custom7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Mainscreen extends AppCompatActivity {
    BottomNavigationView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        btn=findViewById(R.id.bnav);
        //NavController navController= Navigation.findNavController(MainScreen.this,R.id.l1);
        btn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
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
                }
                return true;
            }
        });
    }
}
