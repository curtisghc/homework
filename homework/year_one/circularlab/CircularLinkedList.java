package CLL;
import java.util.Iterator;

public class CircularLinkedList<E> implements Iterable<E> {

	
	
	// Your variables
	// You can include a reference to a tail if you want
	Node<E> head;
	int size;  // BE SURE TO KEEP TRACK OF THE SIZE

	
	// implement this constructor
	public CircularLinkedList() {
	    this.head = null;
	    this.size = 0;
	}


	// writing helper functions for add and remove, like the book did can help
	// but remember, the last element's next node will be the head!



	// attach a node to the end of the list
	// Be sure to handle the adding to an empty list
	// always returns true 
	public boolean add(E e) {
	    return add(size, e);
	}

	
	// need to handle
	// out of bounds
	// empty list
	// adding to front
	// adding to middle
	// adding to "end"
	// REMEMBER TO INCREMENT THE SIZE
	public boolean add(int index, E e){
	    if(index > size || index < 0){
		throw new ArrayIndexOutOfBoundsException();
	    }else if(size == 0){
		this.head = new Node<E>(e);
		this.head.next = this.head;
		size++;
		return true;
	    }else if(index == size){
		Node<E> current = getNode(index - 1);
		current.next = new Node<E>(e);
		current.next.next = this.head;
		size++;
		return true;
	    }else {
		Node<E> current = getNode(index - 1);
		Node<E> temp = new Node<E>(e);
		temp.next = current.next;
		current.next = temp;
		size++;
		return true;
	    }
	}

	// I highly recommend using this helper method
	// Return Node<E> found at the specified index
	// be sure to handle out of bounds cases
	private Node<E> getNode(int index ) {
	    if(index > (size - 1) || index < 0){
		throw new ArrayIndexOutOfBoundsException();
	    }else{
		Node<E> current = this.head;
		for(int i = 0; i < index; i++){
		    current = current.next;
		}
		return current;
	    }
	}

	
	
	// remove must handle the following cases
	// out of bounds
	// removing the only thing in the list
	// removing the first thing in the list (need to adjust the last thing in the list to point to the beginning)
	// removing the last thing (if you have a tail)
	// removing any other node.
	// REMEMBER TO DECREMENT THE SIZE
	public E remove(int index) {
	    if(index > (size - 1) || index < 0){
		throw new ArrayIndexOutOfBoundsException();
	    }else if(index == 0){
		Node<E> end = getNode(size - 1);
		Node<E> oldHead = this.head;
		this.head = this.head.next;
		end.next = this.head;
		size--;
		return oldHead.element;
	    }else if(index == (size - 1)){
		Node<E> nextToLast = getNode(size - 2);
		Node<E> last = nextToLast.next;
		nextToLast.next = head;
		size--;
		return last.element;
	    }else{
		Node<E> current = getNode(index - 1);
		Node<E> toRemove = current.next;
		current.next = current.next.next;
		size--;
		return toRemove.element;
	    }
	}
	
	
	
	
	// Turns your list into a string
	// Useful for debugging
	public String toString(){
		Node<E> current =  head;
		StringBuilder result = new StringBuilder();
		if(size == 0){
			return "";
		}
		if(size == 1) {
			return head.getElement().toString();
			
		}
		else{
			do{
				result.append(current.getElement());
				result.append(" -> ");
				current = current.next;
			} while(current != head);
		}
		return result.toString();
	}
	
	
	public Iterator<E> iterator() {
		return new ListIterator<E>();
	}
	
	// provided code
	// read the comments to figure out how this works and see how to use it
	// you should not have to change this
	// change at your own risk!
	private class ListIterator<E> implements Iterator<E>{
		
		Node<E> nextItem;
		Node<E> prev;
		int index;
		
		@SuppressWarnings("unchecked")
		//Creates a new iterator that starts at the head of the list
		public ListIterator(){
			nextItem = (Node<E>) head;
			index = 0;
		}

		// returns true if there is a next node
		// this is always should return true if the list has something in it
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return size != 0;
		}
		
		// advances the iterator to the next item
		// handles wrapping around back to the head automatically for you
		public E next() {
			// TODO Auto-generated method stub
			prev =  nextItem;
			nextItem = nextItem.next;
			index =  (index + 1) % size;
			return prev.getElement();
	
		}
		
		// removed the last node was visted by the .next() call 
		// for example if we had just created a iterator
		// the following calls would remove the item at index 1 (the second person in the ring)
		// next() next() remove()
		public void remove() {
			int target;
			if(nextItem == head) {
				target = size - 1;
			} else{ 
				target = index - 1;
				index--;
			}
			CircularLinkedList.this.remove(target); //calls the above class
		}
		
	}
	
	
	// Solve the problem in the main method
	// The answer of n = 13,  k = 2 is 
	// the 11th person in the ring (index 10)
	public static void main(String[] args){
		CircularLinkedList<Integer> l =  new CircularLinkedList<Integer>();
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		
		for(int i = 1; i <= n; i++){
		    l.add(i);
		}
		
		// use the iterator to iterate around the list
		Iterator<Integer> iter = l.iterator();
		
		while(l.size > 1){
		    System.out.println(l.toString());
		    //for(int i = 0; i < (k - 1); i++){
		    for(int i = 0; i < k; i++){
			iter.next();
		    }
		    //System.out.println("Person " + iter.next() + " removed");
		    iter.remove();
		}
		System.out.println(l);
		//System.out.println("Final person: " + l);

	}



	
}
