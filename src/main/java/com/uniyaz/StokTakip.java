package com.uniyaz;

import java.util.ArrayList;
import java.util.List;

public class StokTakip {

    public static List<Stok> stokListesi;

    public StokTakip() {
        stokListesi = new ArrayList<>();
    }

    void stokOLustur(Urun stokYapilanUrun, float urunMiktar, EnumMiktarTuru miktarTuru, Personel stokYapanPersonel) {
        Stok stok = new Stok(stokYapanPersonel, stokYapilanUrun, urunMiktar, miktarTuru);
        this.stokListesi.add(stok);
        Veritabani.stokVeritabaniOlustur(stokListesi);
    }


    void alinanStokGoruntule(String urunAdi) {
        System.out.println("Ürün Adı     |   " + urunAdi);
        System.out.println("------------------------------------------------------------");
        List<Stok> stokList = Veritabani.stokBilgileriniDosyadanAl();
        for (Stok stok : stokList) {
            if (stok.getIslemiYapilanUrun().getUrunAdi().equals(urunAdi)) {
                System.out.println(stok.getUrunMiktari() + " " + stok.getUrunMiktarTuru() + " " +
                        "   |  " + stok.getIslemiYapanPersonel().getAdi() + " " +
                        "" + stok.getIslemiYapanPersonel().getSoyadi());

            }

        }
        System.out.println("------------------------------------------------------------");
    }

    void alinanStokGoruntule(Personel stokYapanPersonel) {
        System.out.println("--- " + stokYapanPersonel.getAdi() + " " + stokYapanPersonel.getSoyadi() + " ---");
        List<Stok> stokList = Veritabani.stokBilgileriniDosyadanAl();
        for (Stok stok : stokList) {
            if (stok.getIslemiYapanPersonel().equals(stokYapanPersonel)) {
                System.out.println(stok.getIslemiYapilanUrun().getUrunAdi() + "   |   " + stok.getUrunMiktari() + " " + stok.getUrunMiktarTuru());
            }
        }

        System.out.println("------------------------------------------------------------------------------------------");

    }

    void alinanStokGoruntule() {
        System.out.println("Ürün Adı     |   Ürün Miktarı   |  Stok oluşturan Personel ");
        System.out.println("------------------------------------------------------------");
        try{
            List<Stok> stokList = Veritabani.stokBilgileriniDosyadanAl();
            for (Stok stok : stokList) {
                System.out.println(stok.getIslemiYapilanUrun().getUrunAdi() + "     |     " + stok.getUrunMiktari() + " " + stok.getUrunMiktarTuru() + " " +
                        "    |     " + "" + stok.getIslemiYapanPersonel().getAdi() + " " + stok.getIslemiYapanPersonel().getSoyadi());
            }
        }catch(NullPointerException e){
            System.out.println("Boş stok...");
        }
        System.out.println("----------------------------------------------------------------");




    }

    void stokMaliyetHesapla() {
        double toplamMaliyet = 0;
        double maliyet = 0;
        List<Stok> stokList = Veritabani.stokBilgileriniDosyadanAl();
        System.out.println("Ürün Adı     |   Ürün Miktarı   |  Stok maliyeti ");
        System.out.println("------------------------------------------------------------");
        for (Stok stok : stokList) {
            if (stok.getUrunMiktarTuru().equals(EnumMiktarTuru.KILO)) {
                maliyet = stok.getUrunMiktari() * stok.getIslemiYapilanUrun().getUrunKiloFiyati();
            } else if (stok.getUrunMiktarTuru().equals(EnumMiktarTuru.ADET)) {
                maliyet = stok.getUrunMiktari() * stok.getIslemiYapilanUrun().getUrunAdetFiyati();
            } else {
                maliyet = stok.getUrunMiktari() * stok.getIslemiYapilanUrun().getUrunKasaFiyati();
            }
            System.out.println(stok.getIslemiYapilanUrun().getUrunAdi() + "     |     " + stok.getUrunMiktari() + "" +
                    " " + stok.getUrunMiktarTuru() +  "    |     " + maliyet + "TL");
            toplamMaliyet += maliyet;
            maliyet=0;
        }
        System.out.println( "Toplam maliyet : " + toplamMaliyet );
    }


}



