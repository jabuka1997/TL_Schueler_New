package com.example.daniel.toplearningschueler;


import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.os.EnvironmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registrieren extends Fragment implements View.OnClickListener {

    Button btn_reg;

    public Registrieren() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registrieren, container, false);
        getActivity().setTitle("Registrieren");

        btn_reg = (Button) view.findViewById(R.id.btn_register);
        btn_reg.setOnClickListener(this);


        return view;
    }



    @Override
    public void onClick(View v) {

    }
}
