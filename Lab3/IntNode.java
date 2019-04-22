/**
 * The IntNode class represents the node used in linked lists. An IntNode object will contain an int value and a link to another node.
 * @author longtran
 * @since February 9, 2019
 *
 */
public class IntNode {
	private int data;
	private IntNode link;
	
	/**
	 * Initialize a newly created IntNode object so that it contains 0 and link to no other node.
	 */
	public IntNode() {
		data = 0;
		link = null;
	} // end IntNode
	
	/**
	 * Initialize a newly created IntNode object with the int value, and link to the node in the argument.
	 * @param _data the int value that the node contains.
	 * @param _link the next node that the node will link to.
	 */
	public IntNode(int _data, IntNode _link) {
		data = _data;
		link = _link;
	} // end IntNode
	
	/**
	 * Get the int value of the node calling this method.
	 * @return the int value of the current object(node).
	 */
	public int getValue() {
		return data;
	} // end getValue
	
	/**
	 * Get the link of the node calling this method.
	 * @return the IntNode object (link) of the current object(node).
	 */
	public IntNode getLink() {
		return link;
	} // end getLink
	
	/**
	 * Set the int value of this object(node) to the argument.
	 * @param _data the int value to which the int value of the calling node will be set.
	 */
	public void setValue(int _data) {
		data = _data;
	} // end setValue
	
	/**
	 * Set the link of the IntNode object in the argument.
	 * @param _link the IntNode object to which the link of the calling node will be set.
	 */
	public void setLink(IntNode _link) {
		link = _link;
	} // end setLink
	
	/**
	 * Count the number of nodes in a linked list starting from the arugment node.
	 * @param head the node from which the counting starts.
	 * @return the number of nodes starting from argument.
	 */
	public static int listLength(IntNode head) {
		int count = 0;
		IntNode cursor = head;
		while (cursor != null) {
			count++;
			cursor = cursor.link;
		}
		return count;
	} // end listLength
	
	/**
	 * Get a String presentation of the list.
	 * @return a String for the linked list starting from the node that calls this method.
	 */
	public String toString() {
		String result = ""+data;
		IntNode cursor = link;
		while (cursor != null) {
			result = result + " -> " + cursor.data;
			cursor = cursor.link;
		}
		return result;
	} // end toString
	
	/**
	 * Add a new node initialized with the int value in the argument after the node calling this method.
	 * @param newdata the value of the new added node.
	 */
	public void addNodeAfterThis(int newdata) {
		link = new IntNode(newdata, link);
	} // end addNodeAfterThis
	
	/**
	 * Search for the value in the linked list after the node in the argument. 
	 * @param head the starting node.
	 * @param data the value looked for in the list.
	 * @return true if and only if the node with the int value in the argument is found in the list.
	 * @precondition the head node is not a null. 
	 * @throws IllegalArgumentException Indicates that the head node is a null. 
	 */
	public static boolean search(IntNode head, int data) {
		if (head == null) throw new IllegalArgumentException("The head node is a null.");
		IntNode cursor = head;
		while (cursor != null) { //looking for the value in the list.
			if (cursor.data == data) return true; // found, true
			cursor = cursor.link;
		}
		return false; // not found, false
	} // end search
	
	/**
	 * Remove the node the node calling this method links to.
	 * @notes if the node calling this method is the tail, the method will do nothing.
	 */
	public void removeNodeAfterThis() {
		if (link == null) return;
		link = link.link;
	} // end removeNodeAfterThis

} // end class
