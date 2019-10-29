package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements listFrag.clickActivity{

    TextView itemDesc;
    static ArrayList<String > desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemDesc = findViewById(R.id.itemDesc);

        desc = new ArrayList<>();
        desc.add("A. this is description of item1.");
        desc.add("B. this is description of item2.");
        desc.add("C. this is description of item3.");
        desc.add("D. this is description of item4.");
        itemDesc.setText(desc.get(0));

        if(findViewById(R.id.layout_por)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.fragment2))
                    .show(manager.findFragmentById(R.id.fragment))
                    .commit();
        }

        if(findViewById(R.id.layout_land)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment2))
                    .show(manager.findFragmentById(R.id.fragment))
                    .commit();
        }


    }

    public void onItemSelect(int index)
    {
        itemDesc.setText(desc.get(index));

        if(findViewById(R.id.layout_por)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment2))
                    .hide(manager.findFragmentById(R.id.fragment))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
