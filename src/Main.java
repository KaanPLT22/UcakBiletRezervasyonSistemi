import Models.Airplane;
import Models.Location;
import Models.Flight;
import Models.Reservation;
import Services.JsonDosyaIslemleri;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {          // Arry Kısmı (Hepsi)
        List<Airplane> Ucaklar = new ArrayList<>();
        List<Location> Lokasyonlar = new ArrayList<>();
        List<Flight> Ucuslar = new ArrayList<>();
        List<Reservation> Reservation = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
                                                               // Main başlangıç
        while (true) {
            System.out.println("\n----- Uçuşlar -----");
            System.out.println("1. Uçak Ekle(Admin)");
            System.out.println("2. Lokasyon Ekle(Admin)");
            System.out.println("3. Uçuş Ekle");
            System.out.println("4. Rezervasyon Yap");
            System.out.println("5. Uçakları Listele");
            System.out.println("6. Lokasyonları Listele");
            System.out.println("7. Uçuşları Listele");
            System.out.println("8. Rezervasyon Listele");
            System.out.println("9. Çıkış Yap");

            System.out.print("Hangi İşlemi Yapmak İsitiyorsunuz: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // nextInt sonrası satır sonu temizleme




            if (secim == 1) {                                        // Uçak Ekleme Kısmı
                System.out.println("Uçak Modelini Giriniz: ");
                String Model = scanner.nextLine();

                System.out.println("Uçak Markasını Giriniz: ");
                String Marka = scanner.nextLine();

                System.out.println("Uçak Id Numarasını Giriniz: ");
                String Id = scanner.nextLine();

                System.out.print("Koltuk Kapasitesini Giriniz: ");
                int kapasite = scanner.nextInt();
                scanner.nextLine(); // nextInt sonrası satır sonu temizleme

                Airplane yeniUcak = new Airplane(Model, Marka, Id, kapasite);
                Ucaklar.add(yeniUcak);
                JsonDosyaIslemleri.ucaklariYaz(Ucaklar);                      // Data Kısmı Json Dosyaso

                System.out.println("Uçak başarıyla eklendi: " + yeniUcak);






            }
            else if (secim == 2) {                          // Lokasyon Ekleme Kısmı
                System.out.print("Ülke: ");
                String ulke = scanner.nextLine();

                System.out.print("Şehir: ");
                String sehir = scanner.nextLine();

                System.out.print("Havalimanı: ");
                String havalimani = scanner.nextLine();

                System.out.print("Aktif mi? (true/false): ");
                boolean aktif = scanner.nextBoolean();
                scanner.nextLine();

                Location yeniLokasyon = new Location(ulke, sehir, havalimani, aktif);
                Lokasyonlar.add(yeniLokasyon);
                JsonDosyaIslemleri.lokasyonlariYaz(Lokasyonlar);

                System.out.println("Lokasyon başarıyla eklendi!");
            }





            else if (secim == 3) {                                             // Uçuş Ekleme Bölümü
                if (Ucaklar.isEmpty() || Lokasyonlar.size() < 2) {
                    System.out.println("Önce en az 1 uçak ve 2 lokasyon eklemelisiniz!");
                    continue;
                }

                System.out.println("Uçaklar:");
                for (int i = 0; i < Ucaklar.size(); i++) {
                    System.out.println((i + 1) + ". " + Ucaklar.get(i));
                }

                System.out.print("Uçak seçiniz (numara): ");
                int ucakSecim = scanner.nextInt();
                scanner.nextLine();

                if (ucakSecim < 1 || ucakSecim > Ucaklar.size()) {
                    System.out.println("Geçersiz uçak seçimi! Lütfen listeden uygun numarayı seçiniz.");
                    continue;
                }

                System.out.println("Lokasyonlar:");
                for (int i = 0; i < Lokasyonlar.size(); i++) {
                    System.out.println((i + 1) + ". " + Lokasyonlar.get(i));
                }
                System.out.print("Kalkış lokasyonu seçiniz (numara): ");
                int kalkisSecim = scanner.nextInt();
                scanner.nextLine();

                if (kalkisSecim < 1 || kalkisSecim > Lokasyonlar.size()) {
                    System.out.println("Geçersiz kalkış lokasyonu seçimi! Lütfen listeden uygun numarayı seçiniz.");
                    continue;
                }

                System.out.print("Varış lokasyonu seçiniz (numara): ");
                int varisSecim = scanner.nextInt();
                scanner.nextLine();

                if (varisSecim < 1 || varisSecim > Lokasyonlar.size()) {
                    System.out.println("Geçersiz varış lokasyonu seçimi! Lütfen listeden uygun numarayı seçiniz.");
                    continue;
                }

                System.out.print("Kalkış tarihi ve saati (GG.AA.YYYY SS:mm): ");           // Tarih Bölümü
                String tarihSaatStr = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                LocalDateTime kalkisSaati;

                try {
                    kalkisSaati = LocalDateTime.parse(tarihSaatStr, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Hatalı tarih/saat formatı! Lütfen GG.AA.YYYY SS:mm formatında giriniz.");
                    continue;
                }

                Airplane secilenUcak = Ucaklar.get(ucakSecim - 1);
                Location kalkisLokasyon = Lokasyonlar.get(kalkisSecim - 1);
                Location varisLokasyon = Lokasyonlar.get(varisSecim - 1);

                Flight yeniUcus = new Flight(kalkisLokasyon, varisLokasyon, kalkisSaati, secilenUcak);
                Ucuslar.add(yeniUcus);
                JsonDosyaIslemleri.ucuslariYaz(Ucuslar);
                System.out.println("Uçuş başarıyla eklendi!");
            }





            else if (secim == 4) {                                      // Uçuş Sıralama
                if (Ucuslar.isEmpty()) {
                    System.out.println("Öncelikle uçuş eklemelisiniz!");
                    continue;
                }

                System.out.println("Mevcut Uçuşlar:");
                for (int i = 0; i < Ucuslar.size(); i++) {
                    System.out.println((i + 1) + ". " + Ucuslar.get(i));
                }
                System.out.print("Rezervasyon yapmak istediğiniz uçuşu seçiniz (numara): ");
                int ucusSecim = scanner.nextInt();
                scanner.nextLine(); // satır sonu temizleme

                if (ucusSecim < 1 || ucusSecim > Ucuslar.size()) {
                    System.out.println("Geçersiz uçuş seçimi!");
                    continue;
                }

                System.out.print("Adınızı giriniz: ");
                String ad = scanner.nextLine();

                System.out.print("Soyadınızı giriniz: ");
                String soyad = scanner.nextLine();

                System.out.print("Yaşınızı giriniz: ");
                int yas = scanner.nextInt();
                scanner.nextLine();

                Flight secilenUcus = Ucuslar.get(ucusSecim - 1);

                boolean rezervasyonBasarili = secilenUcus.rezervasyonYap();

                if (rezervasyonBasarili) {                // Rezervasyon Kısmı
                    Reservation yeniRezervasyon = new Reservation(secilenUcus, ad, soyad, yas);

                    System.out.println("Rezervasyon başarıyla yapıldı! Yolcu: " + ad + " " + soyad);
                    // JsonDosyaIslemleri.rezervasyonYaz metodu parametreleri ad, soyad, yas, seçilen uçuş olmalı:
                    JsonDosyaIslemleri.rezervasyonYaz(ad, soyad, yas, secilenUcus );
                    Reservation.add(yeniRezervasyon);
                } else {
                    System.out.println("Üzgünüz, bu uçuşta boş koltuk kalmamıştır.");
                }
            }






            else if (secim == 5) {                                          // Ucakları Sıralama
                if (Ucaklar.isEmpty()) {
                    System.out.println("Henüz hiç uçuş eklenmedi.");
                } else {
                    for (int i = 0; i < Ucaklar.size(); i++) {
                        System.out.println((i + 1) + ". " + Ucaklar.get(i));
                    }
                }
            }





            else if (secim == 6) {                                         // Lokasyon Sıralama
                if (Lokasyonlar.isEmpty()) {
                    System.out.println("Henüz hiç lokasyon eklenmedi.");
                } else {
                    for (int i = 0; i < Lokasyonlar.size(); i++) {
                        System.out.println((i + 1) + ". " + Lokasyonlar.get(i));
                    }
                }
            }





            else if (secim == 7) {                                      // Uçuşları Sıralama
                if (Ucuslar.isEmpty()) {
                    System.out.println("Henüz hiç uçak eklenmedi.");
                } else {
                    for (int i = 0; i < Ucuslar.size(); i++) {
                        System.out.println((i + 1) + ". " + Ucuslar.get(i));
                    }
                }
            }





            else if (secim == 8) {                                  // Rezarvasyon Sıralama
                if (Reservation.isEmpty()) {
                    System.out.println("Henüz hiç rezervasyon yapılmadı.");
                } else {
                    for (int i = 0; i < Reservation.size(); i++) {
                        System.out.println((i + 1) + ". " + Reservation.get(i));
                    }
                }
            }



            else if (secim == 9) {
                System.out.println("Programdan çıkılıyor. İyi günler!");
                break;
            }
            else {
                System.out.println("Geçersiz seçim! Lütfen 1 ile 9 arasında bir sayı giriniz.");
            }
        }
        scanner.close();
    }
}
