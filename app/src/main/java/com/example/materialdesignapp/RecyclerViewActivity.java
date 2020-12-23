package com.example.materialdesignapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends BaseActivity {

    @Nullable
    @BindView(R.id.sampleRecyclerView)
    RecyclerView sampleRecyclerView;

    private RecyclerViewAdapter recyclerViewAdapter;

    @BindView(R.id.topAppBar)
    Toolbar toolBar;

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
        recyclerViewAdapter = new RecyclerViewAdapter(this, list);
        sampleRecyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}