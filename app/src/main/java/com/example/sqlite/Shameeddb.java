package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Shameeddb extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student.db";
    public static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = " CREATE TABLE " + ShameedContract.Shameedcon.TABLE_NAME + " ( " + ShameedContract.Shameedcon.STU_ID + " INTEGER," + ShameedContract.Shameedcon.NAME + " TEXT," +
            ShameedContract.Shameedcon.EMAIL + " TEXT);";
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS " + ShameedContract.Shameedcon.TABLE_NAME;

    Shameeddb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.i("Database Operation", "Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        Log.d("Database Operation", "Table Droped");
    }

    public void addContacts(int id, String name, String email, SQLiteDatabase database) {
        ContentValues values = new ContentValues();
        values.put(ShameedContract.Shameedcon.STU_ID, id);
        values.put(ShameedContract.Shameedcon.NAME, name);
        values.put(ShameedContract.Shameedcon.EMAIL, email);
        database.insert(ShameedContract.Shameedcon.TABLE_NAME, null, values);
    }

    public Cursor readContacts(SQLiteDatabase database) {
        String[] projection = {ShameedContract.Shameedcon.STU_ID, ShameedContract.Shameedcon.NAME, ShameedContract.Shameedcon.EMAIL};
        Cursor cursor = database.query(ShameedContract.Shameedcon.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }

    public void updateContacts(int id, String name, String email, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShameedContract.Shameedcon.NAME, name);
        contentValues.put(ShameedContract.Shameedcon.EMAIL, email);
        String selection = ShameedContract.Shameedcon.STU_ID + "=" + id;
        database.update(ShameedContract.Shameedcon.TABLE_NAME, contentValues, selection, null);
    }

    public void deleteContacts(int  id, SQLiteDatabase database) {
        String selection = ShameedContract.Shameedcon.STU_ID+ "=" + id;
        database.delete(ShameedContract.Shameedcon.TABLE_NAME, selection, null);

    }
}
