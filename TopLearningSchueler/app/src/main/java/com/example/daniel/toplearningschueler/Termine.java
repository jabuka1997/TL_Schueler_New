package com.example.daniel.toplearningschueler;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Termine extends Fragment {
    // List view
    private List<Termin> Terminliste = new ArrayList<Termin>();
    private List<String> Spinnerlist = new ArrayList<String>();
    private List<Termin> Terminlistenew = new ArrayList<Termin>();
    ArrayAdapter<Termin> adapter;
    ListView mylist;



    // Search EditText
    EditText inputSearch;

    public Termine() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_termine, container, false);;
        getActivity().setTitle("Meine Termine");


        Terminliste.add(new Termin("12.12.2016", "10:00", "Deutsch", new Lehrer("Hans", "Güntha")));
        Terminliste.add(new Termin("12.12.2016", "16:00", "Englisch", new Lehrer("Jürgen", "Aldea")));
        Terminliste.add(new Termin("13.12.2016", "09:00", "Mathematik", new Lehrer("Peter", "Schmidt")));
        Terminliste.add(new Termin("13.12.2016", "08:30", "Physik", new Lehrer("Tom", "Baric")));
        Terminliste.add(new Termin("14.12.2016", "20:00", "Physik", new Lehrer("Tim", "Müller")));
        Terminliste.add(new Termin("15.12.2016", "06:45", "Chemie", new Lehrer("Daniel", "Zald")));

        Spinnerlist.add("Datum Neu --> Alt");
        Spinnerlist.add("Datum Alt --> Neu");
        Spinnerlist.add("Fach A --> Z");
        Spinnerlist.add("Fach Z --> A");
        Spinnerlist.add("Lehrer A --> Z");
        Spinnerlist.add("Lehrer Z --> A");


        inputSearch = (EditText) view.findViewById(R.id.inputSearch);

        adapter = new MyListAdapter(Terminliste);
        mylist = (ListView) view.findViewById(R.id.list_view);
        mylist.setAdapter(adapter);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, Spinnerlist);
        final Spinner sinner = (Spinner) view.findViewById(R.id.sp_schultyp);
        sinner.setAdapter(adapter1);
        sinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int pos = sinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        Lehrerza();
                        adapter = new MyListAdapter(Terminlistenew);
                        mylist.setAdapter(adapter);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Termine.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    private void Lehrerza() {
        List<String> lehrerlist  = new ArrayList<String>();
        String[] lis, list;
        for (Termin item : Terminliste)
        {
            lis = item.getMeinLehrer().split(" ");
            lehrerlist.add(lis[1]);
        }
        Collections.sort(lehrerlist, Collections.reverseOrder());
        for (String item : lehrerlist)
        {
            for (Termin item1 : Terminliste)
            {
                list = item1.getMeinLehrer().split(" ");
                String a1 = item.toString(), a2 = list[1].toString();
                if (a1.equals(a2))
                {
                    Terminlistenew.add(item1);
                }
            }
        }
    }
    private class MyListAdapter extends ArrayAdapter<Termin>
    {
        List<Termin> Aktliste;
        public MyListAdapter(List<Termin> aktliste)
        {
            super(getActivity().getApplicationContext(), R.layout.terminlisteitems, aktliste);
            Aktliste = new ArrayList<Termin>(aktliste);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View layout = convertView;
            if (layout == null)
            {
                layout = getActivity().getLayoutInflater().inflate(R.layout.terminlisteitems, parent, false);
            }
            Termin currentTermin = Aktliste.get(position);

            TextView textView = (TextView)layout.findViewById(R.id.textView);
            textView.setText(currentTermin.getFach());

            TextView textView1 = (TextView)layout.findViewById(R.id.textView3);
            textView1.setText(currentTermin.getDatum() + " " + currentTermin.getUhrzeit());

            TextView textView3 = (TextView)layout.findViewById(R.id.textView2);
            textView3.setText(currentTermin.getMeinLehrer());
            return layout;
        }
    }

}
