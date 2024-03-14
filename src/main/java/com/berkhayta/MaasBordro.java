package com.berkhayta;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class MaasBordro {
    private String ay;
    private List<Personel> personeller;

    public MaasBordro(String ay) {
        this.ay = ay;
        personeller = new ArrayList<>();
    }

    public void personelEkle(Personel personel) {
        personeller.add(personel);
    }
    public void maaslariHesaplaVeKaydet() {
        for (Personel personel : personeller) {
            double maas = personel.maasHesapla();
            double anaOdeme = personel.getCalismaSaati() <= 180 ? maas : 180 * personel.getSaatlikUcret(); // Çalışma saati 180'den az ise maaşı hesaplıyoruz
            double mesai = personel.getCalismaSaati() <= 180 ? 0 : (personel.getCalismaSaati() - 180) * personel.getSaatlikUcret() * 1.5; // 180 den büyükse mesai ücreti ekliyoruz
            double toplamOdeme = anaOdeme + mesai;
            kaydet(personel, anaOdeme, mesai, toplamOdeme);
        }
    }

    private void kaydet(Personel personel, double anaOdeme, double mesai, double toplamOdeme) { //İstenen formatta bilgileri personel e özel dosyalara yazdırıyoruz.
        String dosyaAdi = personel.getAd() + "_" + personel.getSoyad() + "_maas.json";
        try (FileWriter writer = new FileWriter(dosyaAdi)) {
            writer.write("{\n");
            writer.write("  \"bordro\": \"" + ay + "\",\n");
            writer.write("  \"personel\": {\n");
            writer.write("    \"ismi\": \"" + personel.getAd() + "\",\n");
            writer.write("    \"calismaSaati\": " + personel.getCalismaSaati() + ",\n");
            writer.write("    \"odemeDetaylari\": {\n");
            writer.write("      \"anaOdeme\": \"" + String.format("₺%.2f", anaOdeme) + "\",\n");
            writer.write("      \"mesai\": \"" + String.format("₺%.2f", mesai) + "\",\n");
            writer.write("      \"toplamOdeme\": \"" + String.format("₺%.2f", toplamOdeme) + "\"\n");
            writer.write("    }\n");
            writer.write("  }\n");
            writer.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void raporGoruntule() {
        for (Personel personel : personeller) {
            if (personel.getCalismaSaati() < 150) {
                System.out.println(personel.getAd() + " " + personel.getSoyad() + " az çalıştı!");
            }
        }
    }
}