package com.production.achour_ar.qrevent;

import java.io.Serializable;

public class Personne implements Serializable {
    private String nom_prenom;
    private String email;
    private String facebook;
    private String insta;
    private String linkedin;
    private String pathImg;

    public Personne(String Name,String Mail, String Face, String Ins, String Link,String img){
            nom_prenom = Name;
            email = Mail;
            facebook = Face;
            insta = Ins;
            linkedin = Link;
            pathImg= img;


    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }
}
