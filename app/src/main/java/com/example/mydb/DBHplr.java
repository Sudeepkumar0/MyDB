package com.example.mydb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHplr extends SQLiteOpenHelper {
    SQLiteDatabase sq;
    public DBHplr(Context context) {
        super(context, "student.db", null, 1);
        sq = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table details(Name text, Location text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void savdata(String s1, String s2) {
        ContentValues cv = new ContentValues();
        cv.put("Name", s1);
        cv.put("Location", s2);
        sq.insert("details", null, cv);
    }

    public String retrv(String s3) {
        Cursor c;
        c = sq.query("details", null, "Name=?", new String[]{s3}, null, null, null);
        c.moveToFirst();
        if(c.getCount()<1){
            return "no data";
        }
        String l1 = c.getString(c.getColumnIndex("Location"));

        return l1;
    }

    public void updtloc(String s4, String s5) {
        ContentValues cv = new ContentValues();
        cv.put("Location", s5);
        sq.update("details", cv, "Name = '"+s4+"'",null);
    }

    public void deletee(String s6, String s7) {
        ContentValues cv = new ContentValues();
        cv.put("Location", s7);
        sq.delete("details", "Name = '"+s6+"'",null);
    }
}
