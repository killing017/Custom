package my.awesome.Garaz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;

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

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;


public class Cartfrag extends Fragment  {
    Tag ram;
Float total=0.0f;
TextView Total,youpay,payamount;
    private static final String TAG = MainActivity.class.getSimpleName();
   // private ImageView imageView;
    cartAdapter flavorAdapter2;
   // private TextView textView;
//private Button button;
Button pay;
    final ArrayList<cartmodel> androidFlavor=new ArrayList<>();
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

            pay=view.findViewById(R.id.paybutton);
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences sharedPreferences1=getContext().getSharedPreferences("ram",MODE_PRIVATE);
                    final SharedPreferences.Editor edit=sharedPreferences1.edit();
                    edit.putFloat("price",total);
                    edit.apply();

                    Intent intent=new Intent(getActivity(),Saved_address.class);
                    intent.putExtra("amount",total);
                    startActivity(intent);
                   // Toast.makeText(getContext(), "gsgalkjjldj;kdjsd", Toast.LENGTH_SHORT).show();
                    //((Mainscreen)getActivity()).startPayment(total);
                }
            });

        //String json=sh.getString("json","");

//        custom24model item=Sharedpref.getInstance(getContext()).getUser();
//
//
//        int count=0;
//        count=item.getImage();
//        Toast.makeText(getContext(), "count"+count, Toast.LENGTH_SHORT).show();
//
//        Checkout.preload(getActivity());
//
//        if(item.getImage()!= -1 && item.getText()!=null) {
//            View view1= inflater.inflate(R.layout.fragment_cartfrag, container, false);
//
//
//
//           //androidFlavor.add(new cartmodel(item.getImage(),item.getText()));
//
//
//           flavorAdapter2=new cartAdapter(androidFlavor,getContext());
//           RecyclerView recyclerView=view1.findViewById(R.id.rec1);
//            recyclerView.setAdapter(flavorAdapter2);
//            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
//            recyclerView.setLayoutManager(linearLayoutManager);
//          //  imageView=view1.findViewById(R.id.carimage);
//          //  textView=view1.findViewById(R.id.text1);
//
//            pay=view1.findViewById(R.id.paybutton);
//            pay.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                   // Toast.makeText(getContext(), "gsgalkjjldj;kdjsd", Toast.LENGTH_SHORT).show();
//                    ((Mainscreen)getActivity()).startPayment();
//                }
//            });
//          //  button=view1.findViewById(R.id.add_btn);
//          //  imageView.setImageResource(item.getImage());
//          //  textView.setText(item.getText());
//
//          return view1;
//        }else{
//            Toast.makeText(getActivity(), "NOTHING IN THE CART ADD SERVICE", Toast.LENGTH_SHORT).show();
//        }
        return view;
    }


}
