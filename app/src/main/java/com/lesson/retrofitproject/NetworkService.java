package com.lesson.retrofitproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService
{
    private static NetworkService mInstance;
    private static final String BASE_URL="http://localhost:8080/api/";
    private Retrofit mRetrofit;
    public NetworkService() {
        mRetrofit=new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static NetworkService getInstance(){
        if(mInstance==null)
            mInstance=new NetworkService();
        return mInstance;
    }
    public  JSONPlaceHolder getJSONApi()
    {
        return mRetrofit.create(JSONPlaceHolder.class);
    }
}
