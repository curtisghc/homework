import java.util.Scanner;
import java.util.Arrays;
public class Cognative {
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


    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        boolean solved = false;
        while(!solved){
            System.out.println("----------");
            System.out.println("Make a guess of three numbers seperated by spaces");
            System.out.println("or enter Answer to guess the solution and quit");

            try{
                String[] input = kb.nextLine().split(" ");
                double[] nums = new double[3];
                if(input[0].equalsIgnoreCase("answer")){
                    solved = true;
                }else{
                    if(input.length != 3){
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    for(int i = 0; i < input.length; i++){
                        nums[i] = Double.parseDouble(input[i]);
                    }
                }

                //System.out.println(Arrays.toString(nums));
                if(guess(nums)){
                    System.out.println();
                    System.out.println("YES");
                }else{
                    System.out.println();
                    System.out.println("NO");
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println();
                System.out.println("Too many or too few numbers");
            }catch(NumberFormatException e){
                System.out.println();
                System.out.println("Invalid option");
            }
        }

        System.out.println("----------");
        System.out.println("Enter your solution to the pattern");
        if(solution(kb.nextLine())){
            System.out.println("That's probably the correct solution,");
        }else{
            System.out.println("That's probably the incorrect solution,");
        }
        System.out.println("The sequence is correct if it increases");
    }
}
