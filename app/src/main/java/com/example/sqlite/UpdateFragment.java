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
public class UpdateFragment extends Fragment {
   private EditText up_id,up_name,up_email;
    private Button bn_updata;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_update, container, false);
    up_id=view.findViewById(R.id.update_id);
    up_name=view.findViewById(R.id.update_name);
    up_email=view.findViewById(R.id.update_email);
    bn_updata=view.findViewById(R.id.update_data);
    bn_updata.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String id=up_id.getText().toString();
            String name=up_name.getText().toString();
            String email=up_email.getText().toString();
            Shameeddb shameeddb=new Shameeddb(getActivity());
            SQLiteDatabase database=shameeddb.getWritableDatabase();
            shameeddb.updateContacts(Integer.parseInt(id),name,email,database);
            shameeddb.close();
            up_id.setText("");
            up_name.setText("");
            up_email.setText("");
            Toast.makeText(getActivity(), "Updated Successfully", Toast.LENGTH_SHORT).show();
        }
    });

        return view;
    }

}
