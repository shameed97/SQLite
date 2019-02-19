package com.example.sqlite;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment {
    private TextView ed_show;

    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show, container, false);
        ed_show = view.findViewById(R.id.show_text);
        readCon();
        return view;
    }

    public void readCon() {
        Shameeddb shameeddb = new Shameeddb(getActivity());
        SQLiteDatabase database = shameeddb.getReadableDatabase();
        Cursor cursor = shameeddb.readContacts(database);
        String info = "";
        while (cursor.moveToNext()) {
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ShameedContract.Shameedcon.STU_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ShameedContract.Shameedcon.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ShameedContract.Shameedcon.EMAIL));
            info = info + "\n\n" + "ID :" + id + "\nNAME :" + name + "\nEMAIL :" + email;
        }
        ed_show.setText(info);
        shameeddb.close();
    }

}
