package com.vicvilian.schoolagenda.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.vicvilian.schoolagenda.Model.MyModel;
import com.vicvilian.schoolagenda.ui.Create.CreateFragment;

import java.util.ArrayList;
import java.util.List;

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
            dataContent.put("task", data.getTitleUserData());
            dataContent.put("day", data.getStartAt());
            dataContent.put("time", data.getStart_time());
            dataContent.put("task_type", data.getTaskType());
            dataContent.put("discipline", data.getCurricular_Unit());
            dataContent.put("teacher", data.getTeacherUserData());
            dataContent.put("colleagues", data.getColleagues_email());
            this.write.insert(HelperDb.table_name, null, dataContent);




        return true;
    }

    @Override
    public List<MyModel> getAllUserTask() {
        List<MyModel> buildModel = new ArrayList<>();
        String sql = "SELECT * FROM "+HelperDb.table_name;
        Cursor cursor = read.rawQuery(sql,null);
        int title = cursor.getColumnIndex("task");
        int startAt = cursor.getColumnIndex("day");
        int start_time = cursor.getColumnIndex("time");
        int taskType = cursor.getColumnIndex("task_type");
        int curricular_Unit = cursor.getColumnIndex("discipline");
        int teacherUserData = cursor.getColumnIndex("teacher");
        int colleagues_email = cursor.getColumnIndex("colleagues");
        while (cursor.moveToNext()){
            MyModel model = new MyModel();
            String titleValue = cursor.getString(title);
            String startAtValue = cursor.getString(startAt);
            String start_timeValue = cursor.getString(start_time);
            String taskTypeValue = cursor.getString(taskType);
            String curricular_UnitValue = cursor.getString(curricular_Unit);
            String teacherUserDataValue = cursor.getString(teacherUserData);
            String colleagues_emailValue = cursor.getString(colleagues_email);
            model.setTitleUserData(titleValue);
            model.setStartAt(startAtValue);
            model.setStart_time(start_timeValue);
            model.setTaskType(taskTypeValue);
            model.setCurricular_Unit(curricular_UnitValue);
            model.setTeacherUserData(teacherUserDataValue);
            model.setColleagues_email(colleagues_emailValue);
            buildModel.add(model);

            }
        Log.i("Error in delete","Delete error"+ buildModel.size());
        return buildModel;
    }

    @Override
    public List<MyModel> loginUser() {
        return null;
    }

    @Override
    public List<MyModel> register() {
        return null;
    }


    @Override
    public Boolean updateUserTask(MyModel data) {
        return true;
    }

    @Override
    public Boolean removeUserTask(MyModel data) {
        try {
            String[] args = {data.getTitleUserData().toString()};
            this.write.delete(HelperDb.table_name,"task=?",args);

        }catch (Exception e){
            Log.e("Error in delete","Delete error");
            return false;
        }
        return true;
    }
}
