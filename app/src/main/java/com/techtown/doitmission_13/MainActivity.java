package com.techtown.doitmission_13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        CustomerAdapter adapter = new CustomerAdapter();

        EditText name = findViewById(R.id.name);
        EditText birthDate = findViewById(R.id.birthDate);
        EditText phoneNum = findViewById(R.id.phoneNum);
        
        Button button = findViewById(R.id.button);
        TextView cusCnt = findViewById(R.id.cusCnt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(new Customer(name.getText().toString(), birthDate.getText().toString(), phoneNum.getText().toString()));
                adapter.notifyDataSetChanged();

                int getCusCnt = recyclerView.getAdapter().getItemCount();
                cusCnt.setText(String.valueOf(getCusCnt) + '명');

                name.getText().clear();
                birthDate.getText().clear();
                phoneNum.getText().clear();
            }
        });

        recyclerView.setAdapter(adapter);

    }
}