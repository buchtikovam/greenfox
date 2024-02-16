public class Flower {
	public String color;
	public double waterLevel = 0;

	public Flower(String color) {
		this.color = color;
	}

	public boolean doesNeedWater() {
		return this.waterLevel < 5;
	}

	private String getWaterStatus() {
		if (this.doesNeedWater()) {
			return "needs water";
		}

		return "doesn't need water";
	}
	public String className = getClass().getSimpleName();

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
