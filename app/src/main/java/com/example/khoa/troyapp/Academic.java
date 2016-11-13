package com.example.khoa.troyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Academic extends AppCompatActivity {
    RecyclerView recyler;
    DatabaseHelper dp;
    AcademicAdapter academic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dp=new DatabaseHelper(this);
        academic=new AcademicAdapter(this,dp.getData());
        recyler=(RecyclerView) findViewById(R.id.my_recycler_view);
        recyler.setAdapter(academic);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Academic.this,classinformation.class);
                startActivity(intent);
            }
        });
    }

}
