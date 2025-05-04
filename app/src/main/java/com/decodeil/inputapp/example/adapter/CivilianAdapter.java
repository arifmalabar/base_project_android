package com.decodeil.inputapp.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.decodeil.inputapp.R;
import com.decodeil.inputapp.helper.BaseListAdapter;

import java.util.ArrayList;
import java.util.Map;

public class CivilianAdapter extends BaseListAdapter {
    public CivilianAdapter(String[] colname, Context context, ArrayList<Map<String, String>> data) {
        super(colname, context, data);
    }

    public CivilianAdapter(Context context, ArrayList<Map<String, String>> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_civilian, viewGroup, false);
        TextView tvName = view.findViewById(R.id.item_name);
        TextView tvAddrs = view.findViewById(R.id.item_address);
        Map<String, String> item = data.get(i);
        tvName.setText(item.get("name"));
        tvAddrs.setText(item.get("address"));
        return view;
    }

}
