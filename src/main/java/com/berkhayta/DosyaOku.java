package com.berkhayta;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DosyaOku {
    public static List<Personel> personelListesiniOku(String dosyaYolu) {
        List<Personel> personelListesi = new ArrayList<>();

        try {
            JsonParser jsonParser = new JsonParser(); //json verisini ayrıştırmak için JsonParser kullanıyoruz.
            JsonArray personelJsonArray = (JsonArray) jsonParser.parse(new FileReader(dosyaYolu)); // dosyadan okunan veriyi parse ederek JsonArray nesnesine dönüştürüyoruz.

            for (int i = 0; i < personelJsonArray.size(); i++) {
                JsonObject personelJson = (JsonObject) personelJsonArray.get(i);
                String role = personelJson.get("role").getAsString(); //role göre ilgili sınıflardan nesne oluşturup daha sonra nesneyi personelListesi Listesine ekliyoruz
                if (role.equals("Yonetici")) {
                    Yonetici yonetici = new Yonetici(
                            personelJson.get("name").getAsString(),
                            personelJson.get("surname").getAsString(),
                            personelJson.get("calismaSaati").getAsInt(),
                            personelJson.get("saatlikUcret").getAsDouble(),
                            personelJson.get("bonus").getAsDouble()
                    );
                    personelListesi.add(yonetici);
                } else if (role.equals("Memur")) {
                    Memur memur = new Memur(
                            personelJson.get("name").getAsString(),
                            personelJson.get("surname").getAsString(),
                            personelJson.get("calismaSaati").getAsInt(),
                            personelJson.get("saatlikUcret").getAsDouble(),
                            Derece.valueOf(personelJson.get("derece").getAsString())
                    );
                    personelListesi.add(memur);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personelListesi;
    }
}
