package GameObject;

public class Skeleton extends Monster
{
	public Skeleton(int level) {
		super(level);
	}

	@Override
	public int getType() {
		return 3;
	}
}
