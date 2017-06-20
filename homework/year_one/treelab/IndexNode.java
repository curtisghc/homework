package index;

import java.util.ArrayList;

public class IndexNode  {

    // The word for this entry
    String word;
    // The number of occurences for this word
    int occurences;
    // A list of line numbers for this word.
    ArrayList<Integer> list; 

    IndexNode left;
    IndexNode right;


    //Constructors
	
    public IndexNode(String word, int lineNumber){
	this.word = word;
	this.left = null;
	this.right = null;
	list = new ArrayList<Integer>();
	list.add(lineNumber);
	occurences++;
    }
	
    public void addLine(int lineNumber){
	list.add(lineNumber);
	occurences++;
    }
	
	
    // Complete This
    // return the word and the lines it appears on.
    // string must be one line
    public String toString(){
	return word + " " + list.toString();
    }
	
	
	
}
