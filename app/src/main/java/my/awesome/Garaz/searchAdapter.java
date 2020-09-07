package my.awesome.Garaz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.viewHolder> implements Filterable {
    private ArrayList<searchModel> androidFlavors1;
    Context context1;
    private List<searchModel> androidFlavorsall;


    public searchAdapter(ArrayList<searchModel> androidFlavors1,Context context1) {
        this.androidFlavors1 = androidFlavors1;
        this.context1=context1;
        androidFlavorsall = new ArrayList<>(androidFlavors1);
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context1).inflate(R.layout.search, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        searchModel searchModel = androidFlavors1.get(position);
        holder.imageView.setImageResource(searchModel.getPic());
        holder.textView.setText(searchModel.getText());
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
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img1);
            textView=itemView.findViewById(R.id.tv1);
        }
    }
}
