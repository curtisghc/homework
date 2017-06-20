package PL;
import java.util.Scanner;
import java.lang.StringBuilder;

public class PalindromeChecker {

    public static boolean isPalindrome(String s){
	Stack<Character> S = new Stack<Character>();
	Queue<Character> Q = new Queue<Character>();
	
	for(int i = 0; i < s.length(); i++){
	    S.push(s.charAt(i));
	    Q.enqueue(s.charAt(i));
	}

	while(!S.isEmpty()){
	    if(!(S.pop() == Q.dequeue())){
		return false;
	    }
	}
	return true;
    }

    public static String onlyLowercaseLetters(String s){
	StringBuilder SB = new StringBuilder();
	String letters = "abcdefghijklmnopqrstuvwxyz";
	s = s.toLowerCase();

	for(int i = 0; i < s.length(); i++){
	    if(letters.contains("" + s.charAt(i))){
		SB.append(s.charAt(i));
	    }
	}
	return SB.toString();
    }

    public static void main(String[] args){
	Scanner KB = new Scanner(System.in).useDelimiter("\\n");
	Stack<String> palindromes = new Stack<String>();
	String input = "";

	while(!input.equals("quit")){
	    
	    System.out.println();
	    System.out.println("Enter potential palindrome");
	    System.out.print("> ");

	    input = KB.next();
	    String parsedInput = onlyLowercaseLetters(input);

	    if(isPalindrome(parsedInput)){
		System.out.println();
		System.out.println("Palindrome");
		palindromes.push(input);
	    } else {
		System.out.println();
		System.out.println("Not a palindrome");
	    }
	}

	System.out.println();
	System.out.println("Palindromes entered:");
	System.out.println();

	while(!palindromes.isEmpty()){
	    System.out.println(palindromes.pop());
	}
    }
}
