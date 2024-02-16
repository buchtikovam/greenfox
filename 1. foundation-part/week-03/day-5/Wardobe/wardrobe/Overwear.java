package wardrobe;

final public class Overwear extends Cloth {

	public Overwear(String type, String color, int daysWorn) {
		super(type, color, daysWorn);
		this.condition = 50;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	@Override
	public boolean needsToBeWashed() {
		if (daysWorn > 4) {
			return true;
		}
		return false;
	}

	@Override
	public boolean needsToBeRepaired() {
		if (condition >= 1 && condition <= 5) {
			return true;
		}
		return false;
	}
}
