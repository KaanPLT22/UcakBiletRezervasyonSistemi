Uçak Bilet Rezervasyon Sistemi
Proje Hakkında
Bu proje, uçak bileti rezervasyonu işlemlerini gerçekleştiren temel bir sistemdir. Java diliyle geliştirilmiş olup, uçak, lokasyon, uçuş ve rezervasyon işlemlerini yönetmektedir.

Sistem; uçak ve lokasyon ekleme, uçuş atama, rezervasyon yapma ve kayıtlı verileri listeleme gibi işlevleri desteklemektedir. Tüm veriler program içerisinde dizilerde tutulur ve JSON formatında dosyalara kaydedilerek kalıcı hale getirilir.

Özellikler
Uçak Ekleme: Sisteme yeni uçak bilgileri eklenebilir.

Lokasyon Ekleme: Yeni kalkış ve varış noktaları (şehir veya havaalanı) tanımlanabilir.

Uçuş Atama: Tanımlanan uçak ve lokasyon bilgileri kullanılarak uçuşlar oluşturulabilir.

Rezervasyon Yapma: Var olan uçuşlara yolcular için rezervasyon yapılabilir.

Listeleme: Kayıtlı uçaklar, lokasyonlar, uçuşlar ve rezervasyonlar ayrı ayrı listelenebilir.

Veri Kaydetme: Tüm işlemler JSON formatında dosyaya kaydedilir ve program yeniden başlatıldığında dosyadan yüklenir.

Kod Açıklaması
Veri Yapıları: Uçak, lokasyon, uçuş ve rezervasyon verileri ayrı diziler (array) içerisinde tutulur.

Veri Kaydetme: JSON formatındaki dosya okuma ve yazma işlemleriyle kalıcılık sağlanır.

Ana Menü: Kullanıcı işlemlerini seçebileceği konsol tabanlı bir menü ile yönlendirilir.

İşlem Fonksiyonları:

UcakEkle(): Yeni uçak bilgisi alıp diziye kaydeder.

LokasyonEkle(): Yeni lokasyon bilgisi ekler.

UcusAtama(): Uçak ve lokasyonlar üzerinden uçuş oluşturur.

RezervasyonYap(): Var olan uçuşlara yolcu için rezervasyon kaydeder.

Listele(): Uçak, lokasyon, uçuş ve rezervasyon verilerini ekrana yazdırır.

Do-While Döngüsü: Kullanıcıdan sürekli işlem seçmesi istenir ve seçilen işlemi çalıştırır.
