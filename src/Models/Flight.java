package Models;

import java.time.LocalDateTime;

public class Flight {
    private Location kalkisLokasyonu;
    private Location varisLokasyonu;
    private LocalDateTime kalkisSaati;
    private Airplane ucak;
    private int doluKoltukSayisi;

    public Flight(Location kalkisLokasyonu, Location varisLokasyonu, LocalDateTime kalkisSaati, Airplane ucak) {
        this.kalkisLokasyonu = kalkisLokasyonu;
        this.varisLokasyonu = varisLokasyonu;
        this.kalkisSaati = kalkisSaati;
        this.ucak = ucak;
        this.doluKoltukSayisi = 0;
    }

    public Location getKalkisLokasyonu() {
        return kalkisLokasyonu;
    }

    public Location getVarisLokasyonu() {
        return varisLokasyonu;
    }

    public LocalDateTime getKalkisSaati() {
        return kalkisSaati;
    }

    public Airplane getUcak() {
        return ucak;
    }

    public int getBosKoltukSayisi() {
        return ucak.getKoltukKapasitesi() - doluKoltukSayisi;
    }

    public boolean koltukVarMi() {
        return getBosKoltukSayisi() > 0;
    }

    public boolean rezervasyonYap() {
        if (koltukVarMi()) {
            doluKoltukSayisi++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Uçuş: " + kalkisLokasyonu + " -> " + varisLokasyonu + " | Kalkış: " + kalkisSaati +
                " | Uçak: " + ucak + " | Boş Koltuk: " + getBosKoltukSayisi();
    }
}
