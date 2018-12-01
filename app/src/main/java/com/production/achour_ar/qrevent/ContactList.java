package com.production.achour_ar.qrevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.production.achour_ar.qrevent.Models.ContactModel;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {

    private ArrayList<ContactModel> contactModels;
    private ListView listView;
    private static ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
    }
}
