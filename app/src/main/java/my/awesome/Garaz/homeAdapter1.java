package my.awesome.Garaz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class homeAdapter1  extends RecyclerView.Adapter<homeAdapter1.viewHolder> {
    ArrayList<homemodel1> androidFlavors1;
    Context context;

    public homeAdapter1(ArrayList<homemodel1> androidFlavors1, Context context) {
        this.androidFlavors1 = androidFlavors1;
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
        homemodel1 homemodel = androidFlavors1.get(position);
        //Picasso.with(context).load(homemodel.getPic()).fit().centerCrop().into(holder.imageView);
        Picasso.with(context).load("https://i.imgur.com/tGbaZCY.jpg").fit().centerCrop().into(holder.imageView);



        //holder.imageView.setImageResource(homemodel.getPic());
        holder.textView.setText(homemodel.getText());
    }

    @Override
    public int getItemCount() {
        return androidFlavors1.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text1);
        }
    }
}
