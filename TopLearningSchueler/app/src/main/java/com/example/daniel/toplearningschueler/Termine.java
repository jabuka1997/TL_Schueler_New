package com.example.daniel.toplearningschueler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    View v;

    public Termine() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_termine, container, false);
        getActivity().setTitle("Meine Termine");
        final ArrayList<Termin>[] filteredList = new ArrayList[]{new ArrayList<Termin>()};
        v = view;
        final Spinner sinner = (Spinner) view.findViewById(R.id.sp_schultyp);


        Bundle b = getArguments();
        int ID = b.getInt("ID");
        getTermine(String.valueOf(ID));


        Spinnerlist.add("Datum Neu --> Alt");
        Spinnerlist.add("Datum Alt --> Neu");
        Spinnerlist.add("Fach A --> Z");
        Spinnerlist.add("Fach Z --> A");
        Spinnerlist.add("Lehrer A --> Z");
        Spinnerlist.add("Lehrer Z --> A");


        inputSearch = (EditText) view.findViewById(R.id.inputSearch);


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
    private void SetADApt()
    {
        adapter = new MyListAdapter(Terminliste);
        mylist = (ListView) v.findViewById(R.id.list_view);
        mylist.setAdapter(adapter);
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
            textView1.setText(currentTermin.getDatum());

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
                found=false;
            }
            catch (Exception e) {
                continue;
            }
        }
        return filteredlist;
    }
    private void getTermine(final String benutzerid)
    {
        StringRequest strReg = new StringRequest(Request.Method.POST, Config.URLGETTERMINE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if (!response.equals("true"))
                    {
                        JSONObject jObj = new JSONObject(response);
                        JSONArray jArr = jObj.getJSONArray("result");
                        for (int i = 0; i < jArr.length(); i++)
                        {
                            JSONObject jObg1 = new JSONObject(jArr.getString(i));
                            String Vorname = jObg1.getString("Vorname");
                            String Nachname = jObg1.getString("Nachname");
                            String Fach = jObg1.getString("Bezeichnung");
                            String Datum = jObg1.getString("Datum_Uhrzeit");
                            Terminliste.add(new Termin(Datum, Fach, new Lehrer(Vorname, Nachname)));
                        }
                        SetADApt();
                    }
                    else
                    {
                        Toast.makeText(v.getContext(), "Sie haben derzeit noch keine Termine!", Toast.LENGTH_LONG).show();
                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(v.getContext(), error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("BenutzerID", benutzerid);


                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
        requestQueue.add(strReg);
    }
}
