import java.util.ArrayList;
/**
 * A stack data structure that uses array list to store the data pushed into the stack. 
 * @author longtran
 *
 * @param <E> defining the type of data this stack will store.
 */
public class ArrayListStack<E> implements StackInterface<E> {
	private ArrayList<E> data;
	
	/**
	 * Create a new ArrayListStack<E> object.
	 */
	public ArrayListStack() {
		data = new ArrayList<E>();
	}
	
	/**
	 * Insert an element e at the top of the stack
	 */
	public void push(E e) {
		data.add(e);
	}
	
	/**
	 * Return the top element from the stack and remove it from the top of the stack
	 * @exception RuntimeException Indicates that the array stack is empty
	 */
	public E pop() {
		if (data.isEmpty()) throw new RuntimeException("The arraylist stack is empty");
		E temp = data.get(data.size()-1);
		data.remove(data.size()-1);
		return temp;
	}
	
	/**
	 * Return a reference to the top element on the stack
	 * @exception RuntimeException Indicates that the array stack is empty
	 */
	public E top() {
		if (data.isEmpty()) throw new RuntimeException("The arraylist stack is empty");
		return data.get(data.size()-1);
	}
	
	/**
	 * Return the number of elements in the stack
	 */
	public int size() {
		return data.size();
	}
	
	/**
	 * Return true if the stack is empty and false other wise
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public String toString() {
		return data.toString();
	}
}	
