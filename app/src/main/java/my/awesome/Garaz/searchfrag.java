package my.awesome.Garaz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;


public class searchfrag extends Fragment {
    SearchView searchView;
searchAdapter flavorAdapter1;
    public searchfrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_searchfrag, container, false);
        searchView=view.findViewById(R.id.search);
searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        flavorAdapter1.getFilter().filter(newText);
        return true;
    }
});
        final ArrayList<searchModel> androidFlavors1= new ArrayList<searchModel>();
        androidFlavors1.add(new searchModel(R.drawable.ic_directions_car_black_24dp,"ram"));
        androidFlavors1.add(new searchModel(R.drawable.ic_directions_car_black_24dp,"pam"));
        androidFlavors1.add(new searchModel(R.drawable.ic_directions_car_black_24dp,"jam"));
        androidFlavors1.add(new searchModel(R.drawable.ic_directions_car_black_24dp,"ram"));
        androidFlavors1.add(new searchModel(R.drawable.ic_directions_car_black_24dp,"ram"));
        androidFlavors1.add(new searchModel(R.drawable.ic_directions_car_black_24dp,"ram"));
        //androidFlavors.add(new homemodel(,"ram"));
        //  homeAdapter adapter=new homeAdapter(androidFlavors,getContext());

        flavorAdapter1 = new searchAdapter(androidFlavors1, getContext());
        RecyclerView recyclerView=view.findViewById(R.id.rec);
        // Get a reference to the ListView, and attach the adapter to the listView.

        recyclerView.setAdapter(flavorAdapter1);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);

        return  view;
    }

}
