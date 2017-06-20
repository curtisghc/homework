package dice;
public class D8 extends Dice {
	
	private static final int sides = 8;
	
	public int roll() {
		return super.roll(sides);
	}
}
