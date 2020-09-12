package my.awesome.Garaz;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//import com.example.custom7.R;

public class Custom24 extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom24);

        Intent intent=getIntent();
        id=intent.getExtras().getString("id");
        subservice_name=intent.getExtras().getString("subservice_name");

        heading=findViewById(R.id.services);
        heading.setText(subservice_name);

        //final ArrayList<custom24model> customflavor= new ArrayList<custom24model>();
        //customflavor.add(new custom24model(R.drawable.hundaii,"service","subservice","price"));

        customAdapter = new custom24Adapter(customflavor,Custom24.this);
         recyclerView=findViewById(R.id.recyclerview);
        // Get a reference to the ListView, and attach the adapter to the listView.
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(Custom24.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapter);

        getSubSerivices("getAllsubService",id);

    }

    private void getSubSerivices(String getAllsubService, final String id) {

        class OfferClass extends AsyncTask<String,Void,String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog1 = ProgressDialog.show(Custom24.this,"Loading Data",null,true,true);
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
                        Toast.makeText(Custom24.this, messege, Toast.LENGTH_SHORT).show();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected String doInBackground(String... params) {


                // jsonInputString="{\"method\":\"getAllsubService\"}";
                String jsonInputString1="{\"method\":\"getAllsubService\",\"service_id\":\""+id+"\"}";

                finalResult1 = jsonhttpParse.postRequest(jsonInputString1, HttpURL);

                return finalResult1;
            }
        }

        OfferClass offerClass = new OfferClass();

        offerClass.execute(getAllsubService);


    }
}
