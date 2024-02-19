package GameObject;

public class Monster extends Character
{
	public Monster(int level) {
		super(level);
		this.maxHealthPoints = 2 * getRandom() * this.level;
		this.currentHealthPoints = this.maxHealthPoints;
		this.defendPoints = (int) this.level / 2 * getRandom();
		this.strikePoints = getRandom() * this.level;
	}

	public int getType() {
		return 0;
	}

	public void strike(Hero hero) {
		if (this.getStrikeValue() > hero.defendPoints) {
			hero.currentHealthPoints -= this.getStrikeValue();
		}
	}
}
