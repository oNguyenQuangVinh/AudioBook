package com.example.vinh.afinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vinh.afinal.Model.ItemContent;
import com.example.vinh.afinal.R;

import java.util.ArrayList;

/**
 * Created by vinh on 23-Nov-16.
 */

public class ChapterAdapter extends BaseAdapter {

//    public ArrayList<ItemContent.Chapter> getArrayList() {
//        return arrayList;
//    }
//
//    public void setArrayList(ArrayList<ItemContent.Chapter> arrayList) {
//        this.arrayList = arrayList;
//    }
    private ArrayList<ItemContent.Chapter> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;
    private TextView titlec,link;

    public ChapterAdapter(ArrayList<ItemContent.Chapter> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.item_superchapter_layout,null);
        titlec = (TextView)convertView.findViewById(R.id.txtTitleC);
        link = (TextView)convertView.findViewById(R.id.txtLink);
        titlec.setText(arrayList.get(position).getTitleC());
        link.setText(arrayList.get(position).getLink());
        return convertView;
    }
}
