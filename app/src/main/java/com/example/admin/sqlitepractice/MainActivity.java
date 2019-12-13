package com.example.admin.sqlitepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etname,etsubject;
    Button btnInsert,btnShow;
    MyDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText) findViewById(R.id.et1);
        etsubject = (EditText) findViewById(R.id.et2);
        btnInsert = (Button) findViewById(R.id.insertbtn);
        btnShow = (Button) findViewById(R.id.Showbtn);
        db= new MyDataBase(getApplication());
        db.open();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString();
                String subject = etsubject.getText().toString();
                db.insertstudent(name,subject);
                etname.setText("");
                etsubject.setText("");
                etname.requestFocus();
                Intent intent = new Intent(MainActivity.this,Show.class);
                startActivity(intent);
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Show.class);
                startActivity(intent);
            }
        });
    }
}
