package my.awesome.Garaz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.viewHolder> implements Filterable {
    private ArrayList<searchModel> androidFlavors1;
    SharedPreferences sharedPreferences;
    Context context;
    private List<searchModel> androidFlavorsall;


    public searchAdapter(ArrayList<searchModel> androidFlavors1,Context context) {
        this.androidFlavors1 = androidFlavors1;
        this.context=context;
        androidFlavorsall = new ArrayList<>(androidFlavors1);
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom24, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {
        final searchModel searchModel = androidFlavors1.get(position);
        holder.imageView.setImageResource(searchModel.getImage());

        holder.textView1.setText(searchModel.getText());
        sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        final SharedPreferences.Editor myEdit = sharedPreferences.edit();
        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myEdit.putString(searchModel.getText(), searchModel.getText() + "-" + holder.textView2.getText().toString() + "-" + searchModel.getImage());
                // myEdit.putString("json", httpResponseMsg);
                myEdit.apply();

                Toast.makeText(context, "item added successful of price "+holder.textView2.getText().toString(), Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return androidFlavors1.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<searchModel> filteredlist = new ArrayList<>();
            if (charSequence.toString().isEmpty()) {
                filteredlist.addAll(androidFlavorsall);

            } else {
                for (searchModel hm1 : androidFlavorsall) {
                    if (hm1.getText().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredlist.add(hm1);

                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredlist;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            androidFlavors1.clear();
            androidFlavors1.addAll((Collection<? extends searchModel>) filterResults.values);
            notifyDataSetChanged();
        }

    };

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView  textView1,textView2;
        Button add_btn;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.carimage);
            textView1=itemView.findViewById(R.id.text1);
            textView2=itemView.findViewById(R.id.text2);
            add_btn=itemView.findViewById(R.id.add_btn);
        }
    }
}
