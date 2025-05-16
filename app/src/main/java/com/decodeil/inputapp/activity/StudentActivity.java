package com.decodeil.inputapp.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.decodeil.inputapp.R;
import com.decodeil.inputapp.helper.EmptyChecker;
import com.decodeil.inputapp.test.Student;

import java.util.ArrayList;

public class StudentActivity extends BaseActvity {

    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void initComponents() {
        btn = findViewById(R.id.btn_proses_mhs);
        txtNim = findViewById(R.id.edit_nim);
        txtNama = findViewById(R.id.edit_nama);
        listHasil = findViewById(R.id.list_hasil);
        cbHoby = findViewById(R.id.cb_hoby);
        String[] hobby = {"Mancing", "Bersepeda", "Masak", "Traveling"};
        cbHoby.setAdapter(spinnerAdapter(hobby));

        btn.setOnClickListener(v -> {
            try {
                proses();
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void proses() throws Exception {
        String nim = getTextField(txtNim);
        String nama = getTextField(txtNama);
        String hobby = cbHoby.getSelectedItem().toString();
        EditText[] editTexts = {txtNama, txtNim};
        EmptyChecker.checkEmptyFields(editTexts);
        Student student = new Student(nim, nama, hobby);
        students.add(student);
        showData(students);
        clearForm();
    }

    private void clearForm() {
        EditText[] editTexts = {txtNama, txtNim};
        String[] strings = {"", ""};
        setText(editTexts, strings);
        cbHoby.setSelection(0);
    }

    private void showData(ArrayList<Student> students) {
        String data = "";
        for (Student student: students) {
            data += "NIM : "+student.getNim()+"\n Nama : "+student.getNama() + "\n Hobby : "+student.getHobby() + "\n <hr> \n";
        }
        listHasil.setText(data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initComponents();
    }
    private Button btn;
    private EditText txtNim, txtNama;
    private TextView listHasil;
    private Spinner cbHoby;

}