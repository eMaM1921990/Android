package com.project.graduation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.project.graduation.Adapter.Symptom2RowItem;
import com.project.graduation.R;
import com.project.graduation.Adapter.CustomArrayAdapter;
import com.project.graduation.managers.DBHelper;
import com.project.graduation.managers.DBSingleton;
import com.project.graduation.model.RowItem;
import com.project.graduation.model.SymptomsGategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home extends AppCompatActivity {

    List<RowItem> rows;
    DBHelper db;
    Map<Integer, Boolean> symptomsMap;
    CustomArrayAdapter caa;
    Button submit;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        symptomsMap = new HashMap<>();
        listView = (ListView) findViewById(android.R.id.list);
        submit = (Button) findViewById(R.id.button);

        db= DBSingleton.getDBInstance(getApplicationContext(), db.DATABASE_NAME, null, db.DATABASE_VERSION);

        List<SymptomsGategory> symptomsGategoryList = db.getAllSymptomsCategory();
        for(int i = 0; i < symptomsGategoryList.size(); i++)
            symptomsMap.put(symptomsGategoryList.get(i).getId(), false);
        rows = Symptom2RowItem.symptomList2RowList(symptomsGategoryList);

        caa = new CustomArrayAdapter(this, rows, symptomsMap);

        listView.setAdapter(caa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                symptomsMap.put(position, !symptomsMap.get(position));
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> number = new ArrayList<Integer>();
                for(int i = 0; i < symptomsMap.size(); i++) {
                    if(symptomsMap.get(i+1))
                    {
                        number.add(i+1);
                    }
                }

                Intent intent = new Intent(Home.this, DiseaseDoctor.class);
                intent.putExtra("SYMPTOMS_N", number.size());
                for(int j = 0; j < number.size(); j++) {
                    intent.putExtra("SYMPTOMS_"+j, number.get(j));
                }
                startActivity(intent);
            }
        });    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
}
