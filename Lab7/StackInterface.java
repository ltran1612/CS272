
public interface StackInterface<E> {
	
	/**
	 * Insert an object to the stack.
	 */
	public void push(E e);
	
	/**
	 * Remove the top element from the stack, and return that top element
	 * Report if the stack is empty.
	 */
	public E pop();
	
	/**
	 * Return the top element of the statck
	 */
	public E top();
	
	/**
	 * Return the number of elements of the stack
	 */
	public int size();
	
	/**
	 * Return true if the stack is empty and false otherwise.
	 */
	public boolean isEmpty();
	
}
