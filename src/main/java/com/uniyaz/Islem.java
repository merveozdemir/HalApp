package com.uniyaz;

import java.io.Serializable;

public abstract class Islem implements Serializable {
    private Personel islemiYapanPersonel;
    private Urun islemiYapilanUrun;
    private float urunMiktari;
    private EnumMiktarTuru urunMiktarTuru;
    private int islemKodu;
    private static int islemKodCounter;

    public Islem(Personel islemiYapanPersonel, Urun islemiYapilanUrun, float urunMiktari, EnumMiktarTuru urunMiktarTuru) {
        this.islemiYapanPersonel = islemiYapanPersonel;
        this.islemiYapilanUrun = islemiYapilanUrun;
        this.urunMiktari = urunMiktari;
        this.urunMiktarTuru = urunMiktarTuru;
        islemKodCounter++;
        this.islemKodu = islemKodCounter;
    }

    public Personel getIslemiYapanPersonel() {
        return islemiYapanPersonel;
    }

    public Urun getIslemiYapilanUrun() {
        return islemiYapilanUrun;
    }

    public float getUrunMiktari() {
        return urunMiktari;
    }

    public EnumMiktarTuru getUrunMiktarTuru() {
        return urunMiktarTuru;
    }

    public void setUrunMiktari(float urunMiktari) {
        this.urunMiktari = urunMiktari;
    }
}
