package com.possiblelabs.sqlitetest.model;

import android.content.ContentValues;

/**
 * Created by possiblelabs on 7/17/15.
 */
public class Todo {

    private int id;
    private String text;

    public Todo(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Todo() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("todo", text);
        return contentValues;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Todo{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
