import java.util.ArrayList;
public class DoublyLinkedListDummy {
	
	DIntNode head;
	DIntNode tail;
	/**
	 * Return the head node of the list
	 * @return the head object of the list
	 */
	public DIntNode getHead() {
		if (head.getNext() == tail) return null;
		return head.getNext();
	} // end getHead
	
	/**
	 * Return the tail node of the list.
	 * @return the tail object of the list
	 */
	public DIntNode getTail() {
		if (tail.getPrev() == head) return null;
		return tail.getPrev();
	} // end getTail
	
	/**
	 * Set the head of the list to an input head.
	 * @param _head the input head object.
	 */
	public void setHead(DIntNode _head) {
		if (_head == null) return;
		if (head.getNext() == tail) return;
		head.getNext().getNext().setPrev(_head);
		_head.setNext(head.getNext().getNext());
		_head.setPrev(head);
		head.setNext(_head);
		
	} // end setHead
	
	/**
	 * Set the tail of the list to an input tail.
	 * @param _tail the input tail object.
	 */
	public void setTail(DIntNode _tail) {
		if (_tail == null) return;
		if (tail.getPrev() == head) return;
		tail.getPrev().getPrev().setNext(_tail);
		_tail.setPrev(tail.getPrev().getPrev());
		_tail.setNext(tail);
		tail.setPrev(_tail);
	} // end setTail
	
	/**
	 * Initialize a newly created DoublyLinkedListDummy with two dummy head and tail
	 */
	public DoublyLinkedListDummy() {
		head = new DIntNode(0);
		tail = new DIntNode(0);
		tail.setPrev(head);
		head.setNext(tail);
	} // end DoublyLinkedListDummy
	
	/**
	 * Add a newly created DIntNode object with the value in the argument to the end of the list
	 * @param e the input data of the node added to the end of the list.
	 */
	public void addEnd(int e) {
		tail.getPrev().setNext(new DIntNode(e, tail.getPrev(), tail));
		tail.setPrev(tail.getPrev().getNext());
	} // end addEnd
	
	/**
	 * Remove the actual head node.
	 */
	// Time complexity in Big-O is: O(1)
	public void removeFromHead() {
		if (head.getNext() == tail) return;
		head.setNext(head.getNext().getNext());
		head.getNext().setPrev(head);
	} // end removeFromHead
	
	/**
	 * A String presentation of the list in both direction.
	 */
	public String toString() { //9n + 12
		if (head.getNext() == tail) return "";
		DIntNode cursor = head.getNext();
		String result = ""+cursor.getData();
		String result2 = cursor.getData()+"";
		cursor = cursor.getNext();
		
		while (cursor != tail) { 
			result += " <-> "+cursor.getData();
			result2 = cursor.getData() + " <-> " + result2;
			cursor = cursor.getNext();
		} // end while
		
		//return result+"\n"+result2;
		return "(Forward) "+result+"\n"+"(Backward) "+result2;
	} // end toString
	
	/**
	 * Count the occurrences of the node with input value in the list.
	 * @param e the input element
	 * @return the number of input element in the list.
	 */
	// Let n be the length of the list.
	// Time complexity in Big-O: O(n)
	public int countOccurrence(int e) {
		int count = 0;
		DIntNode cursor = head.getNext();
		while (cursor != tail) {
			if (cursor.getData() == e) count++;
			cursor = cursor.getNext();
		} // end while
		return count;
	} // end countOccurrence
	
	/** 
	 * Remove all the nodes with the input value.
	 * @param e the input value
	 * @return true if and only if there is at least one node is removed.
	 */
	// Let n be the length of the list.
	// Time complexity in Big-O: O(n)
	public boolean removeAll(int e) {
		DIntNode cursor = head.getNext();
		boolean hasDelete = false;
		while(cursor != tail) {
			if (cursor.getData() == e) {
				cursor.getPrev().setNext(cursor.getNext());
				cursor.getNext().setPrev(cursor.getPrev());
				hasDelete = true;
			} // end if
			cursor = cursor.getNext();
		} // end while
		return hasDelete;
	} // end removeAll
	
	/**
	 * Return a new doubly linked list which copies the portion of this list between the 
	 * specified begin index (inclusive), and end index (exclusive)
	 * @param beginIdx the begin index
	 * @param endIdx the end index
	 * @return the sublist of the list from beginIdx (inclusive) to endIdx (exclusive)
	 * @throws IllegalArgumentExcpetion Indicates that the begin index is negative
	 * @throws IllegalArgumentException Indicates that the begin index is bigger than the length of the list
	 * @throws IllegalArgumentException Indicates that the begin index is bigger than the end index
	 */
	// Let n be the length of the list.
	// Time complexity in Big-O: O(n)
	public DoublyLinkedListDummy subList(int beginIdx,int endIdx) {
		if(beginIdx < 0) throw new IllegalArgumentException("begin index is negative.");
		if(beginIdx > length()) throw new IllegalArgumentException("begin index is bigger than the length of the list.");
		if (beginIdx > endIdx) throw new IllegalArgumentException("begin index is bigger than the end index");
		int count = 0;
		DIntNode cursor = head.getNext();
		DoublyLinkedListDummy result = new DoublyLinkedListDummy();
		while (cursor != tail && count < endIdx) {
			if (count >= beginIdx) result.addEnd(cursor.getData());
			count++;
			cursor = cursor.getNext();
		} // end while
		return result;
	} // end subList
	
