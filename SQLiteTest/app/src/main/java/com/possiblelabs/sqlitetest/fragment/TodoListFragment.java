package com.possiblelabs.sqlitetest.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.possiblelabs.sqlitetest.Constants;
import com.possiblelabs.sqlitetest.ListAdapter;
import com.possiblelabs.sqlitetest.MainActivity;
import com.possiblelabs.sqlitetest.R;
import com.possiblelabs.sqlitetest.model.Todo;
import com.possiblelabs.sqlitetest.db.TodoDAO;

import java.util.List;

/**
 * Created by possiblelabs on 7/17/15.
 */
public class TodoListFragment extends Fragment implements Constants {

    private ListView list;
    private Context context;
    private TodoDAO dao;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static TodoListFragment newInstance(int sectionNumber) {
        TodoListFragment fragment = new TodoListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public TodoListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dao = new TodoDAO(container.getContext());
        final View rootView = inflater.inflate(R.layout.fragment_todolist, container, false);
        context = rootView.getContext();
        list = (ListView) rootView.findViewById(R.id.listview);
        updateList();

        (rootView.findViewById(R.id.btn_add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Todo todo = new Todo();
                String[] a = new String[]{"Ir a clases Android HUB7 Grupo 2", "Prender compu", "opcion 3", "salir de compras", "volver a casa"};
                int posRandom = (int) (Math.random() * a.length);
                todo.setText(a[posRandom]);
                dao.addTodo(todo);

                updateList();
            }
        });

        (rootView.findViewById(R.id.btn_delete)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Todo> todos = dao.getTodos();
                if (todos.size() > 0) {
                    dao.deleteTodo(todos.get(0).getId());
                    updateList();
                }
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dao.deleteTodo(i);
                updateList();
            }
        });

        return rootView;
    }


    private void updateList() {
        List<Todo> todoList = dao.getTodos();
        Log.d(TAG, "==============================");
        for (Todo t : todoList)
            Log.d(TAG, t.toString());

        list.setAdapter(new ListAdapter(context, todoList));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
