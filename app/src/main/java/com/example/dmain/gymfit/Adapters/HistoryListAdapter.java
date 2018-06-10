package com.example.dmain.gymfit.Adapters;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmain.gymfit.R;
import com.example.dmain.gymfit.database.models.ListExercise;
import com.example.dmain.gymfit.database.models.Series;

import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;

import static java.lang.Integer.valueOf;

public class HistoryListAdapter extends BaseAdapter {

    private Context mContex;
    private List<Series> mProduct;
    private List<ListExercise> eProduct;
    int [] Colors;
    int[] Icon;


    public HistoryListAdapter(Context mContex, List<Series> mProduct, List<ListExercise> eProduct, int[] icon) {
        this.mContex = mContex;
        this.mProduct = mProduct;
        this.Icon= icon;
        /*this.Colors=Colors;*/
        this.eProduct = eProduct;

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
        TextView tvName = (TextView)v.findViewById(R.id.result_date);
        TextView tvWeight = (TextView)v.findViewById(R.id.tv_weight);
        TextView tvReps = (TextView)v.findViewById(R.id.tv_reps);
        TextView tvTime = v.findViewById(R.id.tv_time);

        ImageView tvImage1= v.findViewById(R.id.tv_image1);
        ImageView tvImage2= v.findViewById(R.id.tv_image2);
        ImageView tvImage3= v.findViewById(R.id.tv_image3);
        //Set text for TextView
        tvName.setText(String.valueOf(mProduct.get(position).getExercisesName()));
        tvWeight.setText(String.valueOf(mProduct.get(position).getWeight()+"Kg"));
        tvReps.setText(String.valueOf(mProduct.get(position).getRepetitions()));

        tvTime.setText(String.valueOf(mProduct.get(position).getMyTime()));

       int colorid= (valueOf(mProduct.get(position).getColorID()));








        tvImage1.setImageResource(Integer.valueOf(eProduct.get(colorid).getColor()));

        tvImage2.setImageResource(Icon[0]);
        tvImage3.setImageResource(Icon[1]);


        //Save product id to tag
        v.setTag(String.valueOf(mProduct.get(position).getId()));
        return v;
    }
}
