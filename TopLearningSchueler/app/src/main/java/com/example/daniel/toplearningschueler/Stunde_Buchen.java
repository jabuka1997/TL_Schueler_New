package com.example.daniel.toplearningschueler;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.widget.Toast.makeText;

/**
 * A simple {@link Fragment} subclass.
 */

public class Stunde_Buchen extends Fragment{



    Button btnvb;
    EditText etDate, etStunde, etMinute;
    Spinner spFach;
    ArrayAdapter<String> adapter;
    List<String> list;

    public Stunde_Buchen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stunde__buchen, container, false);

        etStunde = (EditText) view.findViewById(R.id.et_hour);
        etMinute = (EditText) view.findViewById(R.id.et_minute);
        btnvb = (Button) view.findViewById(R.id.btn_vb);
        etDate = (EditText) view.findViewById(R.id.et_date);
        spFach = (Spinner) view.findViewById(R.id.sp_fach);

        getActivity().setTitle("Stunde Buchen");

        btnvb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if (Integer.parseInt(etStunde.getText().toString()) >= 0 && Integer.parseInt(etStunde.getText().toString()) <= 23 && Integer.parseInt(etMinute.getText().toString()) >= 0 && Integer.parseInt(etMinute.getText().toString()) <= 59) {
                        Toast.makeText(getContext(), "Stunde gebucht!", Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getContext(), "Bitte überprüfen Sie Ihre Eingaben!", Toast.LENGTH_LONG).show();

                }
                catch (Exception e)
                {
                    Toast.makeText(getContext(), "Bitte überprüfen Sie Ihre Eingaben!", Toast.LENGTH_LONG).show();
                }
            }
        });



        etDate.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });


        list = new ArrayList<String>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFach.setAdapter(adapter);
        spFach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:

                        break;
                    case 1:
                        Toast.makeText(parent.getContext(), "Spinner item 2!", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(parent.getContext(), "Spinner item 3!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });
        // Inflate the layout for this fragment
        return view;
    }




}


