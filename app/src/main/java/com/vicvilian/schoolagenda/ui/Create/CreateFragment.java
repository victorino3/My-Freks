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

import com.vicvilian.schoolagenda.R;

import java.util.Calendar;

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
                System.out.println(mYear+","+mMonth+","+mDay);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                getSelect_Date().setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

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

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                getSelect_Time().setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
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
                }else{
                    getTeacher().setVisibility(View.GONE);
                    getUnitCurricular().setVisibility(View.GONE);
                    getContact().setVisibility(View.GONE);
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