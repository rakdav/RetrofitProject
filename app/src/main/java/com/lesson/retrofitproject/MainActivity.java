package com.lesson.retrofitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<TaskClass> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        NetworkService.getInstance().getJSONApi().
                getTasks().enqueue(new Callback<List<TaskClass>>() {
                    @Override
                    public void onResponse(Call<List<TaskClass>> call, Response<List<TaskClass>> response) {
                        list=response.body();
                    }

                    @Override
                    public void onFailure(Call<List<TaskClass>> call, Throwable t) {

                    }
                });
    }
}