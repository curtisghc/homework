import java.util.Scanner;

public class Trivia {
	private String question;
	private String answer;
	private String guess;

	public Trivia(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public String getQuestion() {
		return question;
	}

	/*
	public void setQuestion(String newQuestion) {
		this.question = newQuestion;
	}

	public void setAnswer(String newAnswer) {
		this.answer = newAnswer;
	}
	*/

	public boolean checkAnswer() {
		if (guess.equalsIgnoreCase(answer)) {
			return true;
		}else{
			return false;
		}
	}
	
	public void inputAnswer() {
		Scanner kb = new Scanner(System.in);
		this.guess = kb.nextLine();
	}
	
	public static void main(String[] args) {
		Trivia a = new Trivia("How many grams are in an ounce?", "28");
		System.out.println(a.getQuestion());
		a.inputAnswer();
		if (a.checkAnswer()) {
			System.out.println("Correct answer");
		}else{
			System.out.println("Wrong answer");
		}
		System.out.println();

		Trivia b = new Trivia("Who is the greatest soldier to ever live?", "Big Boss");
		System.out.println(b.getQuestion());
		b.inputAnswer();
		if (b.checkAnswer()) {
			System.out.println("Correct answer");
		}else{
			System.out.println("Wrong answer");
		}
	}
}
