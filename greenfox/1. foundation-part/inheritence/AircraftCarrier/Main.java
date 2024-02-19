package AircraftCarrier;

public class Main {
	public static void main(String[] args) {
		Carrier carrier1 = new Carrier(2300, 5000);
		Carrier carrier2 = new Carrier(2000, 4000);

		Aircraft f35_1 = new F35();
		Aircraft f35_2 = new F35();
		Aircraft f16_1 = new F16();
		Aircraft f16_2 = new F16();

		carrier1.addAircraft(f35_1);
		carrier1.addAircraft(f35_2);
		carrier2.addAircraft(f16_1);
		carrier2.addAircraft(f16_2);

		carrier1.fill();
		carrier2.fill();

		carrier1.fight(carrier2);

		System.out.println("Carrier 1 Status:");
		System.out.println(carrier1.getStatus());
		System.out.println();
		System.out.println("Carrier 2 Status:");
		System.out.println(carrier2.getStatus());
	}
}