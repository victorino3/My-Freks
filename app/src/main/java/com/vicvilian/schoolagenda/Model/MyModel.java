package com.vicvilian.schoolagenda.Model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MyModel {
    private String titleUserData;
    private String startAt;
    private String teacherUserData;
    private String timeLeft;

    public MyModel(String titleUserData, String startAt, String teacherUserData, String timeLeft) {
        this.titleUserData = titleUserData;
        this.startAt = startAt;
        this.teacherUserData = teacherUserData;
        this.timeLeft = timeLeft;
    }
    public static void getAll(SQLiteDatabase database){
        //Get Data from db
        Cursor cursor = database.rawQuery("SELECT * FROM Userppointment",null);
        int task = cursor.getColumnIndex("task");
        int day = cursor.getColumnIndex("day");
        int time = cursor.getColumnIndex("time");
        int task_type = cursor.getColumnIndex("task_type");
        int discipline = cursor.getColumnIndex("discipline");
        int teacher = cursor.getColumnIndex("teacher");
        int colleagues = cursor.getColumnIndex("colleagues");
        //we must use moveToFirst to restart it
        cursor.moveToFirst();
        while (cursor != null){
            Log.i("Result Task: ", cursor.getString(task));
            Log.i("Result Day: ", cursor.getString(day));
            Log.i("Result Time: ", cursor.getString(time));
            Log.i("Result Task Type: ", cursor.getString(task_type));
            Log.i("Result Discipline: ", cursor.getString(discipline));
            Log.i("Result Teacher: ", cursor.getString(teacher));
            Log.i("Result Colleagues: ", cursor.getString(colleagues));
            cursor.moveToNext();
        }

    }
    public String getTitleUserData() {
        return titleUserData;
    }

    public void setTitleUserData(String titleUserData) {
        this.titleUserData = titleUserData;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getTeacherUserData() {
        return teacherUserData;
    }

    public void setTeacherUserData(String teacherUserData) {
        this.teacherUserData = teacherUserData;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }
}
