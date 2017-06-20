import java.io.File;
import java.util.Scanner;
public class Names {

    public static String[] input(String filepath){
        String[] failure = {"failure"};
        try{
            File file = new File(filepath).getAbsoluteFile();
            Scanner sc = new Scanner(file).useDelimiter("\\Z");
            String unParsedNames = sc.next();
            sc.close();
            String[] namesArr = unParsedNames.split("\",\"|\"");
            return namesArr;
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return failure;
    }

    public static void alphabeticalSort(String[] array){
        while(!isSorted(array)){
            //System.out.println("alphabeticalSort iteration");
            for(int i = 0; i < array.length - 1; i++){
                if(!isBefore(array[i], array[i + 1])){
                    String temp = array[i];
                    array[i] = array[i + 1];
                    array[i+1] = temp;
                }
            }
        }
    }

    public static boolean isSorted(String[] array){
        //System.out.println("length of array for isSorted: " + array.length);
        for(int i = 0; i < array.length - 1; i++){
            //System.out.println("checking array elements: " + array[i] + " " + array[i+1]);
            //System.out.println("isbefore: " + isBefore(array[i], array[i+1]));
            if(!isBefore(array[i], array[i+1])){
                return false;
            }
        }
        return true;
    }

    //return true if s1 is larger than s2
    /*
    public static boolean isBefore(String s1, String s2){
        for(int i = 0; i < s1.length() && i < s2.length(); i++){
            if(s1.charAt(i) > s2.charAt(i)){
                System.out.print(s1.charAt(i) + ">" + s2.charAt(i));
                System.out.println(": "+ (s1.charAt(i) > s2.charAt(i)));

                return false;
            }
        }
        return !(s1.length() > s2.length());
    }
    */


    //return true if s1 is larger than s2
    public static boolean isBefore(String s1, String s2){
        for(int i = 0; i < s1.length() && i < s2.length(); i++){
            if(s1.charAt(i) < s2.charAt(i)){
                return true;
            }else if(s1.charAt(i) > s2.charAt(i)){
                return false;
            }
        }
        return !(s1.length() > s2.length());
    }

    public static int score(String name){
        int sum = 0;
        for(int i = 0; i < name.length(); i++){
            sum += ((int) name.charAt(i)) - 'A' + 1;
        }
        return sum;
    }

    public static void main(String[] args){
        String namesFile = "names";
        String[] names = input(namesFile);
        //System.out.println(Arrays.toString(names));
        alphabeticalSort(names);
        int total = 0;
        int index = 1;
        for(String name: names){
            System.out.println(index + ": " + index * score(name));
            total += index * score(name);
            index++;
        }
        System.out.println(total);
    }
}
