package com.example.baitaplonandroid.lichSu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baitaplonandroid.R;

import org.w3c.dom.Text;

import java.util.List;

public class LichSuAdapter extends BaseAdapter {
    Context context;
    List<ItemLichSu> lichSuList;
    int layout;

    public LichSuAdapter(Context context, List<ItemLichSu> lichSuList, int layout) {
        this.context = context;
        this.lichSuList = lichSuList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return lichSuList.size();
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout,null);
        TextView ten = (TextView) view.findViewById(R.id.textView9);
        TextView deThi = (TextView) view.findViewById(R.id.DeThi);
        TextView cauDung = (TextView) view.findViewById(R.id.cauDung);
        TextView cauSai = (TextView) view.findViewById(R.id.cauSai);
        TextView tongCau = (TextView) view.findViewById(R.id.tongCau);

        //ten.setText(lichSuList.get(i).ten);
        deThi.setText(lichSuList.get(i).deThi);
        cauDung.setText(lichSuList.get(i).cauDung);
        cauSai.setText(lichSuList.get(i).cauSai);
        tongCau.setText(lichSuList.get(i).tongCau);
        return view;
    }
}
