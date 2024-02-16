package wardrobe;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
	final List<Underwear> underwear = new ArrayList<>();
	final List<Overwear> overwear = new ArrayList<>();

	public void addCloth(Underwear underwear) {
		this.underwear.add(underwear);
	}

	public void addCloth(Overwear overwear) {
		this.overwear.add(overwear);
	}

	public void printInfo() {
		for (Overwear overwear: overwear) {
			overwear.getInfo();
		}
		for (Underwear underwear: underwear) {
			underwear.getInfo();
		}
	}

	public void washAllClothes() throws Exception {
		for (Overwear overwear : overwear) {
			if (overwear.needsToBeWashed()) {
				overwear.wash();
			}
		}
		for (Underwear underwear : underwear) {
			if (underwear.needsToBeWashed()) {
				underwear.wash();
			}
		}
	}

	public void repairAllClothes() throws Exception {
		for (Overwear overwear : overwear) {
			if (overwear.needsToBeRepaired()) {
				overwear.repair();
			}
		}
		for (Underwear underwear : underwear) {
			if (underwear.needsToBeRepaired()) {
				underwear.repair();
			}
		}
	}

	public void purge() {
		for (Overwear overwear : overwear) {
			if (overwear.condition == 0) {
				System.out.println(overwear);
				this.overwear.remove(overwear);
			}
		}
		for (Underwear underwear : underwear) {
			if (underwear.condition == 0) {
				System.out.println(underwear);
				this.underwear.remove(underwear);
			}
		}
	}
}