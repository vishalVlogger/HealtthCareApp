package com.example.loginsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.PersistableBundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.loginsqlite.databinding.ActivitySymptomsButtonBinding;

public class SymptomsButton extends AppCompatActivity{

    private DatabaseHelper myDb;
    private String Dise;
    private TextView tv;
    private TextView MultiA;
    Button btc;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_button);

        myDb = new DatabaseHelper(this);
        Dise = getIntent().getStringExtra("ac");
        tv = (TextView) findViewById(R.id.TextD);
        MultiA = (TextView) findViewById(R.id.MultiText);
        btc = (Button) findViewById(R.id.BacktoCab);
        btc.setOnClickListener((v) -> {

            i = new Intent(SymptomsButton.this, DiseaseCabinet.class);
            i.putExtra("ac", Dise);
            i.putExtra("1", "1");
            i.putExtra("ABC", Dise);
            startActivity(i);
        });
        //Toast.makeText(SymptomsButton.this, Dise, Toast.LENGTH_SHORT).show();
        getSymptomsname(Dise);
    }

    public void onBacktoCabClick(View view){

            startActivity(i);
    }

    public void getSymptomsname(String s){
        StringBuffer symptom;
        Cursor res;
        res = myDb.getSymptoms(Dise);
        if (res.getCount() == 0){
            showMessage("Error", "Nothing found");
            return;
        }
        symptom = new StringBuffer("*");
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            symptom.append(res.getString(1));
            break;
        }
        buffer.append("Name: :" +Dise);
        tv.setText(buffer);
        MultiA.setMovementMethod(new ScrollingMovementMethod());
        MultiA.setText(symptom);
    }

    private void showMessage(String title, String Message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}