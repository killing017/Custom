package my.awesome.Garaz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Accountfrag extends Fragment {

Button b1;
    public Accountfrag() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_accountfrag, container, false);
     b1=view.findViewById(R.id.b1);
     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });
        return  view;
    }

}
