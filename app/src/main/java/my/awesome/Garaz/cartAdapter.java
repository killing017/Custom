package my.awesome.Garaz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.viewHolder> {


    private ArrayList<cartmodel> customflavor2;
    Context context;
    public cartAdapter(ArrayList<cartmodel> customflavor2, Context context) {
        this.customflavor2 = customflavor2;
        this.context = context;
    }
    @NonNull
    @Override
    public cartAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart, parent, false);
        return new cartAdapter.viewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final cartAdapter.viewHolder holder, final int position) {
        final cartmodel custom24model1= customflavor2.get(position);
        final int currentPosition=position;
        //holder.imageView.setImageResource(custom24model1.getImage());
        holder.textView1.setText(custom24model1.getText());
        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove(holder.textView1.getText().toString());
                editor.apply();
                notifyDataSetChanged();
                editor.commit();
                customflavor2.remove(position);
                notifyDataSetChanged();
               Cartfrag cartfrag=new Cartfrag();
                FragmentTransaction fragmentTransaction4= ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction4.detach(cartfrag);
                fragmentTransaction4.attach(cartfrag);
                fragmentTransaction4.replace(R.id.l1,cartfrag);
                fragmentTransaction4.commit();

              /* FragmentManager manager=((AppCompatActivity)context).getSupportFragmentManager();
                Fragment Cartfrag=manager.findFragmentByTag(my.awesome.Garaz.Cartfrag.getTag());
                FragmentTransaction fragmentTransaction=manager.beginTransaction();
                fragmentTransaction.detach(Cartfrag);
                fragmentTransaction.attach(Cartfrag);
               fragmentTransaction.replace( R.id.l1,Cartfrag);
                fragmentTransaction.commit();*/



                Toast.makeText(context, "DELETE SUCCESSFULL GO BACK ADD SERVICE", Toast.LENGTH_LONG).show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return customflavor2.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, textView2;
        Button add_btn;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            //textView=itemView.findViewById(R.id.services);
            imageView = itemView.findViewById(R.id.carimage);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            add_btn = itemView.findViewById(R.id.add_btn);
        }
    }
}
