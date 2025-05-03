package com.decodeil.inputapp.activity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.decodeil.inputapp.R;

public class MainActivity extends BaseActvity implements CompoundButton.OnCheckedChangeListener {

    String[] list_hobby = {"menggambar", "traveling", "bernyanyi", "food vlogger"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportActionBar().show();
        initComponents();
    }

    public void initComponents() {
        editId = findViewById(R.id.edit_id);
        editName = findViewById(R.id.edit_name);
        tvId = findViewById(R.id.show_id);
        tvName = findViewById(R.id.show_name);
        showData = findViewById(R.id.show_check);
        spHobby = findViewById(R.id.sp_hobby);
        tvHobby = findViewById(R.id.show_hobby);
        spHobby.setAdapter(spinnerAdapter(list_hobby));
        showData.setOnCheckedChangeListener(this);
    }

    private void showProgram() {
        TextView[] tvs = {tvId, tvName, tvHobby};
        if(showData.isChecked()){
            String[] teks = {getTextField(editId), getTextField(editName), getSelectedOption(spHobby)};
            setText(tvs, teks);
        } else {
            String[] teks = {"ID", "nama", "hobby"};
            setText(tvs, teks);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        showProgram();
    }

    private EditText editId, editName;
    private TextView tvId, tvName, tvHobby;
    private Switch showData;
    private Spinner spHobby;

}