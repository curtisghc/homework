package hangman;
public class hangmanDriver {
	public static void main(String[] args) {
		Hangman a = new Hangman();
		a.makeGuess('s');
		System.out.println(a.getObscuredWord());
		System.out.println(a.isFound());
		a.makeGuess('h');
		System.out.println(a.getObscuredWord());
		System.out.println(a.isFound());
		a.makeGuess('y');
		System.out.println(a.getObscuredWord());
		System.out.println(a.isFound());
		a.makeGuess('o');
		System.out.println(a.getObscuredWord());
		System.out.println(a.isFound());
		a.makeGuess('r');
		System.out.println(a.getObscuredWord());
		System.out.println(a.isFound());
		a.makeGuess('t');
		System.out.println(a.getObscuredWord());
		System.out.println(a.isFound());
		System.out.println(a.getGuessCount());
	}
} 
