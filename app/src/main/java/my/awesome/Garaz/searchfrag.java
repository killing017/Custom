package my.awesome.Garaz;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.appcompat.widget.SearchView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class searchfrag extends Fragment {

    SearchView searchView;
   searchAdapter flavorAdapter1;

    custom24Adapter customAdapter;
    String id="";
    String subservice_name;

    TextView heading;
    ProgressDialog progressDialog1;


    String HttpURL = "https://www.cakiweb.com/mechanic/json-api/api.php";


    String finalResult1 ;

    RecyclerView recyclerView;


    JsonHttpParse jsonhttpParse = new JsonHttpParse();


    ArrayList<custom24model> customflavor = new ArrayList<custom24model>();

    public searchfrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_searchfrag, container, false);
        searchView=(SearchView) view.findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(customflavor.contains(query)){
                    customAdapter.getFilter().filter(query);
                }else{
                    Toast.makeText(getContext(), "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
             //   customAdapter.getFilter().filter(newText);
                return false;
            }
        });

  /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        //flavorAdapter1.getFilter().filter(newText);
        customAdapter.getFilter().filter(newText);
        return true;
    }
});*/
       final ArrayList<searchModel> androidFlavors1= new ArrayList<searchModel>();

//        androidFlavors1.add(new searchModel(R.drawable.hundaii,"SWIFT DZIRE PETROL"));
//        androidFlavors1.add(new searchModel(R.drawable.hundaii,"SWIFT DZIRE PETROL"));
//        androidFlavors1.add(new searchModel(R.drawable.hundaii,"SWIFT DZIRE PETROL"));
//        androidFlavors1.add(new searchModel(R.drawable.hundaii,"I10 SPORTZ PETROL"));
//        androidFlavors1.add(new searchModel(R.drawable.hundaii,"HONDA DZIRE PETROL"));

        //androidFlavors.add(new homemodel(,"ram"));
        //  homeAdapter adapter=new homeAdapter(androidFlavors,getContext());



//        flavorAdapter1 = new searchAdapter(androidFlavors1, getContext());
//        RecyclerView recyclerView=view.findViewById(R.id.rec);
//        // Get a reference to the ListView, and attach the adapter to the listView.
//
//        recyclerView.setAdapter(flavorAdapter1);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,true);
//        recyclerView.setLayoutManager(linearLayoutManager);

        customAdapter = new custom24Adapter(customflavor,getContext());
        recyclerView=view.findViewById(R.id.recyclerview);
        // Get a reference to the ListView, and attach the adapter to the listView.
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapter);

        getSubSerivices("getAllsubService");

        return  view;
    }

    private void getSubSerivices(String getAllsubService) {

        class OfferClass extends AsyncTask<String,Void,String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog1 = ProgressDialog.show(getContext(),"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog1.dismiss();

                // Toast.makeText(getContext(), httpResponseMsg, Toast.LENGTH_SHORT).show();

                if(httpResponseMsg.contains("200")){
                    //Toast.makeText(getContext(), httpResponseMsg, Toast.LENGTH_SHORT).show();

                    try {
                        JSONObject jsonObject = new JSONObject(httpResponseMsg);
                        JSONArray result = jsonObject.getJSONArray("result");
                        for (int i=0; i<result.length(); i++ ){
                            JSONObject ob=result.getJSONObject(i);

                            // Toast.makeText(FirstActivity.this, ob.getString("name"), Toast.LENGTH_SHORT).show();
                            custom24model history1=new custom24model(R.drawable.hundaii,ob.getString("sub_service")
                                   );
                            customflavor.add(history1);
                        }


//
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    recyclerView.setAdapter(customAdapter);
                    customAdapter.notifyDataSetChanged();



                }else{
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(httpResponseMsg);
                        String messege = jsonObject.getString("msg");
                        Toast.makeText(getContext(), messege, Toast.LENGTH_SHORT).show();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected String doInBackground(String... params) {


                 String jsonInputString="{\"method\":\"getAllsubService\"}";
                //String jsonInputString1="{\"method\":\"getAllsubService\",\"service_id\":\""+id+"\"}";

                finalResult1 = jsonhttpParse.postRequest(jsonInputString, HttpURL);

                return finalResult1;
            }
        }

        OfferClass offerClass = new OfferClass();

        offerClass.execute(getAllsubService);


    }

}
