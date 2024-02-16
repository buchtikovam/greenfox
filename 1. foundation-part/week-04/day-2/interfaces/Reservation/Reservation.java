package Reservation;
import java.util.Random;

public class Reservation implements Reservable {
	private final String bookingCode;
	private final String bookingDow;

	public Reservation() {
		this.bookingCode = getBookingCode();
		this.bookingDow = getBookingDow();
	}

	@Override
	public String getBookingDow() {
		String[] randomDay = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		Random random = new Random();
		int randomIndex = random.nextInt(randomDay.length);
		return randomDay[randomIndex];
	}

	@Override
	public String getBookingCode() {
		char[] allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random random = new Random();

		StringBuilder bookingCode = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			int randomIndex = random.nextInt(allChars.length);
			char randomChar = allChars[randomIndex];
			bookingCode.append(randomChar);
		}
		return bookingCode.toString();
	}

	public void printBooking() {
		System.out.println(
				"Booking# "
				+ bookingCode
				+ " for "
				+ bookingDow
		);
	}
}