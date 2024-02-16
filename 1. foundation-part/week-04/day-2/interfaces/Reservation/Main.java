package Reservation;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Reservation> myReservations = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			myReservations.add(new Reservation());
		}

		for (Reservation reservation: myReservations) {
			reservation.printBooking();
		}
	}
}