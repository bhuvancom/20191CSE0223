package com.example.a20191cse0223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextInputLayout etName223;
    TextInputLayout etEmail223;
    TextInputLayout etDepartment223;
    RadioGroup egCategory223;
    AutoCompleteTextView etCollege223;
    TextInputLayout etSemester223;
    TextInputLayout etLanguage223;
    Button btnSubmit223;
    String[] presidencyCollege223 = {
            "Acharya Institutes",
            "New Horizon College of Engineering",
            "Nitte Meenakshi Instittute of Technology",
            "Gitam University"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName223 = findViewById(R.id.et_name);
        etEmail223 = findViewById(R.id.et_email);
        etDepartment223 = findViewById(R.id.et_department);
        egCategory223 = findViewById(R.id.rg_category);
        etCollege223 = findViewById(R.id.et_college);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, presidencyCollege223);
        etCollege223.setThreshold(1);
        etCollege223.setAdapter(adapter);

        etSemester223 = findViewById(R.id.et_semester);
        etLanguage223 = findViewById(R.id.et_language);

        btnSubmit223 = findViewById(R.id.btn_submit);
        btnSubmit223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }

    private String getInputValue223(TextInputLayout layout) {
        return layout.getEditText().getText().toString().trim();
    }

    private void setError223(TextInputLayout layout, String errorMsg) {
        layout.setErrorEnabled(true);
        layout.setError(errorMsg);
    }

    private void submit() {
        String name = getInputValue223(etName223);
        if (name.isEmpty()) {
            setError223(etName223, getString(R.string.name_error));
            return;
        }
        etName223.setErrorEnabled(false);

        String department = getInputValue223(etDepartment223);
        if (department.isEmpty()) {
            setError223(etDepartment223, getString(R.string.department_error));
            return;
        }
        etDepartment223.setErrorEnabled(false);

        String email = getInputValue223(etEmail223);
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            setError223(etEmail223, getString(R.string.email_error));
            return;
        }
        etEmail223.setErrorEnabled(false);

        String semester = getInputValue223(etSemester223);
        if (semester.length() != 1) {
            setError223(etSemester223, getString(R.string.semester_error));
            return;
        }
        etSemester223.setErrorEnabled(false);

        String language = getInputValue223(etLanguage223);
        if (language.isEmpty()) {
            setError223(etLanguage223, getString(R.string.language_error));
            return;
        }
        etLanguage223.setErrorEnabled(false);

        String college = etCollege223.getText().toString();
        boolean collegeFromList = false;
        for (int i = 0; i < presidencyCollege223.length; i++) {
            if (presidencyCollege223[i].contentEquals(college)) {
                collegeFromList = true;
                break;
            }
        }
        if (!collegeFromList) {
            etCollege223.setError(getString(R.string.college_error));
            return;
        }
        etCollege223.setError("");

        String category = ((RadioButton) (findViewById(egCategory223.getCheckedRadioButtonId()))).getText().toString();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("department", department);
        intent.putExtra("semester", semester);
        intent.putExtra("language", language);
        intent.putExtra("college", college);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}