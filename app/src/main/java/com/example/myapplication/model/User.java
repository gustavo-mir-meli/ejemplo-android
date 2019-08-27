package com.example.myapplication.model;

public class User {

    private String mail;
    private String nombre;

    public User(String mail, String nombre) {
        this.mail = mail;
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
