package com.example.materialdesignapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends BaseActivity {

    @Nullable
    @BindView(R.id.sampleRecyclerView)
    RecyclerView sampleRecyclerView;

    private RecyclerViewAdapter recyclerViewAdapter;
    private GridViewAdapter gridViewAdapter;

    @BindView(R.id.topAppBar)
    Toolbar toolBar;

    @BindView(R.id.horizontalRecyclerView)
    RecyclerView horizontalRecyclerView;

    @BindView(R.id.floating_action_button)
    FloatingActionButton floating_action_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        sampleRecyclerView.setHasFixedSize(true);
        sampleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        horizontalRecyclerView.setHasFixedSize(true);
        horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        setRecyclerView(constructData("Chole Grace", R.mipmap.img, 10));
        setHorizontalRecyclerView(constructData("Baby", R.mipmap.baby, 1));
        floating_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData("Tom & Jerry", R.mipmap.tom_and_jerry, v);
            }
        });
    }

    private ArrayList<KidsListVO> constructData(String name, int res, int n) {
        KidsListVO kidsListVO = null;
        ArrayList<KidsListVO> list = new ArrayList<>();
        for(int i=1; i<= n; i++){
            list.add(new KidsListVO((name+" "+i), res));
        }
        return list;
    }

    private void setRecyclerView(ArrayList<KidsListVO> list){
        recyclerViewAdapter = new RecyclerViewAdapter(this, list);
        sampleRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private void setHorizontalRecyclerView(ArrayList<KidsListVO> list){
        gridViewAdapter = new GridViewAdapter(this, list);
        horizontalRecyclerView.setAdapter(gridViewAdapter);
    }

    private void addData(String name, int src, View view){
        gridViewAdapter.addData(new KidsListVO(name, src));
        gridViewAdapter.notifyDataSetChanged();
        Snackbar.make(view, "Image Added successfully", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
        }

}