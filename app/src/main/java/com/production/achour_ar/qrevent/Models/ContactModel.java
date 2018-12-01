package com.production.achour_ar.qrevent.Models;

public class ContactModel {

    private String name;
    private String firstname;
    private String telphone;
    private String email;
    private String facebook;
    private String instagram;
    private String linkedin;
    private String urlpic;

    public ContactModel(String name, String firstname, String telphone, String email, String facebook, String instagram, String linkedin, String urlpic) {
        this.name = name;
        this.firstname = firstname;
        this.telphone = telphone;
        this.email = email;
        this.facebook = facebook;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.urlpic = urlpic;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getTelphone() {
        return telphone;
    }

    public String getEmail() {
        return email;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getLinkedin() {
        return linkedin;
    }
}
