package com.example.khaerulumam.m5_si3904_36_khaerulumam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Umam on 2/13/2018.
 */

public class CustomAdapterList extends BaseAdapter {
    Context context;
    String nama2[];
    LayoutInflater inflter;

    public CustomAdapterList(Context applicationContext, String[] nama) {
        this.context = context;
        this.nama2 = nama;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return nama2.length;
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
        view = inflter.inflate(R.layout.activity_list_item, null);
        TextView nm = (TextView) view.findViewById(R.id.textView);
        nm.setText(nama2[i]);
        return view;
    }
}
