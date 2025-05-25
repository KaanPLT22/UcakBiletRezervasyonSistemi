# Uçak Bilet Rezervasyon Sistemi

## Proje Hakkında

Uçak Bilet Rezervasyon Sistemi, Uçak ekleme listeleme , Lokasyon ekleme ve listeleme , Uçuş ekleme ve listeleme , Rezervasyon yaptırma (Koşullu) ve listeleme işlemlerini kolayca yönetebilmenizi sağlayan bir Java OOP projesidir. Menüden seçim yaparak kolayca uçak ve lokasyon ekleme, uçuş atama, rezervasyon yapma ve kayıtlı verileri listeleme gibi işlemleri gerçekleştirebilirsiniz.

Tüm veriler program içerisinde dizilerde saklanmakta ve JSON dosyalarına kaydedilerek kalıcı hale getirilmektedir.


## Özellikler

- **Uçak Ekleme:** Yeni uçak bilgileri alınarak array ve JSON dosyalarına kaydeder.
- **Lokasyon Ekleme:** Ülke , Şehir , Havalimanı ve Aktif olup olmadığı bilgileri alınarak array ve JSON dosyalarına kaydeder.
- **Uçuş Ekleme :** Uçak ve lokasyon bilgilerini datadan çekerek ve tarih saat gibi bilgileri alarak uçuş atama görevini gerçekleştirir. Array ve JSON dosyalarına kaydeder.
- **Rezervasyon Yapma (Koşullu):** Rezervasyon yapılacak uçak seçildikten sonra kullanıcıdan Ad Soyad Yaş gibi bilgileri alır ve rezervasyon işlemini gerçekleştirir. Array ve JSON dosyalarına kaydeder.
- **Veri Listeleme:** Uçaklar, lokasyonlar, uçuşlar ve rezervasyonlar listelenebilir.
- **Kalıcı Veri:** İşlemler JSON formatında dosyalara kaydedilir.

---

## 🗂️ Projenin Dosya Yapısı

```
UcakBiletRezervasyonSistemi/src/
│
├── Main.java                   → Uygulamanın giriş noktasıdır. Ana menü burada sunulur.
│
├── models/                    → Veri yapıları ve temel sınıflar
│   ├── Airplane.java           → Uçak bilgilerini tutar (model, marka, ID, koltuk kapasitesi).
│   ├── Location.java           → Lokasyon bilgilerini içerir (ülke, şehir, havaalanı, aktif/pasif durumu).
│   ├── Flight.java             → Uçuş bilgilerini içerir (kalkış ve varış lokasyonu, kalkış saati, uçak, dolu koltuk sayısı).
│   └── Reservation.java        → Yolcu rezervasyonu bilgilerini tutar (uçuş, yolcu adı, soyadı, yaşı).
│
├── services/                  → İş mantığını içeren servis katmanı
│   ├── JsonDosyaIslemleri.java → JSON dosyalarına veri kaydetme işlemlerini yapar.
│   └── ReservationService.java → Rezervasyon oluşturma ve listeleme işlemlerini yürütür.
│
└── data/                      → JSON veri dosyalarının saklandığı klasör
    ├── ucaklar.json
    ├── lokasyonlar.json
    ├── ucuslar.json
    └── rezervasyonlar.json
```




## Teknik Detaylar

- Java dili kullanılarak geliştirilmiştir.
- Veri saklama için diziler (array) ve JSON dosyaları kullanılmıştır.
- Konsol tabanlı menü sistemi ile kullanıcı etkileşimi sağlanır.
- Her ana işlem için ayrı metodlar tanımlanmıştır:

---
