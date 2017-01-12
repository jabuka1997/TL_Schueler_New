package com.example.daniel.toplearningschueler;


import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.os.EnvironmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
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
    private List<String> Spinnerlist2 = new ArrayList<String>();
    EditText etVorname, etNachname, etDatum, etAdresse, etPLZ, etOrt, etEmail, etTelefon, etVornameErz, etNachnameErz, etPW;
    RadioButton rbGenderM;
    RadioButton rbGenderW;
    Boolean Gender;
    Button btn_reg;
    Spinner spSchultyp, spSchulstufe;
    String Schulttyp;
    int Schulstufe;

    public Registrieren() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registrieren, container, false);
        getActivity().setTitle("Registrieren");

        spSchultyp = (Spinner) view.findViewById(R.id.sp_schultyp);
        spSchulstufe = (Spinner) view.findViewById(R.id.sp_schulstufe);



        btn_reg = (Button) view.findViewById(R.id.btn_register);
        btn_reg.setOnClickListener(this);

        Spinnerlist2.add("1");
        Spinnerlist2.add("2");
        Spinnerlist2.add("3");
        Spinnerlist2.add("4");
        Spinnerlist2.add("5");


        Spinnerlist.add("HTL");
        Spinnerlist.add("AHS");
        Spinnerlist.add("KMS");
        Spinnerlist.add("Volkschule");



        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, Spinnerlist);
        spSchultyp.setAdapter(adapter1);
        spSchultyp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int pos = spSchultyp.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        Schulttyp = "HTL";
                        break;
                    case 1:
                        Schulttyp = "AHS";
                        break;
                    case 2:
                        Schulttyp = "KMS";
                        break;
                    case 3:
                        Schulttyp = "Volkschule";
                        break;
                    case 4:
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, Spinnerlist2);
        spSchulstufe.setAdapter(adapter2);
        spSchulstufe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int pos = spSchulstufe.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        Schulstufe = 1;
                        break;
                    case 1:
                        Schulstufe = 2;
                        break;
                    case 2:
                        Schulstufe = 3;
                        break;
                    case 3:
                        Schulstufe = 4;
                        break;
                    case 4:
                        Schulstufe = 5;
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


        switch (v.getId()) {
            case R.id.btn_register:
                etVorname = (EditText) v.findViewById(R.id.et_vorname);
                etNachname = (EditText) v.findViewById(R.id.et_nachname);
                etDatum = (EditText) v.findViewById(R.id.et_nachname);
                etAdresse = (EditText) v.findViewById(R.id.et_nachname);
                etPLZ = (EditText) v.findViewById(R.id.et_nachname);
                etOrt = (EditText) v.findViewById(R.id.et_nachname);
                etEmail = (EditText) v.findViewById(R.id.et_nachname);
                etTelefon = (EditText) v.findViewById(R.id.et_nachname);
                etVornameErz = (EditText) v.findViewById(R.id.et_nachname);
                etNachnameErz = (EditText) v.findViewById(R.id.et_nachname);
                etPW = (EditText) v.findViewById(R.id.et_nachname);
                rbGenderM = (RadioButton) v.findViewById(R.id.radioM);
                rbGenderW = (RadioButton) v.findViewById(R.id.radioW);


                if ( rbGenderM.isChecked() == true)
                {
                    Gender = true;
                }
                else if ( rbGenderW.isChecked() == true )
                {
                    Gender = false;
                }



                Schueler s1 = new Schueler(etDatum.getText().toString(), etVorname.getText().toString(), etNachname.getText().toString(),
                        Gender, etAdresse.getText().toString(), Integer.parseInt(etPLZ.getText().toString()), etOrt.getText().toString(),
                        etEmail.getText().toString(), Integer.parseInt(etTelefon.getText().toString()), Schulttyp, Schulstufe ,etPW.getText().toString());
                break;


        }
    }
}
