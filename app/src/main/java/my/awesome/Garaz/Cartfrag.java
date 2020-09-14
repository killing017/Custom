package my.awesome.Garaz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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

import static android.content.ContentValues.TAG;


public class Cartfrag extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();
   // private ImageView imageView;
    cartAdapter flavorAdapter2;
   // private TextView textView;
//private Button button;
Button pay;
    public Cartfrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_custom23, container, false);

        custom24model item=Sharedpref.getInstance(getContext()).getUser();
        int count=0;
        count=item.getImage();
        Toast.makeText(getContext(), "count"+count, Toast.LENGTH_SHORT).show();
        Checkout.preload(getActivity());

        if(item.getImage()!= -1 && item.getText()!=null) {
            View view1= inflater.inflate(R.layout.fragment_cartfrag, container, false);

           final ArrayList<cartmodel> androidFlavor=new ArrayList<>();

           androidFlavor.add(new cartmodel(item.getImage(),item.getText()));
           flavorAdapter2=new cartAdapter(androidFlavor,getContext());
           RecyclerView recyclerView=view1.findViewById(R.id.rec1);
            recyclerView.setAdapter(flavorAdapter2);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
            recyclerView.setLayoutManager(linearLayoutManager);
          //  imageView=view1.findViewById(R.id.carimage);
          //  textView=view1.findViewById(R.id.text1);

            pay=view1.findViewById(R.id.paybutton);
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(getContext(), "gsgalkjjldj;kdjsd", Toast.LENGTH_SHORT).show();
                    ((Mainscreen)getActivity()).startPayment();
                }
            });
          //  button=view1.findViewById(R.id.add_btn);
          //  imageView.setImageResource(item.getImage());
          //  textView.setText(item.getText());

          return view1;
        }else{
            Toast.makeText(getActivity(), "NOTHING IN THE CART ADD SERVICE", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

}
