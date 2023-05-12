package com.lesson.retrofitproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JSONPlaceHolder {
    @GET("todo")
    public Call<List<TaskClass>> getTasks();

    @GET("todo/{todoId}")
    public Call<TaskClass> getTaskById(@Path("todoId") String id);

    @POST("/todo")
    public Call<TaskClass> postTask(@Body TaskClass task);
}
