import java.util.Arrays;
import java.util.Scanner;
public class Hangman2 {
	
	private String word;
	int size;
	private char[] wordArr;
	private char[] obsWord;
	private int numGuesses;

	public Hangman2() {
		super();
	}
	
	public Hangman2(String word) {
		this.word=word;
		this.size = word.length();
		wordArr	= word.toCharArray();
		obsWord = new char[size];
		for(int i = 0; i < size; i++) {
			obsWord[i] = '?';
		}
	}

	/*
	public void setWord(String word) {
		Hangman2(word);
	}
	*/

	public int getGuessCount() {
		return numGuesses;
	}

	public String getObsWord() {
		return Arrays.toString(obsWord);
	}
	
	public String getWord() {
		return word;
	}

	public void makeGuess(char c) {
		for(int i = 0; i < size; i++) {
			if(c == wordArr[i]) {
				obsWord[i] = c;
			}
		}
		numGuesses++;
	}
	
	public boolean isFound() {
		for(int i = 0; i < size; i++) {
			if('?' == obsWord[i]) {
				return false;
			}
		}
		return true;
	}
		
	public static void clearln() {
		System.out.println("\033[H\033[2J");
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		clearln();
		System.out.println("Here is a game of hung man");
		System.out.println();
		System.out.println("What is your word?");
		System.out.println();
		System.out.print(">");
		String myWord = kb.nextLine();
		Hangman2 a = new Hangman2(myWord);
		System.out.println();
		while(!a.isFound()){
			clearln();
			System.out.println("Here is what you have found:");
			System.out.println();
			System.out.println(a.getObsWord());
			System.out.println();
			if(a.getGuessCount() == 1) {
				System.out.println("You have made " + a.getGuessCount() + " guess so far");
			} else {
				System.out.println("You have made " + a.getGuessCount() + " guesses so far");
			}
			System.out.println();
			if(a.getGuessCount() == 0) {
				System.out.println("Enter a char to guess");
			} else {
				System.out.println("Enter a char to guess again");
			}
			System.out.println();
			System.out.print(">");
			char guess = kb.next().charAt(0);
			a.makeGuess(guess);
		}
		System.out.println(); 
		System.out.println("Congradulations, "); 
		System.out.println("you have found the word \"" + a.getWord() + "\" in only " + a.getGuessCount() + " guesses!"); 
	}
	
}

