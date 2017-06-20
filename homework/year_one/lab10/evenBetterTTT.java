import java.util.Arrays;
import java.util.Scanner;
public class evenBetterTTT {
	private char[][] board = new char[3][3];
	private int turn = 0;
	
	public evenBetterTTT() {
		restart();
	}

	public static void clear(){
		System.out.println("\033[H\033[2J");
	}
		
	public void move(int i, int j){
		if(board[i][j] != 'X' || board[i][j] != 'O'){
			if(turn % 2 == 0) {
				board[i][j] = 'X';
			}else {
				board[i][j] = 'O';
			}
			turn++;
		}else{ 
			System.out.println("Spot taken, move again");
		}
	}

	public void turn() {
		if(turn % 2 == 0) {
			System.out.println("X's turn");
		}else {
			System.out.println("O's turn");
		}
	}

	public void showBoard() {
		for(int i = 0; i < board.length; i++) {
			System.out.print("     ");
			System.out.println(Arrays.toString(board[i])); 
		}
	}
	
	public void restart() {
		int n = '1';
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = (char)n;
				n++;
			}
		}
	}
	
	public boolean checkWinner(){
		char winner = '_';
		boolean won = false; 
		
		for(int i = 0; i < board.length; i++){
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
				winner = board[i][0];
				won = true;
				break;
			}
		}

		for(int i = 0; i < board.length; i++){
			if(board[0][i] == board[1][i] && board[0][i] == board[2][i]){
				winner = board[i][0];
				won = true;
				break;
			}
		}

		if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
			winner = board[1][1];
			won = true;
		}

		if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
			winner = board[1][1];
			won = true;
		}

		showBoard();
		System.out.println();
		System.out.println(winner + " wins!");
		return won;
	}

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		evenBetterTTT a = new evenBetterTTT();
		a.showBoard();
		while(!a.checkWinner()){
			clear();
			System.out.println();
			a.showBoard();
			System.out.println();
			a.turn();
			System.out.println();
			System.out.println("Enter a number for a location");
			System.out.println();
			System.out.print("> ");
			int num = (kb.nextInt() - 1);
			int i = num / 3;
			int j = num % 3;
			a.move(i, j);
		}
	}
}
