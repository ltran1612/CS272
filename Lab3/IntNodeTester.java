
public class IntNodeTester {

public static void main(String[] args) {
		
		IntNode head = new IntNode();
		// add more nodes after the head node
		for (int i = 1; i < 10; ++i) 
			head.addNodeAfterThis(i); // add node after head node
		System.out.println(head);
		
		// find the node that before the node contains value 4
		IntNode cursor = head;
		if (cursor.getValue() != 4) 
			while (cursor.getLink().getValue() != 4)
			cursor = cursor.getLink();
		
		// Remove the node containing the value 4
		System.out.println("Remove the node with number " + cursor.getLink().getValue());
		cursor.removeNodeAfterThis(); // remove the node with the 4
		System.out.println(head);
		
		// Search for the nodes with the value 3 and 4 in the list starting from head node.
		System.out.println("The number 3 is in the list? " + IntNode.search(head, 3));
		System.out.println("The number 4 is in the list? " + IntNode.search(head, 4));
		
		// The length of the list starting from the head
		System.out.println("The length of the list start from head " + IntNode.listLength(head));
		head.getLink().addNodeAfterThis(123);
		System.out.println(head);
		System.out.println("The length of the list start from head after adding another node " + IntNode.listLength(head));
		
		System.out.println("The length of the list starting from the second node " + IntNode.listLength(head.getLink()));
		
		// Checking the set method using the node2 and node
		System.out.println("\nnode2 -> node");
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
		
		// Test toString method
		System.out.println("\n"+head);
		System.out.println(head.getLink().toString());
		
		System.out.println("The length of a null node " + IntNode.listLength(null));
		
		// test error case
		System.out.println("\nError cases");
		IntNode tail = new IntNode(2, null);
		IntNode header = new IntNode(12, tail);
		System.out.println(header);
		System.out.println("Calling removeNodeAfter at the tail, do nothing");
		tail.removeNodeAfterThis();
		System.out.println(header);
		
		System.out.println("\nThe error cases of search method");
		IntNode error = null;
		System.out.println(IntNode.search(error, 1));
		
	} // end main

}
