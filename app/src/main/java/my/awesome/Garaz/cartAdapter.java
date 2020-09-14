package my.awesome.Garaz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
    public void onBindViewHolder(@NonNull cartAdapter.viewHolder holder, final int position) {
        final cartmodel custom24model1= customflavor2.get(position);
        final int currentPosition=position;
        holder.imageView.setImageResource(custom24model1.getImage());
        holder.textView1.setText(custom24model1.getText());
        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedpref.deleteUser(context);
                Intent intent=new Intent(context,Custom23.class);
                context.startActivity(intent);
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
