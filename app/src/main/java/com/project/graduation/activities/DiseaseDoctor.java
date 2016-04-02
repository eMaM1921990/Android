package com.project.graduation.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.graduation.R;
import com.project.graduation.managers.DBHelper;
import com.project.graduation.managers.DBSingleton;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Daniel on 01/04/2016.
 */
public class DiseaseDoctor extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_doctor);
        Bundle extras = getIntent().getExtras();
        textView = (TextView) findViewById(R.id.textView2);
        ArrayList<Integer> symptoms = new ArrayList<>();
        if (extras != null) {
            for(int i = 0; i < extras.getInt("SYMPTOMS_N"); i++)
                symptoms.add(extras.getInt("SYMPTOMS_"+i));
        }

        DBHelper db= DBSingleton.getDBInstance(null, null, null, 1);
        String text = db.getLastActivityInfo(symptoms);
        textView.setText(text);

    }

}
