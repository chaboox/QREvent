package com.production.achour_ar.qrevent;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class FirebaseManager {
    public void addInfoToFirebase(final String lastName, final String firstName, final String phoneNumber, final String linkFacebook, final String email, final Bitmap bitmap) {


        final DatabaseReference usersReference = FirebaseDatabase.getInstance().getReference().child("users");

        //Query referenceUser = usersReference.orderByKey().limitToLast(1);

        usersReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int key = 0;
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    if(child.child("email").getValue().equals(email))
                        child.child("lastName").getRef().setValue(lastName);
                        child.child("firstName").getRef().setValue(firstName);
                        child.child("number").getRef().setValue(phoneNumber);
                        child.child("facebookLink").getRef().setValue(linkFacebook);
                }

                //get new id
                final DatabaseReference UserRef = usersReference.child(String.valueOf(key));

                UserRef.child("lastName").setValue(lastName);
                UserRef.child("firstName").setValue(firstName);
                UserRef.child("number").setValue(phoneNumber);
                UserRef.child("facebookLink").setValue(linkFacebook);


                if (bitmap != null) {
                    String imageUrl ="image/" + lastName;
                    StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
                    final StorageReference ref = mStorageRef.child(imageUrl);
                    UserRef.child("imageUrl").setValue(imageUrl);


                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 50, baos);
                    byte[] data = baos.toByteArray();

                    UploadTask uploadTask = ref.putBytes(data);
                    Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                        @Override
                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                            if (!task.isSuccessful()) {
                                throw task.getException();
                            }

                            // Continue with the task to get the download URL
                            return ref.getDownloadUrl();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()) {
                                Uri downloadUri = task.getResult();
                                Log.d("URLL", "onComplete: "+ downloadUri);
                                UserRef.child("imageUrl").setValue(downloadUri.toString());
                            } else {
                                // Handle failures

                                // ...
                            }
                        }
                    });





                } else {
                    UserRef.child("imageUrl").setValue("null");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void AddToContacteAndShowPopUp(final String barcode){
        final DatabaseReference usersReference = FirebaseDatabase.getInstance().getReference().child("users");

        //Query referenceUser = usersReference.orderByKey().limitToLast(1);

        usersReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int key = 0;
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    if(child.child("email").getValue().equals(barcode)){
                     //TODO add To contacte and show pop up

                }
                }
    } @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
});
}}
