package com.project.graduation.Adapter;

import com.project.graduation.model.RowItem;
import com.project.graduation.model.SymptomsGategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 01/04/2016.
 */
public class Symptom2RowItem {

    public static List<RowItem> symptomList2RowList(List<SymptomsGategory> from) {
        List<RowItem> to = new ArrayList<RowItem>();
        if(from!=null) {
            for(int i = 0; i < from.size(); i++)
            {
                RowItem row = new RowItem();
                SymptomsGategory symptomsGategory = from.get(i);
                row.setTitle(symptomsGategory.getName());
                to.add(row);
            }
        }
        return to;
    }
}
