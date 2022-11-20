package com.vicvilian.schoolagenda.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vicvilian.schoolagenda.Model.MyModel;

public class DB_Actions implements DAO_Interface {
    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public DB_Actions(Context context) {
        HelperDb my_db = new HelperDb(context);
        write = my_db.getWritableDatabase();
        read = my_db.getReadableDatabase();
    }


    @Override
    public Boolean saveUserTask(MyModel data) {
        return true;
    }

    @Override
    public Boolean writeUserTask(MyModel data) {
        ContentValues dataContent = new ContentValues();
        dataContent.put("task",data.getTitleUserData());
        dataContent.put("day",data.getStartAt());
        dataContent.put("time",data.getStart_time());
        dataContent.put("task_type",data.getTaskType());
        dataContent.put("discipline",data.getCurricular_Unit());
        dataContent.put("teacher",data.getTeacherUserData());
        dataContent.put("colleagues",data.getColleagues_email());
        this.write.insert(HelperDb.table_name,null, dataContent);
        return true;
    }

    @Override
    public Boolean getAllUserTask(MyModel data) {
        return true;
    }

    @Override
    public Boolean updateUserTask(MyModel data) {
        return true;
    }

    @Override
    public Boolean removeUserTask(MyModel data) {
        return true;
    }
}
