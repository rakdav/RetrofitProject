package com.lesson.retrofitproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<TaskClass> listTasks;
    private Context context;

    public TaskAdapter(List<TaskClass> listTasks, Context context) {
        this.listTasks = listTasks;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.tast_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  TaskClass task=listTasks.get(position);
        holder.data.setText(task.getDateCreated());
        holder.done.setChecked(task.isDone());
        holder.task.setText(task.getTask());
    }

    @Override
    public int getItemCount() {
        return listTasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView data;
        public CheckBox done;
        public TextView task;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            data=itemView.findViewById(R.id.data);
            done=itemView.findViewById(R.id.done);
            task=itemView.findViewById(R.id.task);
        }
    }
}
