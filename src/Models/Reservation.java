package Models;

public class Reservation {
    private Flight ucus;
    private String ad;
    private String soyad;
    private int yas;

    public Reservation(Flight ucus, String ad, String soyad, int yas) {
        this.ucus = ucus;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
    }

    public Flight getUcus() {
        return ucus;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public int getYas() {
        return yas;
    }

    @Override
    public String toString() {
        return "Rezervasyon - Yolcu: " + ad + " " + soyad + ", Yaş: " + yas + "\n" +
                "Uçuş Bilgisi: " + ucus;
    }
}
