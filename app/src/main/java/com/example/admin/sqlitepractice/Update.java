package com.example.admin.sqlitepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {

    MyDataBase sdb;
    EditText etname,edsub;
    Button save;
    String s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etname = (EditText) findViewById(R.id.tv2Name);
        edsub = (EditText) findViewById(R.id.tv3Sub);
        save = (Button) findViewById(R.id.btnSave);

        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();

        s1= bundle.getString("s1");
        s2= bundle.getString("s2");
        s3= bundle.getString("s3");

        etname.setText(s2);
        edsub.setText(s3);

        sdb= new MyDataBase(this);
        sdb.open();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s2 = etname.getText().toString();
                s3 = edsub.getText().toString();
                sdb.update(Integer.parseInt(s1),s2,s3);

                Intent intent1 = new Intent(Update.this,Show.class);
                startActivity(intent1);
            }
        });


    }
}
