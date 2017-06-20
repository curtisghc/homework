package dice;
public class D4 extends Dice {

	private static final int sides = 4;
	public int roll() {
		return super.roll(sides);
	}
}
