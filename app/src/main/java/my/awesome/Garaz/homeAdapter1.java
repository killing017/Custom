package my.awesome.Garaz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        View view = LayoutInflater.from(context).inflate(R.layout.list1, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        homemodel1 homemodel1 = androidFlavors1.get(position);
        //Picasso.with(context).load(homemodel.getPic()).fit().centerCrop().into(holder.imageView);
     //   Picasso.with(context).load("https://i.imgur.com/tGbaZCY.jpg").fit().centerCrop().into(holder.imageView);



        holder.imageView.setImageResource(homemodel1.getDraw_pic());
        //holder.text.setText(homemodel1.getText());
       holder.text1.setText(homemodel1.getText());
        //holder.text2.setText(homemodel1.getText2());
        holder.text3.append(homemodel1.getText3());
        holder.text4.append(homemodel1.getText4());

       holder.linearLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              // context.startActivity(new Intent(context,searchfrag.class));
               Toast.makeText(context, "Soon it will updated", Toast.LENGTH_SHORT).show();

           }
       });


    }

    @Override
    public int getItemCount() {
        return androidFlavors1.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView text,text1,text2,text3,text4;
        LinearLayout linearLayout;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
            text1 = itemView.findViewById(R.id.text1);
            text2= itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);
            text4 = itemView.findViewById(R.id.text4);
            linearLayout=itemView.findViewById(R.id.linearlayout_adds);

        }

    }
}
