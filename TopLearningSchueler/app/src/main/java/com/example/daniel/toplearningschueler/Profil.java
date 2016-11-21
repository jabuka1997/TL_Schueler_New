package com.example.daniel.toplearningschueler;


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
public class Profil extends Fragment {


    Button btnProfilv;

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

        btnProfilv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profil_verwalten p1 = new Profil_verwalten();
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft1.replace(R.id.fragment_container, p1).addToBackStack( "tag" ).commit();
            }
        });


        return view;


    }

}
