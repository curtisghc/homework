package dice;
public class D6 extends Dice {
	
	private static final int sides = 6;
	
	public int roll() {
		return super.roll(sides);
	}
}
