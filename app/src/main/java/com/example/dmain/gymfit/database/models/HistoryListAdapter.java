package com.example.dmain.gymfit.database.models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dmain.gymfit.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class HistoryListAdapter extends BaseAdapter {

    private Context mContex;
    private List<Series> mProduct;

    public HistoryListAdapter(Context mContex, List<Series> mProduct) {
        this.mContex = mContex;
        this.mProduct = mProduct;
    }
    @Override
    public int getCount() {
        return mProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return mProduct.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = View.inflate(mContex, R.layout.history_list_adapter, null);
        TextView tvName = (TextView)v.findViewById(R.id.tv_name);
        TextView tvWeight = (TextView)v.findViewById(R.id.tv_weight);
        TextView tvReps = (TextView)v.findViewById(R.id.tv_reps);
        TextView tvTime = v.findViewById(R.id.tv_time);
        //Set text for TextView
        tvName.setText(String.valueOf(mProduct.get(position).getExercisesName()));
        tvWeight.setText(String.valueOf(mProduct.get(position).getWeight()));
        tvReps.setText(String.valueOf(mProduct.get(position).getRepetitions()));

        tvTime.setText(String.valueOf(mProduct.get(position).getTime2()));

        //Save product id to tag
        v.setTag(String.valueOf(mProduct.get(position).getId()));
        return v;
    }
}
