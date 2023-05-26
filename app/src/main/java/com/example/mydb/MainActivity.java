package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7;
    String s1, s2, s3, s4, s5, s6, s7;
    TextView tv;

    DBHplr dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextPersonName2);
        ed3 = findViewById(R.id.editTextTextPersonName3);
        ed4 = findViewById(R.id.editTextTextPersonName4);
        ed5 = findViewById(R.id.editTextTextPersonName5);
        ed6 = findViewById(R.id.editTextTextPersonName6);
        ed7 = findViewById(R.id.editTextTextPersonName7);
        tv=findViewById(R.id.textView);
        dbh = new DBHplr(MainActivity.this);

    }

    public void savl(View view) {
        s1 = ed1.getText().toString();
        s2 = ed2.getText().toString();
        dbh.savdata(s1,s2);
        Toast.makeText(this, s1+" "+s2+" saved", Toast.LENGTH_SHORT).show();
    }

    public void rtrv(View view) {
        s3 = ed3.getText().toString();
        String lo = dbh.retrv(s3);
        tv.setText(lo);
    }

    public void upd(View view) {
        s4 = ed4.getText().toString();
        s5 = ed5.getText().toString();
        dbh.updtloc(s4,s5);
    }

    public void delt(View view) {
        s6 = ed6.getText().toString();
        s7 = ed7.getText().toString();
        dbh.deletee(s6, s7);
    }
}