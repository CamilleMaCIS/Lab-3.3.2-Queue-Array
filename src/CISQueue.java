import java.util.Arrays;

public class CISQueue<T> {

    // Array property with generic type T
    private T[] queue;
    
    // Size property.
    private int size;
    
    // Index pointer. Indicates the index of the most recently added element.
    // Aka the last element in the queue
    private int pointer;

    // Constructor.
    public CISQueue(int size){
        pointer = -1;
        // Since Java doesn't allow Arrays with generic type, need to cast Object[] to T[]
        queue = (T[]) new Object[size];
        this.size = 0;
    }

    // Enqueue. This method adds a node to the end of the array.
    public void enqueue(T data){
        //Queue is full
        if(size == queue.length){
            System.out.println("Queue is full!");
        }
        else{
            pointer++;
            size++;
            queue[pointer] = data;
        }
    }

    // Dequeue. This method removes a node from the beginning of the array.
    //returns the removed node data
    public T dequeue(){
        if (size == 0){
            System.out.println("Queue is empty!");
            return null;
        }
        else{
            T removedElement = queue[0];
            reshuffle();
            //decrement rear and size since last element is removed
            pointer--;
            size--;
            return removedElement;
        }
    }

    // isEmpty. Returns a boolean indicating whether the array is empty.
    public boolean isEmpty(){
        return (size == 0);
    }

    // size. Returns the size of the queue.
    public int size(){
        return this.size;
    }

    // reshuffle. Moves each element down one index. Called whenever we dequeue.
    private void reshuffle(){
        //e.g. {1,2,3,4,5} will become {2,3,4,5,5}, and the last element will become null
        //so will become {2,3,4,5,null}, leaving room for more enqueues
        for (int i = 0; i < size - 1; i++){
            queue[i] = queue[i+1];
        }
        queue[pointer] = null;
    }

    // toString. Returns a description of the queue in, for example, the following format:
    // CISQueue{queue=[7, 11], size=2, pointer=1}
    public String toString(){
        String queueElements = "";
        for (int i = 0; i < queue.length - 1; i++){
            queueElements += queue[i] + ", ";
        }
        queueElements += queue[queue.length-1];
        return "CISQueue{queue=[" + queueElements + "], size=" + this.size + ", pointer=" + this.pointer + "}";
    }
}
