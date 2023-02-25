package com.example.geektools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Drawer extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;


    static ArrayList<String> arrayList = new ArrayList<>();
    MainAdapter adapter;

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawerLayout = findViewById(R.id.drawer_layout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recycler_view);



    arrayList.clear();

    arrayList.add("Newsfeed");
    arrayList.add("Pc-builder");
    arrayList.add("About");
    arrayList.add("Preferences");
    arrayList.add("Map");
    arrayList.add("Forum");
    arrayList.add("Logout");


    adapter = new MainAdapter(this,arrayList);

    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    recyclerView.setAdapter(adapter);

    btMenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    });
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }


}