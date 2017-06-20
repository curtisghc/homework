package index;

import java.io.*;

public class IndexTree{

    // This is your root 
    private IndexNode root;

    // Make your constructor
    public IndexTree(){
	this.root = null;
    }



    // complete the methods below

    // call your recursive add method
    public void add(String word, int lineNumber){
	this.root = add(root, word, lineNumber);
    }
	
    public IndexNode add(IndexNode root, String word, int lineNumber){
	if(root == null){
	    return new IndexNode(word, lineNumber);
	}

	int compare = word.compareTo(root.word);
	
	if(compare == 0){
	    root.addLine(lineNumber);
	    return root;
	}else if(compare < 0){
	    root.left = add(root.left, word, lineNumber);
	    return root;
	}else {
	    root.right = add(root.right, word, lineNumber);
	    return root;
	}
    }

    // returns true if the word is in the index
    public boolean contains(String word){
	    return false;
    }

    // call your recursive method
    public void delete(String word){

    }

    // your recursive case
    // remove the word and all the entries for the word
    private IndexNode delete(IndexNode root, String word){
	    return null;
    }


    // prints all the words in the index in inorder order
    public void printIndex(IndexNode root){
	if (root == null){
	    return;
	}else {
	    printIndex(root.left);
	    System.out.println(root.toString());
	    printIndex(root.right);
	}
    }


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
		    word = word.replaceAll("[!()\".,:;?*]", "");
		    index.add(word,lineNumber);
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
	index.printIndex(index.root);
    }
}
