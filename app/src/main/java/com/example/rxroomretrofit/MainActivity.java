package com.example.rxroomretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.rxroomretrofit.Retrofit.Data;
import com.example.rxroomretrofit.Retrofit.GetFirstData;
import com.example.rxroomretrofit.Retrofit.RetrofitHolder;
import com.example.rxroomretrofit.recyclerViewPack.UserAdapter;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    UserAdapter userAdapter = new UserAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        intiView();

        viewModel.subscriber(getData());

    }

    private void intiView() {

        recyclerView = findViewById(R.id.recView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public Observable<GetFirstData> getData(){

        return new RetrofitHolder().getApi()
                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<GetFirstData, GetFirstData>() {
                    @Override
                    public GetFirstData apply(@NotNull GetFirstData getFirstData) throws Exception {

                        userAdapter.setData(getFirstData.getData());
                        recyclerView.setAdapter(userAdapter);

                        System.out.println("First Data : " + getFirstData);

                        return getFirstData;
                    }
                });
    }
}