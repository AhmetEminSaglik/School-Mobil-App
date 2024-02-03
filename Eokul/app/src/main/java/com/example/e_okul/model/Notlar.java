package com.example.e_okul.model;

public class Notlar extends User {
    private String  vize;
    private String _final;
    private String dersAdi;


    public String getVize() {
        return vize;
    }

    public void setVize(String vize) {
        this.vize = vize;
    }

    public String get_final() {
        return _final;
    }

    public void set_final(String _final) {
        this._final = _final;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }
}
