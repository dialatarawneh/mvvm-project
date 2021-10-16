package com.project.foodapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.foodapp.R;
import com.project.foodapp.pojo.postModel;

import java.util.ArrayList;
import java.util.List;

public class postAdapter extends RecyclerView.Adapter<postAdapter.viewHolder> {
    List<postModel> postModelList = new ArrayList<>();

    public postAdapter(List<postModel> postModelList) {
        this.postModelList = postModelList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.Tittle.setText(postModelList.get(position).getTitle());
        holder.Body.setText(postModelList.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView Tittle, Body;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Tittle = itemView.findViewById(R.id.tittle_tv);
            Body = itemView.findViewById(R.id.body_tv);



        }
    }
}
