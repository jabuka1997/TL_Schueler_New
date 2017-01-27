package com.example.daniel.toplearningschueler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
public class Login_Schueler extends Fragment implements View.OnClickListener {



    Button btnlogin, btnpwvergessen, btnregister;

    String sUsername, sPassword;
    EditText etemail, etpw;
    View v;

    public Login_Schueler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login__schueler, container, false);

        v = view;
        btnlogin = (Button) view.findViewById(R.id.btn_login);
        btnregister = (Button) view.findViewById(R.id.btn_register);
        btnpwvergessen = (Button) view.findViewById(R.id.btn_pwvergessen);
        etemail = (EditText) view.findViewById(R.id.et_email);
        etpw = (EditText) view.findViewById(R.id.et_passwort);


        btnlogin.setOnClickListener(this);
        btnregister.setOnClickListener(this);
        btnpwvergessen.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                if (!etemail.getText().toString().trim().isEmpty() && !etpw.getText().toString().trim().isEmpty()) {
                    sUsername = etemail.getText().toString().trim();
                    sPassword = etpw.getText().toString().trim();


                    loginUser(sUsername, sPassword);


                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Die Eingaben sind ungültig!", Toast.LENGTH_LONG).show();
                }
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

    private void loginUser(final String username, final String password)
    {
        StringRequest strReg = new StringRequest(Request.Method.POST, Config.URLLOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    int id = jObj.getInt("id");

                    if (!error)
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "User successfully logged in.", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getView().getContext(), Nav_Drawer_list.class);
                        i.putExtra("ID", id);
                        startActivity(i);

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
                params.put("Username", username);
                params.put("Password", password);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
        requestQueue.add(strReg);
    }
}