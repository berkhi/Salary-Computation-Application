package com.berkhayta;

import java.util.Date;

public class Memur extends Personel {
    private Derece derece;

    public Memur(String ad, String soyad, int calismaSaati, double saatlikUcret, Derece derece) {
        super(ad, soyad, calismaSaati, saatlikUcret);
        this.derece = derece;
    }
    @Override
    public double maasHesapla() {
        switch (derece) {
            case JUNIOR:
                setSaatlikUcret(500);
                break;
            case MID:
                setSaatlikUcret(600);
                break;
            case SENIOR:
                setSaatlikUcret(700);
                break;
            default:
                setSaatlikUcret(500); // Varsayılan 500 TL
                break;
        }

        double maas = 0;
        if (getCalismaSaati() <= 180) {
            maas = getCalismaSaati() * getSaatlikUcret(); //normal maaş
        } else {
            maas = (180 * getSaatlikUcret()) + ((getCalismaSaati() - 180) * getSaatlikUcret() * 1.5); //mesai ücretli hali
        }
        return maas;
    }
}