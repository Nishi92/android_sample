package com.example.materialdesignapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<KidsListVO> ridersList = new ArrayList<>();

    public RecyclerViewAdapter(Context context, ArrayList<KidsListVO> ridersList) {
        this.context = context;
        this.ridersList = ridersList;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new RecyclerViewAdapter.ViewHolder(v, viewType);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {

        /*if(ridersList.get(position).getUrl() != null){
            Picasso.get().load(ridersList.get(position).getUrl()).placeholder(R.drawable.progress_animation).centerInside().fit().into(holder.kidImage);
        }
        else{
            Picasso.get().load(R.mipmap.placeholder).fit().into(holder.kidImage);
        }*/
        Picasso.get().load(ridersList.get(position).getUrl()).centerCrop().fit().into(holder.kidImage);
        holder.kidName.setText(ridersList.get(position).getName());

        holder.clickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ridersList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ridersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.kidImage)
        ImageView kidImage;
        @BindView(R.id.kidName)
        TextView kidName;
        @BindView(R.id.clickLayout)
        RelativeLayout clickLayout;


        public ViewHolder(View itemView, int ViewType) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
