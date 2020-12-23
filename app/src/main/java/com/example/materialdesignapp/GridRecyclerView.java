package com.example.materialdesignapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridRecyclerView extends BaseActivity {

    @Nullable
    @BindView(R.id.gridRecyclerView)
    RecyclerView gridRecyclerView;

    private GridViewAdapter gridViewAdapter;

    @BindView(R.id.topAppBar)
    Toolbar toolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        gridRecyclerView.setHasFixedSize(true);
        gridRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        setRecyclerView(constructData());
    }

    private ArrayList<KidsListVO> constructData() {
        KidsListVO kidsListVO = null;
        ArrayList<KidsListVO> list = new ArrayList<>();
        for(int i=1; i<20; i++){
            list.add(new KidsListVO(("John Abraham "+i), R.mipmap.img));
        }
        list.add(new KidsListVO("John Abraham", R.mipmap.img));
        return list;
    }

    private void setRecyclerView(ArrayList<KidsListVO> list){
        gridViewAdapter = new GridViewAdapter(this, list);
        gridRecyclerView.setAdapter(gridViewAdapter);
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