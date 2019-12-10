package com.uniyaz;

import java.io.Serializable;

public class Stok extends Islem  {

    public Stok(Personel islemiYapanPersonel, Urun islemiYapilanUrun, float urunMiktari, EnumMiktarTuru urunMiktarTuru) {
        super(islemiYapanPersonel, islemiYapilanUrun, urunMiktari, urunMiktarTuru);
    }

    public void changeStokYapilanUrunMiktari(float kalanMiktar) {
        this.setUrunMiktari(kalanMiktar);
    }
}


