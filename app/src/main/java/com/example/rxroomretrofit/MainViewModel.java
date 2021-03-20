package com.example.rxroomretrofit;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxroomretrofit.Retrofit.GetFirstData;
import com.example.rxroomretrofit.Retrofit.RetrofitHolder;
import com.example.rxroomretrofit.recyclerViewPack.UserAdapter;

import org.jetbrains.annotations.NotNull;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel{

    public void subscriber(Observable<GetFirstData> observable){
        observable.subscribe(new Observer<GetFirstData>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {
                System.out.println("Started");
            }

            @Override
            public void onNext(@NotNull GetFirstData getFirstData) {

                System.out.println("FirstData : " + getFirstData);

                for (int i = 0; i < getFirstData.getData().size() ; i++) {
                    System.out.println("Data Email : " + getFirstData.getData().get(i).getEmail() );
                }
            }

            @Override
            public void onError(@NotNull Throwable e) {

                System.out.println("Error : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        });
    }
}
