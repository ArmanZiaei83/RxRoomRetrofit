package com.example.rxroomretrofit.RoomDataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user_data")
    Flowable<DataEntity> getAllData();

    @Query("DELETE FROM user_data")
    Flowable<DataEntity> deleteAll();

    @Insert
    Flowable<DataEntity> insertData(DataEntity dataEntity);
}
