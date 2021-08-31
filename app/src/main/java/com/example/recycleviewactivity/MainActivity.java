package com.example.recycleviewactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = findViewById(R.id.recyclerViewID);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

        listItem= new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            ListItem item = new ListItem("item"+(i+1),
                    "description");

            listItem.add(item);
        }

        adapter= new MyAdapter(this, listItem);
        recycleView.setAdapter(adapter);
    }
}