package com.example.daniel.toplearningschueler;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profil extends Fragment {


    Button btnProfilv;
    String vorname, nachname, gebdat, strasse, plz, ort, telefon, email, schultyp, schulstufe, evorname, enachname, schuelerverh, userpassword;
    TextView tvVorname, tvNachname, tvGB, tvAdresse,  tvPLZ, tvOrt, tvTelefon, tvEmail, tvSchultyp, tvSchulstufe, tvEVorname, tvENachname, tvVerhältnis;

    int ID;
    public Profil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        getActivity().setTitle("Profil");

        btnProfilv = (Button) view.findViewById(R.id.btn_pv);

        tvVorname = (TextView) view.findViewById(R.id.tv_vorname);
        tvNachname = (TextView) view.findViewById(R.id.tv_nachname);
        tvGB = (TextView) view.findViewById(R.id.tv_birthday);
        tvAdresse = (TextView) view.findViewById(R.id.tv_adresse);
        tvPLZ = (TextView) view.findViewById(R.id.tv_plz);
        tvOrt = (TextView) view.findViewById(R.id.tv_ort);
        tvTelefon = (TextView) view.findViewById(R.id.tv_telefon);
        tvEmail = (TextView) view.findViewById(R.id.tv_email);
        tvSchultyp = (TextView) view.findViewById(R.id.tv_schultyp);
        tvSchulstufe = (TextView) view.findViewById(R.id.tv_schulstufe);
        tvEVorname = (TextView) view.findViewById(R.id.tv_eVorname);
        tvENachname = (TextView) view.findViewById(R.id.tv_eNachname);
        tvVerhältnis = (TextView) view.findViewById(R.id.tv_verhältnis);


        Bundle b = getArguments();
        ID = b.getInt("ID");
        email =  b.getString("Email");
        vorname = b.getString("Vorname");                               //31.01.2017
        nachname = b.getString("Nachname");                             //31.01.2017
        gebdat = b.getString("Geburtsdatum");                           //31.01.2017
        strasse = b.getString("Strasse");                               //31.01.2017
        plz = b.getString("Plz");                                        //31.01.2017
        ort = b.getString("Ort");                                       //31.01.2017
        telefon = b.getString("Telefon");                               //31.01.2017
        schultyp  = b.getString("Schultyp");                             //31.01.2017
        schulstufe = b.getString("Schulstufe");                         //31.01.2017
        evorname = b.getString("EVorname");                             //31.01.2017
        enachname = b.getString("ENachname");                           //31.01.2017
        schuelerverh = b.getString("Schuelerverhaeltnis");              //31.01.2017
        userpassword = b.getString("Password");


        tvVorname.setText(vorname);
        tvNachname.setText(nachname);
        tvGB.setText(gebdat);
        tvAdresse.setText(strasse);
        tvPLZ.setText(plz);
        tvOrt.setText(ort);
        tvTelefon.setText(telefon);
        tvEmail.setText(email);
        tvSchultyp.setText(schultyp);
        tvSchulstufe.setText(schulstufe);
        tvEVorname.setText(evorname);
        tvENachname.setText(enachname);
        tvVerhältnis.setText(schuelerverh);


        btnProfilv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profil_verwalten p1 = new Profil_verwalten();
                Bundle b1 = new Bundle();
                b1.putInt("ID", ID);
                b1.putString("Vorname", vorname);
                b1.putString("Nachname", nachname);
                b1.putString("Geburtsdatum", gebdat);
                b1.putString("Strasse", strasse);
                b1.putString("Plz", plz);
                b1.putString("Ort", ort);
                b1.putString("Telefon", telefon);
                b1.putString("Email", email);
                b1.putString("Schultyp", schultyp);
                b1.putString("Schulstufe", schulstufe);
                b1.putString("EVorname", evorname);
                b1.putString("ENachname", enachname);
                b1.putString("Schuelerverhaeltnis", schuelerverh);
                b1.putString("Password", userpassword);
                p1.setArguments(b1);
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft1.replace(R.id.fragment_container, p1).addToBackStack("tag").commit();





            }
        });


        return view;


    }

}
