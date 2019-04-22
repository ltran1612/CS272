public interface QueueInterface<E> {
	/**
	 * Insert element e at the rear of the queue
	 * @param e element to add
	 */
    public void enqueue(E e);
    
    /**
     * Remove the element at the front of the queue
     * @return the element at the front
     */
    public E dequeue();
    
    /**
     * Return a reference to the front element in the queue
     * @return the element at the front
     */
    public E front();
    
    /**
     * Return the number of elements in the queue
     * @return the number of elements
     */
    public int size();

    /**
     * Return true if the queue is empty and false otherwise
     * @return true if and only if the queue is empty.
     */
    public boolean isEmpty();
}
