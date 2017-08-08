package com.jan.flc.firstlinecode.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by huangje on 2017/7/4.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String CREATE_TABLE = "create table Book (" +
            "id integer primary key autoincrement," +
            "name text," +
            "price real," +
            "author text )";

    public static final String DROP_TABLE = "drop table Book";

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
