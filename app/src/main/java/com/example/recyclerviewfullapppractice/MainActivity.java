package com.example.recyclerviewfullapppractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public RecyclerView.Adapter adapterPopular;
    public RecyclerView recyclerViewPopular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<CourseDomain> ItemsArray = new ArrayList<>();
        ItemsArray.add(new CourseDomain("Quick Learn Java Language","Hamza",100,4.1,"pic1"));
        ItemsArray.add(new CourseDomain("Full Course Android Development","Sanad",500,5,"pic2"));
        ItemsArray.add(new CourseDomain("Quick Learn C# Language","Rashed Daraghma",200,4.2,"pic3"));
        recyclerViewPopular = findViewById(R.id.view);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPopular = new CourseAdapter(ItemsArray);
        recyclerViewPopular.setAdapter(adapterPopular);
        }
    }
