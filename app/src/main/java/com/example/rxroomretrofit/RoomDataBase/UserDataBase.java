package com.example.rxroomretrofit.RoomDataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DataEntity.class} , version = 1)
public abstract class UserDataBase {

    public abstract UserDao userDao();

    UserDataBase INSTANCE;
    
}
