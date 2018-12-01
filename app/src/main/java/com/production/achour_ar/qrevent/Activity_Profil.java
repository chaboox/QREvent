package com.production.achour_ar.qrevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Profil extends AppCompatActivity {
    private ImageView image_personel;
    private ImageView image_faceb;
    private ImageView image_instagrame;
    private ImageView image_linked;
    private ImageView image_mail;
    private TextView nom_prenom;
    private TextView book;
    private TextView email;
    private TextView nsta;
    private TextView link;
    private String pathImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__profil);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view =getSupportActionBar().getCustomView();
        TextView edit= (TextView) view.findViewById(R.id.edit);

        initView();

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Personne p = new Personne(nom_prenom.getText().toString(),e_mail.getText().toString(),book.getText().toString(),nsta.getText().toString(),link.getText().toString(),pathImg);
                Intent intent = new Intent(Activity_Profil.this, Activity_EditProfil.class);
                intent.putExtra("data1",  p);
                startActivity(intent);
            }
        });
    }


    public void initView(){
        nom_prenom = findViewById(R.id.nomprenom);
        email = findViewById(R.id.email);
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
