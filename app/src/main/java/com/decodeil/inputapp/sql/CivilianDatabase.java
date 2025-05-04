package com.decodeil.inputapp.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CivilianDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "civilian";
    public static final String TABLE_NAME = "civilians";
    private String name, address;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CivilianDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" (id integer PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public Cursor getData()
    {
        SQLiteDatabase sql = this.getReadableDatabase();
        return sql.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
    public void insertData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("address", address);
        db.insert(TABLE_NAME, null,cv);
    }
}
