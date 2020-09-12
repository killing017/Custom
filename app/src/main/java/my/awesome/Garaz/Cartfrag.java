package my.awesome.Garaz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Cartfrag extends Fragment {

    private ImageView imageView;
    private TextView textView;
private Button button;
    public Cartfrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_custom23, container, false);

        custom24model item=Sharedpref.getInstance(getContext()).getUser();
        if(item.getImage()!= -1&& item.getText()!=null) {
            View view1= inflater.inflate(R.layout.fragment_cartfrag, container, false);
            imageView=view1.findViewById(R.id.carimage);
            textView=view1.findViewById(R.id.text1);
            button=view1.findViewById(R.id.add_btn);
            imageView.setImageResource(item.getImage());
            textView.setText(item.getText());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Sharedpref.deleteUser(getContext());
                    Intent intent=new Intent(getActivity(),Custom23.class);
                    startActivity(intent);
                    Toast.makeText(getContext(), "DELETE SUCCESSFULL GO BACK ADD SERVICE", Toast.LENGTH_LONG).show();

                }
            });
          return view1;
        }else{
            Toast.makeText(getActivity(), "NOTHING IN THE CART ADD SERVICE", Toast.LENGTH_SHORT).show();
        }
        return view;
    }


}
