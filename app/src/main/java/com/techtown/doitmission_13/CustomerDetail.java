package com.techtown.doitmission_13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerDetail extends AppCompatActivity {
    String name;
    String birthDate;
    String phoneNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_detail);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        birthDate = intent.getStringExtra("birthDate");
        phoneNum = intent.getStringExtra("phoneNum");

        EditText editView = findViewById(R.id.editView);
        EditText editView2 = findViewById(R.id.editView2);
        EditText editView3 = findViewById(R.id.editView3);

        editView.setText(name);
        editView2.setText(birthDate);
        editView3.setText(phoneNum);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext() ,MainActivity.class);

                view.getContext().startActivity(intent);

                Toast.makeText(view.getContext(), "수정되었습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
