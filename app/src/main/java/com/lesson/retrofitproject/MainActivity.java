package com.lesson.retrofitproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<TaskClass> list;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        recyclerView=findViewById(R.id.rv);
        NetworkService.getInstance().getJSONApi().
                getTasks().enqueue(new Callback<List<TaskClass>>() {
                    @Override
                    public void onResponse(Call<List<TaskClass>> call, Response<List<TaskClass>> response) {
                        list=response.body();
                        adapter=new TaskAdapter(list,MainActivity.this);
                        recyclerView.setAdapter(adapter);
                    }
                    @Override
                    public void onFailure(Call<List<TaskClass>> call, Throwable t) {
                        Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}