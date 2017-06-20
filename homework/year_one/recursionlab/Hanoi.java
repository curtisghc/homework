import java.util.Stack;

public class Hanoi {

    public static void stackMove(int n, Stack<Integer> Start, Stack<Integer> Finish, Stack<Integer> Spare){
	if(n == 0){
	    return;
	}
	else{
	    stackMove(n - 1, Start, Spare, Finish);
	    System.out.println("Moving " + Start.peek());
	    System.out.println("From " + Start);
	    System.out.println("To " + Finish);
	    System.out.println("Using " + Spare + " as a spare");
	    System.out.println("---------------------------");
	    Finish.push(Start.pop());
	    stackMove(n - 1, Spare, Finish, Start);
	}
    }

    public static void symbolicMove(int n, String start, String to, String spare){
	if(n == 0){
	    return;
	}else{
	    symbolicMove(n - 1, start, spare, to);
	    System.out.println("move from " + start + " to " + to);
	    symbolicMove(n - 1, spare, to, start);
	}
    }

    public static void main(String[] args){
	Stack<Integer> A = new Stack<Integer>();
	Stack<Integer> B = new Stack<Integer>();
	Stack<Integer> C = new Stack<Integer>();

	int init = 3;

	try{
	    init = Integer.parseInt(args[0]);
	}catch(ArrayIndexOutOfBoundsException e){
	}

	for(int i = init; i > 0; i--){
	    A.push(i);
	}

	//symbolicMove(init, "A", "C", "B");
	System.out.println("A " + A);
	System.out.println("B " + B);
	System.out.println("C " + C);
	System.out.println();
	stackMove(A.size(), A, C, B);
	System.out.println();
	System.out.println("A " + A);
	System.out.println("B " + B);
	System.out.println("C " + C);
    }
}
