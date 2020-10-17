package my.awesome.Garaz;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultListener;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;


public class Cartfrag extends Fragment  {
    Tag ram;

    String messege;

Float total=0.0f;
TextView Total,youpay,payamount;
    private static final String TAG = MainActivity.class.getSimpleName();
   // private ImageView imageView;
    cartAdapter flavorAdapter2;
   // private TextView textView;
//private Button button;
Button pay;
    final ArrayList<cartmodel> androidFlavor=new ArrayList<>();
    JsonHttpParse jsonhttpParse = new JsonHttpParse();
    String HttpURL = "https://www.cakiweb.com/mechanic/json-api/api.php";
    String finalResult ;
    public Cartfrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cartfrag, container, false);
        Checkout.preload(getActivity());
        Total=view.findViewById(R.id.Total);
        youpay=view.findViewById(R.id.youpay);
        payamount=view.findViewById(R.id.payamount);
        SharedPreferences sh =this.getActivity().getSharedPreferences("MySharedPref", MODE_PRIVATE);
     //   Toast.makeText(getActivity(), ""+sh.getAll().size(), Toast.LENGTH_SHORT).show();



        Map<String, ?> keys = sh.getAll();

        for(Map.Entry<String, ?> entry : keys.entrySet()){
            Log.d("map values",entry.getKey() + ": " +
                    entry.getValue().toString());

            String[] str=entry.getValue().toString().split("-");
          //tal=Integer.parseInt(entry.getValue());
        String tot=str[1];
        String []tot1=tot.split(" ");
        String d=tot1[1];

        total=total+Float.valueOf(d).floatValue();
            //Toast.makeText(getContext(), ""+d, Toast.LENGTH_SHORT).show();
            androidFlavor.add(new cartmodel(100,str[0]));
        }

        youpay.setText("$"+total);
        payamount.setText("$"+total);
        Total.setText("$"+total);

        flavorAdapter2=new cartAdapter(androidFlavor,getContext());
            RecyclerView recyclerView=view.findViewById(R.id.rec1);
            recyclerView.setAdapter(flavorAdapter2);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
            recyclerView.setLayoutManager(linearLayoutManager);

            flavorAdapter2.notifyDataSetChanged();

        Map<String, ?> bookitems = sh.getAll();

        ArrayList<Integer> sch_service_set=new ArrayList<>();
        ArrayList<Integer> service_id=new ArrayList<>();
        ArrayList<Integer> cost=new ArrayList<>();
        ArrayList<String> service_name=new ArrayList<>();

        //these values will be used in jsoninputstring in background function



        for(Map.Entry<String, ?> entry : bookitems.entrySet()){
            Log.d("map values",entry.getKey() + ": " +
                    entry.getValue().toString());

            String[] str=entry.getValue().toString().split("-");

            int item=Integer.parseInt(str[3]);
            sch_service_set.add(item);

            int service_item=Integer.parseInt(str[4]);
            service_id.add(service_item);

//            int cost_item=Integer.parseInt(str[5]);
//            cost.add(cost_item);

            String service_name_item=str[0];
            service_name.add(service_name_item);





        }

            pay=view.findViewById(R.id.paybutton);
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //UserLoginFunction(  put proper attributes needed for book request   )

                    UserLoginFunction();

                    SharedPreferences sharedPreferences1=getContext().getSharedPreferences("ram",MODE_PRIVATE);
                    final SharedPreferences.Editor edit=sharedPreferences1.edit();
                    edit.putFloat("price",total);
                    edit.apply();



                    Intent intent=new Intent(getActivity(),Saved_address.class);
                    intent.putExtra("amount",total);
                    startActivity(intent);

                }
            });


        return view;
    }
    public void UserLoginFunction(){

        class UserLoginClass extends AsyncTask<String,Void,String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();


            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);


                Toast.makeText(getContext(), httpResponseMsg, Toast.LENGTH_SHORT).show();

                if(httpResponseMsg.contains("200")){

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(httpResponseMsg);
                         messege= jsonObject.getString("booking_id");
                         //handle this booking id as it will be used in next step




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }




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


                //String jsonInputString="{\"method\":\"login\",\"customer_email\":\""+Email+"\",\"customer_password\":\""+Password+"\"}";
                String jsonInputString="{\n\t\"method\":\"book\",\n\t\"user_id\":\"1\",\n\t\"sch_servie_id\":\"1\",\n\t\"vehicle_type_id\":\"1\",\n\t\"manufacturer_id\":\"2\",\n\t\"vehicle_id\":\"1\",\n\t\"vehicle_number\":\"OR5-880-3W4\",\n\t\"customer_name\":\"Swagatika Sahoo\",\n\t\"customer_mobile\":\"9999999999\",\n\t\"customer_email\":\"ss@gmail.com\",\n\t\"schedule_date\":\"16-09-2020\",\n\t\"schedule_time\":\"09:00\",\n\t\"location_id\":\"1\",\n\t\"pickup\":\"0\",\n\t\"pickup_date\":\"\",\n\t\"pickup_time\":\"\",\n\t\"pickup_address\":\"\",\n\t\"dropup\":\"0\",\n\t\"deliver_date\":\"\",\n\t\"deliver_time\":\"\",\n\t\"deliver_address\":\"\",\n\t\"service_id\":[2,2],\n\t\"sub_service\":[2,4],\n\t\"service_name\":[],\n\t\"cost\":[5,2]\n\t\n}";



                finalResult = jsonhttpParse.postRequest(jsonInputString, HttpURL);

                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute();
    }

}
