package com.decodeil.inputapp.example.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.decodeil.inputapp.R;
import com.decodeil.inputapp.activity.BaseActvity;
import com.decodeil.inputapp.activity.MainActivity;
import com.decodeil.inputapp.example.adapter.CivilianAdapter;
import com.decodeil.inputapp.helper.Navigator;
import com.decodeil.inputapp.sql.CivilianDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CivilianMain extends BaseActvity {

    private CivilianDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_civilian_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initComponents();
        initData();
    }

    private void initData() {
        db = new CivilianDatabase(this);
        db.setName("ridho");
        db.setAddress("singosari");
        db.insertData();
        Cursor cursor = db.getData();
        ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>();
        while (cursor.moveToNext())
        {
            Map<String, String> item = new HashMap<String, String>();
            item.put("id", cursor.getString(0));
            item.put("name", cursor.getString(1));
            item.put("address", cursor.getString(2));
            data.add(item);
        }
        lvMain.setAdapter(new CivilianAdapter(this, data));

    }

    @Override
    public void initComponents() {
        fab = findViewById(R.id.fab_tambah);
        lvMain = findViewById(R.id.list_civilian);


    }

    private void pageSeccond() {
        Navigator.push(this, MainActivity.class);
    }

    private FloatingActionButton fab;
    private ListView lvMain;


}