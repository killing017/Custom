package my.awesome.Garaz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


public class Accountfrag extends Fragment  {

TextView logout,mycars;
TextView account;
    public Accountfrag() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_accountfrag, container, false);
     logout=view.findViewById(R.id.logout);
        final SharedPreferences sharedPreferences2 =this.getActivity().getSharedPreferences("MySharedPref2", MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences2.edit();

      logout.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
             builder.setTitle("Logout");
             builder.setMessage("Are you sure you want to logout?");
             builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                     editor.clear();
                     editor.apply();
                    Intent intent=new Intent(getActivity(),Signup.class);
                    startActivity(intent);
                 }
             });

             builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialogInterface, int i){
                     dialogInterface.dismiss();
                 }
             });

             builder.show();

         }
     });

     account=view.findViewById(R.id.profile);
     account.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(getActivity(),Myprofile.class);
             startActivity(intent);

         }
     });
     mycars=view.findViewById(R.id.cars);
     mycars.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             searchfrag searchfrag=new searchfrag();
             FragmentTransaction fragmentTransaction2=getParentFragmentManager().beginTransaction();
             fragmentTransaction2.replace(R.id.l1,searchfrag);
             fragmentTransaction2.commit();
         }
     });

        return  view;
    }




}
