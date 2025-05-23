    package Services;

    import Models.*;
    import java.io.FileWriter;
    import java.util.List;

    public class JsonDosyaIslemleri {              // Bütün Json Kayıt İşlemlerinin İşleyişi Ve GÖrünüşü Buradan Yapılır

        public static void ucaklariYaz(List<Airplane> ucaklar) {

            try (FileWriter writer = new FileWriter("Data/ucaklar.json")) {
                writer.write("[\n");
                for (int i = 0; i < ucaklar.size(); i++) {
                    Airplane u = ucaklar.get(i);
                    writer.write("  {\n");
                    writer.write("    \"id\": " + u.getId() + ",\n");
                    writer.write("    \"model\": \"" + u.getModel() + "\",\n");
                    writer.write("    \"koltuk Kapasitesi\": " + u.getKoltukKapasitesi() + "\n");
                    writer.write("  }" + (i < ucaklar.size() - 1 ? "," : "") + "\n");
                }
                writer.write("]");
                System.out.println("✅ Uçaklar JSON'a yazıldı.");
            } catch (Exception e) {
                System.out.println("Hata (ucaklar): " + e.getMessage());
            }
        }

        public static void lokasyonlariYaz(List<Location> lokasyonlar) {
            try (FileWriter writer = new FileWriter("Data/lokasyonlar.json")) {
                writer.write("[\n");
                for (int i = 0; i < lokasyonlar.size(); i++) {
                    Location l = lokasyonlar.get(i);
                    writer.write("  {\n");
                    writer.write("    \"ülke\": " + l.getUlke() + ",\n");
                    writer.write("    \"sehir\": \"" + l.getSehir() + "\",\n");
                    writer.write("    \"havalimani\": \"" + l.getHavaalani() + "\"\n");
                    writer.write("  }" + (i < lokasyonlar.size() - 1 ? "," : "") + "\n");
                }
                writer.write("]");
                System.out.println("✅ Lokasyonlar JSON'a yazıldı.");
            } catch (Exception e) {
                System.out.println("Hata (lokasyonlar): " + e.getMessage());
            }
        }

        public static void ucuslariYaz(List<Flight> ucuslar) {
            try (FileWriter writer = new FileWriter("Data/ucuslar.json")) {
                writer.write("[\n");
                for (int i = 0; i < ucuslar.size(); i++) {
                    Flight f = ucuslar.get(i);
                    writer.write("  {\n");
                    writer.write("    \"kalkis\": \"" + f.getKalkisLokasyonu().getSehir() + " - " + f.getKalkisLokasyonu().getHavaalani() + "\",\n");
                    writer.write("    \"varis\": \"" + f.getVarisLokasyonu().getSehir() + " - " + f.getVarisLokasyonu().getHavaalani() + "\",\n");
                    writer.write("    \"tarih\": \"" + f.getKalkisSaati().toString() + "\",\n");
                    writer.write("    \"ucakModel\": \"" + f.getUcak().getModel() + "\"\n");
                    writer.write("  }" + (i < ucuslar.size() - 1 ? "," : "") + "\n");
                }
                writer.write("]");
                System.out.println("✅ Uçuşlar JSON'a yazıldı.");
            } catch (Exception e) {
                System.out.println("Hata (ucuslar): " + e.getMessage());
            }
        }

        public static void rezervasyonYaz(String ad, String soyad, int yas, Flight ucus) {
            try (FileWriter writer = new FileWriter("Data/rezervasyonlar.json", true)) {
                writer.write("{");
                writer.write("\"ad\": \"" + ad + "\", ");
                writer.write("\"soyad\": \"" + soyad + "\", ");
                writer.write("\"yas\": " + yas + ", ");
                writer.write("\"ucus\": {");
                writer.write("\"kalkis\": \"" + ucus.getKalkisLokasyonu().getSehir() + " - " + ucus.getKalkisLokasyonu().getHavaalani() + "\", ");
                writer.write("\"varis\": \"" + ucus.getVarisLokasyonu().getSehir() + " - " + ucus.getVarisLokasyonu().getHavaalani() + "\", ");
                writer.write("\"tarih\": \"" + ucus.getKalkisSaati().toString() + "\", ");
                writer.write("\"ucakModel\": \"" + ucus.getUcak().getModel() + "\"");
                writer.write("}}");
                writer.write(System.lineSeparator()); // her rezervasyon yeni satıra yazdırılır
                System.out.println("✅ Rezervasyon eklendi.");
            } catch (Exception e) {
                System.out.println("Hata (rezervasyon): " + e.getMessage());
            }
        }

    }
