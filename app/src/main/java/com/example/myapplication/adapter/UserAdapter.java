package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.User;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_user, parent, false);
        }
        // Lookup view for data population
        TextView tvMail = (TextView) convertView.findViewById(R.id.tvMail);
        TextView tvNombre = (TextView) convertView.findViewById(R.id.tvNombre);
        // Populate the data into the template view using the data object
        tvMail.setText(user.getMail());
        tvNombre.setText(user.getNombre());
        // Return the completed view to render on screen
        return convertView;
    }

}
