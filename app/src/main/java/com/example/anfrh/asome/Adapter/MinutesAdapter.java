package com.example.anfrh.asome.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.anfrh.asome.MinutesItem;
import com.example.anfrh.asome.R;

import java.util.ArrayList;

public class MinutesAdapter extends BaseAdapter {

    Context context;
    ArrayList<MinutesItem> al_minutes_items;
    TextView tv_minutes_title, tv_minutes_date, tv_minutes_st;

    public MinutesAdapter(Context context, ArrayList<MinutesItem> al_minutes_items) {
        this.context = context;
        this.al_minutes_items = al_minutes_items;
    }

    @Override
    public int getCount() {
        return this.al_minutes_items.size();
    }

    @Override
    public Object getItem(int i) {
        return al_minutes_items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_minutes, null);
            tv_minutes_title = view.findViewById(R.id.tv_minutes_title);
            tv_minutes_date = view.findViewById(R.id.tv_minutes_date);
            tv_minutes_st = view.findViewById(R.id.tv_minutes_st);
        }
        tv_minutes_title.setText(al_minutes_items.get(i).getMinutes_title());
        tv_minutes_date.setText(al_minutes_items.get(i).getMinutes_update_date());
        tv_minutes_st.setText(al_minutes_items.get(i).getMinutes_st());
        return view;
    }
}
