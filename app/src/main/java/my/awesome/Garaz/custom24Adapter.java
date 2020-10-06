package my.awesome.Garaz;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
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

public class custom24Adapter extends RecyclerView.Adapter<custom24Adapter.viewHolder> implements Filterable {
    private ArrayList<custom24model> customflavor;
   // SharedPreferences sharedPreferences;
    Context context;
    ArrayList<custom24model>  alist;
    SharedPreferences sharedPreferences ;
    int i;

    public custom24Adapter(ArrayList<custom24model> ccustomflavor, Context context,ArrayList<custom24model> alist) {
        this.customflavor = ccustomflavor;
        this.context = context;
       this.alist=alist;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom24, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, final int position) {
        final custom24model custom24model1= customflavor.get(position);
        final int currentPosition=position;
        holder.imageView.setImageResource(custom24model1.getImage());
        holder.textView1.setText(custom24model1.getText());
        //holder.textView2.setText(custom24model1.getText2());
        sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
       final SharedPreferences.Editor myEdit = sharedPreferences.edit();
        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               myEdit.putString(custom24model1.getText(), custom24model1.getText()+"-"+holder.textView2.getText().toString()+"-"+custom24model1.getImage());
               // myEdit.putString("json", httpResponseMsg);

               myEdit.apply();
                BottomNavigationView btn;
                btn=((AppCompatActivity) context).findViewById(R.id.bnav);
                SharedPreferences sh =context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
                //   Toast.makeText(getActivity(), ""+sh.getAll().size(), Toast.LENGTH_SHORT).show();
               int n=sh.getAll().size();
               btn.getOrCreateBadge(R.id.cart).setNumber(n);
//                Sharedpref sharedpref= new Sharedpref(context);
//                sharedpref.getInstance(context).saveitem(customflavor.get(currentPosition));
//               String price= holder.textView2.getText().toString();

                Toast.makeText(context, "item added successful of price "+holder.textView2.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return customflavor.size();
    }
    public Filter getFilter() {
        return filter;
    }

    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
           List<custom24model> filteredlist = new ArrayList<>();
            if (charSequence.toString().isEmpty()) {
                filteredlist.addAll(customflavor);

            } else {
                for (custom24model hm1 : customflavor) {
                    //Toast.makeText(context, ""+hm1.getText(), Toast.LENGTH_SHORT).show();
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
            customflavor.clear();
            customflavor.addAll((Collection<? extends custom24model>) filterResults.values);
            notifyDataSetChanged();
        }

    };


    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView  textView1,textView2;
        Button add_btn;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            //textView=itemView.findViewById(R.id.services);
            imageView=itemView.findViewById(R.id.carimage);
            textView1=itemView.findViewById(R.id.text1);
            textView2=itemView.findViewById(R.id.text2);
            add_btn=itemView.findViewById(R.id.add_btn);
        }
    }

}
