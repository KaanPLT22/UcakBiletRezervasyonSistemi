package Services;

import Models.Reservation;
import Models.Flight;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private List<Reservation> reservations;

    public ReservationService() {
        reservations = new ArrayList<>();
    }

    public boolean makeReservation(Flight ucus, String ad, String soyad, int yas) {
        if (ucus.rezervasyonYap()) {  // flight.rezervasyonYap() metodu uçuşta boş koltuk kontrolü yapar
            Reservation newReservation = new Reservation(ucus, ad, soyad, yas);
            reservations.add(newReservation);
            return true;
        } else {
            return false; // Koltuk yok
        }
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
