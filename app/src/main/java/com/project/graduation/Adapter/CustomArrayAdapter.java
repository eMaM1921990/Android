package com.project.graduation.Adapter;

import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Daniel on 01/04/2016.
 */

    import java.util.List;
import java.util.Map;

import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.TextView;

import com.project.graduation.R;
import com.project.graduation.model.RowItem;

    /**
     * Custom adapter - "View Holder Pattern".
     *
     * @author daniel
     *
     */
    public class CustomArrayAdapter extends ArrayAdapter<RowItem> implements View.OnClickListener
    {
        private LayoutInflater layoutInflater;

        private Map<Integer, Boolean> symptomsMap;

        public CustomArrayAdapter(Context context, List<RowItem> objects, Map<Integer, Boolean> symptomsMap)
        {
            super(context, 0, objects);
            layoutInflater = LayoutInflater.from(context);
            this.symptomsMap = symptomsMap;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            // holder pattern
            Holder holder = null;
            if (convertView == null)
            {
                holder = new Holder();

                convertView = layoutInflater.inflate(R.layout.list_item, null);
                holder.setTextViewTitle((TextView) convertView.findViewById(R.id.textViewTitle));
                holder.setCheckBox((CheckBox) convertView.findViewById(R.id.checkBox));
                convertView.setTag(holder);
            }
            else
            {
                holder = (Holder) convertView.getTag();
            }

            RowItem row = getItem(position);
            holder.getTextViewTitle().setText(row.getTitle());
            holder.getCheckBox().setTag(position);
            holder.getCheckBox().setChecked(row.isChecked());
            holder.getCheckBox().setOnClickListener(this);
            return convertView;
        }
        @Override
        public void onClick(View v) {

            CheckBox checkBox = (CheckBox) v;
            int position = (Integer) v.getTag();
            getItem(position).setChecked(checkBox.isChecked());

            symptomsMap.put(position+1, checkBox.isChecked());
        }

        public Map<Integer, Boolean> getSympyomsMap() {
            return symptomsMap;
        }

        static class Holder
        {
            TextView textViewTitle;
            CheckBox checkBox;

            public TextView getTextViewTitle()
            {
                return textViewTitle;
            }

            public void setTextViewTitle(TextView textViewTitle)
            {
                this.textViewTitle = textViewTitle;
            }

            public CheckBox getCheckBox()
            {
                return checkBox;
            }
            public void setCheckBox(CheckBox checkBox)
            {
                this.checkBox = checkBox;
            }

        }
    }

