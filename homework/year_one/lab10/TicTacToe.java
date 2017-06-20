import java.util.Arrays;
public class TicTacToe {
	private char[][] board = new char[3][3];
	private int turn = 0;
	
	public TicTacToe() {
		restart();
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
		for(int i = 0; i < board.length; i++) {
				System.out.println(Arrays.toString(board[i])); 
		}
		System.out.println("*********");
	}
	
	public void restart() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = '_';
			}
		}
	}
	
	public void checkWinner(){
		char winner = '_';
		
		for(int i = 0; i < board.length; i++){
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
				winner = board[i][0];
				break;
			}
		}

		for(int i = 0; i < board.length; i++){
			if(board[0][i] == board[1][i] && board[0][i] == board[2][i]){
				winner = board[i][0];
				break;
			}
		}

		if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
			winner = board[1][1];
		}

		if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
			winner = board[1][1];
		}

		System.out.println(winner + " wins");
	}

	public static void main(String[] args){
		TicTacToe a = new TicTacToe();
		a.showBoard();
		a.move(1,1);
		a.move(1,2);
		a.move(0,0);
		a.move(1,0);
		a.move(2,1);
		a.move(2,0);
		a.move(2,2);
		a.showBoard();
		a.checkWinner();
	}

