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

public class carAdapter extends RecyclerView.Adapter<carAdapter.viewHolder> {
    private ArrayList<carmodel> carflavor;
    Context context;

    public carAdapter(ArrayList<carmodel> carflavor, Context context) {
        this.carflavor = carflavor;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car, parent, false);
        return new carAdapter.viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        final carmodel carmodel = carflavor.get(position);
        holder.imageView.setImageResource(carmodel.getImage());
        holder.textView.setText(carmodel.getText());
        holder.textView1.setText(carmodel.getText1());

       holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeitem(carmodel);
            }
        });
    }
    public  void  removeitem(carmodel carmodel){
        int position=carflavor.indexOf(carmodel);
        carflavor.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return carflavor.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView,textView1,textView2;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.car1);
            textView=itemView.findViewById(R.id.text1);
            textView1=itemView.findViewById(R.id.fuel);
           textView2=itemView.findViewById(R.id.remove);


        }


    }

    }
