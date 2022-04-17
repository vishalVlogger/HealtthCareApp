package com.example.loginsqlite;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.loginsqlite.databinding.ActivityDiseaseCabinetBinding;

public class DiseaseCabinet extends AppCompatActivity {

    String dis;
    private Button SympB;
    TextView textView;
    Intent i,j,k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_cabinet);

        Intent intent = getIntent();
        dis = intent.getStringExtra("ABC");
        //Toast.makeText(DiseaseCabinet.this, dis, Toast.LENGTH_SHORT).show();
        if ("1".equals(getIntent().getStringExtra("1")));
        //dis = intent.getStringExtra("ac");

        i = new Intent(DiseaseCabinet.this, SymptomsButton.class);
        i.putExtra("ac", dis);

        j = new Intent(DiseaseCabinet.this, MedicineButton.class);
        j.putExtra("ac", dis);

        k = new Intent(DiseaseCabinet.this, TreatmentButton.class);
        k.putExtra("ac", dis);
    }

    public void onBacktoMainClick(View view){

        if (view.getId() == R.id.BackToMain){
            Intent i = new Intent(DiseaseCabinet.this, MainPage.class);
            startActivity(i);

        }
    }

    public void onTreatmentClick(View view){
        startActivity(k);
    }

    public void onMedicineClick(View view){
        startActivity(j);
    }

    public void onSympClick(View view){
        startActivity(i);
    }

}