package com.uniyaz;

public class Satis extends Islem{
    private Musteri satisYapilanMusteri;

    public Satis(Personel islemiYapanPersonel, Urun islemiYapilanUrun, float urunMiktari, EnumMiktarTuru urunMiktarTuru, Musteri satisYapilanMusteri) {
        super(islemiYapanPersonel, islemiYapilanUrun, urunMiktari, urunMiktarTuru);
        this.satisYapilanMusteri = satisYapilanMusteri;
    }

    public Musteri getSatisYapilanMusteri() {
        return satisYapilanMusteri;
    }
}

