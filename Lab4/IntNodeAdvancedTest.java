
public class IntNodeAdvancedTest {
	public static void main(String[] args) {
		
		IntNode head = new IntNode();
		// add more nodes after the head node
		for (int i = 1; i < 10; ++i) 
			head.addNodeAfterThis(i); // add node after head node
		System.out.println(head);
		
		// find the node that before the node contains value 4
		IntNode cursor = head;
		while (cursor.getLink().getValue() != 4)
			cursor = cursor.getLink();
		
		// Remove the node containing the value 4
		System.out.println("Remove the node with number " + cursor.getLink().getValue());
		cursor.removeNodeAfterThis(); // remove the node with the 4
		System.out.println(head);
		
		// Searchn for the nodes with the value 3 and 4 in the list starting from head node.
		System.out.println("The number 3 is in the list? " + IntNode.search(head, 3));
		System.out.println("The number 4 is in the list? " + IntNode.search(head, 4));
		// The length of the list starting from the head
		System.out.println("The length of the list start from head " + IntNode.listLength(head));
		
		// Checking the set method using the node2 and node
		System.out.println("node2 -> node");
		IntNode node = new IntNode(1, null);
		IntNode node2 = new IntNode(2, node); // node 2 link to node 
		System.out.println(node2);
		
		// checking the setValue method on node2
		System.out.println("the list after changing the value of node2");
		node2.setValue(10);
		System.out.println(node2);
		
		// checking the setLink method on node2
		System.out.println("the list after change the link of node2 to a new node");
		node2.setLink(new IntNode(123, null)); // change the link of node2 to a new node.
		System.out.println(node2);
		
		// test error case
		IntNode error = null;
		//System.out.println(IntNode.search(error, 1));
		
		// Test add to end+listEvenNumber+sumLast+copyOdd
		head.addToEnd(12);
		System.out.println("\nThe list starting from head after adding 12 to the end: \n"+head);
		
		System.out.println("The number of even nodes: "+IntNode.listEvenNumber(head));
		System.out.println("The number of even nodes in a null node: "+IntNode.listEvenNumber(error));
		
		System.out.println("The sum of the last 8 nodes: "+IntNode.sumLast(head, 8));
		System.out.println("the sum of the last 20 nodes: " + IntNode.sumLast(head, 20));
		//System.out.println("The sum of the last 8 nodes of a null list: "+IntNode.sumLast(error, 8));
		
		System.out.println("The list of odd numbers in the list: "+IntNode.copyOdd(head));
		System.out.println("The list of odd numbers in a null list: "+IntNode.copyOdd(error));
		System.out.println("The head and the odd list are pointing to the same nodes? "+theSameList(head, IntNode.copyOdd(head)));
		
		// Test removeAll
		System.out.println("\nremoveAll");
		IntNode removeTest = new IntNode(5, null);
		removeTest.addNodeAfterThis(5);
		removeTest.addNodeAfterThis(2);
		removeTest.addNodeAfterThis(5);
		for (int i = 0; i < 2; ++i) removeTest.addNodeAfterThis(4);
		System.out.println(removeTest);
		IntNode removeTest2 = new IntNode(5, null);
		removeTest2.addNodeAfterThis(2);
		removeTest2.addNodeAfterThis(4);
		removeTest2.addNodeAfterThis(5);
		removeTest2.addNodeAfterThis(5);
		removeTest2.addToEnd(5);
		System.out.println(removeTest2);
		IntNode removeTest3 = new IntNode(5, null);
		for (int i = 0; i < 4; ++i) removeTest3.addNodeAfterThis(5);
		System.out.println(removeTest3);
		System.out.println("The removeTest list after removing all 5: "+IntNode.removeAll(removeTest, 5));
		System.out.println("The removeTest2 list after removing all 5: "+IntNode.removeAll(removeTest2, 5));
		System.out.println("The removeTest3 list after removing all 5: "+IntNode.removeAll(removeTest3, 5));
		System.out.println("The reuslt of calling removeAll using a null list: "+IntNode.removeAll(error, 1));
		
		// Test reverse
		System.out.println("\nreverse");
		IntNode reverseTest = new IntNode(12, null);
		reverseTest.addNodeAfterThis(34);
		reverseTest.addNodeAfterThis(0);
		reverseTest.addNodeAfterThis(28);
		System.out.println("The reverseTest list: " + reverseTest);
		System.out.println("The reverseTest list after reversing at 12: "+IntNode.reverse(reverseTest));
		System.out.println("The reverseTest list after reversing at 28: "+IntNode.reverse(reverseTest.getLink()));
		System.out.println("The reverseTest list after reversing at 0: "+IntNode.reverse(reverseTest.getLink().getLink()));

		
		//Test hasCycle
		System.out.println("\nhasCycle");
		// cyclic list
		IntNode cyclicTest = new IntNode(12, null);
		cyclicTest.addNodeAfterThis(1);
		cyclicTest.addNodeAfterThis(2);
		cyclicTest.addNodeAfterThis(3);
		cyclicTest.getLink().getLink().getLink().setLink(cyclicTest);
		IntNode cyclicTest2 = new IntNode(12, null);
		for (int i = 0; i < 5; ++i) cyclicTest2.addNodeAfterThis(i);
		cyclicTest2.getLink().getLink().getLink().getLink().getLink().setLink(cyclicTest2.getLink());
		IntNode cyclicTest3 = new IntNode(12, null);
		cyclicTest3.addNodeAfterThis(2);
		cyclicTest3.addNodeAfterThis(5);
		cyclicTest3.getLink().getLink().setLink(cyclicTest3.getLink().getLink());
		
		// acyclic list
		IntNode acyclicTest = new IntNode(13, null);
		acyclicTest.addNodeAfterThis(5);
		acyclicTest.addNodeAfterThis(6);
		acyclicTest.addNodeAfterThis(7);
		
		System.out.println("cyclicTest is cyclic ? "+IntNode.hasCycle(cyclicTest));
		System.out.println("cyclicTest2 is cyclic ? "+IntNode.hasCycle(cyclicTest2));
		System.out.println("cyclicTest3 is cyclic ? "+IntNode.hasCycle(cyclicTest3));
		System.out.println("acyclicTest is cyclic ? "+IntNode.hasCycle(acyclicTest));
		


		
		
		
	} // end main
	
	public static boolean theSameList(IntNode a, IntNode b) {
		IntNode cursor1 = a;
		IntNode cursor2 = b;
		
		while (cursor1 != null) {
			while (cursor2 != null) {
				if (cursor1 == cursor2) return true;
				cursor2 = cursor2.getLink();
			} // end while cursor2
			cursor1 = cursor1.getLink();
		} // end while cursor1
		return false;
	} // end notTheSameList
} // end class
