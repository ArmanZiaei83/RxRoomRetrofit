package com.example.rxroomretrofit.RoomDataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import io.reactivex.Flowable;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user_data")
    Flowable<DataEntity> getAllData();

    @Query("DELETE FROM user_data")
    void deleteAll();

    @Insert
    void insertData(DataEntity dataEntity);
}
