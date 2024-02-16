package wardrobe;

final public class Underwear extends Cloth{

	public Underwear(String type, String color, int daysWorn) {
		super(type, color, daysWorn);
		this.condition = 100;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	@Override
	public boolean needsToBeWashed() {
		if (daysWorn >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean needsToBeRepaired() throws Exception {
		if (this.condition <= 0) {
			throw new Exception("Underwear cannot be repaired");
		}
		return false;
	}
}
