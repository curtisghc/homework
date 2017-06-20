package dice;
public class Dice {

	public final int roll(int sides) {
		int val = (int)(1 + (Math.random() * sides));
		return val;
	}
	public int roll() {
		return 0;
	}
}
