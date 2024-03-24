package com.example.projectcn.View.Account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectcn.R;
import com.example.projectcn.model.TotalQuestionsScore;

import java.util.List;

public class ViewDiemAdapter extends RecyclerView.Adapter<ViewDiemAdapter.ViewHolder> {
    private List<TotalQuestionsScore> data;

    public ViewDiemAdapter(List<TotalQuestionsScore> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_diem_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TotalQuestionsScore score = data.get(position);
        holder.quizName.setText(score.getQuiz().getNameQuiz()); // Assuming Quiz has a method getNameQuiz
        holder.totalScore.setText(String.valueOf(score.getTotalScore()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView quizName, totalScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quizName = itemView.findViewById(R.id.tenBai);
            totalScore = itemView.findViewById(R.id.soDiem);
        }
    }
}
