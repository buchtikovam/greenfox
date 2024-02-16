package GameObject;

public class Boss extends Monster {
	public static final int type = 4;

	public Boss(int level) {
		super(level);
		this.maxHealthPoints = 2 * this.level * getRandom() + getRandom();
		this.defendPoints = (int) (level / 2) * getRandom() + (getRandom() / 2);
		this.strikePoints = getRandom() * this.level + this.level;
	}

	@Override
	public int getType() {
		return type;
	}
}
