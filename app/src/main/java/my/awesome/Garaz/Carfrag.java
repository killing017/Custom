package my.awesome.Garaz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Carfrag extends Fragment {
TextView add;
carAdapter cadapter;
    public Carfrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_carfrag, container, false);
        add=view.findViewById(R.id.addcar);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                searchfrag searchfrag=new searchfrag();
                FragmentTransaction fragmentTransaction2=getParentFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.l1,searchfrag);
                fragmentTransaction2.commit();

            }
        });
        final ArrayList<carmodel> carflavor= new ArrayList<carmodel>();
        carflavor.add(new carmodel(R.drawable.hundaii,"Swift Dzire","petrol"));
        carflavor.add(new carmodel(R.drawable.hundaii,"Swift Dzire","petrol"));
        cadapter = new carAdapter(carflavor, getContext());
        RecyclerView recyclerView=view.findViewById(R.id.rec);
        // Get a reference to the ListView, and attach the adapter to the listView.
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cadapter);
        return view;
    }


}
