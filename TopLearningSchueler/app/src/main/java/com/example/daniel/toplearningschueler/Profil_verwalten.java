package com.example.daniel.toplearningschueler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profil_verwalten extends Fragment implements View.OnClickListener{


    String vorname, nachname, gebdat, strasse, plz, ort, telefon, email, schultyp, schulstufe, evorname, enachname, schuelerverh, userpassword;

    EditText etVorname, etNachname, etGB, etAdresse,  etPLZ, etOrt, etTelefon, etEmail, etSchultyp, etSchulstufe, etEVorname, etENachname, etVerhältnis;

    Button btnspeichern, btnpwändern;
    int ID;

    View v;
    public Profil_verwalten() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setTitle("Profil verwalten");

        View view = inflater.inflate(R.layout.fragment_profil_verwalten, container, false);

        v = view;
        btnspeichern = (Button) view.findViewById(R.id.btn_speichern);
        btnpwändern = (Button) view.findViewById(R.id.btn_pwändern);

        btnspeichern.setOnClickListener(this);
        btnpwändern.setOnClickListener(this);

        etVorname = (EditText) view.findViewById(R.id.et_vorname);
        etNachname = (EditText) view.findViewById(R.id.et_nachname);
        etGB = (EditText) view.findViewById(R.id.et_birthday);
        etAdresse = (EditText) view.findViewById(R.id.et_adresse);
        etPLZ = (EditText) view.findViewById(R.id.et_plz);
        etOrt = (EditText) view.findViewById(R.id.et_ort);
        etTelefon = (EditText) view.findViewById(R.id.et_telefon);
        etEmail = (EditText) view.findViewById(R.id.et_email);
        etSchultyp = (EditText) view.findViewById(R.id.et_schultyp);
        etSchulstufe = (EditText) view.findViewById(R.id.et_schulstufe);
        etEVorname = (EditText) view.findViewById(R.id.et_eVorname);
        etENachname = (EditText) view.findViewById(R.id.et_eNachname);
        etVerhältnis = (EditText) view.findViewById(R.id.et_verhältnis);


        Bundle b = getArguments();
        ID = b.getInt("ID");
        email =  b.getString("Email");
        vorname = b.getString("Vorname");
        nachname = b.getString("Nachname");
        gebdat = b.getString("Geburtsdatum");
        strasse = b.getString("Strasse");
        plz = b.getString("Plz");
        ort = b.getString("Ort");
        telefon = b.getString("Telefon");
        schultyp  = b.getString("Schultyp");
        schulstufe = b.getString("Schulstufe");
        evorname = b.getString("EVorname");
        enachname = b.getString("ENachname");
        schuelerverh = b.getString("Schuelerverhaeltnis");
        userpassword = b.getString("Password");





        etVorname.setText(vorname);
        etNachname.setText(nachname);
        etGB.setText(gebdat);
        etAdresse.setText(strasse);
        etPLZ.setText(plz);
        etOrt.setText(ort);
        etTelefon.setText(telefon);
        etEmail.setText(email);
        etSchultyp.setText(schultyp);
        etSchulstufe.setText(schulstufe);
        etEVorname.setText(evorname);
        etENachname.setText(enachname);
        etVerhältnis.setText(schuelerverh);

        if (isUserOver18())
        {
            etEVorname.setEnabled(false);
            etENachname.setEnabled(false);
            etVerhältnis.setEnabled(false);
        }
        else
        {
            etEVorname.setEnabled(true);
            etENachname.setEnabled(true);
            etVerhältnis.setEnabled(true);
        }


        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_speichern:
                if (isUserOver18())
                {
                    etEVorname.setEnabled(false);
                    etENachname.setEnabled(false);
                    etVerhältnis.setEnabled(false);
                    if (!etGB.getText().toString().trim().isEmpty() && !etVorname.getText().toString().trim().isEmpty() &&
                        !etNachname.getText().toString().trim().isEmpty() && !etAdresse.getText().toString().trim().isEmpty() &&
                        !etPLZ.getText().toString().trim().isEmpty() && !etOrt.getText().toString().trim().isEmpty() &&
                        !etEmail.getText().toString().trim().isEmpty() && !etTelefon.getText().toString().trim().isEmpty() && !etSchultyp.getText().toString().trim().isEmpty() &&
                        !etSchulstufe.getText().toString().trim().isEmpty())
                {
                    email =  etEmail.getText().toString().trim();
                    vorname = etVorname.getText().toString().trim();
                    nachname = etNachname.getText().toString().trim();
                    gebdat = etGB.getText().toString().trim();
                    strasse = etAdresse.getText().toString().trim();
                    plz = etPLZ.getText().toString().trim();
                    ort = etOrt.getText().toString().trim();
                    telefon = etTelefon.getText().toString().trim();
                    schultyp  = etSchultyp.getText().toString().trim();
                    schulstufe = etSchulstufe.getText().toString().trim();

                    changeData(String.valueOf(ID) ,vorname, nachname, strasse, gebdat, plz, ort, email, telefon, schultyp, schulstufe, "", "", "");

                }
                    else
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Die Felder müssen alle gefüllt sein!", Toast.LENGTH_LONG).show();
                    }
                }

                else if (!etGB.getText().toString().trim().isEmpty() && !etVorname.getText().toString().trim().isEmpty() &&
                        !etNachname.getText().toString().trim().isEmpty() && !etAdresse.getText().toString().trim().isEmpty() &&
                        !etPLZ.getText().toString().trim().isEmpty() && !etOrt.getText().toString().trim().isEmpty() &&
                        !etEmail.getText().toString().trim().isEmpty() && !etTelefon.getText().toString().trim().isEmpty() && !etSchultyp.getText().toString().trim().isEmpty() &&
                        !etSchulstufe.getText().toString().trim().isEmpty() && !etEVorname.getText().toString().trim().isEmpty() &&
                        !etENachname.getText().toString().trim().isEmpty() && !etVerhältnis.getText().toString().trim().isEmpty())
                {
                    etVorname.setEnabled(true);
                    etNachname.setEnabled(true);
                    etVerhältnis.setEnabled(true);
                    email =  etEmail.getText().toString().trim();
                    vorname = etVorname.getText().toString().trim();
                    nachname = etNachname.getText().toString().trim();
                    gebdat = etGB.getText().toString().trim();
                    strasse = etAdresse.getText().toString().trim();
                    plz = etPLZ.getText().toString().trim();
                    ort = etOrt.getText().toString().trim();
                    telefon = etTelefon.getText().toString().trim();
                    schultyp  = etSchultyp.getText().toString().trim();
                    schulstufe = etSchulstufe.getText().toString().trim();
                    evorname = etEVorname.getText().toString().trim();
                    enachname = etNachname.getText().toString().trim();
                    schuelerverh = etVerhältnis.getText().toString().trim();


                    changeData(String.valueOf(ID) ,vorname, nachname, strasse, gebdat, plz, ort, email, telefon, schultyp, schulstufe, evorname, enachname, schuelerverh);

                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Die Felder müssen alle gefüllt sein!", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_pwändern:

                break;
        }
    }


    private void changeData(final String id, final String vorname, final String nachname, final String adresse, final String gbdatum,
                              final String plz, final String ort, final String email, final String telefon, final String schultyp, final String schulstufe,
                            final String vornameerz, final String nachnameerz, final String verhältnis)
    {
        StringRequest strReg = new StringRequest(Request.Method.POST, Config.URLPROFILCHANGE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    if (!error)
                    {
                        Toast.makeText(v.getContext(), "Profil erfolgreich geändert!", Toast.LENGTH_LONG).show();
                        Profil p1 = new Profil();
                        Bundle b1 = new Bundle();
                        b1.putInt("ID", ID);
                        b1.putString("Vorname", vorname);
                        b1.putString("Nachname", nachname);
                        b1.putString("Geburtsdatum", gbdatum);
                        b1.putString("Strasse", adresse);
                        b1.putString("Plz", plz);
                        b1.putString("Ort", ort);
                        b1.putString("Telefon", telefon);
                        b1.putString("Email", email);
                        b1.putString("Schultyp", schultyp);
                        b1.putString("Schulstufe", schulstufe);
                        b1.putString("EVorname", vornameerz);
                        b1.putString("ENachname", nachnameerz);
                        b1.putString("Schuelerverhaeltnis", verhältnis);
                        b1.putString("Password", userpassword);
                        p1.setArguments(b1);
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                        ft.replace(R.id.fragment_container, p1).addToBackStack("tag").commit();


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
                Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();


            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("BenutzerID", id);
                params.put("Vorname", vorname);
                params.put("Nachname", nachname);
                params.put("Geburtsdatum", gbdatum);
                params.put("Strasse", adresse);
                params.put("Plz", plz);
                params.put("Ort", ort);
                params.put("Email", email);
                params.put("Telefon", telefon);
                params.put("Schultyp", schultyp);
                params.put("Schulstufe", schulstufe);
                params.put("EVorname", vornameerz);
                params.put("ENachname", nachnameerz);
                params.put("Verhaeltnis", verhältnis);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(strReg);
    }



    boolean isUserOver18(){
        String datum = etGB.getText().toString().trim();
        String[] yeartime = datum.split("\\.");
        int day = Integer.parseInt(yeartime[0]);
        int month = Integer.parseInt(yeartime[1]);
        int year = Integer.parseInt(yeartime[2]);

        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        int currentmonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentday = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int h = currentyear - year;

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
