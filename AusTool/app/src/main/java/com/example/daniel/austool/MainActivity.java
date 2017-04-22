package com.example.daniel.austool;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    private List<String> Spinnerlist = new ArrayList<String>();
    String Monat;
    GraphView graphView;
    BarGraphSeries<DataPoint> series;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("BarChart");

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        graphView = (GraphView) findViewById(R.id.graph);




        Spinnerlist.add("");
        Spinnerlist.add("März");
        Spinnerlist.add("April");
        Spinnerlist.add("Mai");
        Spinnerlist.add("Juni");
        Spinnerlist.add("Juli");
        Spinnerlist.add("August");
        Spinnerlist.add("Alle");





        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Spinnerlist);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String pos = (String)spinner1.getItemAtPosition(i);

                Monat = pos;
                DiagrammStunden(Monat);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }


    private void DiagrammStunden(String monat)
    {
        graphView.removeAllSeries();
        graphView.getLegendRenderer().setVisible(true);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);



        if (monat == "März")
        {
            series = new BarGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 0),
                    new DataPoint(1, 30),
                    new DataPoint(2, 0),
                    new DataPoint(3, 0),
                    new DataPoint(4, 0),
                    new DataPoint(5, 0),
                    new DataPoint(6, 0),
                    new DataPoint(7, 0),

            });

            graphView.addSeries(series);

            series.setColor(Color.BLACK);

            series.setTitle("angefragte Stunden");

            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.BLACK);

        }
        else if (monat == "April")
        {
             series = new BarGraphSeries<>(new DataPoint[]{
                     new DataPoint(0, 0),
                     new DataPoint(1, 0),
                     new DataPoint(2, 10),
                     new DataPoint(3, 0),
                     new DataPoint(4, 0),
                     new DataPoint(5, 0),
                     new DataPoint(6, 0),
                     new DataPoint(7, 0),

            });

            graphView.addSeries(series);

            series.setColor(Color.BLUE);
            series.setTitle("angefragte Stunden");


            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.BLACK);

        }
        else if (monat == "Mai")
        {
            series = new BarGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 0),
                    new DataPoint(1, 0),
                    new DataPoint(2, 0),
                    new DataPoint(3, 30),
                    new DataPoint(4, 0),
                    new DataPoint(5, 0),
                    new DataPoint(6, 0),
                    new DataPoint(7, 0),

            });
            graphView.addSeries(series);

            series.setColor(Color.GREEN);

            series.setTitle("angefragte Stunden");


            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.BLACK);

        }
        else if (monat == "Juni")
        {
            series = new BarGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 0),
                    new DataPoint(1, 0),
                    new DataPoint(2, 0),
                    new DataPoint(3, 0),
                    new DataPoint(4, 10),
                    new DataPoint(5, 0),
                    new DataPoint(6, 0),
                    new DataPoint(7, 0),

            });
            graphView.addSeries(series);

            series.setColor(Color.RED);

            series.setTitle("angefragte Stunden");



            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.BLACK);



        }
        else if (monat == "Juli")
        {
            series = new BarGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 0),
                    new DataPoint(1, 0),
                    new DataPoint(2, 0),
                    new DataPoint(3, 0),
                    new DataPoint(4, 0),
                    new DataPoint(5, 15),
                    new DataPoint(6, 0),
                    new DataPoint(7, 0),

            });

            graphView.addSeries(series);

            series.setColor(Color.CYAN);

            series.setTitle("angefragte Stunden");

            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.BLACK);

        }
        else if (monat == "August")
        {
            series = new BarGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 0),
                    new DataPoint(1, 0),
                    new DataPoint(2, 0),
                    new DataPoint(3, 0),
                    new DataPoint(4, 0),
                    new DataPoint(5, 0),
                    new DataPoint(6, 25),
                    new DataPoint(7, 0),

            });

            graphView.addSeries(series);

            series.setColor(Color.MAGENTA);

            series.setTitle("angefragte Stunden");

            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.BLACK);

        }
        else if (monat == "Alle")
        {
            series = new BarGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 0),
                    new DataPoint(1, 30),
                    new DataPoint(2, 10),
                    new DataPoint(3, 30),
                    new DataPoint(4, 10),
                    new DataPoint(5, 15),
                    new DataPoint(6, 25),
                    new DataPoint(7, 0),

            });

            graphView.addSeries(series);

            series.setColor(Color.GRAY);

            series.setTitle("angefragte Stunden");

            series.setDrawValuesOnTop(true);
            series.setValuesOnTopColor(Color.BLACK);

        }
        else
        {
            series = new BarGraphSeries<>(new DataPoint[]{

            });

            graphView.addSeries(series);

            series.setColor(Color.BLACK);
            series.setTitle("angefragte Stunden");


        }






    }
}
