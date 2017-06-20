import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Cognative2 {
    public static boolean solution(String solution){
        if(solution.contains("increase") || solution.contains("increasing")){
            return true;
        }
        return false;
    }

    public static boolean guess(double[] guess){
        if(guess[0] < guess[1] && guess[1] < guess[2]){
             return true;
        }
        return false;
    }

    public static void previous(List<double[]> guesses){
        if(guesses.isEmpty()){
            System.out.println();
            System.out.println("No guesses have been made yet!");
        }
        else{
	    for(double[] guess : guesses){
		System.out.println();
		System.out.println(Arrays.toString(guess));
		System.out.println("Guess was valid: " + guess(last));
	    }
	    /*
            double[] last = guesses.get(guesses.size() - 1);

            System.out.println();
            System.out.println(Arrays.toString(last));
            System.out.println("Guess was valid: " + guess(last));
	    */
        }
    }

    public static void valid(double[] nums){
        if(guess(nums)){
            System.out.println();
            System.out.println("YES");
        }else{
            System.out.println();
            System.out.println("NO");
        }
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        boolean solved = false;
        List<double[]> guesses = new ArrayList<double[]>();

        while(!solved){
            System.out.println("----------");
            System.out.println("Make a guess of three numbers seperated by spaces");
            System.out.println("Enter \"answer\" to guess the solution and quit");
            System.out.println("Enter \"previous\" to see your last guess");
            System.out.print("> ");

            try{
                String[] input = kb.nextLine().split(" ");
                double[] nums = new double[3];

                if(input[0].equalsIgnoreCase("answer")){
                    solved = true;
                }
                else if(input[0].equalsIgnoreCase("previous")){
                    previous(guesses);
                }
                else{
                    if(input.length != 3){
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    for(int i = 0; i < input.length; i++){
                        nums[i] = Double.parseDouble(input[i]);
                    }
                    guesses.add(nums);
                    valid(nums);
                }
                //System.out.println(Arrays.toString(nums));
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println();
                System.out.println("Too many or too few numbers");
            }
            catch(NumberFormatException e){
                System.out.println();
                System.out.println("Invalid option");
            }
        }

        System.out.println("----------");
        System.out.println("Enter your solution to the pattern");
        if(solution(kb.nextLine())){
            System.out.println();
            System.out.println("That's the correct solution,");
        }
        else{
            System.out.println();
            System.out.println("That's an incorrect solution,");
        }
        System.out.println("The sequence is correct only if it increases");
    }
}
