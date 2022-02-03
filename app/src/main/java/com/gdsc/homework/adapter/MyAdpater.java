package com.gdsc.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gdsc.homework.R;
import com.gdsc.homework.model.MyChores;

import java.util.ArrayList;

public class MyAdpater extends RecyclerView.Adapter<MyAdpater.ViewHolder> {
    private final ArrayList<MyChores> localDataSet;

    public MyAdpater(ArrayList<MyChores> dataSet) {
        this.localDataSet = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRoles;
        TextView tvDate;

        ViewHolder(View itemView){
            super(itemView);
            tvRoles = itemView.findViewById(R.id.roles);
            tvDate = itemView.findViewById(R.id.date);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_mine, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyChores item = localDataSet.get(position);
        holder.tvRoles.setText(item.getRoles());
        holder.tvDate.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
