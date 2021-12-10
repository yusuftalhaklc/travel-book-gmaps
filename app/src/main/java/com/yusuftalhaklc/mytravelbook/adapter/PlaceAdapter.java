package com.yusuftalhaklc.mytravelbook.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Placeholder;
import androidx.recyclerview.widget.RecyclerView;

import com.yusuftalhaklc.mytravelbook.databinding.RercyclerViewBinding;
import com.yusuftalhaklc.mytravelbook.model.Place;
import com.yusuftalhaklc.mytravelbook.view.MapsActivity;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder> {
    List<Place> placeList;

    public PlaceAdapter(List<Place> placeList){
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RercyclerViewBinding rercyclerViewBinding = RercyclerViewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PlaceHolder(rercyclerViewBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
            holder.rercyclerViewBinding.recyclerViewTextView.setText(placeList.get(position).name);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(holder.itemView.getContext(), MapsActivity.class);
                    intent.putExtra("info","old");
                    intent.putExtra("place",placeList.get(position));
                    holder.itemView.getContext().startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public class PlaceHolder extends RecyclerView.ViewHolder{
        RercyclerViewBinding rercyclerViewBinding;

        public PlaceHolder(RercyclerViewBinding rercyclerViewBinding) {
            super(rercyclerViewBinding.getRoot());
            this.rercyclerViewBinding = rercyclerViewBinding;
        }
    }
}
