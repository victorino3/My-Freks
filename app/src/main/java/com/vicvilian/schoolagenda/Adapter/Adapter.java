package com.vicvilian.schoolagenda.Adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.vicvilian.schoolagenda.Model.MyModel;
import com.vicvilian.schoolagenda.R;

import java.util.ArrayList;
import java.util.List;


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
        if ( buildModel.size() > 0 ) {
            MyModel object = buildModel.get(position);
            holder.titleUserData.setText(object.getTitleUserData());
            holder.startAt.setText(object.getStartAt());
            holder.teacherUserData.setText(object.getTeacherUserData());
            holder.curricular_unit.setText(object.getCurricular_Unit());
            holder.timeLeft.setText("There are " + " 32 " + "days and " + object.getStart_time() + " left to finish the submission time");
            Log.i("getHere", object.getTitleUserData());
        }else{
            //holder.message();
        }
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

        public Myadapter(@NonNull View itemView) {
            super(itemView);
            //Instancing my view tha came from onCreateViewHolder
            titleUserData = itemView.findViewById(R.id.title_user);
            startAt = itemView.findViewById(R.id.startAt_user);
            teacherUserData = itemView.findViewById(R.id.teacherUser);
            timeLeft = itemView.findViewById(R.id.timeLeft_user);
            curricular_unit = itemView.findViewById(R.id.Unite_user);
        }
        public void message(){
            Snackbar.make(
                    itemView,
                    "Do you to delete?",
                    Snackbar.LENGTH_INDEFINITE
            ).setAction("Delete", view1 -> {
                //you can create new instance of snackBar and use dismiss to remove pop up
            }).show();
        }
    }

}
