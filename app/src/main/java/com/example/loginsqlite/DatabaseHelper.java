package com.example.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "healthcare.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase myDb) {

        String HealthcareTable="create table healthcare(id integer PRIMARY KEY ,DiseaseName varchar(100));";
        String TreatTable="create table treat(id integer,treatment varchar(200),Foreign key(id) references healthcare(id) );";
        String SympTable="create table symp(id integer,Symptoms varchar(10000),Foreign key(id) references healthcare(id) );";
        String MediTable="create table MediTable(id integer,Medicines varchar(1000),Foreign key(id) references healthcare(id) );";

        myDb.execSQL(HealthcareTable);
        myDb.execSQL(TreatTable);
        myDb.execSQL(SympTable);
        myDb.execSQL(MediTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDb, int oldVersion, int newVersion) {
        String HCT="healthcare";
        String TT="treat";
        String ST="symp";
        String MT="MediTable";
        myDb.execSQL("DROP TABLE IF EXISTS "+HCT);
        myDb.execSQL("DROP TABLE IF EXISTS "+TT);
        myDb.execSQL("DROP TABLE IF EXISTS "+ST);
        myDb.execSQL("DROP TABLE IF EXISTS "+MT);

        onCreate(myDb);

    }

    public void insertDiseaseData(int id, String Disease) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("DiseaseName",Disease);
        String TABLE_NAME="healthcare";
        myDb.insert(TABLE_NAME, null, contentValues);
    }

    public void deleteDiseaseData() {
        SQLiteDatabase myDb = this.getWritableDatabase();

        String deleteDia = "Delete from healthcare";
        myDb.execSQL(deleteDia);
    }

    public void insertTreatmentData(int id, String treatment) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("treatment",treatment);
        String TABLE_NAME="treat";
        myDb.insert(TABLE_NAME, null, contentValues);
    }

    public void deleteTreatmentData() {
        SQLiteDatabase myDb = this.getWritableDatabase();

        String deleteDia = "Delete from treat";
        myDb.execSQL(deleteDia);
    }

    public void insertSymptomsData(int id, String Symptoms){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("Symptoms",Symptoms);
        String TABLE_NAME="symp";
        myDb.insert(TABLE_NAME, null, contentValues);
    }

    public void deleteSymptomsData() {
        SQLiteDatabase myDb = this.getWritableDatabase();

        String deleteDia = "Delete from symp";
        myDb.execSQL(deleteDia);
    }

    public void insertMedicineData(int id, String med){

        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("Medicines",med);
        String TABLE_NAME="MediTable";
        myDb.insert(TABLE_NAME, null, contentValues);
    }

    public void deleteMedicineData() {
        SQLiteDatabase myDb = this.getWritableDatabase();

        String deleteDia = "Delete from MediTable";
        myDb.execSQL(deleteDia);
    }

    public Cursor getSymptoms(String s){

        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor res = myDb.rawQuery("select s.id,s.Symptoms,h.Diseasename from symp s,healthcare h where s.id in (Select id from healthcare where DiseaseName= '"+s+"');", null);
        return res;
    }

    public Cursor getTreatment(String s){

        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor res = myDb.rawQuery("select * from treat where id in (Select id from healthcare where DiseaseName= '"+s+"');", null);
        return res;
    }

    public Cursor getMedicine(String s){

        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor res = myDb.rawQuery("select * from MediTable where id in (Select id from healthcare where DiseaseName= '"+s+"');", null);
        return res;
    }
}
