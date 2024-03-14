package com.berkhayta;

public abstract class Personel {
    private String ad;
    private String soyad;
    private int calismaSaati;
    private double saatlikUcret;

    public Personel(String ad, String soyad, int calismaSaati, double saatlikUcret) {
        this.ad = ad;
        this.soyad = soyad;
        this.calismaSaati = calismaSaati;
        this.saatlikUcret = saatlikUcret;
    }

    public abstract double maasHesapla();

    public double getSaatlikUcret() {
        return saatlikUcret;
    }

    public void setSaatlikUcret(double saatlikUcret) {
        this.saatlikUcret = saatlikUcret;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public int getCalismaSaati() {
        return calismaSaati;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public void setCalismaSaati(int calismaSaati) {
        this.calismaSaati = calismaSaati;
    }
}