package com.production.achour_ar.qrevent;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class DetailsInputActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameET;
    private EditText firstnameET;
    private EditText telnumberET;
    private EditText fbET;
    private ImageView profilePicIV;
    private TextView changePicTV;
    private Button startEventButton;
    private String picturePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_input_act);

        initVieww();

    }

    private void initVieww() {
        nameET = findViewById(R.id.input_name);
        firstnameET = findViewById(R.id.input_firstname);
        telnumberET = findViewById(R.id.input_telephone);
        fbET = findViewById(R.id.input_facebook);
        profilePicIV = findViewById(R.id.picprofileinput);
        changePicTV = findViewById(R.id.changepictv);
        startEventButton = findViewById(R.id.starteventbutton);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.changepictv:
                changePic();
                break;
            case R.id.starteventbutton:
                startEvent();
                break;
        }
    }

    private void startEvent() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.PICK_IMAGE) {
            if(resultCode == Activity.RESULT_OK){
                picturePath = data.getStringExtra(Constants.PicturePath);
                performCrop(picturePath);
            }
        }

        if (requestCode == Constants.RESULT_CROP) {
            if(resultCode == Activity.RESULT_OK){
                Bundle extras ;
                Bitmap selectedBitmap = null;

                if(!(data.getExtras()==null)){
                    try {
                        extras = data.getExtras();
                        selectedBitmap = extras.getParcelable("data");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        selectedBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                // Set The Bitmap Data To ImageView
                //profilPicIV.setImageBitmap(selectedBitmap);
                setProfilePicToImageView(profilePicIV, selectedBitmap);
                profilePicIV.setScaleType(ImageView.ScaleType.FIT_XY);

                //String pathToPic = saveToInternalStorage(selectedBitmap);

            }
        }

    }

    private void setProfilePicToImageView(ImageView profilePicIV, Bitmap selectedBitmap) {
        profilePicIV.setImageBitmap(selectedBitmap);
        Log.d("PROFILE PIC", "setProfilePicToImageView: I'M ADJUSTING BRO");
        profilePicIV.setAdjustViewBounds(true);
        profilePicIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void performCrop(String picturePath) {
        try {
            //Start Crop Activity
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            // indicate image type and Uri
            File f = new File(picturePath);
            Uri contentUri = Uri.fromFile(f);

            cropIntent.setDataAndType(contentUri, "image/*");
            // set crop properties
            cropIntent.putExtra("crop", "true");
            // indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            // indicate output X and Y
            cropIntent.putExtra("outputX", 300);
            cropIntent.putExtra("outputY", 300);

            // retrieve data on return
            cropIntent.putExtra("return-data", true);
            // start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, Constants.RESULT_CROP);
        }
        // respond to users whose devices do not support the crop action
        catch (ActivityNotFoundException anfe) {
            // display an error message
            String errorMessage = "your device doesn't support the crop action!";
            Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void changePic() {
        Intent gallery = new Intent(getApplicationContext(), GalleryUtil.class);
        startActivityForResult(gallery, Constants.PICK_IMAGE);
    }
}
