package stack;
public class Anagram{

    public static void main(String[] args){

	String input = args[0];

	Stack<Character> S = new Stack<Character>();

	for(int i = 0; i < input.length(); i++){
	    S.push(input.charAt(i));
	}

	boolean ana = true;
	
	for(int i = 0; i < input.length(); i++){
	    if(input.charAt(i) != S.pop()){
		ana = false;
	    }
	}
	System.out.println(ana);
    }
}
	 
	    
	     
