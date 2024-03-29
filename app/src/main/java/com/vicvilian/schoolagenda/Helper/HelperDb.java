package com.vicvilian.schoolagenda.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class HelperDb extends SQLiteOpenHelper {
    public static final String name_db = "DB_TASK";
    public static final String table_name = "Appointments";
    public static final String table_name_register = "User";
    public static final int version = 2;
    public HelperDb(@Nullable Context context) {
        super(context, name_db, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            String sql = ("CREATE TABLE IF NOT EXISTS " +table_name+" (id INTEGER PRIMARY KEY AUTOINCREMENT, task VARCHAR(255) NOT NULL , day VARCHAR(255) NOT NULL, time VARCHAR(255) NOT NULL , task_type VARCHAR(255) NOT NULL, discipline VARCHAR(255) NOT NULL, teacher VARCHAR(255) NOT NULL, colleagues TEXT )");
            String sql_1 = ("CREATE TABLE IF NOT EXISTS " +table_name_register+" (id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR(255) NOT NULL, pssword VARCHAR(255) NOT NULL)");
            db.execSQL(sql);
            db.execSQL(sql_1);
            Log.i("DB creation","Db created successfully");
        }catch (Exception e){
            Log.e("onCreate DB error", "onCreate: query create table wrong");
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE "+HelperDb.table_name;
        db.execSQL(sql);
        Log.i("Dropped","Table Deleted");
    }
}
