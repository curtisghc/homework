import java.util.Arrays;
import java.util.Scanner;
public class betterTTT {
	private char[][] board = new char[3][3];
	private int turn = 0;
	
	public betterTTT() {
		restart();
	}

	public static void clear(){
		System.out.println("\033[H\033[2J");
	}
		
	public void move(int i, int j){
		if(board[i][j] == '_'){
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
		System.out.print("     ");
		System.out.println("  0  1  2");
		for(int i = 0; i < board.length; i++) {
				System.out.print("     ");
				System.out.println(i + Arrays.toString(board[i])); 
		}
	}
	
	public void restart() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = '_';
			}
		}
	}
	
	public boolean checkWinner(){
		char winner = '_';
		boolean won = false; 
		
		for(int i = 0; i < board.length; i++){
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
				winner = board[i][0];
				if(winner != '_'){
					won = true;
				}
				break;
			}
		}

		for(int i = 0; i < board.length; i++){
			if(board[0][i] == board[1][i] && board[0][i] == board[2][i]){
				winner = board[i][0];
				if(winner != '_'){
					won = true;
				}
				break;
			}
		}

		if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
			winner = board[1][1];
			if(winner != '_'){
				won = true;
			}
		}

		if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
			winner = board[1][1];
			if(winner != '_'){
				won = true;
			}
		}

		System.out.println(winner + " wins");
		return won;
	}

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		betterTTT a = new betterTTT();
		System.out.println(a.checkWinner());
		while(!a.checkWinner()){
			clear();
			System.out.println();
			a.showBoard();
			System.out.println();
			a.turn();
			System.out.println();
			System.out.println("Enter row then column coordinates");
			System.out.println("Example: (0 1) for top middle");
			System.out.println();
			System.out.print("> ");
			int i = kb.nextInt();
			int j = kb.nextInt();
			a.move(i, j);
		}
	}
}
