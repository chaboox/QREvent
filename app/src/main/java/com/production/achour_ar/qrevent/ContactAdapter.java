package com.production.achour_ar.qrevent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.production.achour_ar.qrevent.Models.ContactModel;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<ContactModel> {

    private ArrayList<ContactModel> dataSet;
    Context mContext;


    // View lookup cache
    private class ViewHolder {
        TextView txtName;
        TextView txtFirstname;
        TextView txtEmail;
    }


    public ContactAdapter(ArrayList<ContactModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;
    }


    private int lastPosition = -1;


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ContactModel model = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtFirstname = (TextView) convertView.findViewById(R.id.prenomb);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.nomb);
            viewHolder.txtEmail = (TextView) convertView.findViewById(R.id.emailb);


            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.txtName.setText(model.getName());
        viewHolder.txtFirstname.setText(model.getFirstname());
        viewHolder.txtEmail.setText(model.getEmail());


        // Return the completed view to render on screen
        return convertView;
    }
}
