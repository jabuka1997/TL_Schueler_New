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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registrieren extends Fragment implements View.OnClickListener {

    private List<String> Spinnerlist = new ArrayList<String>();
    private List<String> Spinnerlist2 = new ArrayList<String>();
    private List<String> Spinnerlist3 = new ArrayList<String>();
    EditText etVorname, etNachname, etDatum, etAdresse, etPLZ, etOrt, etEmail, etTelefon, etVornameErz, etNachnameErz, etPW;
    RadioButton rbGenderM;
    RadioButton rbGenderW;
    RadioButton rbAGB;
    String isGender;
    Button btn_reg;
    Spinner spSchultyp, spSchulstufe, spVerhältnis;
    String Schulttyp;
    String Schulstufe;
    String Verhältnis;

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
        spVerhältnis = (Spinner) view.findViewById(R.id.sp_verhältnis);


        etVorname = (EditText) view.findViewById(R.id.et_vorname);
        etNachname = (EditText) view.findViewById(R.id.et_nachname);
        etDatum = (EditText) view.findViewById(R.id.et_date);
        etAdresse = (EditText) view.findViewById(R.id.et_address);
        etPLZ = (EditText) view.findViewById(R.id.et_plz);
        etOrt = (EditText) view.findViewById(R.id.et_ort);
        etEmail = (EditText) view.findViewById(R.id.et_email);
        etTelefon = (EditText) view.findViewById(R.id.et_telefon);
        etVornameErz = (EditText) view.findViewById(R.id.et_vornameerz);
        etNachnameErz = (EditText) view.findViewById(R.id.et_nachnameerz);
        etPW = (EditText) view.findViewById(R.id.et_pw);
        rbGenderM = (RadioButton) view.findViewById(R.id.radioM);
        rbGenderW = (RadioButton) view.findViewById(R.id.radioW);
        rbAGB = (RadioButton) view.findViewById(R.id.radioButton3);



        btn_reg = (Button) view.findViewById(R.id.btn_register);
        btn_reg.setOnClickListener(this);

        Spinnerlist3.add("Vater");
        Spinnerlist3.add("Mutter");


       for ( int i = 1 ; i <= 13; i++) {

           Spinnerlist2.add(Integer.toString(i));
       }


        Spinnerlist.add("HTL");
        Spinnerlist.add("AHS");
        Spinnerlist.add("KMS");
        Spinnerlist.add("Volkschule");
        Spinnerlist.add("HAK");
        Spinnerlist.add("HAS");
        Spinnerlist.add("BMS");
        Spinnerlist.add("BHS");
        Spinnerlist.add("BS");
        Spinnerlist.add("NMS");
        Spinnerlist.add("PS");




        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Spinnerlist);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spSchultyp.setAdapter(adapter1);

        spSchultyp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                    return;
                else {
                    String pos = (String)spSchultyp.getItemAtPosition(i);

                    Schulttyp = pos;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Spinnerlist2);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spSchulstufe.setAdapter(adapter2);

        spSchulstufe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                long pos;
                if (i == 0)
                    return;
               else {
                    pos = spSchulstufe.getItemIdAtPosition(i);
                    ++pos;
                }
                Schulstufe = Long.toString(pos);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Spinnerlist3);
        adapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spVerhältnis.setAdapter(adapter3);

        spVerhältnis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int pos = spVerhältnis.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        Verhältnis = "Vater";
                        break;
                    case 1:
                        Verhältnis = "Mutter";
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
                if (rbAGB.isChecked()) {
                    if (rbGenderM.isChecked()) {
                        isGender = "m";
                    } else if (rbGenderW.isChecked()) {
                        isGender = "w";
                    }
                    String GBDatum = etDatum.getText().toString().trim();
                    String Vorname = etVorname.getText().toString().trim();
                    String Nachname = etNachname.getText().toString().trim();
                    String Gender = isGender;
                    String Adresse = etAdresse.getText().toString().trim();
                    String PLZ = etPLZ.getText().toString().trim();
                    String Ort = etOrt.getText().toString().trim();
                    String Email = etEmail.getText().toString().trim();

                    String Telefon = etTelefon.getText().toString().trim();

                    String schultyp = Schulttyp;
                    String schulstufe = Schulstufe;
                    String Passwort = etPW.getText().toString().trim();
                    String VornameErz = etVornameErz.getText().toString().trim();
                    String NachnameErz = etNachnameErz.getText().toString().trim();
                    String verhältnis = Verhältnis;


                    if (!GBDatum.isEmpty() && !Vorname.isEmpty() &&
                            !Nachname.isEmpty() && !Adresse.isEmpty() &&
                            !PLZ.isEmpty() && !Ort.isEmpty() && !Email.isEmpty() && !Telefon.isEmpty() && !schultyp.isEmpty() &&
                            !schulstufe.isEmpty() && !Passwort.isEmpty() && !VornameErz.isEmpty() && !NachnameErz.isEmpty() && !verhältnis.isEmpty())
                    {


                    }
                    else
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Sie müssen alle Felder ausfüllen!", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Sie müssen die AGBs aktzeptieren!", Toast.LENGTH_LONG).show();
                }


        }
    }
    private void registerUser(final String gbdatum, final String vorname, final String nachname, final String gender, final String adresse,
                              final String plz, final String ort, final String email, final String telefon, final String schulttyp, final String schulstufe,
                              final String passwort, final String vornameerz, final String nachnameerz, final String verhältnis)
    {
        StringRequest strReg = new StringRequest(Request.Method.POST, Config.URLREGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    if (!error)
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "User successfully registered.", Toast.LENGTH_LONG).show();
                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("GBDatum", gbdatum);
                params.put("Vorname", vorname);
                params.put("Nachname", nachname);
                params.put("Gender", gender);
                params.put("Adresse", adresse);
                params.put("PLZ", plz);
                params.put("Ort", ort);
                params.put("Email", email);
                params.put("Telefon", telefon);
                params.put("schultyp", schulttyp);
                params.put("schulstufe", schulstufe);
                params.put("Passwort", passwort);
                params.put("VornameErz", vornameerz);
                params.put("NachnameErz", nachnameerz);
                params.put("Verhältnis", verhältnis);

                return params;




            }
        };

    }
}
