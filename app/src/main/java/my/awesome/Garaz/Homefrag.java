package my.awesome.Garaz;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Homefrag extends Fragment {

    String HttpURL = "https://www.cakiweb.com/mechanic/json-api/api.php";

    String finalResult ;

    ProgressDialog progressDialog;

    RecyclerView recyclerView;
    homeAdapter flavorAdapter;
    JsonHttpParse jsonhttpParse = new JsonHttpParse();

    ArrayList<homemodel> androidFlavors = new ArrayList<homemodel>();


    public Homefrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_homefrag, container, false);

//        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
//        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
//        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
//        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
//        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));
//        androidFlavors.add(new homemodel(R.drawable.ic_directions_car_black_24dp,"ram"));

         flavorAdapter = new homeAdapter( androidFlavors, getContext());
         recyclerView=view.findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        // Get a reference to the ListView, and attach the adapter to the listView.


        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(flavorAdapter);

        ServicesFunction("getAllService");

        return view;
    }

    public void ServicesFunction(final String method){



        class UserLoginClass extends AsyncTask<String,Void,String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(getContext(),"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

               // Toast.makeText(getContext(), httpResponseMsg, Toast.LENGTH_SHORT).show();

                if(httpResponseMsg.contains("200")){
                    //Toast.makeText(getContext(), httpResponseMsg, Toast.LENGTH_SHORT).show();

                    try {
                        JSONObject jsonObject = new JSONObject(httpResponseMsg);
                        JSONArray result = jsonObject.getJSONArray("result");
                        for (int i=0; i<result.length(); i++ ){
                            JSONObject ob=result.getJSONObject(i);

                            // Toast.makeText(FirstActivity.this, ob.getString("name"), Toast.LENGTH_SHORT).show();
                            homemodel history=new homemodel(R.drawable.caricon,ob.getString("img"),ob.getString("service_name"));

                            androidFlavors.add(history);
                        }


//
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    recyclerView.setAdapter(flavorAdapter);
                    flavorAdapter.notifyDataSetChanged();



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


                String jsonInputString="{\"method\":\"getAllService\"}";

                finalResult = jsonhttpParse.postRequest(jsonInputString, HttpURL);

                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(method);
    }


}
