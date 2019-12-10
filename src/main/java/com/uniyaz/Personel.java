package com.uniyaz;

import java.io.Serializable;
import java.util.Objects;

public class Personel implements Serializable {
   private String adi;
   private String soyadi;
   private int personelId;
   static int idCounter;

    public Personel(String adi, String soyadi) {
        this.adi = adi;
        this.soyadi = soyadi;
        idCounter++;
        this.personelId= idCounter;
    }

    public String getAdi() {
        return adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public int getPersonelId() {
        return personelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personel personel = (Personel) o;
        return personelId == personel.personelId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personelId);
    }

    @Override
    public String toString() {
        return  personelId + " \t " + adi + "\t" + soyadi + "\t";
    }
}
