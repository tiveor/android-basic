package com.possiblelabs.sqlitetest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by possiblelabs on 7/17/15.
 */
public class TodoSQLiteHelper extends SQLiteOpenHelper {

    public TodoSQLiteHelper(Context context) {
        super(context, "todolist", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE  TABLE todo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, todo TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS todo");
    }
}
