package dice;
import java.util.Arrays;
import java.util.Scanner;

public class diceGame {

	public static void clear() {
		System.out.println("\033[H\033[2J");
	}

	public static int rollAllDice(Dice[] dice){
		int sum = 0;
		for(Dice i:dice){
			sum += i.roll();
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		D4 d4 = new D4();
		D6 d6 = new D6();
		D8 d8 = new D8();
		int player1 = 0;
		int player2 = 0;
		boolean p1scored = true;
		boolean p2scored = true;

		clear();

		while(p1scored) {
			System.out.println("Player 1, choose your die (4/6/8)");
			System.out.print("> ");
			switch(kb.nextInt()){
				case 4 :	player1 = d4.roll();
							p1scored = false;
							System.out.println("Your score is " + player1);
							break;
				case 6 :	player1 = d6.roll();
							p1scored = false;
							System.out.println("Your score is " + player1);
							break;
				case 8 :	player1 = d8.roll();
							p1scored = false;
							System.out.println("Your score is " + player1);
							break;
				default :	System.out.println("Bad number, retry");
							break;
			}
		}

		System.out.println();

		while(p2scored) {
			System.out.println("Player 2, choose your die (4/6/8)");
			System.out.print("> ");
			switch(kb.nextInt()){
				case 4 :	player2 = d4.roll();
							p2scored = false;
							System.out.println("Your score is " + player2);
							break;
				case 6 :	player2 = d6.roll();
							p2scored = false;
							System.out.println("Your score is " + player2);
							break;
				case 8 :	player2 = d8.roll();
							p2scored = false;
							System.out.println("Your score is " + player2);
							break;
				default :	System.out.println("Bad number, retry");
							break;
			}
		}
		if(player1 > player2){
			System.out.println("Player 1 wins!");
		} else if(player2 > player1){
			System.out.println("Player 2 wins!");
		} else {
			System.out.println("No player wins! It's a tie!");
		}
	}

	/*
	public static void main(String[] args) {
		D8 d8a = new D8();
		D8 d8b = new D8();
		D8 d8c = new D8();
		D8 d8d = new D8();
		D8 d8e = new D8();
		Dice[] diceArr = {d8a,d8b,d8c,d8d,d8e};
		System.out.println(rollAllDice(diceArr));
	}
*/
}
