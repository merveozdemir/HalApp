package com.uniyaz;

import java.util.ArrayList;
import java.util.List;

public class SatisTakip {
    public static List<Satis> satisListesi = new ArrayList<>();

    void satisYap(Urun gonderilecekUrun, float urunMiktari, EnumMiktarTuru urunMiktarTuru, Personel personel, Musteri musteri) {
        boolean stokVar = true;
        List<Stok> stokList = Veritabani.stokBilgileriniDosyadanAl();
        for (Stok stok : stokList) {
            if (stok.getIslemiYapilanUrun().equals(gonderilecekUrun) && stok.getIslemiYapanPersonel().equals(personel) && stok.getUrunMiktarTuru().equals(urunMiktarTuru)) {
                if (urunMiktari == stok.getUrunMiktari()) {
                    StokTakip.stokListesi.remove(stok);
                    break;
                } else if (urunMiktari < stok.getUrunMiktari()) {
                    float kalanMiktar = stok.getUrunMiktari() - urunMiktari;
                    stok.changeStokYapilanUrunMiktari(kalanMiktar);
                } else {
                    System.out.println(urunMiktari + " " + stok.getUrunMiktarTuru() + " kadar " + gonderilecekUrun.getUrunAdi() + " yoktur...");
                    stokVar = false;
                }
                break;
            }
        }
        if (stokVar) {
            Satis satis = new Satis(personel, gonderilecekUrun, urunMiktari, urunMiktarTuru, musteri);
            satisListesi.add(satis);
            Veritabani.satisVeritabaniOlustur(satisListesi);
            Veritabani.stokVeritabaniOlustur(stokList);

        }

    }


    void satisListesiGoruntule() {
        List<Satis> satisList = Veritabani.satisBilgileriniDosyadanAl();
        System.out.println("Ürün Adı     |   Ürün Miktarı   |  Satış oluşturan Personel    |   Satış yapılan Müşteri");
        System.out.println("------------------------------------------------------------------------------------------");
        for (Satis satis : satisList) {
            System.out.println(satis.getIslemiYapilanUrun().getUrunAdi() + "     |     " + satis.getUrunMiktari() + " " + satis.getUrunMiktarTuru() +
                    "        |        " + satis.getIslemiYapanPersonel().getAdi() + " " + satis.getIslemiYapanPersonel().getSoyadi() +
                    "     |    " + satis.getSatisYapilanMusteri().getAdi() + " " + satis.getSatisYapilanMusteri().getSoyadi());
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }

}
