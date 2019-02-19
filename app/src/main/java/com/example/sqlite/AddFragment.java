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
public class AddFragment extends Fragment {
    EditText ed_id, ed_name, ed_email;
    Button bn_add;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        ed_id = view.findViewById(R.id.enter_id);
        ed_name = view.findViewById(R.id.enter_name);
        ed_email = view.findViewById(R.id.enter_email);
        bn_add = view.findViewById(R.id.add_data);
        bn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ed_id.getText().toString();
                String name = ed_name.getText().toString();
                String email = ed_email.getText().toString();
                Shameeddb shameeddb = new Shameeddb(getActivity());
                SQLiteDatabase database = shameeddb.getWritableDatabase();
                shameeddb.addContacts(Integer.parseInt(id), name, email, database);
                shameeddb.close();
                ed_id.setText("");
                ed_name.setText("");
                ed_email.setText("");
                Toast.makeText(getActivity(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
