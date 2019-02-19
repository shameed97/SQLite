package com.example.sqlite;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button bn_add, bn_show, bn_update, bn_delete;

    DatabaseSender databaseSend;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface DatabaseSender {
        void Sender(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bn_add = view.findViewById(R.id.add_info);
        bn_add.setOnClickListener(this);
        bn_show = view.findViewById(R.id.show_info);
        bn_show.setOnClickListener(this);
        bn_update = view.findViewById(R.id.upda_info);
        bn_update.setOnClickListener(this);
        bn_delete = view.findViewById(R.id.dele_info);
        bn_delete.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_info:
                databaseSend.Sender(0);
                break;
            case R.id.show_info:
                databaseSend.Sender(1);
                break;
            case R.id.upda_info:
                databaseSend.Sender(2);
                break;
            case R.id.dele_info:
                databaseSend.Sender(3);
                break;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            databaseSend = (DatabaseSender) activity;
        } catch (Exception e) {
            Log.d("Database Operation", "e");
        }
    }
}
