package com.production.achour_ar.qrevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class DetailContact_Activity extends AppCompatActivity {
    private ImageView image_personel;
    private EditText nom_prenom;
    private EditText book;
    private EditText e_mail;
    private EditText nsta;
    private EditText link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact_);
        initView();

        nom_prenom.setText("");
        e_mail.setText("");
        book.setText("");
        nsta.setText("");
        link.setText("");
    }
    public void initView(){
        nom_prenom = findViewById(R.id.nomprenom);
        e_mail = findViewById(R.id.email);
        book = findViewById(R.id.facebook);
        nsta = findViewById(R.id.insta);
        link = findViewById(R.id.linkedin);
        image_personel = findViewById(R.id.image_perso);
    ;
    }
}
