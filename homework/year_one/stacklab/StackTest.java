package stack;
import java.util.Scanner;

public class StackTest{
    public static void main(String[] args){

	Stack<Integer> S = new Stack<Integer>();

	String test = args[0];

	for(int i = 0; i < test.length(); i++){
	    if(test.charAt(i) == '('){
		S.push(i);
	    }else if(test.charAt(i) == ')'){
		S.pop();
	    }
	}

	while (!S.isEmpty()){
	    System.out.println(S.pop());
	}
    }
}

	
