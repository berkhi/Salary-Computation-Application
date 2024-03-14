package com.berkhayta;

public class Yonetici extends Personel {
    private double bonus;

    public Yonetici(String ad, String soyad, int calismaSaati, double saatlikUcret, double bonus) {
        super(ad, soyad, calismaSaati, saatlikUcret);
        this.bonus = bonus;
    }

    @Override //maasHesapla() metodu ortak olduğu için override ettik.
    public double maasHesapla() {
        return (getCalismaSaati() * Math.max(getSaatlikUcret(), 500) + bonus);
    }
}