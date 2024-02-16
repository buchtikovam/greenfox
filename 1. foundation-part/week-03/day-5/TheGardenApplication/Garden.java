import java.util.ArrayList;
import java.util.List;

public class Garden {
	private final List<Flower> flowers = new ArrayList<>();
	private final List<Tree> trees = new ArrayList<>();

	public void addFlower(Flower flower) {
		this.flowers.add(flower);
	}
	public void addTree(Tree tree) {
		this.trees.add(tree);
	}

	public void getStatus() {
		for (Flower flower: flowers) {
			System.out.println(flower.status());
		}
		for (Tree tree: trees) {
			System.out.println(tree.status());
		}
		System.out.println();
	}

	public int getThirstyPlants() {
		int thirstyPlants = 0;
		for (Flower flower: flowers) {
			if (flower.doesNeedWater()) {
				thirstyPlants++;
			}
		}
		for (Tree tree: trees) {
			if (tree.doesNeedWater()) {
				thirstyPlants++;
			}
		}
		return thirstyPlants;
	}

	public void waterPlants(double water) {
		System.out.println("Watering with " + (int) water);

		int thirstyPlants = this.getThirstyPlants();
		if (thirstyPlants == 0) {
			return;
		}
		water /= thirstyPlants;

		for (Flower flower: flowers) {
			if (flower.doesNeedWater()) {
				flower.setWaterLevel(water * 0.75);
			}
		}

		for (Tree tree: trees) {
			if (tree.doesNeedWater()) {
				tree.setWaterLevel(water * 0.4);
			}
		}
	}
}
