package com.example.shivam.project2.Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Project.db";
    public static  final int DATABASE_VERSION = 2;

    public static final String TABLE_NAME = " project_db ";
    public static final String COL_1 = "Id";
    public static final String COL_2 = " Projectname ";
    public static final String COL_3 = " reference ";
    public static final String COL_4 = " amountpro ";
    public static final String COL_5 = " amountfinal ";
    public static final String COL_6 = " quatation ";


    public static  final String TABLE_2 = " user_db ";
    public static final String COL_2_1 = " Id ";
    public static final String COL_2_2 = " Name ";
    public static final String COL_2_3 = " Percentage ";
    public static final String CREATE_TABLE2 = " CREATE TABLE " + TABLE_2 + "("+ COL_2_1 + " INTEGER PRIMARY KEY  ,"
           + COL_2_2 + "TEXT ," + COL_2_3 + " TEXT   )";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = " create table if not exists " + TABLE_NAME  + "("+ COL_1 + " INTEGER PRIMARY KEY  ,"
                + COL_2 + "TEXT," +COL_3+ "TEXT," + COL_4+ "TEXT," + COL_5 +" TEXT," + COL_6 + " TEXT   )";
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == oldVersion + 1){
        Log.w(Database.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
     db.execSQL("DROP TABLE IF EXISTS " + Database.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Database.TABLE_2);
        onCreate(db);

    }}
    public boolean insertData(String projectname, String reference, String amountpro, String amountfinal, String quatation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, projectname);
        contentValues.put(COL_3, reference);
        contentValues.put(COL_4, amountpro);
        contentValues.put(COL_5, amountfinal);
        contentValues.put(COL_6, quatation);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean adddata(String name, String percentage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_2, name);
        contentValues.put(COL_2_3, percentage);
        long result = db.insert(TABLE_2, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<DBholder> getAllinfo() {

        List<DBholder> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.rawQuery(" select * from " + TABLE_NAME , null);
        DBholder dBholder;
        if (cursor.moveToFirst()) {
            do {
                dBholder = new DBholder();

                dBholder.setProjectName(cursor.getString(1));
                dBholder.setReference(cursor.getString(2));
                dBholder.setAmountProposed(cursor.getString(3));
                dBholder.setAmountFianl(cursor.getString(4));
                dBholder.setQuatation(cursor.getString(5));

                arrayList.add(dBholder);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return arrayList;
    }

    public List<Dbholder2> alluser() {

        List<Dbholder2> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" select * from " + TABLE_2, null);
        DBholder dBholder;
        if (cursor.moveToFirst()) {
            do {
                Dbholder2 dbholder = new Dbholder2();
                dbholder.setId(cursor.getString(0));
                dbholder.setName(cursor.getString(1));
                dbholder.setPercentage(cursor.getString(2));
                arrayList.add(dbholder);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return arrayList;

    }
    public Cursor getAllDATA() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
    public Cursor getInfo(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor rst = db.rawQuery("select * from " + TABLE_2, null);
        return rst;
    }

    public boolean updataData(String id, String projectname, String reference, String amountpro, String amountfinal, String quatation,String name,String percentage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, projectname);
        contentValues.put(COL_3, reference);
        contentValues.put(COL_4, amountpro);
        contentValues.put(COL_5, amountfinal);
        contentValues.put(COL_6, quatation);
        db.update(TABLE_NAME, contentValues, "ID = ? ", new String[]{id});
        return true;

    }
    public boolean updataData(String name,String percentage,String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_1, id);
        contentValues.put(COL_2_2, name);
        contentValues.put(COL_2_3, percentage);
        db.update(TABLE_2, contentValues, "ID = ? ", new String[]{id});
        return true;

    }
}


