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
	
	/**
	 * Get the number of even numbers in the list.
	 * @param head the starting node of the list that will be searched.
	 * @return the number of even number in the list
	 */
	public static int listEvenNumber(IntNode head) {
		IntNode cursor = head;
		int count = 0;
		while (cursor != null) {
			if (cursor.data % 2 == 0) count++;
			cursor = cursor.link;
		} // end while
		return count;
	} //  end listEvenNumber
	
	/**
	 * Create a new node with an argument data, and add it to the end of the list of the object calling this method.
	 * @param newdata the data of the node that will be added to the end.
	 */
	public void addToEnd(int newdata) {
		IntNode cursor = this;
		while (cursor.link != null) 
			cursor = cursor.link;
		cursor.addNodeAfterThis(newdata);
	} // end addToEnd
	/**
	 * Get the sum of the input number of last nodes.
	 * @param head the input head of a list.
	 * @param num the number of last nodes which will be sum up.
	 * @return the sum of all of the input number amount of last nodes.
	 * @exception IllegalArgumentException Indicates that the head node is null.
	 */
	public static int sumLast(IntNode head, int num) {
		if (head == null) throw new IllegalArgumentException("input head node is null.");
		int result = 0;
		IntNode cursor = head;
		int count = 1;
		
		// find the node of position listLength - num + 1(the num node counting from the last node)
		while (cursor != null && count < (IntNode.listLength(head)-num+1)) {
			cursor = cursor.link;
			count++;
		} // end while	
		
		// sum up the value from the node founded. 
		while (cursor != null) 	{
			result += cursor.data;
			cursor = cursor.link;
		} // end while
		return result;
	} // end sumLast
	
	/**
	 * Get a new list of all of the nodes with odd number from an list starting from an input head.
	 * @param head the input head of a list.
	 * @return a new head of a new list with all of the nodes with odd number from the list with the input head.
	 */
	public static IntNode copyOdd(IntNode head) {
		IntNode result = new IntNode(0, null);
		IntNode cursor = head;
		while (cursor != null) {
			if (cursor.data % 2 != 0) result.addToEnd(cursor.data);
			cursor = cursor.link;
		} // end while
		
		return result.link;
	} // end copyOdd
	
	/**
	 * Remove all the nodes having the same value as the input number in an input list and return a new head for that list.
	 * @param head the input head of a list.
	 * @param e the input number
	 * @return a new head of the old list which has all of the nodes with the same value as the input number removed.
	 */
	public static IntNode removeAll(IntNode head, int e) {
		if (head == null) return null;
		
		// move the new head to a node with value different from e
		while (head != null && head.data == e )
			head = head.link;
		
		// once reaching a node with value different from e
		
		IntNode preC = head; // assign preCursor to the node with value different from e
		
		// check and remove the nodes with the value e until the end of the list starting from the new head.
		while (preC != null && preC.link != null) {
			IntNode cursor = preC.link;
			if (cursor.data == e) preC.removeNodeAfterThis(); 
			else preC = preC.link;
		} // end while
		
		return head; // return the new head with all the nodes with e value removed.
	} // end removeAll
	
	/**
	 * Get a new list with reverse order from an input list.
	 * @param head the input head of a list.
	 * @return a new head of the new list which has reverse order from the list with the input head. return null if the list is null.
	 */
	public static IntNode reverse(IntNode head) {
		if (head == null) return null;
		IntNode cursor = head.link;
		head = new IntNode(head.data, null);
		while (cursor != null) {
			head = new IntNode(cursor.data, head);
			cursor = cursor.link;
		} // end while
		return head;
	} // end reverse
	
	/**
	 * Check if the list with input head is cyclic or acyclic
	 * @param head the input head of a list.
	 * @return true if and only if the list with the input head is cyclic.
	 * 
	 */
	// rabbit start off ahead of tortoise with a speed greater than the tortoise by 1 node.
	// When both tortoise and rabbit enter the cycle, 
	// since the rabbit moves only one step ahead of the tortoise and it is a cycle.
	// which is like a race track.
	// the tortoise and rabbit will eventually meet each other.
	// To explain it mathematically. If the linked list has a loop,
	// the i element in side the loop will be the same as the i+ka element, where a is the the length of the loop and k is the number of loop.
	// Thus, if we can see that i element is equal to i + ka element, a loop is found.
	// However, because a is unknown, we must go for a special case where i = ka; thus, the i element will be equal to the 2i element.
	// As a result, if the i element is the same as the 2i element, there is a loop.
	public static boolean hasCycle(IntNode head) {
		if (head == null) return false; // 
		if (head.link == null) return false;
		IntNode tortoise = head; // say that tortoise start at index 1
		IntNode rabbit = tortoise.link; // rabbit  start at index 2 * 1 = 2
		
		// tortoise: i + 1(node/operations)*operations
		// rabbit: 2i + 2 (nodes/operations)*operations
		// rabbit/tortoise = 2. Thus, the index of rabbit is twice that of tortoise.
		while (rabbit != tortoise) { // if tortoise and rabbit is the same, the rabbit is found
			
			// if the linked list has an end, this is not a cycle
			if (tortoise.link == null) return false; 
			if (rabbit.link == null) return false;
			if (rabbit.link.link == null) return false;
			
			tortoise = tortoise.link; // 1 node/operation
			rabbit = rabbit.link.link; // 2 nodes/operation
			// the difference in the speed of rabbit and tortoise is one node. Thus, the rabbit will never go pass the turtle because 
		}
		return true;
	} // hasCycle
	
} // end class
