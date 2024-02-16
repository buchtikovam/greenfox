final public class Tree {
	public String color;
	public double waterLevel = 0;

	public Tree(String color) {
		this.color = color;
	}

	public String className = getClass().getSimpleName();

	public boolean doesNeedWater() {
		return this.waterLevel < 10;
	}

	private String getWaterStatus() {
		if (this.doesNeedWater()) {
			return "needs water";
		}

		return "doesn't need water";
	}

	public String status() {
		return "The "
		+ this.color
		+ " "
		+ this.className
		+ " "
		+ this.getWaterStatus();
	}

	public void setWaterLevel(double water) {
		this.waterLevel += water;
	}
}
