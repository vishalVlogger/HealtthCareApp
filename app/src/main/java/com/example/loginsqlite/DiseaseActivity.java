package com.example.loginsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DiseaseActivity extends AppCompatActivity {

    EditText Dname;
    String D_Name;
    DatabaseHelper myDb;
    Button SearchB;
    TextView tv;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        myDb = new DatabaseHelper(this);

        SearchB = (Button) findViewById(R.id.search_disease);
        SearchB.setOnClickListener((v) -> {
            Dname = (EditText) findViewById(R.id.Disease_name);
            D_Name = Dname.getText().toString();
            Intent i = new Intent(DiseaseActivity.this, DiseaseCabinet.class);
            i.putExtra(D_Name,"DiseaseName");
            i.putExtra("ABC", D_Name);
            startActivity(i);

        });

    }

    public void onBackDiseaseClick(View view){

        if (view.getId() == R.id.backDisease){
            Intent i = new Intent(DiseaseActivity.this, MainPage.class);
            startActivity(i);
        }
    }

    public void onSearchClick(View view) {
    }
}