package com.project.graduation.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.project.graduation.model.DieseaseSymptoms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emam on 2/15/16.
 */
public class SymptomsAdapter extends ArrayAdapter<DieseaseSymptoms> {
    private ArrayList<DieseaseSymptoms> dieseaseSymptomses;


    public SymptomsAdapter(Context context, int resource, int textViewResourceId, List<DieseaseSymptoms> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
