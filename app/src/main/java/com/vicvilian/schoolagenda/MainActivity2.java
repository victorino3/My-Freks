package com.vicvilian.schoolagenda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.vicvilian.schoolagenda.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_create, R.id.nav_task, R.id.nav_about)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //Setting Database here
        try {
            SQLiteDatabase database = openOrCreateDatabase("Appointments",MODE_PRIVATE,null);

            database.execSQL("CREATE TABLE IF NOT EXISTS Userppointment (task VARCHAR, day VARCHAR, time VARCHAR , task_type VARCHAR, discipline VARCHAR, teacher VARCHAR,colleagues TEXT )");
            database.execSQL("INSERT INTO Userppointment (task,day,time,task_type,discipline,teacher,colleagues)" +
                    "VALUES ('Develop app','2022-11-19','23:40','School','PDM','Pedro Inacio','victorinogomes1@gmail')");

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

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}