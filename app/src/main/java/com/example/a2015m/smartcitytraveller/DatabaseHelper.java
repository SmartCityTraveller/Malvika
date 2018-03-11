package com.example.a2015m.smartcitytraveller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 26-Feb-18.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION= 1;
    private static String DATABASE_NAME= "contacts.db";
    private static String TABLE_NAME= "contacts";
    private static String COLUMN_ID= "id";
    private static String COLUMN_NAME= "name";
    private static String COLUMN_DOB="dob";
    private static String COLUMN_NUMBER="number";
    private static String COLUMN_EMAIL= "email";
    private static String COLUMN_PASSWORD= "password";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="create table contacts(id integer primary key not null," +
            "name text not null," +
            "dob DATE not null" +
            "number int not null" +
            "email text not null" +
            "password text not null)";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertContact(com.example.a2015m.smartcitytraveller.Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values=new ContentValues();

        String query= "Select * from contacts";
        Cursor cursor=db.rawQuery(query, null);
        int count= cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_DOB, String.valueOf(c.getDob()));
        values.put(COLUMN_NUMBER,c.getNumber());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_PASSWORD,c.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname,pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(uname))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        String query = "DROP TABLE IF EXITS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
