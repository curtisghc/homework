import java.util.Arrays;
public class FourQueens{

    public static void printChessboard(boolean[][] arr){
	System.out.print("  ");
	for(int i = 0; i < arr[0].length; i++){
	    System.out.print(i +  " ");
	}
	System.out.println();
	for(int i = 0; i < arr.length; i++){
	    System.out.print(i + " ");
	    for(int j = 0; j < arr[i].length; j++){
		if(arr[i][j]){
		    System.out.print("Q ");
		}else if(i % 2 != j % 2){
		    System.out.print("# ");
		}else {
		    System.out.print("  ");
		}
	    }
	    System.out.println();
	}
	System.out.println("-----------------");
    }
	
    public static void emptyBoard(boolean[][] chessboard){
	for(int i = 0; i < chessboard.length; i++){
	    for(int j = 0; j < chessboard[i].length; j++){
		chessboard[i][j] = false;
	    }
	}
    }

    public static boolean isSafe(boolean[][] chessboard, int col, int row){
	for(int i = 0; i < 8; i++){ // verticals and diagonals
	    try{if(chessboard[col+i][row]){return false;}}catch(ArrayIndexOutOfBoundsException e){}
	    try{if(chessboard[col-i][row]){return false;}}catch(ArrayIndexOutOfBoundsException e){}
	    try{if(chessboard[col][row+i]){return false;}}catch(ArrayIndexOutOfBoundsException e){}
	    try{if(chessboard[col][row-i]){return false;}}catch(ArrayIndexOutOfBoundsException e){}
	    try{if(chessboard[col+i][row+i]){return false;}}catch(ArrayIndexOutOfBoundsException e){}
	    try{if(chessboard[col+i][row-i]){return false;}}catch(ArrayIndexOutOfBoundsException e){}
	    try{if(chessboard[col-i][row+i]){return false;}}catch(ArrayIndexOutOfBoundsException e){}
	    try{if(chessboard[col-i][row-i]){return false;}}catch(ArrayIndexOutOfBoundsException e){}
	}
	return true;
    }

    public static void placeQueen(boolean[][] chessboard, int col, int row){
	if(col == 0 && row == chessboard[col].length){
	    return;
	}else if(col == chessboard.length){
	    printChessboard(chessboard);
	}else if(row == chessboard[col].length){
	    for(int i = 0; i < chessboard[col - 1].length; i++){
		if(chessboard[col-1][i]){
		    chessboard[col-1][i] = false;
		    //System.out.println("backtracking from " + x + "," + y);
		    placeQueen(chessboard, col - 1, i + 1);
		}
	    }
	}else if(isSafe(chessboard, col, row)){
	    chessboard[col][row] = true;
	    //System.out.println("queen placed at " + x + "," + y);
	    placeQueen(chessboard, col + 1, 0);
	}else{
	    placeQueen(chessboard, col, row + 1);
	}
    }

    public static void queens(boolean[][] chessboard){
	placeQueen(chessboard, 0, 0);
    }
	   
    public static void main(String[] args){
	boolean[][] realboard = new boolean[8][8];
	emptyBoard(realboard);
	queens(realboard);
    }
}
