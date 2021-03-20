package com.example.rxroomretrofit.Retrofit;

import com.example.rxroomretrofit.R;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHolder {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Api api = retrofit.create(Api.class);

    public Api getApi() {
        return api;
    }
}
