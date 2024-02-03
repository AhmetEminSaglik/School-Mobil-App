package com.example.e_okul.model;

public class Duyurular extends User {
    private String  duyuruBaslik;
    private String duyuruIcerik;


    public String getDuyuruBaslik() {
        return duyuruBaslik;
    }

    public void setDuyuruBaslik(String duyuruBaslik) {
        this.duyuruBaslik = duyuruBaslik;
    }

    public String getDuyuruIcerik() {
        return duyuruIcerik;
    }

    public void setDuyuruIcerik(String duyuruIcerik) {
        this.duyuruIcerik = duyuruIcerik;
    }
}
