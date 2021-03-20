package com.example.rxroomretrofit.RoomDataBase;

import androidx.media.AudioAttributesCompat;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DataEntity {

    @PrimaryKey
    int id;

    @ColumnInfo(name = "fname")
    String fName;

    @ColumnInfo(name = "Lname")
    String lName;

    
}
