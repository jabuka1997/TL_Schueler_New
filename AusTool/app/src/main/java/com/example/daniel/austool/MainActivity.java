package com.example.daniel.austool;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("BarChart");
        GraphView graphView = (GraphView) findViewById(R.id.graph);

        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
           new DataPoint(0, 45),
                new DataPoint(1, 50),
                new DataPoint(2,60),
                new DataPoint(3,40),
                new DataPoint(4,35),
                new DataPoint(5,80),
                new DataPoint(6,50),
                new DataPoint(7,35),
        });



        graphView.addSeries(series);

        series.setColor(Color.BLACK);
        series.setTitle("Anfragen");

        graphView.getLegendRenderer().setVisible(true);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);


        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLACK);
    }
}
