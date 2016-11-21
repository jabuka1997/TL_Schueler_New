package com.example.daniel.toplearningschueler;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profil_verwalten extends Fragment {


    public Profil_verwalten() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setTitle("Profil verwalten");

        return inflater.inflate(R.layout.fragment_profil_verwalten, container, false);
    }

}
