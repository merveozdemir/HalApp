package com.uniyaz;

import java.io.Serializable;
import java.util.Objects;

public abstract class Urun implements Serializable {
    private int urunId;
    private double urunKiloFiyati;
    private double urunKasaFiyati;
    private double urunAdetFiyati;
    private static int idCounter;

    public Urun() {
        idCounter++;
        this.urunId = idCounter;
    }

    abstract double getUrunKiloFiyati();
    abstract double getUrunAdetFiyati();
    abstract double getUrunKasaFiyati();
    abstract String getUrunAdi();

    public int getUrunId() {
        return urunId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urun urun = (Urun) o;
        return getUrunAdi() == urun.getUrunAdi();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrunAdi());
    }


}
