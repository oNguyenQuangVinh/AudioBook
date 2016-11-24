package com.example.vinh.afinal.Adapter;

/**
 * Created by vinh on 15-Nov-16.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vinh.afinal.Model.ItemContent;
import com.example.vinh.afinal.R;

import java.util.ArrayList;

/**
 * Created by vinh on 23-Sep-16.
 */
public class ListViewAdapter extends BaseAdapter {


    private ArrayList<ItemContent> arrayList;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListViewAdapter(ArrayList<ItemContent> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public ArrayList<ItemContent> getArrayList() {
        return arrayList;
    }


    public void setArrayList(ArrayList<ItemContent> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Holder holder;

        if (view == null) {
            holder = new Holder();
            layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.item_layout, null);
            holder.imageView = (ImageView) view.findViewById(R.id.imageView69);
            holder.txtTitle = (TextView) view.findViewById(R.id.txtTitle69);
            holder.txtContent = (TextView) view.findViewById(R.id.txtContent69);
            holder.imageView1 = (ImageView) view.findViewById(R.id.iconFavorite69);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();

        }
//        holder.imageView.setImageResource(arrayList.get(i).getImage());
//        Gli
        Glide.with(context).load(arrayList.get(i).getImage()).asBitmap().into(holder.imageView);
        holder.txtTitle.setText(arrayList.get(i).getTitle());
        holder.txtContent.setText(arrayList.get(i).getContent());

        if (!arrayList.get(i).getFavorite()) {
            holder.imageView1.setImageResource(R.drawable.ic_favorite_border);
        } else {
            holder.imageView1.setImageResource(R.drawable.ic_favorite);
        }
        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int i= (int) v.getTag();
                ImageView img = (ImageView) v;
                if (arrayList.get(i).getFavorite()) {
                    img.setImageResource(R.drawable.ic_favorite_border);
                    //imageView1.setImageResource(R.drawable.ic_favorite_border);
//                    new AlertDialog.Builder(context).setMessage("Đã xóa khỏi mục yêu thích").setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    }).show();
                    arrayList.get(i).setFavorite(false);
                } else {
                    img.setImageResource(R.drawable.ic_favorite);
//                    new AlertDialog.Builder(context).setMessage("Đã thêm vào mục yêu thích").setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    }).show();
                    arrayList.get(i).setFavorite(true);
                }
            }
        });
        if (arrayList.get(i).isSelected()) {
            view.setBackgroundColor(Color.parseColor("#FFAB91"));
        } else {
            view.setBackgroundColor(Color.WHITE);
        }
        return view;
    }

    private class Holder {
        TextView txtContent, txtTitle;
        ImageView imageView, imageView1;
    }
}




