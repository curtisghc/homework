package PL;
/*
 * Implement a reference based queue
 */
public class Queue<E> {
	
    private Node<E> front;
    private Node<E> back;
    int size;

    public Queue() {
	this.front = null;
	this.back  = null;
	size = 0;
    }


    /*
	* places element in the back of the Queue
	*/
    public void enqueue(E element){
	Node<E> temp = new Node<E>(element);
	if(isEmpty()){
	    front = temp;
	    back = temp;
	}else {
	    back.next = temp;
	    back = temp;
	}
	size++;

    }

    /*
	* remove the front node of the queue and return it
	*/
    public E dequeue(){
	if(isEmpty()){
	    return null;
	} else {
	    E temp = front.element;
	    front = front.next;
	    size--;
	    return temp;
	}
    }

    /*
	* Look at the front of the queue and return it, without removing
	*/
    public E peek(){
	if(isEmpty()){
	    return null;
	} else {
	    return front.element;
	}
    }

    //returns the size of the queue
    public int size(){
	return size;  //replace
    }

    public boolean isEmpty(){
	return front == null;
    }

}
