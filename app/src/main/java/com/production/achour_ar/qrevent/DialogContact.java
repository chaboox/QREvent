package com.production.achour_ar.qrevent;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DialogContact {

    Activity mActivity;

    public void showDialog(Activity activity, String NomPrenom, String Email, final String Tel, String facebookURL){
        mActivity = activity;
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_contact_act);


        TextView NomPrenomTV = dialog.findViewById(R.id.NomPrenom);
        NomPrenomTV.setText(NomPrenom);

        TextView EmailTV = dialog.findViewById(R.id.emailasker);
        EmailTV.setText(Email);

        TextView TelTV =  dialog.findViewById(R.id.telasker);
        TelTV.setText(Tel);


        TextView facebookTV = dialog.findViewById(R.id.facebookAsker);
        facebookTV.setText(facebookURL);


        Button ajouterContact = dialog.findViewById(R.id.callasker);
        ajouterContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        Button FermerFialog = (Button) dialog.findViewById(R.id.fermer);
        FermerFialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

}