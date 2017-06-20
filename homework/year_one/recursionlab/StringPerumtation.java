import java.util.Random;

public class StringPerumtation{

    public static String permutate(String s){
	if(s.equals("")){
	    return "";
	}else {
	Random rand = new Random();
	int index = rand.nextInt(s.length());
	return s.charAt(index) + permutate(s.substring(0,index) + s.substring(index + 1));
	}
    }
    
    public static void main(String[] args){
	String word = args[0];
	System.out.println(permutate("abcd"));
	
    }
}
