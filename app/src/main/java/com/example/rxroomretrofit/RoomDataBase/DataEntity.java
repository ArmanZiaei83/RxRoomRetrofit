package com.example.rxroomretrofit.RoomDataBase;

import androidx.media.AudioAttributesCompat;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_data")
public class DataEntity {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "fname")
    String fName;

    @ColumnInfo(name = "Lname")
    String lName;

    public DataEntity(int id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
