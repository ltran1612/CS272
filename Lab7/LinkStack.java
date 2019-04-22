/**
 * A stack data structure that uses nodes to store the data pushed into the stack.
 * @author longtran
 *
 * @param <E>
 */
public class LinkStack<E> implements StackInterface<E>{
	private SNode<E> head;
	
	/**
	 * Create a new LinkStack<E> object.
	 */
	public LinkStack(){
		head = null;
	}
	
	/**
	 * Insert an element e at the top of the stack
	 */
	public void push(E e) {
		head = new SNode<E>(e, head);
	}
	
	/**
	 * Return the top element from the stack and remove it from the top of the stack
	 * @exception RuntimeException Indicates that the list stack is empty
	 */
	public E pop() {
		if (isEmpty()) throw new RuntimeException("The link stack is empty");
		E temp = head.getData();
		head = head.getLink();
		return temp;
	}
	
	/**
	 * Return a reference to the top element on the stack
	 * @exception RuntimeException Indicates that the list stack is empty
	 */
	public E top() {
		if (isEmpty()) throw new RuntimeException("The link stack is empty");
		return head.getData();
	}
	
	/**
	 * Return the number of elements in the stack
	 */
	public int size() {
		return SNode.listLength(head);
	}
	
	/**
	 * Return true if the stack is empty and false other wise
	 */
	public boolean isEmpty() {
		if (head == null) return true;
		return false;
	}
	    
	public String toString() {
		String result = "";
		if (head == null) return result;
		
		result += head.getData();
		SNode<E> cursor = head.getLink();
		while(cursor != null) {
			result = cursor.getData() + "-" + result;
			cursor = cursor.getLink();
		}
		return result;
	}
}
