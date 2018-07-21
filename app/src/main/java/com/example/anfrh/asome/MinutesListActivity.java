package com.example.anfrh.asome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.anfrh.asome.Adapter.MinutesAdapter;

import java.util.ArrayList;

public class MinutesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minutes_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView lv_minutes = (ListView)findViewById(R.id.lv_minutes);
        ArrayList al_minutes= new ArrayList<MinutesItem>();
        al_minutes =  new ArrayList<MinutesItem>();




        al_minutes.add(new MinutesItem("제목","데이트","텍스트"));

        MinutesAdapter adapter_minutes = new MinutesAdapter(getApplicationContext(),al_minutes);
        lv_minutes.setAdapter(adapter_minutes);
    }

}
