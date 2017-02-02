package com.example.daniel.toplearningschueler;


import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
    String GBDatum, Vorname, Nachname, Gender, Adresse, PLZ, Ort, Email, Telefon, schultyp, schulstufe, Passwort, VornameErz, NachnameErz, verhältnis;
    int h, sb;

    View v;
    public Registrieren() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registrieren, container, false);
        getActivity().setTitle("Registrieren");

        v = view;
        spSchultyp = (Spinner) view.findViewById(R.id.sp_schultyp);
        spSchulstufe = (Spinner) view.findViewById(R.id.sp_schulstufe);
        spVerhältnis = (Spinner) view.findViewById(R.id.sp_verhältnis);

        sb = 0;

        etVorname = (EditText) view.findViewById(R.id.et_vorname);
        etNachname = (EditText) view.findViewById(R.id.et_nachname);
        etDatum = (EditText) view.findViewById(R.id.et_birthday);
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


        etDatum.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                DialogFragment newFragment = new DatePickerFragment();
                Bundle b = new Bundle();
                b.putInt("SB", sb);
                newFragment.setArguments(b);
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });


        Spinnerlist3.add("");
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

                    String pos = (String)spSchultyp.getItemAtPosition(i);

                    Schulttyp = pos;

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

                    pos = spSchulstufe.getItemIdAtPosition(i);
                    pos++;
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
                String pos = (String)spVerhältnis.getItemAtPosition(i);
                Verhältnis = pos;

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
                if (isEmailValid(etEmail.getText().toString().trim())) {
                    if (rbAGB.isChecked()) {
                        if (!etDatum.getText().toString().isEmpty()) {


                            if (rbGenderM.isChecked()) {
                                isGender = "m";
                            } else if (rbGenderW.isChecked()) {
                                isGender = "w";
                            }



                            if (isUserOver18()) {
                                if (!etDatum.getText().toString().isEmpty() && !etVorname.getText().toString().isEmpty() &&
                                        !etNachname.getText().toString().isEmpty() && !etAdresse.getText().toString().isEmpty() &&
                                        !etPLZ.getText().toString().isEmpty() && !etOrt.getText().toString().isEmpty() &&
                                        !etEmail.getText().toString().isEmpty() && !etTelefon.getText().toString().isEmpty() && !Schulttyp.isEmpty() &&
                                        !Schulstufe.isEmpty() && !etPW.getText().toString().isEmpty()) {

                                    GBDatum = etDatum.getText().toString().trim();
                                    Vorname = etVorname.getText().toString().trim();
                                    Nachname = etNachname.getText().toString().trim();
                                    Gender = isGender;
                                    Adresse = etAdresse.getText().toString().trim();
                                    PLZ = etPLZ.getText().toString().trim();
                                    Ort = etOrt.getText().toString().trim();
                                    Email = etEmail.getText().toString().trim();

                                    Telefon = etTelefon.getText().toString().trim();

                                    schultyp = Schulttyp;
                                    schulstufe = Schulstufe;
                                    Passwort = etPW.getText().toString().trim();

                                    registerUser(GBDatum, Vorname, Nachname, Gender, Adresse, PLZ, Ort, Email, Telefon, schultyp, schulstufe, Passwort, "", "", "");
                                } else {
                                    Toast.makeText(getActivity().getApplicationContext(), "Sie müssen alle Felder ausfüllen!", Toast.LENGTH_LONG).show();
                                }
                            } else if (!etDatum.getText().toString().isEmpty() && !etVorname.getText().toString().isEmpty() &&
                                    !etNachname.getText().toString().isEmpty() && !etAdresse.getText().toString().isEmpty() &&
                                    !etPLZ.getText().toString().isEmpty() && !etOrt.getText().toString().isEmpty() &&
                                    !etEmail.getText().toString().isEmpty() && !etTelefon.getText().toString().isEmpty() && !Schulttyp.isEmpty() &&
                                    !Schulstufe.isEmpty() && !etPW.getText().toString().isEmpty() && !etVornameErz.getText().toString().isEmpty() &&
                                    !etNachnameErz.getText().toString().isEmpty() && !Verhältnis.isEmpty()) {

                                GBDatum = etDatum.getText().toString().trim();
                                Vorname = etVorname.getText().toString().trim();
                                Nachname = etNachname.getText().toString().trim();
                                Gender = isGender;
                                Adresse = etAdresse.getText().toString().trim();
                                PLZ = etPLZ.getText().toString().trim();
                                Ort = etOrt.getText().toString().trim();
                                Email = etEmail.getText().toString().trim();

                                Telefon = etTelefon.getText().toString().trim();

                                schultyp = Schulttyp;
                                schulstufe = Schulstufe;
                                Passwort = etPW.getText().toString().trim();
                                VornameErz = etVornameErz.getText().toString().trim();
                                NachnameErz = etNachnameErz.getText().toString().trim();
                                verhältnis = Verhältnis;

                                registerUser(GBDatum, Vorname, Nachname, Gender, Adresse, PLZ, Ort, Email, Telefon, schultyp, schulstufe, Passwort, VornameErz, NachnameErz, verhältnis);
                            } else {
                                Toast.makeText(getActivity().getApplicationContext(), "Sie müssen alle Felder ausfüllen!", Toast.LENGTH_LONG).show();
                            }
                        }
                        else {

                            Toast.makeText(getActivity().getApplicationContext(), "Sie müssen ein Geburtsdatum angeben!", Toast.LENGTH_LONG).show();

                        }


                    }
                    else {
                        Toast.makeText(getActivity().getApplicationContext(), "Sie müssen die AGBs aktzeptieren!", Toast.LENGTH_LONG).show();
                    }


                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Geben Sie eine gültige Email Adresse ein!", Toast.LENGTH_LONG).show();
                }
                break;
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
                        Intent i = new Intent(getActivity().getApplicationContext(), Start_Fenster.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                    else{
                        String errormessage = jObj.getString("error_msg");

                        Toast.makeText(v.getContext(), errormessage, Toast.LENGTH_LONG).show();
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(v.getContext(), error.getMessage(), Toast.LENGTH_LONG).show();


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
                params.put("Schultyp", schulttyp);
                params.put("Schulstufe", schulstufe);
                params.put("Passwort", passwort);
                params.put("VornameErz", vornameerz);
                params.put("NachnameErz", nachnameerz);
                params.put("Verhaeltnis", verhältnis);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
        requestQueue.add(strReg);
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    boolean isUserOver18(){
        String datum = etDatum.getText().toString().trim();
        String[] yeartime = datum.split("\\.");
        int day = Integer.parseInt(yeartime[0]);
        int month = Integer.parseInt(yeartime[1]);
        int year = Integer.parseInt(yeartime[2]);

        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        int currentmonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentday = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        h = currentyear - year;

        if (h >= 18 && month <= (currentmonth + 1))
        {
            if (month == (currentmonth + 1))
            {
                if (day <= currentday)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return true;
            }

        }
        else
        {
            return false;
        }

    }
}
