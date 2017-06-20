package stack;

public class Stack<E>{

    private Node<E> top;
    private int size;

    public Stack(){
	top = null;
	size = 0;
    }

    public boolean isEmpty(){
	return top == null;
    }
    
    public int size(){
	return size;
    }

    public E peek(){
	return top.getData();
    }
    
    public E pop(){
	if(isEmpty()){
	    return null;
	}
	E temp = top.getData();
	top = top.getNext();
	return temp;
    }

    public void push(E element){
	Node<E> temp = new Node<E>(element);
	temp.setNext(top);
	top = temp;
    }
}
