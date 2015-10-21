package com.span.hamburger3;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    ListView listView;
    DrawerLayout drawerLayout;
    ArrayAdapter<String> listAdapter;
    ActionBarDrawerToggle drawerListener;
    String options[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerListener = new ActionBarDrawerToggle(this,drawerLayout,R.drawable.ic_drawer,R.string.open_navigation_drawer,R.string.close_navigation_drawer);
        drawerLayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        options = getResources().getStringArray(R.array.option);
        listView =(ListView) findViewById(R.id.listView);
        listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "button 1 clicked",
                                Toast.LENGTH_SHORT).show();

                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "button 2 clicked",
                                Toast.LENGTH_SHORT).show();
                        break;
                }

                drawerLayout.closeDrawers();
            }
        });


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }


}
