package ModelStringedInstruments;

public abstract class StringedInstrument extends Instrument {
	private int numberOfStrings;
	private String classname;
	private String sound;

	public StringedInstrument(int numberOfStrings, String sound) {
		this.numberOfStrings = numberOfStrings;
		this.sound = sound;
	}

	public String nameOfInstrument() {
		this.classname = this.getClass().getSimpleName();
		return this.classname;
	}

	@Override
	public void play() {
		System.out.println(nameOfInstrument()
			+ ", a "
			+ this.numberOfStrings
			+ "-stringed instrument that goes "
			+ this.Sound()
		);
	}

	public String Sound() {
		return sound;
	}
}
