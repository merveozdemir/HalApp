package com.uniyaz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 */
public class HalApp {

    static Map<Integer, Personel> personelListesi = new HashMap<>();
    static Map<Integer, Musteri> musteriListesi = new HashMap<>();


    public static void main(String[] args) {

        Personel personel1 = new Personel("Merve", "Özdemir");
        Personel personel2 = new Personel("Elif", "Kadim");
        Personel personel3 = new Personel("Ümmü", "Can");
        Personel personel4 = new Personel("Selin", "Daldaban");

        personelListesi.put(personel1.getPersonelId(), personel1);
        personelListesi.put(personel2.getPersonelId(), personel2);
        personelListesi.put(personel3.getPersonelId(), personel3);
        personelListesi.put(personel4.getPersonelId(), personel4);

        Musteri musteri1 = new Musteri("Ahmet", "Ak");
        Musteri musteri2 = new Musteri("Mehmet", "Yüce");
        Musteri musteri3 = new Musteri("Ayşe", "Kara");
        Musteri musteri4 = new Musteri("Derya", "Şahin");

        musteriListesi.put(musteri1.getMusteriId(), musteri1);
        musteriListesi.put(musteri2.getMusteriId(), musteri2);
        musteriListesi.put(musteri3.getMusteriId(), musteri3);
        musteriListesi.put(musteri4.getMusteriId(), musteri4);


        System.out.println("-----------HAL STOK TAKİP UYGULAMASI-----------");
        tumPersonelGoruntule();
        tumMusteriGoruntule();

        StokTakip stokTakip = new StokTakip();
        SatisTakip satisTakip = new SatisTakip();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
            System.out.println("1. Stok oluştur");
            System.out.println("2. Stok görüntüle");
            System.out.println("3. Stok maliyet hesapla");
            System.out.println("4. Satış Yap");

            int menuSecim = scanner.nextInt();
            scanner.nextLine();
            switch (menuSecim) {

                case 1: // stok olustur
                    Urun urun = null;
                    Personel personel = null;
                    EnumMiktarTuru urunMiktarTuru = null;
                    float urunMiktar = 0;
                    kullanicidanVeriAl(scanner,urun, personel, urunMiktarTuru, urunMiktar);
                    stokTakip.stokOLustur(urun, urunMiktar, urunMiktarTuru, personel);
                    break;
                case 2: //stok görüntüle
                    System.out.println("1. Tüm stokları görüntüle");
                    System.out.println("2. Ürüne göre stok görüntüle");
                    System.out.println("3. Personele göre stok görüntüle");
                    int goruntulemeSecim = scanner.nextInt();

                    if (goruntulemeSecim == 1) { //tüm stok listele
                        stokTakip.alinanStokGoruntule();
                    } else if (goruntulemeSecim == 2) { //ürüne göre stok listele
                        System.out.println("Lütfen ürünlerden birinin adını giriniz:");
                        System.out.println("1.Domates \n" +
                                "2.Salatalık \n" +
                                "3.Karpuz \n" +
                                "4.Elma");
                        int uruneGoreSecim = scanner.nextInt();
                        switch (uruneGoreSecim) { //urun secimi
                            case 1:
                                stokTakip.alinanStokGoruntule("Domates");
                                break;
                            case 2:
                                stokTakip.alinanStokGoruntule("Salatalık");
                                break;
                            case 3:
                                stokTakip.alinanStokGoruntule("Karpuz");
                                break;
                            case 4:
                                stokTakip.alinanStokGoruntule("Elma");
                                break;
                        }

                    } else if (goruntulemeSecim == 3) { //personele göre stok listele
                        tumPersonelGoruntule();
                        System.out.println("Seçmek istediğiniz personeli giriniz:");
                        int secilenPersonelId = scanner.nextInt();
                        Personel secilenPersonel = personelListesi.get(secilenPersonelId);
                        stokTakip.alinanStokGoruntule(secilenPersonel);
                    }

                    break;
                case 3: //stok maliyet hesapla
                    stokTakip.stokMaliyetHesapla();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + menuSecim);
                case 4: //satış yap
                    Urun urun2 = null;
                    Personel personel_2 = null;
                    EnumMiktarTuru urunMiktarTuru2 = null;
                    float urunMiktar2=0;
                    kullanicidanVeriAl(scanner,urun2,personel_2, urunMiktarTuru2,urunMiktar2);

                    System.out.println("Satış yapılan müşteri id'sini giriniz: ");
                    int musteriId = scanner.nextInt();
                    Musteri musteri = musteriListesi.get(musteriId);

                    satisTakip.satisYap(urun2, urunMiktar2, urunMiktarTuru2, personel_2, musteri);
                    break;
            }


        }

    }

    private static void tumMusteriGoruntule() {
        System.out.println("---Mevcut müşteriler---");
        for (Musteri musteri : musteriListesi.values()) {
            System.out.println(musteri.toString());
        }

    }

    private static void tumPersonelGoruntule() {
        System.out.println("---Mevcut personeller---");
        for (Personel personel : personelListesi.values()) {
            System.out.println(personel.toString());
        }
    }

    private static void kullanicidanVeriAl(Scanner scanner, Urun urun, Personel personel, EnumMiktarTuru urunMiktarTuru, float urunMiktar) {
        int urunSecim;
        int turSecim;
        System.out.println("Eklemek istediğiniz stok ürününü giriniz:\n" +
                "1.Domates \n" +
                "2.Salatalık \n" +
                "3.Karpuz \n" +
                "4.Elma");
        urunSecim = scanner.nextInt();
        switch (urunSecim) { //urun secimi
            case 1:
                urun = new Domates();
                break;
            case 2:
                urun = new Salatalik();
                break;
            case 3:
                urun = new Karpuz();
                break;
            case 4:
                urun = new Elma();
                break;
        }

        System.out.println("Ürün miktar türünü giriniz: ");
        System.out.println("1.Kilo");
        System.out.println("2.Adet");
        System.out.println("3.Kasa");
        turSecim = scanner.nextInt();
        switch (turSecim) { //tur secimi
            case 1:
                urunMiktarTuru = EnumMiktarTuru.KILO;
                break;
            case 2:
                urunMiktarTuru = EnumMiktarTuru.ADET;
                break;
            case 3:
                urunMiktarTuru = EnumMiktarTuru.KASA;
                break;
        }
        System.out.println("Ürün miktarını giriniz:");
        urunMiktar = scanner.nextFloat();

        System.out.println("Stoğu gerçekleştiren Personel id'sini giriniz: ");
        int personelId = scanner.nextInt();
        personel = personelListesi.get(personelId);

    }
}

