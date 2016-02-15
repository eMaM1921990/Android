package com.project.graduation.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.project.graduation.R;
import com.project.graduation.model.DieseaseSymptoms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emam on 2/15/16.
 */
public class SymptomsAdapter extends ArrayAdapter<DieseaseSymptoms> {
    private ArrayList<DieseaseSymptoms> dieseaseSymptomses;


    public SymptomsAdapter(Context context, int resource, int textViewResourceId, ArrayList<DieseaseSymptoms> dieseaseSymptomses) {
        super(context, resource, textViewResourceId, dieseaseSymptomses);
        this.dieseaseSymptomses=new ArrayList<DieseaseSymptoms>();
        this.dieseaseSymptomses.addAll(dieseaseSymptomses);

    }


    private class ViewHolder {
        TextView code;
        CheckBox name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));
        if (convertView == null) {


        }

        return null;
    }

}
