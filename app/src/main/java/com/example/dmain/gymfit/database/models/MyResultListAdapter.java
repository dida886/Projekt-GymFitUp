package com.example.dmain.gymfit.database.models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmain.gymfit.R;

import java.util.List;

public class MyResultListAdapter extends BaseAdapter {

    Context context;
    List<BodyMeasure> list;
    int[] icon;






    public MyResultListAdapter(Context context, List<BodyMeasure> list, int[] icon) {
        this.context = context;
        this.list = list;
        this.icon = icon;


    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = View.inflate(context, R.layout.result_list_adapter, null);
        TextView tData = (TextView)v.findViewById(R.id.result_date);
        TextView tramie = (TextView)v.findViewById(R.id.result_ramie);
        TextView tPrzedramie = (TextView)v.findViewById(R.id.result_przedramie);
        TextView tKlatka = v.findViewById(R.id.result_klatka);
        TextView tPas = v.findViewById(R.id.result_pas);
        TextView tUdo = v.findViewById(R.id.result_udo);
        TextView tLydka = v.findViewById(R.id.result_lydka);
        ImageView image1 = v.findViewById(R.id.result_image1);
        ImageView image2 = v.findViewById(R.id.result_image3);
        ImageView image3 = v.findViewById(R.id.result_image2);
        ImageView image4 = v.findViewById(R.id.result_image4);
        ImageView image5 = v.findViewById(R.id.result_image5);
        ImageView image6 = v.findViewById(R.id.result_image6);

                
        
        //Set text for TextView
        tData.setText(String.valueOf(list.get(position).myDate()));
        tramie.setText(String.valueOf(list.get(position).getArm()+"cm"));
        tPrzedramie.setText(String.valueOf(list.get(position).getForearm()+"cm"));
        tKlatka.setText(String.valueOf(list.get(position).getChest()+"cm"));
        tPas.setText(String.valueOf(list.get(position).getWaist()+"cm"));
        tUdo.setText(String.valueOf(list.get(position).getTight()+"cm"));
        tLydka.setText(String.valueOf(list.get(position).getCalf()+"cm"));

        image1.setImageResource(icon[0]);
        image2.setImageResource(icon[1]);
        image3.setImageResource(icon[2]);
        image4.setImageResource(icon[3]);
        image5.setImageResource(icon[4]);
        image6.setImageResource(icon[5]);


        //Save product id to tag
        v.setTag(String.valueOf(list.get(position).getId()));
        return v;
        
        
        
        

        
        
        
    }
}
