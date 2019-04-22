/**
 * A queue data structure that uses node to store data.
 * @author longtran
 *
 * @param <E> the data type of the element of the queue
 */
public class LinkedQueue<E> implements QueueInterface<E> {

    private SNode<E> front;
    private SNode<E> rear;
    private int numE;
    
    /**
     * Create a new LinkedQueue Object of data type E with no element
     */
    public LinkedQueue() {
        front = rear = null;
        numE = 0;
    }
    
    /**
	 * Insert element e at the rear of the queue
	 * @param e element to add
	 */
    public void enqueue(E e) { 
    	if (e == null) return;
        SNode<E> temp = new SNode<E>();
        temp.setData(e);
        temp.setLink(null);

        if (rear == null) {front = rear = temp;}
        else {rear.setLink(temp); rear = temp;}

        numE++;
    }
    
    /**
     * Remove the element at the front of the queue
     * @return the element at the front
     * @exception RuntimeException Indicates that the queue is empty
     */
    public E dequeue() {
        if (front == null) throw new RuntimeException("The queue is empty");

        E temp = front.getData();
        front = front.getLink();
        if (front == null) rear = null;

        numE--;
        return temp;
    }
    
    /**
     * Return a reference to the front element in the queue
     * @return the element at the front
     * @exception RuntimeException Indicates that the queue is empty
     */
    public E front() {
        if (front == null) throw new RuntimeException("The queue is empty");
        return front.getData();
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
    
    /**
     * Return a string presentation of the queue.
     */
    public String toString() {
    	if (front == null) return "Empty String";
    	String result = ""+front.getData();
    	for (SNode<E> cursor = front.getLink(); cursor != null; cursor = cursor.getLink())
    		result += "-"+cursor.getData(); 
    	
    	return result;
    }
}
