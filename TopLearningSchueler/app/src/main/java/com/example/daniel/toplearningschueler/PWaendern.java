package com.example.daniel.toplearningschueler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class PWaendern extends Fragment implements View.OnClickListener{


    int ID;
    String userpassword, neuesPW;

    EditText etaltpw, etneupw, etneupw2;

    Button btnPWändern;

    View v;
    public PWaendern() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pwaendern, container, false);

        v = view;
        btnPWändern = (Button) view.findViewById(R.id.btn_spw);
        etaltpw = (EditText) view.findViewById(R.id.et_altpw);
        etneupw = (EditText) view.findViewById(R.id.et_neupw);
        etneupw2 = (EditText) view.findViewById(R.id.et_neupw2);



        btnPWändern.setOnClickListener(this);

        Bundle b = getArguments();
        ID = b.getInt("ID");
        userpassword = b.getString("Password");

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_spw:
                if (!etaltpw.getText().toString().trim().isEmpty() &&
                        !etneupw.getText().toString().trim().isEmpty() &&
                            !etneupw2.getText().toString().trim().isEmpty() ){
                    if (etaltpw.getText().toString().trim().equals(userpassword))
                    {
                        if (etneupw.getText().toString().trim().equals(etneupw2.getText().toString().trim()))
                        {
                            neuesPW = etneupw.getText().toString().trim();
                            changePW(String.valueOf(ID), neuesPW);
                        }
                        else
                        {
                            Toast.makeText(getActivity().getApplicationContext(), "Die Passwörter stimmen nicht überein!", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Das alte Passwort muss mit ihrem übereinstimmen!", Toast.LENGTH_LONG).show();
                    }


                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Sie müssen alle Felder ausfüllen!", Toast.LENGTH_LONG).show();
                }

                break;
        }
    }

    private void changePW(final String id, final String newuserpassword)
    {
        StringRequest strReg = new StringRequest(Request.Method.POST, Config.URLPWCHANGE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    if (!error) {
                        Toast.makeText(v.getContext(), "Passwort erfolgreich geändert!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getView().getContext(), Start_Fenster.class);
                        i.putExtra("ID", id);
                        i.putExtra("Password", newuserpassword);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);


                    }
                    else{
                        String errormessage = jObj.getString("error_msg");

                        Toast.makeText(v.getContext(), errormessage, Toast.LENGTH_LONG).show();
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();


            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("BenutzerID", id);
                params.put("Password", newuserpassword);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(strReg);
    }
}
