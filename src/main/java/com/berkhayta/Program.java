package com.berkhayta;

import java.util.List;

/**
 * personelBilgi.json dosyasının formatında değişiklik yaptım
 * eklenmesi kod yapısına daha uygun olduğunu düşündüğüm bazı parametreleri ekledim
 */

public class Program {
    public static void main(String[] args) {
        List<Personel> personelListesi = DosyaOku.personelListesiniOku("personelBilgi.json");
        MaasBordro maasBordro = new MaasBordro("SUBAT 2020");

        for (Personel personel : personelListesi) {
            maasBordro.personelEkle(personel);
        }

        maasBordro.maaslariHesaplaVeKaydet();
        maasBordro.raporGoruntule();


    }
}
