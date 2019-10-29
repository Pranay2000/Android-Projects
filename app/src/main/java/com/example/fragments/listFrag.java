package com.example.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class listFrag extends ListFragment {


    public listFrag() {
        // Required empty public constructor
    }

    clickActivity obj;

    public interface clickActivity
    {
        void onItemSelect(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        obj = (clickActivity)context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> items = new ArrayList<>();
        items.add("1. This is item 1.");
        items.add("2. This is item 2.");
        items.add("3. This is item 3.");
        items.add("4. This is item 4.");

        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,items));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        obj.onItemSelect(position);
    }
}
