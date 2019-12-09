package com.uniyaz;

public class Karpuz extends Meyve {


    @Override
    double getUrunKiloFiyati() {
        return 0.75;
    }

    @Override
    double getUrunAdetFiyati() {
        return 3.0;
    }

    @Override
    double getUrunKasaFiyati() {
        return 6.0;
    }

    @Override
    String getUrunAdi() {
        return "Karpuz";
    }
}
