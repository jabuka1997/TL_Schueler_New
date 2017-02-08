package com.example.daniel.toplearningschueler;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import java.nio.BufferUnderflowException;

public class Nav_Drawer_list extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView =  null;
    Toolbar toolbar = null;


    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__drawer_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        i = getIntent();

        Hauptmenu f1 = new Hauptmenu();
        Bundle b = new Bundle();
        b.putInt("ID", i.getIntExtra("ID", 0));
        b.putString("Vorname", i.getStringExtra("Vorname"));
        b.putString("Nachname", i.getStringExtra("Nachname"));
        b.putString("Geburtsdatum", i.getStringExtra("Geburtsdatum"));
        b.putString("Strasse", i.getStringExtra("Strasse"));
        b.putString("Plz", i.getStringExtra("Plz"));
        b.putString("Ort", i.getStringExtra("Ort"));
        b.putString("Telefon", i.getStringExtra("Telefon"));
        b.putString("Email", i.getStringExtra("Email"));
        b.putString("Schultyp", i.getStringExtra("Schultyp"));
        b.putString("Schulstufe", i.getStringExtra("Schulstufe"));
        b.putString("EVorname", i.getStringExtra("EVorname"));
        b.putString("ENachname", i.getStringExtra("ENachname"));
        b.putString("Schuelerverhaeltnis", i.getStringExtra("Schuelerverhaeltnis"));
        b.putString("Password", i.getStringExtra("Password"));
        f1.setArguments(b);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, f1);
        fragmentTransaction.commit();





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav__drawer_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_termine) {
            Termine t1 = new Termine();
            Bundle b = new Bundle();
            b.putInt("ID", i.getIntExtra("ID", 0));
            t1.setArguments(b);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            ft.replace(R.id.fragment_container, t1).addToBackStack("tag").commit();


        } else if (id == R.id.nav_buchen) {
            Stunde_Buchen s1 = new Stunde_Buchen();
            Bundle b = new Bundle();
            b.putInt("ID", i.getIntExtra("ID", 0));
            s1.setArguments(b);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            ft.replace(R.id.fragment_container, s1).addToBackStack(null).commit();

        } else if (id == R.id.nav_profil) {
            Profil p1 = new Profil();
            Bundle b1 = new Bundle();
            b1.putInt("ID", i.getIntExtra("ID", 0));
            b1.putString("Vorname", i.getStringExtra("Vorname"));
            b1.putString("Nachname", i.getStringExtra("Nachname"));
            b1.putString("Geburtsdatum", i.getStringExtra("Geburtsdatum"));
            b1.putString("Strasse", i.getStringExtra("Strasse"));
            b1.putString("Plz", i.getStringExtra("Plz"));
            b1.putString("Ort", i.getStringExtra("Ort"));
            b1.putString("Telefon", i.getStringExtra("Telefon"));
            b1.putString("Email", i.getStringExtra("Email"));
            b1.putString("Schultyp", i.getStringExtra("Schultyp"));
            b1.putString("Schulstufe", i.getStringExtra("Schulstufe"));
            b1.putString("EVorname", i.getStringExtra("EVorname"));
            b1.putString("ENachname", i.getStringExtra("ENachname"));
            b1.putString("Schuelerverhaeltnis", i.getStringExtra("Schuelerverhaeltnis"));
            b1.putString("Password", i.getStringExtra("Password"));
            p1.setArguments(b1);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            ft.replace(R.id.fragment_container, p1).addToBackStack("tag").commit();


        } else if (id == R.id.nav_einstellungen) {
            Einstellungen e1 = new Einstellungen();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            ft.replace(R.id.fragment_container, e1).addToBackStack("tag").commit();

        }
        else if (id == R.id.nav_logout) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            Intent i = new Intent(Nav_Drawer_list.this, Start_Fenster.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Sind Sie sicher?").setPositiveButton("Ja", dialogClickListener)
                    .setNegativeButton("Nein", dialogClickListener).show();

        }





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }



}
