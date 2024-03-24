package com.example.projectcn.View.lessonview;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectcn.R;
import com.example.projectcn.fragment.SetsAdaptervocabulary;
import com.example.projectcn.fragment.SetsModel;

import java.util.ArrayList;

public class Vocabulary2 extends AppCompatActivity {
    ArrayList<SetsModel>list;
    RecyclerView recyclerView;
    SetsAdaptervocabulary adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabularyview2);
        recyclerView = findViewById(R.id.recyclerView);
        SearchView searchView = findViewById(R.id.searchView);
        list = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list.add(new SetsModel("Abase"));
        list.add(new SetsModel("Abash"));
        list.add(new SetsModel("Abate"));
        list.add(new SetsModel("Abbreviate"));
        list.add(new SetsModel("Abbreviate"));
        list.add(new SetsModel("Abdicate"));
        list.add(new SetsModel("Abduction"));
        list.add(new SetsModel("Aberrant"));
        list.add(new SetsModel("Abet"));
        list.add(new SetsModel("Benevolent"));
        list.add(new SetsModel("Belligerent"));
        list.add(new SetsModel("Bifurcate"));
        list.add(new SetsModel("Cacophony"));
        list.add(new SetsModel("Cajole"));
        list.add(new SetsModel("Candid"));
        list.add(new SetsModel("Delineate"));
        list.add(new SetsModel("Debilitate"));
        list.add(new SetsModel("Dichotomy"));
        list.add(new SetsModel("Elucidate"));
        list.add(new SetsModel("Ephemeral"));
        list.add(new SetsModel("Equivocate"));
        list.add(new SetsModel("Fervent"));
        list.add(new SetsModel("Fluctuate"));
        list.add(new SetsModel("Fortuitous"));
        list.add(new SetsModel("Galvanize"));
        list.add(new SetsModel("Garrulous"));
        list.add(new SetsModel("Grandiloquent"));
        list.add(new SetsModel("Harangue"));
        list.add(new SetsModel("Hedonistic"));
        list.add(new SetsModel("Hapless"));
        list.add(new SetsModel("Ineffable"));
        list.add(new SetsModel("Inscrutable"));
        list.add(new SetsModel("Insidious"));
        adapter = new SetsAdaptervocabulary(list, this);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the list based on the search query
                adapter.getFilter().filter(newText);
                return true;
            }
        });
    }

}
