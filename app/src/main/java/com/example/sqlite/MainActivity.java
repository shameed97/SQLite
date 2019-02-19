package com.example.sqlite;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements HomeFragment.DatabaseSender {
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment(), null).commit();
        }
    }

    @Override
    public void Sender(int method) {
        switch (method) {
            case 0:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddFragment(), null).addToBackStack(null).commit();
                break;
            case 1:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ShowFragment(), null).addToBackStack(null).commit();
                break;
            case 2:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment(), null).addToBackStack(null).commit();
                break;
            case 3:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteFragment(), null).addToBackStack(null).commit();
                break;

        }
    }
}
