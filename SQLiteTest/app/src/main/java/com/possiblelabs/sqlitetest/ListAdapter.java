package com.possiblelabs.sqlitetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.possiblelabs.sqlitetest.model.Todo;

import java.util.List;

/**
 * Created by possiblelabs on 7/17/15.
 */
public class ListAdapter extends ArrayAdapter<Todo> {

    private Context context;
    private List<Todo> todoList;

    public ListAdapter(Context context, List<Todo> objects) {
        super(context, R.layout.fragment_todolist, objects);
        this.context = context;
        this.todoList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.frament_item, parent, false);

        TextView todoText = (TextView) rowView.findViewById(R.id.todoText);
        todoText.setText(todoList.get(position).getText());

        return rowView;
    }
}
