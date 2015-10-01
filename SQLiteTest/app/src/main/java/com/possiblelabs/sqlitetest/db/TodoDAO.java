package com.possiblelabs.sqlitetest.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.possiblelabs.sqlitetest.model.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by possiblelabs on 7/17/15.
 */
//CRUDL
//CREATE
//READ
//UPDATE
//DELETE
//LIST-SEARCH

public class TodoDAO {

    private SQLiteDatabase db;
    private TodoSQLiteHelper dbHelper;

    public TodoDAO(Context context) {
        dbHelper = new TodoSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public void addTodo(Todo todo) {
        db.insert("todo", null, todo.toContentValues());
    }

    public void deleteTodo(int todoId) {
        db.delete("todo", "_id=" + todoId, null);
    }

    public List<Todo> getTodos() {
        List<Todo> todoList = new ArrayList<Todo>();

        String[] columns = new String[]{"_id", "todo"};
        //SELECT _id, todo FROM todo
        //db.rawQuery("SELECT _id, todo FROM todo;", null);
        Cursor cursor = db.query("todo", columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            int indexID = cursor.getColumnIndex("_id");
            int indexTODO = cursor.getColumnIndex("todo");

            Todo todo = new Todo(cursor.getInt(indexID), cursor.getString(indexTODO));
            todoList.add(todo);
            cursor.moveToNext();
        }
        return todoList;
    }

    public void updateTodo(int todoId, Todo todo) {
        db.update("todo", todo.toContentValues(), "_id=" + todoId, null);
    }

    public Todo getTodo(int todoId) {
        Cursor c = db.rawQuery("SELECT _id, todo FROM todo WHERE _id=" + todoId, null);
        c.moveToFirst();
        return new Todo(c.getInt(0), c.getString(1));
    }
}
