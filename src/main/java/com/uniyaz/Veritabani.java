package com.uniyaz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Veritabani {
    static List<Personel> personelList;
    static List<Musteri> musteriList;
    static List<Stok> stokList;
    static List<Satis> satisList;

    static void personelVeritabaniOlustur(List<Personel> personelList) {
        File file = new File(".\\Veritabani\\personelListesi.txt");
        try (FileOutputStream fileOut = new FileOutputStream(file, false);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(personelList);
            objectOut.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void musteriVeritabaniOlustur(List<Musteri> musteriList) {
        File file = new File(".\\Veritabani\\\\musteriListesi.txt");
        try (FileOutputStream fileOut = new FileOutputStream(file, false);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(musteriList);
            objectOut.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void stokVeritabaniOlustur(List<Stok> stokList) {
        File file = new File(".\\Veritabani\\stokListesi.txt");
        try (FileOutputStream fileOut = new FileOutputStream(file, false);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(stokList);
            objectOut.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void satisVeritabaniOlustur(List<Satis> satisList) {
        File file = new File(".\\Veritabani\\satisListesi.txt");
        try (FileOutputStream fileOut = new FileOutputStream(file, false);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(satisList);
            objectOut.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    static List<Personel> personelleriDosyadanAl() {
        File file = new File(".\\Veritabani\\personelListesi.txt");
        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            personelList = (List<Personel>) objectInput.readObject();
        } catch (Exception e) {
            System.out.println("Şu anda personel yoktur! ");
            personelList = new ArrayList<>();
        }
        return personelList;
    }


    static List<Musteri> musterileriDosyadanAl() {
        File file = new File(".\\Veritabani\\musteriListesi.txt");
        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            musteriList = (List<Musteri>) objectInput.readObject();

        } catch (Exception e) {
            System.out.println("Şu anda müşteri yoktur!");
            musteriList = new ArrayList<>();

        }
        return musteriList;
    }

    static List<Stok> stokBilgileriniDosyadanAl() {
        File file = new File(".\\Veritabani\\stokListesi.txt");
        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
             stokList = (List<Stok>) objectInput.readObject();

        } catch (Exception e) {
            System.out.println("Şu anda stoklar boştur!");
            stokList = new ArrayList<>();
        }

        return stokList;
    }


    static List<Satis> satisBilgileriniDosyadanAl() {
        File file = new File(".\\Veritabani\\satisListesi.txt");
        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            satisList = (List<Satis>) objectInput.readObject();

        } catch (Exception e) {
            System.out.println("Şu anda stoklar boştur!");
        }
        return satisList;
    }


}
