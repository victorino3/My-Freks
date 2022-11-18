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
    private TextView btn_Time;
    private TextView btn_Date;
    private EditText title;
    private Button btn;


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
        //Setting date
        btn_Date.setOnClickListener(new View.OnClickListener() {
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
                                select_Date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        //Setting time
        btn_Time.setOnClickListener(new View.OnClickListener() {
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

                                select_Time.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });



        return view;
    }


}