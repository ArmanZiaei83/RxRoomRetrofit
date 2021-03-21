package com.example.rxroomretrofit.Accessor;

import android.content.Context;

import androidx.room.Room;

import com.example.rxroomretrofit.RoomDataBase.UserDataBase;

import io.reactivex.Completable;

public class GetAccess {

    UserDataBase userDataBase;
    Context context;

    public GetAccess(Context context) {
        this.context = context;

        userDataBase = Room.databaseBuilder(context, UserDataBase.class , "userinfo.db").build();
    }

    
}
