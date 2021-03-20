package com.example.rxroomretrofit.Retrofit;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("api/users?page=2")
    Observable<GetFirstData> getUsers();

}
