package com.example.daniel.toplearningschueler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login_Schueler extends Fragment implements View.OnClickListener {


    Button btnlogin, btnpwvergessen, btnregister;


    public Login_Schueler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login__schueler, container, false);

        btnlogin = (Button) view.findViewById(R.id.btn_login);
        btnregister = (Button) view.findViewById(R.id.btn_register);
        btnpwvergessen = (Button) view.findViewById(R.id.btn_pwvergessen);

        btnlogin.setOnClickListener(this);
        btnregister.setOnClickListener(this);
        btnpwvergessen.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                Intent i = new Intent(getView().getContext(), Nav_Drawer_list.class);
                startActivity(i);
                break;
            case R.id.btn_register:
                Registrieren r1 = new Registrieren();
                FragmentTransaction f1 = getFragmentManager().beginTransaction();
                f1.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                f1.replace(R.id.activity_start_fenster, r1).addToBackStack("tag").commit();
                break;
            case R.id.btn_pwvergessen:

                break;

        }
    }
}
