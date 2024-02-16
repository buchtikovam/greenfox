package Main;

import GameObject.*;
import com.sun.javafx.scene.traversal.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Board extends JComponent implements KeyListener {
	static final int tileSize = 72;

	int currentLevel = 1;
	int heroMoveCount;

	boolean loadLevel = true;
	boolean isFighting = false;
	boolean isDoorOpened = false;
	boolean isFull = true;

	ArrayList<Monster> monsters = new ArrayList<>();
	Hero hero = new Hero(1);
	Door door = new Door();
	HealthPotion healthPotion = new HealthPotion();

	public Board() {
		setPreferredSize(new Dimension(tileSize * 10, tileSize * 10));
		setVisible(true);
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		// drawing the map for current level
		for (int posY = 0; posY < 9; posY++) {
			for (int posX = 0; posX < 10; posX++) {
				int objectId = getLevelMap()[posY][posX];

				PositionedImage tileImage = new PositionedImage(
					"img/floor.png",
					posX * tileSize,
					posY * tileSize
				);
				tileImage.draw(graphics);

				if (objectId == 1) {
					PositionedImage wallImage = new PositionedImage(
						"img/wall.png",
						posX * tileSize,
						posY * tileSize
					);

					wallImage.draw(graphics);
				}
			}
		}

		// drawing characters based on matrix
		if (loadLevel) {
			for (int posY = 0; posY < 9; posY++) {

				for (int posX = 0; posX < 10; posX++) {

					Skeleton enemy = new Skeleton(this.currentLevel);
					switch (getLevelMap()[posY][posX]) {
						case 2:
							this.hero.setPosX(posX * tileSize);
							this.hero.setPosY(posY * tileSize);
							break;
						case 3:
							enemy.setPosX(posX * tileSize);
							enemy.setPosY(posY * tileSize);
							this.monsters.add(enemy);
							break;
						case 4:
							Boss boss = new Boss(this.currentLevel);
							boss.setPosX(posX * tileSize);
							boss.setPosY(posY * tileSize);
							this.monsters.add(boss);
							break;
						case 5:
							enemy.hasKey = true;
							enemy.setPosX(posX * tileSize);
							enemy.setPosY(posY * tileSize);
							this.monsters.add(enemy);
							break;
						case 6:
							door.setPosX(posX * tileSize);
							door.setPosY(posY * tileSize);
						case 7:
							healthPotion.setPosX(posX * tileSize);
							healthPotion.setPosY(posY * tileSize);
					}
				}
			}
			this.loadLevel = false;
		}

		// making sure hero faces the right way when a key is pressed
		String filename = "img/hero-down-png";
		switch (hero.getDirection()) {
			case UP:
				filename = "img/duck-up.png";
				break;
			case DOWN:
				filename = "img/duck-down.png";
				break;
			case LEFT:
				filename = "img/duck-left.png";
				break;
			case RIGHT:
				filename = "img/duck-right.png";
				break;
		}

		// drawing all characters + checking if they are alive
		if (this.isFull) {
			new PositionedImage(
				"img/health-potion.png",
				this.healthPotion.getPosX(),
				this.healthPotion.getPosY()
			).draw(graphics);
		}

		for (Monster monster : this.monsters) {
			if (monster.isAlive()) {
				int monsterType = monster.getType();
				if (monsterType == 3) {
					new PositionedImage(
						"img/cat.png",
						monster.getPosX(),
						monster.getPosY()
					).draw(graphics);
				}

				if (monsterType == 4) {
					new PositionedImage(
						"img/boss.png",
						monster.getPosX(),
						monster.getPosY()
					).draw(graphics);
				}
			}
		}

		// Adding healing potions
		if (this.hero.getPosX() == this.healthPotion.getPosX() &&
			this.hero.getPosY() == this.healthPotion.getPosY()
		) {
			this.hero.heal();
			this.isFull = false;
		}

		if (hero.isAlive()) {
			new PositionedImage(
				filename,
				this.hero.getPosX(),
				this.hero.getPosY()
			).draw(graphics);
		} // add a losing screen!!!!!!

		// Drawing HUD
		Font largerFont = new Font("SansSerif", Font.BOLD, 18);
		graphics.setFont(largerFont);
		graphics.drawString
			(
			"Hero (Level "
				+ this.currentLevel
				+ ") HP: "
				+ this.hero.getCurrentHealthPoints()
				+ "/"
				+ this.hero.getMaxHealthPoints()
				+ " | DP: "
				+ this.hero.getDefendPoints()
				+ " | SP: "
				+ this.hero.getStrikePoints()
				+ " | Has key: "
				+ this.hero.hasKey,
				tileSize / 2,
				(tileSize * 10) - tileSize / 2 + 5
		);

		// Draw a rectangle if fight is happening
		if (this.isFighting) {
			graphics.setColor(Color.red);
			graphics.drawRect(this.hero.getPosX(), this.hero.getPosY(), tileSize, tileSize);
		}

		// Checking if door should open
		if (hero.hasKey && !this.getBoss().isAlive()) {
			this.isDoorOpened = true;
		}

		// Implementing door logic
		if (isDoorOpened == false) {
			new PositionedImage(
				"img/closed-door.png",
				this.door.getPosX(),
				this.door.getPosY()
			).draw(graphics);

		} else {
			new PositionedImage(
				"img/door-opened.png",
				this.door.getPosX(),
				this.door.getPosY()
			).draw(graphics);

			if (this.hero.getPosX() == this.door.getPosX() &&
				this.hero.getPosY() == this.door.getPosY()
			) {
				// GAME RESET
				this.currentLevel++;
				this.loadLevel = true;
				this.monsters.clear();
				hero.hasKey = false;
				hero.setLevel(hero.getLevel() + 1);
				this.isDoorOpened = false;
				this.isFull = true;
				repaint();
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("RPG Game");
		Board board = new Board();
		frame.add(board);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(board);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int newPosX = this.hero.getPosX();
		int newPosY = this.hero.getPosY();

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.hero.setDirection(Direction.UP);
			newPosY -= tileSize;
			heroMoveCount++;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.hero.setDirection(Direction.DOWN);
			newPosY += tileSize;
			heroMoveCount++;

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.hero.setDirection(Direction.LEFT);
			newPosX -= tileSize;
			heroMoveCount++;

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.hero.setDirection(Direction.RIGHT);
			newPosX += tileSize;
			heroMoveCount++;
		}

		// setting boundaries for hero
		if (newPosX >= 0 && newPosX < tileSize * 10 && newPosY >= 0 && newPosY < tileSize * 9) {
			int newTileX = newPosX / tileSize;
			int newTileY = newPosY / tileSize;
			int objectId = getLevelMap()[newTileY][newTileX];

			if (objectId != 1) {
				this.hero.setPosX(newPosX);
				this.hero.setPosY(newPosY);
			}
		}

		// kung fu fighting
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			for (Monster monster : this.monsters) {
				if (this.hero.getPosX() == monster.getPosX() &&
					this.hero.getPosY() == monster.getPosY()) {
					this.isFighting = true;
					this.hero.strike(monster);
					if (! monster.isAlive()) {
						this.isFighting = false;
					}
					break;
				}
			}

			repaint();
			return;
		}

		// checking how often should skeletons move based on level
		if (this.currentLevel == 1) {
			if (heroMoveCount % 3 == 0) {
				moveSkeletonsRandomly();
			}
		}

		if (this.currentLevel == 2) {
			if (heroMoveCount % 2 == 0) {
				moveSkeletonsRandomly();
			}
		}

		if (this.currentLevel == 3) {
			if (heroMoveCount % 2 == 0) {
				moveSkeletonsRandomly();
				moveSkeletonsRandomly();
			}
		}

		// marking tile red if hero meets monster
		this.isFighting = false;
		for (Monster monster : this.monsters) {
			if (this.hero.getPosX() == monster.getPosX() &&
				this.hero.getPosY() == monster.getPosY()) {
				this.isFighting = true;
				break;
			}
		}

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public void moveSkeletonsRandomly() {
		for (Monster monster : this.monsters) {
			int newX, newY;

			do {
				int randomDirection = (int) (Math.random() * 4);
				newX = monster.getPosX();
				newY = monster.getPosY();

				if (randomDirection == 0) { // move up
					newY -= tileSize;
				} else if (randomDirection == 1) { // move down
					newY += tileSize;
				} else if (randomDirection == 2) { // move left
					newX -= tileSize;
				} else if (randomDirection == 3) { // move right
					newX += tileSize;
				}

			} while (
				newX < 0 ||
				newX >= tileSize * 10 ||
				newY < 0 || newY >= tileSize * 9 ||
				getLevelMap()[newY / tileSize][newX / tileSize] == 1
			);

			monster.setPosX(newX);
			monster.setPosY(newY);
		}
	}

	public int[][] getLevelMap() {
		HashMap<Integer, int[][]> levels = new HashMap<>();
		// 0: grass
		// 1: rock
		// 2: duck
		// 3: enemy
		// 4: boss
		// 5: enemy with key
		// 6: door
		// 7: health potion

		// Level 1
		levels.put(1, new int[][] {
			{2, 1, 1, 0, 1, 1, 0, 1, 1, 6},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 0, 1, 1, 1, 0, 1, 1, 0, 5},
			{0, 0, 0, 3, 0, 0, 0, 1, 0, 0},
			{1, 1, 1, 1, 1, 1, 0, 1, 0, 0},
			{1, 0, 0, 0, 0, 1, 0, 1, 0, 0},
			{7, 0, 1, 1, 0, 0, 0, 1, 0, 0},
			{0, 4, 0, 0, 0, 1, 3, 0, 0, 1},
			{1, 1, 0, 1, 1, 1, 0, 1, 0, 1}
		});

		// Level 2
		levels.put(2, new int[][] {
			{2, 0, 1, 1, 1, 1, 1, 1, 1, 1},
			{6, 0, 0, 0, 0, 0, 0, 0, 3, 1},
			{1, 5, 1, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 1, 0, 0, 3, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
			{1, 0, 0, 0, 1, 1, 0, 1, 0, 1},
			{1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 1, 3, 1},
			{1, 1, 1, 1, 1, 1, 4, 0, 7, 1}
		});

		// Level 3
		levels.put(3, new int[][] {
			{2, 3, 0, 0, 1, 1, 1, 1, 1, 1},
			{0, 0, 1, 0, 1, 0, 0, 0, 3, 6},
			{0, 0, 1, 0, 1, 0, 1, 1, 1, 1},
			{1, 0, 1, 3, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
			{0, 0, 1, 0, 1, 4, 0, 1, 3, 1},
			{7, 0, 1, 0, 1, 1, 3, 1, 0, 1},
			{1, 5, 0, 0, 0, 1, 0, 1, 0, 1},
			{1, 1, 1, 1, 0, 1, 0, 0, 0, 1}
		});

		return levels.get(this.currentLevel);
	}

	public Boss getBoss() {
		for (Monster monster : this.monsters) {
			if (monster.getType() == Boss.type) {
				return (Boss) monster;
			}
		}
		throw new RuntimeException("Boss not found!");
	}
}

