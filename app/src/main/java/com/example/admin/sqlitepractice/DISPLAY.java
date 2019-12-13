package com.example.admin.sqlitepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DISPLAY extends AppCompatActivity {

    public TextView tvId,tvName,tvSubject;
    Button deletebtn,updatebtn;
    public String s1,s2,s3;
    MyDataBase sdb;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvId = (TextView) findViewById(R.id.diaplayId);
        tvName = (TextView) findViewById(R.id.NameId);
        tvSubject = (TextView) findViewById(R.id.SubjectId);
        deletebtn = (Button) findViewById(R.id.btnDelete);
        updatebtn = (Button) findViewById(R.id.btnUpdate);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        s1 = bundle.getString("id");
        s2 = bundle.getString("name");
        s3 = bundle.getString("subject");
        tvId.setText(s1);
        tvName.setText(s2);
        tvSubject.setText(s3);

        sdb = new MyDataBase(this);
        sdb.open();

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DISPLAY.this,Update.class);
                intent.putExtra("s1",s1);
                intent.putExtra("s2",s2);
                intent.putExtra("s3",s3);
                startActivity(intent);
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sdb.delete(Integer.parseInt(s1));
                Intent intent = new Intent(DISPLAY.this,Update.class);
                startActivity(intent);
            }
        });
    }
}
