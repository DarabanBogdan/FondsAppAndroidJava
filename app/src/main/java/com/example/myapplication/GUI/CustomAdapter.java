package com.example.myapplication.GUI;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.Domain.Account;
import com.example.myapplication.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Account> {

    private final Activity context;
    private final List<Account> items;

    public CustomAdapter(Activity context, List<Account> items) {


        super(context, R.layout.list_item, items);
        this.context = context;
        this.items = items;

    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        TextView name = (TextView) rowView.findViewById(R.id.name);
        TextView sold = (TextView) rowView.findViewById(R.id.sold);


        name.setText(items.get(2 * position).getName());
        sold.setText(Float.toString(items.get(2 * position + 1).getSold()));

        return rowView;
    }
}