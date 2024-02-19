package wardrobe;

public class Cloth {
	protected String type;
	protected String color;
	protected int condition;
	protected int daysWorn;
	protected int initialCondition = condition;

	public Cloth(String type, String color, int daysWorn) {
		this.type = type;
		this.color = color;
		this.daysWorn = daysWorn;
	}

	public boolean needsToBeWashed() {
		return true;
	}

	public boolean needsToBeRepaired() throws Exception {
		return true;
	}

	public void wear() throws Exception {
		if (needsToBeWashed()) {
			throw new Exception(
				"wardrobe.Cloth cannot be worn, it needs to be washed"
			);
		} else {
			this.daysWorn++;
		}
	}

	public void wash() throws Exception {
		if (this.condition >= 0) {
			this.daysWorn = 0;
			this.condition--;
		} else {
			throw new Exception(
				"Cloth cannot be worn due to its condition."
			);
		}
	}

	public void repair() {
		this.condition = initialCondition;
	}

	public void getInfo() {
		System.out.println(
			this.color
			+ " "
			+ this.type
			+ " worn for "
			+ this.daysWorn
			+ " days, has "
			+ this.condition
			+ " wash cycles left"
		);
	}
}
