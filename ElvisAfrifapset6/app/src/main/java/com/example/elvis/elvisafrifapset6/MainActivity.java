package com.example.elvis.elvisafrifapset6;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private TodoAdapter adapter;
    private ToDoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = ToDoDatabase.getInstance(getApplicationContext());

        ListView itemlist = findViewById(R.id.itemlist);
        adapter = new TodoAdapter(getApplicationContext(), db.selectAll());

        itemlist.setAdapter(adapter);
        itemlist.setOnItemClickListener(new onClickList());
        itemlist.setOnItemLongClickListener(new onClickList2());
    }

    public void addItem(View view) {
        db = ToDoDatabase.getInstance(getApplicationContext());

        EditText textbox = findViewById(R.id.textbox);
        db.insert(textbox.getText().toString(), 1);
        updateData();
    }

    private void updateData() {
        db = ToDoDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();
        adapter.swapCursor(cursor);
    }

    private class onClickList implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            ListView itemlist = findViewById(R.id.itemlist);

            int position = itemlist.getPositionForView(view);
            int completed = 0;

            db.update(position + 1, completed);
            updateData();
        }
    }


    private class onClickList2 implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            ListView itemlist = findViewById(R.id.itemlist);
            int position = itemlist.getPositionForView(view);

            db.delete(position+ 1);
            updateData();
            return false;
        }
    }
}
