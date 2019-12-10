package com.uniyaz;

import java.util.*;

import static java.util.Collections.max;

/**
 * Hello world!
 */
public class HalApp {

    static Map<Integer, Personel> personelMap = new HashMap<>();
    static Map<Integer, Musteri> musteriMap = new HashMap<>();

    static Urun urun = null;
    static Personel personel = null;
    static EnumMiktarTuru urunMiktarTuru = null;
    static float urunMiktar = 0;

    public static void main(String[] args) {
        StokTakip stokTakip = new StokTakip();
        SatisTakip satisTakip = new SatisTakip();

        stokTakip.stokListesi = Veritabani.stokBilgileriniDosyadanAl();
        satisTakip.satisListesi = Veritabani.satisBilgileriniDosyadanAl();
        List<Personel> personelList = Veritabani.personelleriDosyadanAl();
        List<Musteri> musteriList = Veritabani.musterileriDosyadanAl();

        for (Personel personel : personelList) {
            personelMap.put(personel.getPersonelId(), personel);
        }
        for (Musteri musteri : musteriList) {
            musteriMap.put(musteri.getMusteriId(), musteri);
        }

        System.out.println("\033[1m-----------HAL STOK TAKİP UYGULAMASI-----------\033[0m");
        tumPersonelGoruntule();
        tumMusteriGoruntule();

        boolean programCalisiyor = true;
        Scanner scanner = new Scanner(System.in);
        while (programCalisiyor) {
            System.out.println("*************************************");
            System.out.println("\033[1mYapmak istediğiniz işlemi seçiniz:");
            System.out.println("1. Stok oluştur");
            System.out.println("2. Stok görüntüle");
            System.out.println("3. Stok maliyet hesapla");
            System.out.println("4. Satış Yap");
            System.out.println("5. Satış Görüntüle");
            System.out.println("6. Yeni Personel Ekle");
            System.out.println("7. Yeni Müşteri Ekle");
            System.out.println("0. Çıkış");
            System.out.println("************************************* \033[0m");

            int menuSecim = scanner.nextInt();
            scanner.nextLine();
            switch (menuSecim) {

                case 1: // stok olustur
                    kullanicidanVeriAl(scanner);
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
                        Personel secilenPersonel = personelMap.get(secilenPersonelId);
                        stokTakip.alinanStokGoruntule(secilenPersonel);
                    }

                    break;
                case 3: //stok maliyet hesapla
                    stokTakip.stokMaliyetHesapla();
                    break;
                case 4: //satış yap
                    kullanicidanVeriAl(scanner);
                    System.out.println("Satış yapılan müşteri id'sini giriniz: ");
                    int musteriId = scanner.nextInt();
                    Musteri musteri = musteriMap.get(musteriId);

                    satisTakip.satisYap(urun, urunMiktar, urunMiktarTuru, personel, musteri);
                    break;
                case 5: //satis listesi görüntüle
                    satisTakip.satisListesiGoruntule();
                    break;
                case 6: //yeni personel ekle
                    System.out.println("Eklemek istediğiniz personelin adını giriniz: ");
                    String personelAdi = scanner.nextLine();

                    System.out.println("Eklemek istediğiniz personelin soyadını giriniz: \"");
                    String personelSoyadi = scanner.nextLine();

                    if (!personelMap.isEmpty()){
                        Personel.idCounter = max(personelMap.keySet());
                    }
                    Personel yeniPersonel = new Personel(personelAdi,personelSoyadi);
                    personelMap.put(yeniPersonel.getPersonelId(), yeniPersonel);
                    personelList.add(yeniPersonel);
                    Veritabani.personelVeritabaniOlustur(personelList);
                    tumPersonelGoruntule();
                    break;
                case 7: //yeni musteri ekle
                    System.out.println("Eklemek istediğiniz müşterinin adını giriniz: ");
                    String musteriAdi = scanner.nextLine();

                    System.out.println("Eklemek istediğiniz müşterinin soyadını giriniz: \"");
                    String musteriSoyadi = scanner.nextLine();

                    if (!musteriMap.isEmpty()){
                        Musteri.idCounter = max(musteriMap.keySet());
                    }
                    Musteri yeniMusteri = new Musteri(musteriAdi,musteriSoyadi);
                    musteriMap.put(yeniMusteri.getMusteriId(), yeniMusteri);
                    musteriList.add(yeniMusteri);
                    Veritabani.musteriVeritabaniOlustur(musteriList);
                    tumMusteriGoruntule();
                    break;
                case 0:
                    programCalisiyor = false;
                    System.out.println("Çıkış...");
                    break;
            }
        }
    }

    private static void tumMusteriGoruntule() {
        System.out.println("\033[1m Müşteriler \033[0m");
        List<Musteri> dosyadanOkunanMusteriler = Veritabani.musterileriDosyadanAl();
        for (Musteri musteri : dosyadanOkunanMusteriler) {
            System.out.println(musteri.toString());
        }
        System.out.println("-------------------------------------");

    }

    private static void tumPersonelGoruntule() {
        System.out.println("\033[1m Personeller \033[0m");
        List<Personel> dosyadanOkunanPersoneller = Veritabani.personelleriDosyadanAl();
        for (Personel personel : dosyadanOkunanPersoneller) {
            System.out.println(personel.toString());
        }
        System.out.println("-------------------------------------");

    }

    private static void kullanicidanVeriAl(Scanner scanner) {
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
        personel = personelMap.get(personelId);


    }
}

