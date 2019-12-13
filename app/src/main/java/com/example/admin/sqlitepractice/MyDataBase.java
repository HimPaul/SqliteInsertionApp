package com.example.admin.sqlitepractice;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 12/8/2019.
 */

public class MyDataBase {

    MyHelper mh;
    SQLiteDatabase sdb;
    public static String dbtable = "student";

    public MyDataBase(Context c){
        mh = new MyHelper(c,"techpalle.db",null,1);
    }
    public void open(){
        sdb =mh.getWritableDatabase();
    }
    public void insertstudent(String text1,String text2)
    {
        sdb.execSQL("Insert into student(name,subject) values('"+text1+"','"+text2+"')");
    }
    public void update(int id,String text1,String text2){
        sdb.execSQL("UPDATE "+dbtable+" SET name='"+text1+"', subject='"+text2+"'  WHERE _id=" + id);
    }
    public  void delete(int id){
        sdb.execSQL("DELETE FROM "+dbtable+" WHERE _id="+id);
    }
    public Cursor querystudent(){
        Cursor c;
        c=sdb.query("student",null,null,null,null,null,null);
        return c;
    }
    public void close(){
        sdb.close();
    }

    public class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sdb) {

            sdb.execSQL("create table student(_id integer primary key autoincrement,name text,subject text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
