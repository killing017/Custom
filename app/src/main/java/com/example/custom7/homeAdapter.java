package com.example.custom7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.imageView.setImageResource(homemodel.getPic());
        holder.textView.setText(homemodel.getText());
    }

    @Override
    public int getItemCount() {
        return androidFlavors.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.tv);
        }
    }
}
