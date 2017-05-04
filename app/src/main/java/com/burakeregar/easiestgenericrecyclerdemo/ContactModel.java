package com.burakeregar.easiestgenericrecyclerdemo;

/**
 * Created by burak on 5.05.2017.
 */

public class ContactModel {
    String name, surname;

    public ContactModel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
