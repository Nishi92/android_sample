package com.example.materialdesignapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<KidsListVO> ridersList = new ArrayList<>();

    public GridViewAdapter(Context context, ArrayList<KidsListVO> ridersList) {
        this.context = context;
        this.ridersList = ridersList;
    }

    public void addData(KidsListVO obj){
        this.ridersList.add(obj);
    }

    @NonNull
    @Override
    public GridViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
        return new GridViewAdapter.ViewHolder(v, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewAdapter.ViewHolder holder, int position) {
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