	/**
	 * Print a list of every distinguish elements with its number of occurrences in the linked list.
	 */
	public void printStatistics() {
		DIntNode cursor = head.getNext();
		ArrayList<Integer> number = new ArrayList<Integer>(2);
		
		while (cursor != tail) {
			if (!(number.contains(cursor.getData()))) {
				number.add(cursor.getData());
				System.out.printf("%-8d %s\n", cursor.getData(), countOccurrence(cursor.getData()));
			} // end if
			cursor = cursor.getNext();
		} // end while
	} // end printStatistics
	
	private int length() {
		int count = 0;
		DIntNode cursor = head.getNext();
		while (cursor != tail) {count++; cursor = cursor.getNext();}
		return count;
	} // end length
	
	public static void main(String[] args) {
		DoublyLinkedListDummy list1 = new DoublyLinkedListDummy(); // test constructor
		DoublyLinkedListDummy list0 = new DoublyLinkedListDummy(); // a list with no node except the dummy nodes.
		
		
		
		for (int i = 1; i < 8; ++i) list1.addEnd(i); // test addToEnd
		
		System.out.println("List 1\n"+list1); // test toString
		System.out.println("\nList 0\n"+list0); // test toString with empty list
		
		for (int i = 0; i < 4; ++i) list1.addEnd(2); // add a bunch of 2 to the end
		
		System.out.println("List 1 after adding a bunch of 2 to the end"
				+ ":\n"+list1+"\nOccurrences of 2 in list 1: "
				+list1.countOccurrence(2)+"\n"); // test countOccurrence
		
		// test removeAll
		list1.removeAll(2); // test removeAll
		list0.removeAll(0); // test removeAll with empty list
		System.out.println("List 1 after remove all the 2:\n"+list1+"\nOccurrences of 2: "+list1.countOccurrence(2));  // test countOccurrence
		System.out.println("\nList 0 after remove all the 0:\n"+list0); 
		System.out.println("Occurrence of 0 in list0: "+list0.countOccurrence(0)); // test countOccurrence with empty list
		
		// test removeFromHead
		list1.removeFromHead();	// test removeFromHead
		list0.removeFromHead(); // test removeFromHead with empty list
		System.out.println("\nList 1 after removing the head:\n"+list1);
		System.out.println("\nList 0 after removing the head:\n"+list0);
		
		// test subList
		System.out.println("\nList 1 is\n"+ list1);
		System.out.println("\nThe sublist of list 1 from 2, 9 is\n" + list1.subList(2, 9));
		System.out.println("\nThe sublist of list 1 from 0, 3 is\n"+ list1.subList(0, 3));
		
		// error case for sublist
		//list1.subList(8, 1);
		//list1.subList(-1, 9);
		//list1.subList(4, 0);
		
		// test printStatistics
		list1.printStatistics();
		DoublyLinkedListDummy list2 = new DoublyLinkedListDummy();
		
		System.out.println();
		for (int i = 0; i < 9; ++i) list2.addEnd(i);
		list2.addEnd(4);
		list2.addEnd(7);
		System.out.println("List 2:\n"+list2+"\n");
		list2.printStatistics();
		
		for (int i = 0; i < 10; ++i) list2.addEnd(9);
		System.out.println("\nList 2:\n"+list2+"\n");
		list2.printStatistics();
		
		// Test getter, setter method.
		System.out.println("list1: "+list1+"\n"+"list0"+list0+"\n");
		System.out.println(list1.getHead());
		System.out.println(list1.getTail());
		System.out.println(list0.getHead());
		System.out.println(list0.getTail());
		
		list1.setHead(new DIntNode(12));
		list1.setTail(new DIntNode(18));
		list0.setHead(new DIntNode(1231)); // if the first actual node has not been added, do nothing
		list0.setTail(new DIntNode(12321));// if the first actual node has not been added, do nothing
		
		System.out.println("list1: "+list1+"\n"+"list0"+list0+"\n");
		System.out.println(list1.getHead());
		System.out.println(list1.getTail());
		System.out.println(list0.getHead());
		System.out.println(list0.getTail());
	} // end main
	
} // end class
