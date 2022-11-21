package com.vicvilian.schoolagenda.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vicvilian.schoolagenda.Model.MyModel;
import com.vicvilian.schoolagenda.R;


import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit ;

import java.util.Date;


public class Adapter extends RecyclerView.Adapter <Adapter.Myadapter>{
    List<MyModel> buildModel;
    public Adapter ( List<MyModel> buildModels) {
        this.buildModel = buildModels;
    }

    @NonNull
    @Override
    public Myadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //parent make reference of context where my list is being created
        //This onCreate will render the XML created in LinearLayout
        View mylist = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista,parent,false);
        return new Myadapter(mylist);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder( Myadapter holder, int position) {
        MyModel object = buildModel.get(position);
        String daytime = object.getStartAt() +" "+object.getStart_time();
        long millisecond = getRemainTime(daytime);
        String dayTimes = convertMilliSecondToHourAndDay(millisecond);
            holder.titleUserData.setText(object.getTitleUserData());
            holder.startAt.setText(object.getStartAt());
            holder.teacherUserData.setText(object.getTeacherUserData());
            holder.curricular_unit.setText(object.getCurricular_Unit());
            holder.timeLeft.setText(dayTimes);

    }

    @Override
    public int getItemCount() {
        return this.buildModel.size();
    }

    //Recyclerview instance new class that must be create in this
    public static class  Myadapter extends RecyclerView.ViewHolder{
         TextView titleUserData;
         TextView startAt;
         TextView teacherUserData;
         TextView timeLeft;
         TextView curricular_unit;
         ImageButton submit;

        public Myadapter(@NonNull View itemView) {
            super(itemView);
            //Instancing my view tha came from onCreateViewHolder
            titleUserData = itemView.findViewById(R.id.title_user);
            startAt = itemView.findViewById(R.id.startAt_user);
            teacherUserData = itemView.findViewById(R.id.teacherUser);
            timeLeft = itemView.findViewById(R.id.timeLeft_user);
            curricular_unit = itemView.findViewById(R.id.Unite_user);
            submit = itemView.findViewById(R.id.submit);
            

            //try

        }

    }
    public long getRemainTime(String daytime){
            try {
                Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                        .parse(daytime);

                long remaining = date.getTime() - System.currentTimeMillis();

                return remaining;
                //  return remaining;
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }

    }
    public  String convertMilliSecondToHourAndDay(Long millisecond){
        long hours = TimeUnit.MILLISECONDS.toHours(millisecond);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millisecond) % 60;
        long days = TimeUnit.MILLISECONDS.toDays(millisecond);
       if (days > 0){
            return (days+" days "+ hours+"H : "+minutes+"m "+" left");
       }else if (hours < 0) {return (minutes+" m "+" time left");
       }else{
           return (hours+"H : "+minutes+"m "+"time left");
       }

    }

}
