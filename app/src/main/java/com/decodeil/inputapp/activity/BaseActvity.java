package com.decodeil.inputapp.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.decodeil.inputapp.R;

public abstract class BaseActvity extends AppCompatActivity {
    abstract public void initComponents();

    public ArrayAdapter<String> spinnerAdapter(String[] data)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }
    public ArrayAdapter<String> spinnerAdapter(String[] data, int layout)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layout, data);
        adapter.setDropDownViewResource(layout);
        return adapter;
    }
    public String getSelectedOption(Spinner sp)
    {
        return sp.getSelectedItem().toString();
    }
    public void setText(TextView[] tv, String[] texts) {
        int i = 0;
        while(i < tv.length && i < texts.length){
            tv[i].setText(texts[i]);
            i++;
        }
    }
    public String getTextField(EditText edit)
    {
        return edit.getText().toString();
    }
    public void setFragment(int view, Fragment fragment) throws Exception
    {
        try {
            getSupportFragmentManager().beginTransaction().replace(view, fragment).commit();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
