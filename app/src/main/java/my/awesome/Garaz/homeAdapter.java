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
        final homemodel homemodel = androidFlavors.get(position);



        Picasso.with(context).load(homemodel.getPic().replace("http","https")).fit().centerInside().into(holder.imageView);
        //Picasso.with(context).load("https://www.cakiweb.com/mechanic/app-admin/service-img/schedule_service_1601908285.png").fit().centerCrop().into(holder.imageView);

        //holder.imageView.setImageResource(homemodel.getDraw_pic());
        holder.textView.setText(homemodel.getText().replace("&amp;","&"));

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(context,Custom24.class);
               intent.putExtra("id",homemodel.getId());
               intent.putExtra("subservice_name",homemodel.getText().replace("&amp;","&"));
               context.startActivity(intent);
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
