package com.production.achour_ar.qrevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_EditProfil extends AppCompatActivity {
    private ImageView image_personel;
    private ImageView image_faceb;
    private ImageView image_instagrame;
    private ImageView image_linked;
    private ImageView image_mail;
    private EditText nom_prenom;
    private EditText book;
    private EditText e_mail;
    private EditText nsta;
    private EditText link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__edit_profil);
        initView();
        Personne personne =(Personne) getIntent().getSerializableExtra("data1");

        nom_prenom.setText(personne.getNom_prenom());
        e_mail.setText(personne.getEmail());
        book.setText(personne.getFacebook());
        nsta.setText(personne.getInsta());
        link.setText(personne.getLinkedin());



    }
    public void initView(){
        nom_prenom = findViewById(R.id.nomprenom);
        e_mail = findViewById(R.id.email);
        book = findViewById(R.id.facebook);
        nsta = findViewById(R.id.insta);
        link = findViewById(R.id.linkedin);
        image_personel = findViewById(R.id.image_perso);
        image_faceb = findViewById(R.id.image_facebook);
        image_instagrame = findViewById(R.id.image_insta);
        image_linked = findViewById(R.id.image_linkedin);
        image_mail = findViewById(R.id.image_email);
    }
}
