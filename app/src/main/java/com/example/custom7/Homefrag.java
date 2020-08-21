package com.example.custom7;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Homefrag extends Fragment {


    public Homefrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_homefrag, container, false);
        ArrayList<homemodel> androidFlavors = new ArrayList<homemodel>();
        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));

        homeAdapter flavorAdapter = new homeAdapter( androidFlavors, getContext());
        RecyclerView recyclerView=view.findViewById(R.id.rec);
        // Get a reference to the ListView, and attach the adapter to the listView.

        recyclerView.setAdapter(flavorAdapter);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);

        return view;
    }

}
