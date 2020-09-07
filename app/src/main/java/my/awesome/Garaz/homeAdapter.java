package my.awesome.Garaz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class homeAdapter  extends RecyclerView.Adapter<homeAdapter.viewHolder> {
    ArrayList<homemodel> androidFlavors;

    Context context;

    public homeAdapter(ArrayList<homemodel> androidFlavors, Context context) {
        this.androidFlavors = androidFlavors;
        this.context = context;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        homemodel homemodel = androidFlavors.get(position);
        //Picasso.with(context).load(homemodel.getPic()).fit().centerCrop().into(holder.imageView);
        //Picasso.with(context).load("https://i.imgur.com/tGbaZCY.jpg").fit().centerCrop().into(holder.imageView);

        holder.imageView.setImageResource(homemodel.getDraw_pic());
        holder.textView.setText(homemodel.getText());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,Custom24.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return androidFlavors.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.tv);
            linearLayout=itemView.findViewById(R.id.linearlayout_services);
        }
    }
}
