package com.example.projectcn.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectcn.R;

import java.util.ArrayList;

public class SetAdapter extends RecyclerView.Adapter<SetAdapter.viewhoder> {


    ArrayList<SetsModel> list;

    Context context;
    public SetAdapter(ArrayList<SetsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lessonview,parent,false);
        return new viewhoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewhoder holder, int position) {
        final SetsModel model=list.get(position);
        holder.setName.setText(model.getSetName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,PdfViewActivity.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewhoder extends RecyclerView.ViewHolder{
        TextView setName;
        public viewhoder(@NonNull View itemView) {
            super(itemView);
            setName = itemView.findViewById(R.id.setName);
        }
    }
}
