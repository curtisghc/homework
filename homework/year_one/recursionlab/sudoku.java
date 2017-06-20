import java.lang.Thread;
import java.util.Arrays;
public class sudoku {

    public static void clear(){
	System.out.println("\033[H\033[2J");
    }
      
    public static void printSudoku(int[][] board){
	for(int i = 0; i < board.length; i++){
	    if(i%3 == 0){
		System.out.println("-------------------------");
	    }
	    for(int j = 0; j < board.length; j++){
		if(j%3 == 0){
		    System.out.print("| ");
		}
		System.out.print(board[i][j] + " ");
	    }
	    System.out.println("|");
	}
	System.out.println("-------------------------");
    }

    public static boolean complete(int[][] board){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if(board[i][j] == 0){
		    return false;
		}
	    }
	}
	return true;
    }

    public static boolean isSafe(int[][] board, int input, int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	//check rows/columns
	for(int i = 0; i < board.length; i++){
	    if(input == board[row][i] || input == board[i][col]){
		return false;
	    }
	}
	//check blocks
	for(int i = (row/3)*3; i < (row/3)*3 + 3; i++){
	    for(int j = (col/3)*3; j < (col/3)*3 + 3; j++){
		if(input == board[i][j]){
		    return false;
		}
	    }
	}
	return true;
    }

    public static boolean solve(int[][] board){
	if(complete(board)){
	    return true;
	}
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board.length; j++){
		for(int number = 1; number < 10; number++){
		    if(isSafe(board, number, i, j)){
			clear();
			printSudoku(board);

			try{
			Thread.sleep(500);
			}catch(Exception e){
			}
			board[i][j] = number;
			//System.out.println("added "+number+" to ("+i+","+j+")");
		        boolean ok = solve(board);
			if(ok){
			    return true;
			}else{
			    board[i][j] = 0;
			}
		    }
		}
	    }
	}
	return false;
    }

    public static void boardClear(int[][] board){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		board[i][j] = 0;
	    }
	}
    }
	    
    
    public static void main(String[] args){

	int[][] Sudoku = {{3,0,6,5,0,8,4,0,0},
			  {5,2,0,0,0,0,0,0,0},
			  {0,8,7,0,0,0,0,3,1},
			  {0,0,3,0,1,0,0,8,0},
			  {9,0,0,8,6,3,0,0,5},
			  {0,5,0,0,9,0,6,0,0},
			  {1,3,0,0,0,0,2,5,0},
			  {0,0,0,0,0,0,0,7,4},
			  {0,0,5,2,0,6,3,0,0}};

	int[][] Sudoku2 = {{3,1,6,5,4,8,4,2,1},
			  {5,2,2,1,3,4,5,6,1},
			  {5,2,2,1,3,4,5,6,1},
			  {5,2,2,1,3,4,5,6,1},
			  {5,2,2,1,3,4,5,6,1},
			  {5,2,2,1,3,4,5,6,1},
			  {5,2,2,1,3,4,5,6,1},
			  {5,2,2,1,3,4,5,6,1},
			  {5,2,2,1,3,4,5,6,1}};

	int[][] emptySudoku = new int[9][9];
	boardClear(emptySudoku);
	emptySudoku[0][0] = 1;
	solve(emptySudoku);
    }
}
