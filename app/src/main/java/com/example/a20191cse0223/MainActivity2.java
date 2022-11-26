package com.example.a20191cse0223;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button btnConfirm223;
    ScrollView svMain223;
    TextView tvDetails223;
    TextView tvEnabled223;
    TextView tvNotEnabled223;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        StringBuilder sb = new StringBuilder();
        sb.append("Name :\t")
                .append(getFromIntent223("name"))
                .append("\n")

                .append("Department : \t")
                .append(getFromIntent223("department"))
                .append("\n")

                .append("Email : \t")
                .append(getFromIntent223("email"))
                .append("\n")

                .append("Category : \t")
                .append(getFromIntent223("category"))
                .append("\n")

                .append("College Name : \t")
                .append(getFromIntent223("college"))
                .append("\n")

                .append("Semester : \t")
                .append(getFromIntent223("semester"))
                .append("\n")

                .append("Domain Expertise : \t")
                .append(getFromIntent223("language"))
        ;

        String language = getFromIntent223("language");
        int semester = getSemester223();
        tvEnabled223 = findViewById(R.id.tv_enable);
        tvNotEnabled223 = findViewById(R.id.tv_not_enable);

        tvDetails223 = findViewById(R.id.tv_details);
        tvDetails223.setText(sb.toString());
        svMain223 = findViewById(R.id.sv_main);

        btnConfirm223 = findViewById(R.id.btn_confirm);
        btnConfirm223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onConfirm223(language, semester);
            }
        });
    }

    private String getFromIntent223(String key) {
        return getIntent().getStringExtra(key);
    }

    private int getSemester223() {
        try {
            return Integer.parseInt(getIntent().getStringExtra("semester"));
        } catch (Exception e) {
            return 0;
        }
    }

    private void onConfirm223(String language, int semester) {
        svMain223.setVisibility(View.GONE);
        btnConfirm223.setVisibility(View.GONE);
        if (("java".equalsIgnoreCase(language) || "python".equalsIgnoreCase(language)) && semester > 4) {
            tvEnabled223.setVisibility(View.VISIBLE);
        } else {
            tvNotEnabled223.setVisibility(View.VISIBLE);
        }
    }
}