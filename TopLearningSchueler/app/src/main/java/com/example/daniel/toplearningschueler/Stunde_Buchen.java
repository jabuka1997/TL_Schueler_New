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

public class Stunde_Buchen extends Fragment implements View.OnClickListener{



    Button btnvb;
    EditText etDate, etStunde, etMinute;
    Spinner spFach, spEinheiten, spLehrer;

    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;
    List<String> list= new ArrayList<String>();
    List<String> list2= new ArrayList<String>();
    List<String> list3= new ArrayList<String>();
    String Fach;
    String Einheiten;
    String Lehrer;
    public Stunde_Buchen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stunde__buchen, container, false);
        getActivity().setTitle("Stunde Buchen");

        etStunde = (EditText) view.findViewById(R.id.et_hour);
        etMinute = (EditText) view.findViewById(R.id.et_minute);
        btnvb = (Button) view.findViewById(R.id.btn_vb);
        etDate = (EditText) view.findViewById(R.id.et_date);
        spFach = (Spinner) view.findViewById(R.id.sp_fach);
        spEinheiten = (Spinner) view.findViewById(R.id.sp_einheiten);
        spLehrer = (Spinner) view.findViewById(R.id.sp_lehrer);






        etDate.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });



        list.add("Mathematik");
        list.add("Deutsch");
        list.add("Englisch");
        list.add("Latein");


        adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, list);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spFach.setAdapter(adapter1);
        spFach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                if (i == 0)
                    return;
                else {
                    String pos = (String) spFach.getItemAtPosition(i);

                    Fach = pos;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });


        for (int i = 2 ; i <= 5; i++)
        {
            list2.add(Integer.toString(i));
        }


        adapter2 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spEinheiten.setAdapter(adapter2);
        spEinheiten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                long pos;
                if (i == 0)
                    return;
                else {
                    pos = spEinheiten.getItemIdAtPosition(i);
                    ++pos;
                }
                Einheiten = Long.toString(pos);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });

        list3.add("Herr Huber");
        list3.add("Max Mustermann");
        list3.add("Frau Schmidt");


        adapter3 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, list3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spLehrer.setAdapter(adapter3);
        spLehrer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                if (i == 0)
                    return;
                else {
                    String pos = (String) spLehrer.getItemAtPosition(i);

                    Lehrer = pos;
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


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_vb:

                        String fach = Fach;
                        String einheiten = Einheiten;
                        String lehrer = Lehrer;

                        String datum = etDate.getText().toString().trim();
                        String stunde = etStunde.getText().toString().trim();
                        String minute = etMinute.getText().toString().trim();

                        try {
                            if (Integer.parseInt(etStunde.getText().toString()) >= 0 && Integer.parseInt(etStunde.getText().toString()) <= 23
                                    && Integer.parseInt(etMinute.getText().toString()) >= 0 && Integer.parseInt(etMinute.getText().toString()) <= 59
                                    && !fach.isEmpty() && !einheiten.isEmpty() && !lehrer.isEmpty() && !datum.isEmpty() && !stunde.isEmpty() && !minute.isEmpty()) {
                                Toast.makeText(getContext(), "Stunde gebucht!", Toast.LENGTH_LONG).show();
                            }
                            else
                                Toast.makeText(getContext(), "Bitte überprüfen Sie Ihre Eingaben!", Toast.LENGTH_LONG).show();

                        }
                        catch (Exception e)
                        {
                            Toast.makeText(getContext(), "Bitte überprüfen Sie Ihre Eingaben!", Toast.LENGTH_LONG).show();
                        }


                break;
        }
    }
}


