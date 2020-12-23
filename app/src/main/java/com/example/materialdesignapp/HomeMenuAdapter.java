package com.example.materialdesignapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuAdapter.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[];
    private int mIcons[];

    private String name;
    private int profile;
    private String email;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        int Holderid;
        TextView textView;
        ImageView imageView;
        ImageView profile, placeHolder;
        TextView Name;
        TextView email;
        Context contxt;

        public ViewHolder(View itemView,int ViewType, Context c) {

            super(itemView);
            contxt = c;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);


            if(ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                Holderid = 1;
            }
            else{
                Name = (TextView) itemView.findViewById(R.id.name);
                profile = (ImageView) itemView.findViewById(R.id.profile);
                placeHolder = (ImageView) itemView.findViewById(R.id.profileplaceholder);
                Holderid = 0;
            }
        }
        @Override
        public void onClick(View v) {


        }
    }



    public HomeMenuAdapter(String Titles[], int Icons[], String Name, Context passedContext){ // MyAdapter Constructor with titles and icons parameter
        mNavTitles = Titles;
        mIcons = Icons;
        name = Name;
        this.context = passedContext;
    }



    @Override
    public HomeMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gp_menu_items,parent,false); //Inflating the layout

            ViewHolder vhHeader = new ViewHolder(v,viewType, context); //Creating ViewHolder and passing the object of type view

            return vhHeader;


        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_header,parent,false); //Inflating the layout

            ViewHolder vhHeader = new ViewHolder(v,viewType, context); //Creating ViewHolder and passing the object of type view

            return vhHeader; //returning the object created


        }
        return null;

    }


    @Override
    public void onBindViewHolder(HomeMenuAdapter.ViewHolder holder, int position) {
        if(holder.Holderid ==1) {
            holder.textView.setText(mNavTitles[position - 1]);
            holder.imageView.setImageResource(mIcons[position -1]);
        }
        else{
                holder.placeHolder.setVisibility(View.GONE);
                Picasso.get()
                        .load(R.mipmap.profile)
                        .placeholder(R.drawable.progress_animation)
                        .resize(300, 200)
                        .centerInside()
                        .into(holder.profile);

            holder.Name.setText(name);
        }
    }

    @Override
    public int getItemCount() {
        return mNavTitles.length+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
    }

