package com.example.sqlite;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {
    EditText ed_deltext;
    Button bn_delete;


    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        ed_deltext = view.findViewById(R.id.enter_delid);
        bn_delete = view.findViewById(R.id.delete_data);
        bn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delContacts();

            }
        });
        return view;
    }

    public void delContacts() {
        int id = Integer.parseInt(ed_deltext.getText().toString());
        Shameeddb shameeddb = new Shameeddb(getActivity());
        SQLiteDatabase database = shameeddb.getWritableDatabase();
        shameeddb.deleteContacts(id, database);
        shameeddb.close();
        ed_deltext.setText("");
        Toast.makeText(getActivity(), "Deleted Sucessfully", Toast.LENGTH_SHORT).show();

    }

}
