package com.cs3012.aa11.inventorytracker.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.cs3012.aa11.inventorytracker.R;
import com.cs3012.aa11.inventorytracker.activity.AddProjectsActivity;
import com.cs3012.aa11.inventorytracker.barcodeScanner;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndividualsFragment extends Fragment {


    public IndividualsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Individuals");
        View view = inflater.inflate(R.layout.fragment_individuals, container, false);

        String[] menuItems = {"Hola", "Hello", "Bonjour", "Gutentag", "Ciao"};

        FloatingActionButton addProjects = (FloatingActionButton) view.findViewById(R.id.addIndividuals);
        addProjects.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), barcodeScanner.class);
                startActivity(intent);
            }
        });

        ListView listView = (ListView) view.findViewById(R.id.individuals_list);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listView.setAdapter(listViewAdapter);
        return view;
    }

}
