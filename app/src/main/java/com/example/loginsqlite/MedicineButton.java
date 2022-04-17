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

import com.example.loginsqlite.databinding.ActivityMedicineButtonBinding;

public class MedicineButton extends AppCompatActivity {

    private DatabaseHelper myDb;
    private String Dise;
    private TextView tv;
    private TextView MultiA;
    Button btc;
    Intent i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_button);

        myDb = new DatabaseHelper(this);
        Dise = getIntent().getStringExtra("ac");
        //Toast.makeText(MedicineButton.this, Dise, Toast.LENGTH_SHORT).show();
        tv = (TextView) findViewById(R.id.TextD);
        MultiA = (TextView) findViewById(R.id.MultiText);
        i = new Intent(MedicineButton.this, DiseaseCabinet.class);
        i.putExtra("ac", Dise);
        btc = (Button) findViewById(R.id.BacktoCab);
        btc.setOnClickListener((v) -> {
            i = new Intent(MedicineButton.this, DiseaseCabinet.class);
            i.putExtra("ac", Dise);
            i.putExtra("1", "1");
            i.putExtra("ABC", Dise);
            startActivity(i);
        });
        getMedicinename(Dise);
    }

    public void onBacktoCabClick(View view){
        startActivity(i);
    }

    private void getMedicinename(String s) {
        StringBuffer Medicine;
        Cursor res;
        //Toast.makeText(MedicineButton.this, s, Toast.LENGTH_SHORT).show();

        res = myDb.getMedicine(Dise);
        if (res.getCount() == 0){
            showMessage("Error", "Nothing found");
            return;
        }
        Medicine = new StringBuffer("*");
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            Medicine.append(res.getString(1));
            break;
        }
        buffer.append("Name: :" +Dise);
        tv.setText(buffer);
        tv.setMovementMethod(new ScrollingMovementMethod());
        MultiA.setMovementMethod(new ScrollingMovementMethod());
        MultiA.setText(Medicine);
    }

    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}