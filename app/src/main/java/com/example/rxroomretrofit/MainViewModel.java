package com.example.rxroomretrofit;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rxroomretrofit.Retrofit.GetFirstData;
import com.example.rxroomretrofit.Retrofit.RetrofitHolder;
import com.example.rxroomretrofit.RoomDataBase.DataEntity;
import com.example.rxroomretrofit.RoomDataBase.UserDataBase;
import com.example.rxroomretrofit.recyclerViewPack.UserAdapter;

import org.jetbrains.annotations.NotNull;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel{

    UserDataBase userDataBase;
    private Context context;

    public void createDataBase(Context context){

        this.context = context;

        userDataBase = Room.databaseBuilder(context, UserDataBase.class , "userinfo.db").build();
    }

    //Room Inserting :
    public void addToDb(String fName , String lName){

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {

                DataEntity dataEntity = new DataEntity(fName , lName);
                userDataBase.userDao().insertData(dataEntity);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {
                        System.out.println("Subscribed");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                });
    }

    //Rx FlatMap Subscriber:

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
                    addToDb(getFirstData.getData().get(i).getFirst_name() , getFirstData.getData().get(i).getLast_name());
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

    public void getData(){

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                userDataBase.userDao().getAllData().subscribe(new Consumer<DataEntity>() {
                    @Override
                    public void accept(DataEntity dataEntity) throws Exception {
                        System.out.println("DataBase Data : " + dataEntity.getfName() + " " + dataEntity.getlName());
                    }
                });
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {
                        System.out.println("Data Getting Started");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Data Getting Finished");
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        System.out.println("Data Getting Error : " + e.getMessage());
                    }
                });
    }
}
