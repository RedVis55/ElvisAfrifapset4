package com.example.elvis.elvisafrifapset6;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by Elvis on 24-11-2017.
 */

public class TodoAdapter extends ResourceCursorAdapter {
    public TodoAdapter(Context context, int layout, Cursor c) {
        super(context, layout, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int name = cursor.getColumnIndex("title");
        String name2 = cursor.getString(name);

        int name3 = cursor.getColumnIndex("completed");
        String name4 = cursor.getString(name3);

        CheckBox gedaan = (CheckBox) view.findViewById(R.id.gedaan);

        if(gedaan.isChecked())
        {gedaan.setChecked(true);

        }
        else {
            gedaan.setChecked(false);
        }


        TextView adapb = (TextView) view.findViewById(R.id.adapb);

        adapb.setText(name2);
    }
}
