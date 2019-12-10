package com.uniyaz;

import java.io.Serializable;

public class Salatalik extends Sebze {

    @Override
    double getUrunKiloFiyati() {
        return 2.0;
    }

    @Override
    double getUrunAdetFiyati() {
        return 0.4;
    }

    @Override
    double getUrunKasaFiyati() {
        return 14.0;
    }

    @Override
    String getUrunAdi() {
        return "Salatalık";
    }
}
