package GameObject;

import com.sun.javafx.scene.traversal.Direction;

public class Hero extends Character {
	protected Direction direction = Direction.DOWN;

	public Hero(int level) {
		super(level);
		this.maxHealthPoints = 20 + getRandom() * 3;
		this.defendPoints = getRandom() * 2;
		this.strikePoints = 5 + getRandom();
		this.currentHealthPoints = this.maxHealthPoints;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return this.direction;
	}

	public void strike(Monster monster) {
		if (! monster.isAlive()) {
			return;
		}

		if (this.getStrikeValue() > monster.defendPoints) {
			monster.currentHealthPoints -= this.getStrikeValue();
		}

		if (monster.isAlive()) {
			monster.strike(this);
		} else if (monster.hasKey) {
			this.hasKey = true;
		}
	}

	public void heal() {
		this.currentHealthPoints = this.maxHealthPoints;
	}
}
