package PL;
/*
 * Implement a reference based stack
 */
public class Stack<E> {
	
    private Node<E> top;
    int size;

    public Stack() {
	this.top =null;
	this.size = 0;
    }
	
	
       /*
	* places element on the top of the stack
	*/
    public void push(E element){
	Node<E> temp = new Node<E>(element);
	temp.next = top;
	top = temp;
	size--;
    }
	
    /*
	* remove the top node and return its contents
	*/
    public E pop(){
	if(isEmpty()){
	    return null;
	} else {
	    E temp = top.element;
	    top = top.next;
	    size--;
	    return temp;
	}
    }
	
    /*
	* Look at the top element of the Stack and return it, without removing
	*/
    public E peek(){
	if(isEmpty()){
	    return null;
	} else {
	    return top.element;
	}
    }

    public boolean isEmpty(){
	return top == null;
    }
	
    //returns the size of the stack
    public int size(){
	return size;  //replace
    }

}
