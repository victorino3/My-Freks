package com.vicvilian.schoolagenda.ui.Task;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.vicvilian.schoolagenda.Adapter.Adapter;
import com.vicvilian.schoolagenda.Helper.DB_Actions;
import com.vicvilian.schoolagenda.Model.MyModel;
import com.vicvilian.schoolagenda.R;
import com.vicvilian.schoolagenda.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskFragment extends Fragment {
    List<MyModel> buildModel = new ArrayList<>();
    public RecyclerView recyclerView;

    public TaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        loadData();
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        MyModel item = buildModel.get(position);
                        Toast.makeText(getContext(), String.format("%s ",item.getTitleUserData()), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));

        return view;
    }

    public void loadData(){
        //Getting the list Tasks
        DB_Actions db_actions = new DB_Actions(getContext());
        buildModel = db_actions.getAllUserTask();

        //Instance and Set an adapter

        Adapter adapterMade = new Adapter( buildModel );

        //set layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        //Set listener
        //I removed
        //Setting adapter in recyclerview
        recyclerView.setAdapter(adapterMade);
        // Inflate the layout for this fragment
    }

    @Override
    public void onStart() {
        loadData();
        super.onStart();
    }
}
