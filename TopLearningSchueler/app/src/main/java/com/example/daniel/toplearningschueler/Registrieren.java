package com.example.daniel.toplearningschueler;


import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.os.EnvironmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registrieren extends Fragment implements View.OnClickListener {

    private List<String> Spinnerlist = new ArrayList<String>();
    Button btn_reg;
    Spinner sp_schultyp;

    public Registrieren() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registrieren, container, false);
        getActivity().setTitle("Registrieren");

        sp_schultyp = (Spinner) view.findViewById(R.id.sp_schultyp);

        btn_reg = (Button) view.findViewById(R.id.btn_register);
        btn_reg.setOnClickListener(this);

        Spinnerlist.add("HTL");
        Spinnerlist.add("AHS");
        Spinnerlist.add("KMS");
        Spinnerlist.add("Volkschule");



        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, Spinnerlist);
        sp_schultyp.setAdapter(adapter1);
        sp_schultyp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int pos = sp_schultyp.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }



    @Override
    public void onClick(View v) {

    }
}
