package List;
import java.lang.System;
public class MyList<E> {

    private final int INITIAL_SIZE = 10;
    private E array[] = (E[]) new Object[INITIAL_SIZE];
    private int size = 0;

    public void reallocate(){
        System.arraycopy(array, 0, array, 0, array.length * 2);
    }

    public int size(){
        return size;
    }

    public void add(E element){
        add(this.size, element);
    }

    public void add(int index, E element){
        if(index <= this.size){
            if(index == 0){
                for(int i = this.size; i >= index; i--){
                    array[i + 1] = array[i];
                }
                array[index] = element;
            }else{
                add(index - 1, element);
            }
            this.size++;
        }else{
            throw new IndexOutOfBoundsException();
        }
        if(size == array.length){
            reallocate();
        }
    }

    public void set(int index, E element){
        array[index] = element;
    }

    public boolean contains(E element){
        for(E item: array){
            if(element.equals(item)){
                return true;
            }
        }
        return false;
    }

    public E get(int index){
        return array[index];
    }

    public int indexOf(E element){
        for(int i = 0; i < this.size; i++){
            if(element.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public void remove(int index){
        for(int i = index; i < size; i++){
            array[i] = array[i + 1];
        }
    }
}
