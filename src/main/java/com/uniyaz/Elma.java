package com.uniyaz;


import java.io.Serializable;

public class Elma extends Meyve  {

    @Override
    double getUrunKiloFiyati() {
        return 4.0;
    }

    @Override
    double getUrunAdetFiyati() {
        return 0.6;
    }

    @Override
    double getUrunKasaFiyati() {
        return 20.0;
    }

    @Override
    String getUrunAdi() {
        return "Elma";
    }
}
