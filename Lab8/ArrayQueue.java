/**
 * A queue data structure that use array to store data.
 * @author longtran
 *
 * @param <E> the data type of the element of this queue.
 */
public class ArrayQueue<E> implements QueueInterface<E> {
    
    private int front, rear, numE;
    private E[] data;
    
    /**
     * Create a new ArrayQueue object of data type E with no element.
     */
    public ArrayQueue() {
        front = rear = numE = 0;
        data = (E[]) new Object[3];
    }
    /**
	 * Insert element e at the rear of the queue
	 * @param e element to add
	 */
    public void enqueue(E e) {
    	if (e == null) return;
        if (numE == data.length) ensureCapacity(); 
        
        data[rear] = e;
        rear = (rear+1)%data.length;  
        numE++;
    }
    
    /**
     * Remove the element at the front of the queue
     * @return the element at the front
     * @exception RuntimeException Indicates that the queue is empty
     */
    public E dequeue() {
        if (numE == 0) throw new RuntimeException("The queue is empty");
        numE--;
        E temp = data[front];
        front = (front+1)%data.length;
        if (rear == front) {rear = front = 0;}
        return temp;
    }
    
    /**
     * Return a reference to the front element in the queue
     * @return the element at the front
     * @exception RuntimeException Indicate that the queue is empty
     */
    public E front() {
        if (numE == 0) throw new RuntimeException("The queue is empty");
        return data[front];
    }
    
    /**
     * Return the number of elements in the queue
     * @return the number of elements
     */
    public int size() {
        return numE;
    }
    
    /**
     * Return true if the queue is empty and false otherwise
     * @return true if and only if the queue is empty.
     */
    public boolean isEmpty() {
        return numE == 0;
    }
    
    private void ensureCapacity() {
    	E[] temp = (E[]) new Object[numE * 2];
    	System.arraycopy(data, front, temp, 0, numE-front);
    	System.arraycopy(data, 0, temp, numE-front, rear);
    	rear = numE; front = 0;  
    	
    	data = temp;
    }
    
    /**
     * Return a string presentation of the queue.
     */
    public String toString() {
    	if (numE == 0) return "Empty Queue";
        String result = ""+data[front];
        if (rear > front) 
        	for (int i = front+1; i < rear; ++i) result += "-"+data[i];
        else {
        	for (int i = front+1; i < data.length; ++i) result += "-"+data[i];
        	for (int i = 0; i < rear; ++i) result += "-"+data[i];
        }
        return result;
    }
    
}
