package com.example.daniel.toplearningschueler;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PWvergessen extends Fragment implements View.OnClickListener {

    EditText etemail;
    Button btnPW;
    public PWvergessen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pwvergessen, container, false);

        etemail = (EditText) view.findViewById(R.id.et_email);
        btnPW = (Button) view.findViewById(R.id.btn_pwvergessen);

        btnPW.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pwvergessen:
                if (!etemail.getText().toString().trim().isEmpty()){

                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Geben sie eine Email Adresse ein!", Toast.LENGTH_LONG).show();
                }



                break;
        }
    }
}
