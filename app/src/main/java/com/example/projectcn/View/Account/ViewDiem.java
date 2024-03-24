package com.example.projectcn.View.Account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.projectcn.R;
import com.example.projectcn.View.quiz.menucatagoryquiz;
import com.example.projectcn.datalocal.PreferenceManager;
import com.example.projectcn.interfaces.TotalQuestionsScoreAPI;
import com.example.projectcn.model.Category;
import com.example.projectcn.model.TotalQuestionsScore;
import com.example.projectcn.model.connect.RetrofitClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewDiem extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ViewDiemAdapter adapter;
    private List<TotalQuestionsScore> totalQuestionsScore = new ArrayList<>();
    PreferenceManager preferenceManager= new PreferenceManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diem);
        // Khởi tạo RecyclerView

        recyclerView = findViewById(R.id.recyclerView);

        // Khởi tạo Adapter
        adapter = new ViewDiemAdapter(totalQuestionsScore);
        recyclerView.setAdapter(adapter);

        // Thiết lập LayoutManager là GridLayoutManager với spanCount là 2
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        loadTotalQuestionsScores();
        }

    private void loadTotalQuestionsScores() {
        TotalQuestionsScoreAPI apiService = RetrofitClient.getClient().create(TotalQuestionsScoreAPI.class);
        Call<List<TotalQuestionsScore>> call = apiService.getTotalScoresByUserId(Long.parseLong(preferenceManager.getId()));

        call.enqueue(new Callback<List<TotalQuestionsScore>>() {
            @Override
            public void onResponse(Call<List<TotalQuestionsScore>> call, Response<List<TotalQuestionsScore>> response) {
                if (response.isSuccessful()) {
                    totalQuestionsScore.clear();
                    totalQuestionsScore.addAll(response.body());
                    Collections.reverse(totalQuestionsScore);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<TotalQuestionsScore>> call, Throwable t) {
                // Xử lý lỗi
            }
        });
    }
}