package com.vicvilian.schoolagenda.ui.Create;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.vicvilian.schoolagenda.Helper.DB_Actions;
import com.vicvilian.schoolagenda.Model.MyModel;
import com.vicvilian.schoolagenda.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateFragment extends Fragment {
    private int mYear, mMonth, mDay, mHour, mMinute;
    private TextView select_Time;
    private TextView select_Date;
    private Button btn_Time;
    private Button btn_Date;
    private EditText title;
    private Button btn;
    //RadioGroup and element connected
    private RadioGroup radioGroupId;
    private TextView teacher;
    private TextView unitCurricular;
    private TextView contact;
    //RadioButton
    private RadioButton exam;
    private RadioButton school;
    private RadioButton week;

    //Checked
    public int myChecked;



    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);
        // Inflate the layout for this fragment

        select_Time = view.findViewById(R.id.select_time);
        title = view.findViewById(R.id.text_title);
        select_Date = view.findViewById(R.id.select_date);
        btn_Time = view.findViewById(R.id.button_time);
        btn_Date = view.findViewById(R.id.button_date);
        btn = view.findViewById(R.id.button_save_task);

        //RadioGroup Ids
        radioGroupId = view.findViewById(R.id.radioGroupId);
        exam = view.findViewById(R.id.radioButton_Exam);
        school = view.findViewById(R.id.radioButtonSchool);
        week = view.findViewById(R.id.radioButton_Week);
        teacher = view.findViewById(R.id.teacher_name);
        unitCurricular = view.findViewById(R.id.Currilar_unit);
        contact = view.findViewById(R.id.collegue_contact);

        //Hide elements
        getTeacher().setVisibility(View.GONE);
        getUnitCurricular().setVisibility(View.GONE);
        getContact().setVisibility(View.GONE);

        //Setting date
        getBtn_Date().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                getSelect_Date().setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        //Setting time
        getBtn_Time().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);
                int second = 50;
               // mSecond = c.get(Calendar.SECOND);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                getSelect_Time().setText(hourOfDay + ":" + minute + ":"+second);
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();
            }
        });

        //Setting radioGroup
        getRadioGroupId().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                if (getExam().getId() == checked || getSchool().getId() == checked){
                    getTeacher().setVisibility(View.VISIBLE);
                    getUnitCurricular().setVisibility(View.VISIBLE);
                    getContact().setVisibility(View.VISIBLE);
                    myChecked = checked;
                }else{
                    getTeacher().setVisibility(View.GONE);
                    getUnitCurricular().setVisibility(View.GONE);
                    getContact().setVisibility(View.GONE);
                }
            }
        });


        getBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getExam().getId() == myChecked ){
                    String title = String.valueOf(getTitle().getText());
                    String date = String.valueOf(getSelect_Date().getText());
                    String time = String.valueOf(getSelect_Time().getText());
                    String task = String.valueOf(getExam().getText());
                    String unite = String.valueOf(getUnitCurricular().getText());
                    String teacher = String.valueOf(getTeacher().getText());
                    String colleagues_email = String.valueOf(getContact().getText());
                    MyModel data = new MyModel(title,date,time,task,unite,teacher,colleagues_email);
                    //Send to DB
                    DB_Actions db_actions = new DB_Actions(getContext());
                    db_actions.writeUserTask(data);
                    System.out.println("I get no 255");

                }else if(getSchool().getId() == myChecked){
                    String title = String.valueOf(getTitle().getText());
                    String date = String.valueOf(getSelect_Date().getText());
                    String time = String.valueOf(getSelect_Time().getText());
                    String task = String.valueOf(getSchool().getText());
                    String unite = String.valueOf(getUnitCurricular().getText());
                    String teacher = String.valueOf(getTeacher().getText());
                    String colleagues_email = String.valueOf(getContact().getText());
                    MyModel data = new MyModel(title,date,time,task,unite,teacher,colleagues_email);
                    //Send to DB
                    DB_Actions db_actions = new DB_Actions(getContext());
                    db_actions.writeUserTask(data);
                    System.out.println("I get no 2");



                }else{
                    String title = String.valueOf(getTitle().getText());
                    String date = String.valueOf(getSelect_Date().getText());
                    String time = String.valueOf(getSelect_Time().getText());
                    String task = String.valueOf(getSchool().getText());

                    MyModel data = new MyModel(title,date,time,task);
                }


            }
        });

        return view;
    }

    public TextView getSelect_Time() {
        return select_Time;
    }

    public TextView getSelect_Date() {
        return select_Date;
    }

    public Button getBtn_Time() {
        return btn_Time;
    }

    public Button getBtn_Date() {
        return btn_Date;
    }

    public EditText getTitle() {
        return title;
    }

    public Button getBtn() {
        return btn;
    }

    public RadioGroup getRadioGroupId() {
        return radioGroupId;
    }

    public TextView getTeacher() {
        return teacher;
    }

    public TextView getUnitCurricular() {
        return unitCurricular;
    }

    public TextView getContact() {
        return contact;
    }

    public RadioButton getExam() {
        return exam;
    }

    public RadioButton getSchool() {
        return school;
    }

    public RadioButton getWeek() {
        return week;
    }
}