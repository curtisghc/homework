package index;

import java.io.*;

public class TreeStuff {

     public static void main(String[] args){

	IndexTree index = new IndexTree();

	// add all the words to the tree

	// print out the index

	// test removing a word from the index
	
	String fileName = "pg2240.txt";
	String line = null;
	BufferedReader bufferedReader;
	int lineNumber = 1;

	try {

	    bufferedReader= new BufferedReader(new FileReader(fileName));

	    while(bufferedReader.ready()) {
		line = bufferedReader.readLine();

		//System.out.println(line);
		String[] words = line.split("\\s+");
		for(String word : words){
		    word = word.replaceAll("[.,:;?*]", "");
		    IndexTree.add(word,lineNumber);
		    //System.out.println(word);
		}
		lineNumber++;
	    }

	    bufferedReader.close();         
	}
	catch(FileNotFoundException e) { 
	    System.err.println("File not found");                
	}
	// catch any other exception
	catch(Exception e) {
	    e.printStackTrace();
	}
    }
}
