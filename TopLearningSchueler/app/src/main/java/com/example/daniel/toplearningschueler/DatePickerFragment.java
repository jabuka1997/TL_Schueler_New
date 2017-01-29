package com.example.daniel.toplearningschueler;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Daniel on 04.11.2016.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    int IDsb = 0;
    int year, month, day;
    public DatePickerFragment(){}

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        Bundle b = getArguments();

        IDsb = b.getInt("SB");

        if (IDsb == 1)
        {
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }
        else
        {
            year = 1997;
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }


        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }




    public void onDateSet(DatePicker view, int year, int month, int day) {

        if(IDsb == 1){
            ((TextView) getActivity().findViewById(R.id.et_date)).setText(day + "." + (month + 1) + "." + year);


        }
        else {
            ((TextView) getActivity().findViewById(R.id.et_birthday)).setText(day + "." + (month + 1) + "." + year);
        }





        }
    }
