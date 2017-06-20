package LL;
import java.lang.StringBuilder;
public class LinkedList<E>{

    private Node<E> head;
    private int size;

    public LinkedList(){
	this.head = null;
	this.size = 0;
    }

    public boolean isEmpty(){
	return this.head == null;
    }
    
    public int getSize(){
	return this.size;
    }

    public void add(E data){
	add(this.size, data);
    }

    public void add(int index, E data){

	if(index > size){
	    throw new IndexOutOfBoundsException();
	}
	
	if(this.head == null ){
	    this.head = new Node<E>(data, null);
	    return;
	}

	Node<E> current = this.head;
	while(index > 0){
	    current = current.getNext();
	    index--;
	}
	Node<E> temp = new Node<E>(data, current.getNext());
	current.setNext(temp);
	size++;
    }

    public E get(int index){
	if(index > size){
	    throw new IndexOutOfBoundsException();
	}

	Node<E> current = this.head;
	while(index > 0 && current.getNext() != null){
	    current = current.getNext();
	    index--;
	}
	return current.getData();
    }

    public void set(int index, E data){
	Node<E> current = this.head;
	while(index > 0 && current.getNext() != null){
	    current = current.getNext();
	    index--;
	}
	current.setData(data);
    }

    public String toString(){
	StringBuilder sb = new StringBuilder();
	Node<E> current = this.head;
	while(current.getNext() != null){
	    sb.append(current.getData() + "->");
	    current = current.getNext();
	}
	sb.append(current.getData() + "->");
	return sb.toString();
    }
}
