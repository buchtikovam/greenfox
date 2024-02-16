package GameObject;
import java.util.Random;

public abstract class Character
{
	public boolean hasKey = false;
	protected int maxHealthPoints;
	protected int currentHealthPoints;
	protected int defendPoints;
	protected int strikePoints;
	protected int level;
	protected int randomNumber;
	protected int strikeValue;
	private int posX;
	private int posY;

	public Character(int level) {
		this.level = level;
	}

	public boolean isAlive() {
		return this.currentHealthPoints > 0;
	}

	public int getDefendPoints() {
		return this.defendPoints;
	}

	public int getStrikePoints() {
		return this.strikePoints;
	}


	public int getMaxHealthPoints() {
		return this.maxHealthPoints;
	}


	public int getCurrentHealthPoints() {
		return this.currentHealthPoints;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPosX() {
		return this.posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getRandom() {
		Random r = new Random();
		int min = 1;
		int max = 6;
		this.randomNumber = r.nextInt(max) + min;
		return this.randomNumber;
	}

	public int getStrikeValue() {
		this.strikeValue = getRandom() * 2 + this.strikePoints;
		return this.strikeValue;
	}
}
