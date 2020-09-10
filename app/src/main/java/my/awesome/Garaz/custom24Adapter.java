package my.awesome.Garaz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class custom24Adapter extends RecyclerView.Adapter<custom24Adapter.viewHolder> {
    private ArrayList<custom24model> customflavor;
    Context context;

    public custom24Adapter(ArrayList<custom24model> customflavor, Context context) {
        this.customflavor = customflavor;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom24, parent, false);
        return new custom24Adapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        custom24model custom24model1 = customflavor.get(position);
        holder.imageView.setImageResource(custom24model1.getImage());

        holder.textView1.setText(custom24model1.getText());
        //holder.textView2.setText(custom24model1.getText2());
    }

    @Override
    public int getItemCount() {
        return customflavor.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView  textView1,textView2;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            //textView=itemView.findViewById(R.id.services);
            imageView=itemView.findViewById(R.id.carimage);
            textView1=itemView.findViewById(R.id.text1);
            textView2=itemView.findViewById(R.id.text2);
        }
    }
}
