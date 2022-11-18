package com.vicvilian.schoolagenda.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vicvilian.schoolagenda.R;


public class Adapter extends RecyclerView.Adapter <Adapter.Myadapter>{

    public Adapter() {

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
    public void onBindViewHolder(@NonNull Myadapter holder, int position) {
        holder.titleUserData.setText("PDM Text");
        holder.startAt.setText("10-10-2022");
        holder.teacherUserData.setText("Pedro inacio");
        holder.timeLeft.setText("3 dias 72 horas");
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    //Recyclerview instance new class that must be create in this
    public static class  Myadapter extends RecyclerView.ViewHolder{
        public TextView titleUserData;
        public TextView startAt;
        public TextView teacherUserData;
        public TextView timeLeft;

        public Myadapter(@NonNull View itemView) {
            super(itemView);
            //Instancing my view tha came from onCreateViewHolder
            titleUserData = itemView.findViewById(R.id.title_user);
            startAt = itemView.findViewById(R.id.startAt_user);
            teacherUserData = itemView.findViewById(R.id.teacherUser);
            timeLeft = itemView.findViewById(R.id.timeLeft_user);
        }
    }
}
