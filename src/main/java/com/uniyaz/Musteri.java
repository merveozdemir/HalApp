package com.uniyaz;

import java.io.Serializable;
import java.util.Objects;

public class Musteri implements Serializable {
    private String adi;
    private String soyadi;
    private int musteriId;
    static int idCounter;

    public Musteri(String adi, String soyadi) {
        this.adi = adi;
        this.soyadi = soyadi;
        idCounter++;
        this.musteriId = idCounter;
    }

    public String getAdi() {
        return adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public int getMusteriId() {
        return musteriId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musteri musteri = (Musteri) o;
        return musteriId == musteri.musteriId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(musteriId);
    }

    @Override
    public String toString() {
        return musteriId + " \t " + adi + "\t" + soyadi + "\t";
    }
}
