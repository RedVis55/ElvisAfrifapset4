package com.example.elvis.elvisafrifapset6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static java.sql.Types.BOOLEAN;
import static org.xmlpull.v1.XmlPullParser.TEXT;

/**
 * Created by Elvis on 21-11-2017.
 */

public class ToDoDatabase extends SQLiteOpenHelper {
    private ToDoDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static ToDoDatabase instance;

    public static ToDoDatabase getInstance(Context context) {
        if(instance == null) {
            instance = new ToDoDatabase(context, "stringname",null, 1);
        }
        return instance;
    }

    public Cursor selectAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM todos", null);
        return cursor;
    }


    public void insert(String title, int completed){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("title", title);
        values.put("completed", completed);

        getWritableDatabase().insert("todos","null", values);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table todos (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, completed INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
