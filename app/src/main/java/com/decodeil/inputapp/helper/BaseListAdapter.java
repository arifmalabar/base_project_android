package com.decodeil.inputapp.helper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Map;

public abstract class BaseListAdapter extends BaseAdapter {

    public ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>();
    public String[] colname;
    public Context context;

    public BaseListAdapter(String[] colname, Context context, ArrayList<Map<String, String>> data) {
        this.colname = colname;
        this.context = context;
        this.data = data;
    }

    public BaseListAdapter(Context context, ArrayList<Map<String, String>> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    abstract public View getView(int i, View view, ViewGroup viewGroup);
}
