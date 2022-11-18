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
import com.vicvilian.schoolagenda.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskFragment extends Fragment {
    public RecyclerView recyclerView;

    public TaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        //Instance and Set an adapter
        recyclerView = view.findViewById(R.id.recyclerView);
        Adapter adapterMade = new Adapter();


        //set layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        //Set listener
        //I removed
        //Setting adapter in recyclerview
        recyclerView.setAdapter(adapterMade);
        // Inflate the layout for this fragment
        return view;
    }
}