package com.example.baitaplonandroid.danhSachDeThi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitaplonandroid.R;

import java.util.List;

public class Adapter_De_Thi extends BaseAdapter {
    private Context ct;
    private List<Item_De_Thi> list;
    int layout;

    public Adapter_De_Thi(Context ct, List<Item_De_Thi> list, int layout) {
        this.ct = ct;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout,null);
        TextView textView = (TextView) view.findViewById(R.id.textView11);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView6);
        textView.setText(list.get(i).name);
        imageView.setImageResource(list.get(i).image);
        return view;
    }
}
