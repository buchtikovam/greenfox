public class Main {
	public static void main(String[] args) {
		Garden garden = new Garden();

		garden.addFlower(new Flower("yellow"));
		garden.addFlower(new Flower("blue"));
		garden.addTree(new Tree("purple"));
		garden.addTree(new Tree("orange"));

		garden.getStatus();
		garden.waterPlants(40);
		garden.getStatus();
		garden.waterPlants(70);
		garden.getStatus();
	}
}
