package hangman;
public class Hangman {

	private String word = "short";	
	private char obsA = '?';
	private char obsB = '?';
	private char obsC = '?';
	private char obsD = '?';
	private char obsE = '?';
	private int numGuesses;
		
	public void makeGuess(char c) {
		switch (c) {
			case 's': obsA = 's';
						numGuesses++;
						break;
			case 'h': obsB = 'h';
						numGuesses++;
						break;
			case 'o': obsC = 'o';
						numGuesses++;
						break;
			case 'r': obsD = 'r';
						numGuesses++;
						break;
			case 't': obsE = 't';
						numGuesses++;
						break;
			default: numGuesses++;
		}
	}

	
	public String getObscuredWord() {
		StringBuilder dw = new StringBuilder("");
		dw.append(obsA);
		dw.append(obsB);
		dw.append(obsC);
		dw.append(obsD);
		dw.append(obsE);
		return dw.toString();
	}
	
	public String getSecretWord() {
		return word;
	}

	public int getGuessCount() {
		return numGuesses; 
	}
	
	public boolean isFound() {
		String obsWord = getObscuredWord();
		boolean found = true;
		for (int i = 0; i <= 4; i++) {
			if (obsWord.charAt(i) == '?') {
				found = false;
			}
		}
	return found;
	}
}
