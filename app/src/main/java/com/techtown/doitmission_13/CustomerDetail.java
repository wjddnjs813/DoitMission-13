package com.techtown.doitmission_13;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerDetail extends AppCompatActivity {
    private Intent intent;
    String name;
    String birthDate;
    String phoneNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_detail);

        intent = getIntent();
        name = intent.getStringExtra("name");
        birthDate = intent.getStringExtra("birthDate");
        phoneNum = intent.getStringExtra("phoneNum");

        EditText editView = findViewById(R.id.editView);
        EditText editView2 = findViewById(R.id.editView2);
        EditText editView3 = findViewById(R.id.editView3);

        editView.setText(name);
        editView2.setText(birthDate);
        editView3.setText(phoneNum);
    }
}
