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
    }


    void alinanStokGoruntule(String urunAdi) {
        System.out.println("Ürün Adı     |   " + urunAdi);
        System.out.println("------------------------------------------------------------");
        for (Stok stok : stokListesi) {
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
        for (Stok stok : stokListesi) {
            if (stok.getIslemiYapanPersonel().equals(stokYapanPersonel)) {
                System.out.println(stok.getIslemiYapilanUrun().getUrunAdi() + "   |   " + stok.getUrunMiktari() + " " + stok.getUrunMiktarTuru());
            }
        }

    }

    void alinanStokGoruntule() {
        System.out.println("Ürün Adı     |   Ürün Miktarı   |  Stok oluşturan Personel ");
        System.out.println("------------------------------------------------------------");
        for (Stok stok : stokListesi) {
            System.out.println(stok.getIslemiYapilanUrun().getUrunAdi() + "     |     " + stok.getUrunMiktari() + " " + stok.getUrunMiktarTuru() + " " +
                    "    |     " +
                    "" + stok.getIslemiYapanPersonel().getAdi() + " " + stok.getIslemiYapanPersonel().getSoyadi());
        }

    }

    void stokMaliyetHesapla() {
        double toplamMaliyet = 0;
        double maliyet = 0;
        System.out.println("Ürün Adı     |   Ürün Miktarı   |  Stok oluşturan Personel ");
        System.out.println("------------------------------------------------------------");
        for (Stok stok : stokListesi) {
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



