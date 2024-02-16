package AircraftCarrier;

public class F16 extends Aircraft {
	public F16() {
		super(8, 30);
	}

	@Override
	public String getType() {
		return "F16";
	}

	@Override
	public boolean isPriority() {
		return false;
	}
}