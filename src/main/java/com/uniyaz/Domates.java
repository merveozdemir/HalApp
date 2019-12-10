package com.uniyaz;

import java.io.Serializable;

public class Domates extends Sebze  {

    @Override
    double getUrunKiloFiyati() {
        return 1.0;
    }

    @Override
    double getUrunAdetFiyati() {
        return 0.3;
    }

    @Override
    double getUrunKasaFiyati() {
        return 5.0;
    }

    @Override
    String getUrunAdi() {
        return "Domates";
    }
}
