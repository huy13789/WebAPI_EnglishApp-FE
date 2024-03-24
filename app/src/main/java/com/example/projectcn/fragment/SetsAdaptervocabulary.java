package com.example.projectcn.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectcn.R;

import java.util.ArrayList;
import java.util.List;

public class SetsAdaptervocabulary extends RecyclerView.Adapter<SetsAdaptervocabulary.viewhoder> implements Filterable {
    private ArrayList<SetsModel> list;
    private ArrayList<SetsModel> filteredList;
    private Context context;

    public SetsAdaptervocabulary(ArrayList<SetsModel> list, Context context) {
        this.list = list;
        this.context = context;
        this.filteredList = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lessonview, parent, false);
        return new viewhoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewhoder holder, int position) {
        final SetsModel model = filteredList.get(position); // Use filteredList instead of list
        holder.setName.setText(model.getSetName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, pdfViewvocabularyActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size(); // Use filteredList instead of list
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString().toLowerCase();

                ArrayList<SetsModel> filtered = new ArrayList<>();

                for (SetsModel item : list) {
                    if (item.getSetName().toLowerCase().contains(query)) {
                        filtered.add(item);
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredList.clear();
                filteredList.addAll((List<SetsModel>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class viewhoder extends RecyclerView.ViewHolder {
        TextView setName;

        public viewhoder(@NonNull View itemView) {
            super(itemView);
            setName = itemView.findViewById(R.id.setName);
        }
    }
}
