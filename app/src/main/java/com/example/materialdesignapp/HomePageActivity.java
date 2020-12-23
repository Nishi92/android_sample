package com.example.materialdesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageActivity extends BaseActivity {

    @BindView(R.id.topAppBar)
    Toolbar toolBar;

    String TITLES[] = {"Form with Validation","Recycler View","Buttons", "Fragments", "Messages","Vehicle Gas FillUp", "Vehicle Mileage", "Gas FillUp Log","Log Out"};
    int ICONS[] = {R.mipmap.vehicle, R.mipmap.vehiclemaintenance,R.mipmap.calendar, R.mipmap.ic_notification, R.mipmap.ic_chat,R.mipmap.petrolstation, R.mipmap.mileageicon, R.mipmap.file, R.mipmap.logout};

    private HomeMenuAdapter mAdapter;

    @Nullable
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @BindView(R.id.drawerLayout)
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mRecyclerView.setHasFixedSize(false);

        mAdapter = new HomeMenuAdapter(TITLES, ICONS, "Hello",this);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final GestureDetector mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent   ) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();
                    Log.d("Nishi", ""+recyclerView.getChildAdapterPosition(child));
                    if (recyclerView.getChildAdapterPosition(child) == 2) {
                        startActivity(new Intent(getApplicationContext(), RecyclerViewActivity.class));
                    } else if (recyclerView.getChildAdapterPosition(child) == 1) {
                        //startActivity(new Intent(RidesListActivity.this, RideSummaryActivity.class));
                    } /*else if (recyclerView.getChildAdapterPosition(child) == 4) {
                       Intent i = new Intent();
                        i.setClass(getApplicationContext(), NotificationListActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                    else if(recyclerView.getChildAdapterPosition(child) == 5){
                        Intent i = new Intent();
                        i.setClass(getApplicationContext(), ChatHistoryActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                    else if (recyclerView.getChildAdapterPosition(child) == 6) {
                        Intent i = new Intent();
                        i.setClass(getApplicationContext(), GarageCardActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);

                    }
                    else if (recyclerView.getChildAdapterPosition(child) == 8) {
                        startActivity(new Intent(RidesListActivity.this, GasFilledDetailsActivity.class));


                    }else if(recyclerView.getChildAdapterPosition(child) == 0){

                        startActivity(new Intent(RidesListActivity.this, DriverProfileActivity.class));
                    }
                    else if(recyclerView.getChildAdapterPosition(child) == 7){
                        KidskabSharedPreferenceManager.getInstance().getSharedPreferences().storeBoolean(KidskabConstants.SHOW_END_MILEAGE, false);
                        Intent i = new Intent(RidesListActivity.this, VehicleMileageActivity.class);
                        i.putExtra("showRadioGroup", true);
                        startActivity(i);

                    }
                    else if(recyclerView.getChildAdapterPosition(child) == 9){
                        logOut();
                        KidskabSharedPreferenceManager.getInstance().getSharedPreferences().storeBoolean(KidskabConstants.IS_LOGGED_IN, false);
                        checkVehicleEndMileage();
                    }*/
                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolBar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if(slideOffset < 0.6)
                    toolBar.setAlpha(1 - slideOffset);
            }
        };
        Drawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.top_app_bar, menu);
        return true;
    }
}
