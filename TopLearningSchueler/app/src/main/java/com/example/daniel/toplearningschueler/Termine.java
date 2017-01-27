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
    private ArrayList<Termin> Terminliste = new ArrayList<Termin>();
    private List<String> Spinnerlist = new ArrayList<String>();
    private List<Termin> Terminlistenew = new ArrayList<Termin>();
    private List<Termin> Leereliste = new ArrayList<Termin>();




    ArrayAdapter<Termin> adapter;
    ListView mylist;



    // Search EditText
    EditText inputSearch;

    public Termine() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_termine, container, false);;
        getActivity().setTitle("Meine Termine");
        final ArrayList<Termin>[] filteredList = new ArrayList[]{new ArrayList<Termin>()};

        final Spinner sinner = (Spinner) view.findViewById(R.id.sp_schultyp);

        Terminliste.add(new Termin("12.12.2016", "10:00", "Deutsch", new Lehrer("Hans", "Güntha")));
        Terminliste.add(new Termin("12.12.2016", "16:00", "Englisch", new Lehrer("Jürgen", "Aldea")));
        Terminliste.add(new Termin("13.12.2016", "09:00", "Mathematik", new Lehrer("Peter", "Schmidt")));
        Terminliste.add(new Termin("13.12.2016", "08:30", "Physik", new Lehrer("Tom", "Baric")));
        //Terminliste.add(new Termin("14.12.2016", "20:00", "Physik", new Lehrer("Tim", "Müller")));
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


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Spinnerlist);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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
                        adapter = new MyListAdapter(Leereliste);
                        mylist.setAdapter(adapter);
                        Fachaz();
                        adapter = new MyListAdapter(Terminlistenew);
                        mylist.setAdapter(adapter);
                        break;
                    case 3:
                        adapter = new MyListAdapter(Leereliste);
                        mylist.setAdapter(adapter);
                        Fachza();
                        adapter = new MyListAdapter(Terminlistenew);
                        mylist.setAdapter(adapter);
                        break;
                    case 4:
                        adapter = new MyListAdapter(Leereliste);
                        mylist.setAdapter(adapter);
                        Lehreraz();
                        adapter = new MyListAdapter(Terminlistenew);
                        mylist.setAdapter(adapter);
                        break;
                    case 5:
                        adapter = new MyListAdapter(Leereliste);
                        mylist.setAdapter(adapter);
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
            String keyword;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                keyword=inputSearch.getText().toString().trim();
                filteredList[0] = filterTerminList(Terminliste, keyword);
                mylist.setAdapter(null);
                adapter = new MyListAdapter(filteredList[0]);
                mylist.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void Fachaz() {
        Terminlistenew.clear();
        List<String> fachlist  = new ArrayList<String>();
        String lis;
        for (Termin item : Terminliste)
        {
            lis = item.getFach();
            fachlist.add(lis);
        }
        Collections.sort(fachlist);
        for (String item : fachlist)
        {
            for (Termin item1 : Terminliste)
            {
                lis = item1.getFach();
                String a1 = item.toString(), a2 = lis.toString();
                if (a1.equals(a2))
                {
                    Terminlistenew.add(item1);
                }
            }
        }
    }
    private void Fachza() {
        Terminlistenew.clear();
        List<String> fachlist  = new ArrayList<String>();
        String lis;
        for (Termin item : Terminliste)
        {
            lis = item.getFach();
            fachlist.add(lis);
        }
        Collections.sort(fachlist, Collections.reverseOrder());
        for (String item : fachlist)
        {
            for (Termin item1 : Terminliste)
            {
                lis = item1.getFach();
                String a1 = item.toString(), a2 = lis.toString();
                if (a1.equals(a2))
                {
                    Terminlistenew.add(item1);
                }
            }
        }
    }
    private void Lehreraz() {
        Terminlistenew.clear();
        List<String> lehrerlist  = new ArrayList<String>();
        String[] lis, list;
        for (Termin item : Terminliste)
        {
            lis = item.getMeinLehrer().split(" ");
            lehrerlist.add(lis[1]);
        }
        Collections.sort(lehrerlist);
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
    private void Lehrerza() {
        Terminlistenew.clear();
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
        private List<Termin> Aktliste;
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

    public static ArrayList<Termin> filterTerminList(ArrayList<Termin> terminList, String keyw)
    {
        ArrayList<Termin> filteredlist = new ArrayList<Termin>();
        Boolean found = false;
        for (Termin t:terminList) {
            try{
                if(t.getMeinLehrer().contains(keyw)&&found==false){
                    filteredlist.add(t);
                    found=true;
                }
                if(t.getFach().contains(keyw)&&found==false){
                    filteredlist.add(t);
                    found=true;
                }
                if(t.getDatum().contains(keyw)&&found==false){
                    filteredlist.add(t);
                    found=true;
                }
                if(t.getUhrzeit().contains(keyw)&&found==false){
                    filteredlist.add(t);
                    found=true;
                }
                found=false;
            }
            catch (Exception e) {
                continue;
            }
        }
        return filteredlist;
    }

}
