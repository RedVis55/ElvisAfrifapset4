package com.example.elvis.elvisafrifapset6;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ToDoDatabase db = ToDoDatabase.getInstance(getApplicationContext());

        adapter = new TodoAdapter(getApplicationContext(),db.selectAll());

        final Button button = findViewById(R.id.jenson);

        ToDoDatabase.getInstance(getApplicationContext());

    private void updateData() {


    }





    }
}
