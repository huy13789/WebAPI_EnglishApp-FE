package com.example.projectcn.View.lessonview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectcn.R;
import com.example.projectcn.fragment.SetAdapter;
import com.example.projectcn.fragment.SetsModel;

import java.util.ArrayList;

public class LessonviewActivity extends AppCompatActivity {
    ArrayList<SetsModel> list;
    SetAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessonview);
        recyclerView= findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list.add(new SetsModel("lesson-1"));
        list.add(new SetsModel("lesson-2"));
        list.add(new SetsModel("lesson-3"));
        list.add(new SetsModel("lesson-4"));
        list.add(new SetsModel("lesson-5"));
        list.add(new SetsModel("lesson-6"));
        list.add(new SetsModel("lesson-7"));
        list.add(new SetsModel("lesson-8"));
        list.add(new SetsModel("lesson-9"));
        list.add(new SetsModel("lesson-10"));
        list.add(new SetsModel("lesson-11"));
        adapter = new SetAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }
}