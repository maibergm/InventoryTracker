package com.cs3012.aa11.inventorytracker.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;
import android.content.*;

import com.cs3012.aa11.inventorytracker.R;
import com.cs3012.aa11.inventorytracker.activity.AddProjectsActivity;
import com.cs3012.aa11.inventorytracker.activity.MainActivity;

import java.util.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsFragment extends Fragment {


    public ProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Projects");
        View view = inflater.inflate(R.layout.fragment_projects, container, false);

        String[] menuItems = {"Project 1", "Project 2", "Project 3", "Project 4", "Project 5", "Project 6",
                "Project 1", "Project 2", "Project 3", "Project 4", "Project 5", "Project 6",
                "Project 1", "Project 2", "Project 3", "Project 4", "Project 5", "Project 6"
        };
        ListView listView = (ListView) view.findViewById(R.id.projects_list);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listView.setAdapter(listViewAdapter);

        FloatingActionButton addProjects = (FloatingActionButton) view.findViewById(R.id.fab_add_projects);
        addProjects.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddProjectsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
