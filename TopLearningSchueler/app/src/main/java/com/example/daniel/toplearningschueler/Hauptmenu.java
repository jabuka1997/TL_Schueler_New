package com.example.daniel.toplearningschueler;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Hauptmenu extends Fragment implements View.OnClickListener{

    private Button mStundeBuchen;
    private Button mTermine;
    int ID=0;
    public Hauptmenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hauptmenu, container, false);
        // Inflate the layout for this fragment
        mStundeBuchen = (Button) view.findViewById(R.id.btn_stunde);
        mTermine = (Button) view.findViewById(R.id.btn_termine);

        getActivity().setTitle("Top Learning+");
        ID = getArguments().getInt("ID");


        mStundeBuchen.setOnClickListener(this);
        mTermine.setOnClickListener(this);
        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_stunde:
                Stunde_Buchen f1 = new Stunde_Buchen();
                Bundle b = new Bundle();
                b.putInt("ID", ID);
                f1.setArguments(b);
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft1.replace(R.id.fragment_container, f1).addToBackStack( "tag" ).commit();

                break;

            case R.id.btn_termine:
                Termine f2 = new Termine();
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft2.replace(R.id.fragment_container, f2).addToBackStack( "tag" ).commit();

                break;

        }
    }
    

}
