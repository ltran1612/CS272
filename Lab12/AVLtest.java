
public class AVLtest {

	public static void main(String[] args) {	
		myInsertRemoveTest1();
		myTestForOthers();
	}
	
	private static void myInsertRemoveTest1() {
		System.out.println("********myInsertRemoveTest1*********");
		AVL testTree = new AVL();
		testTree.insert(10); System.out.println("insert 10"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(8); System.out.println("insert 8"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(5); System.out.println("insert 5 case 2"); testTree.inOrderTraversal(); System.out.println();
		System.out.println("remove 5: "+testTree.remove(5)); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(13); System.out.println("insert 13 case 1"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(16); System.out.println("insert 16"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(14); System.out.println("insert 14 case 3"); testTree.inOrderTraversal(); System.out.println();
		System.out.println("remove 14: "+testTree.remove(14)); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(6); System.out.println("insert 6"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(4); System.out.println("insert 4 case 4"); testTree.inOrderTraversal(); System.out.println();
		System.out.println("remove 16: "+testTree.remove(16)); testTree.inOrderTraversal(); System.out.println();
		//System.out.println("left height: "+testTree.getRoot().getLeft().getRoot().getLeftHeight());
		//System.out.println("right height: "+testTree.getRoot().getLeft().getRoot().getRightHeight());
		//System.out.println("root height: "+testTree.getRoot().getLeft().getRoot().getHeight());
		System.out.println("remove 13 cases where the left subtree is neither left heavy nor right heavy: "+testTree.remove(13)); testTree.inOrderTraversal(); System.out.println();
		System.out.println("remove 3, the number not in the tree: "+testTree.remove(3)); testTree.inOrderTraversal(); System.out.println();
		
		
		AVL emptyTree = new AVL();
		System.out.println("remove 2 from an empty tree: "+emptyTree.remove(2)); testTree.inOrderTraversal(); System.out.println();


		
	}
	
	private static void myTestForOthers() {
		System.out.println("********myTestForOthers******");
		AVL testTree = new AVL();
		testTree.insert(10); System.out.println("insert 10"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(6); System.out.println("insert 6"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(15); System.out.println("insert 15"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(12); System.out.println("insert 12"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(12); System.out.println("insert 16"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(13); System.out.println("insert 13"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(3); System.out.println("insert 3"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(3); System.out.println("insert 3 again"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(4); System.out.println("insert 4"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(6); System.out.println("insert 6 again"); testTree.inOrderTraversal(); System.out.println();
		testTree.insert(2); System.out.println("insert 2"); testTree.inOrderTraversal(); System.out.println();
		System.out.println("Count occurences of 3: "+testTree.countOccurrences(3));
		System.out.println("Count occurences of 2: "+ testTree.countOccurrences(2));
		
		
		System.out.println("Pre-order recursive");
		testTree.preOrderPrtRecursive();
		System.out.println("\nPre-order nonrecursive");
		testTree.preOrderPrtNonRecursive();
		
		AVL emptyTree = new AVL();
		System.out.println("Count occurences of 3 in an empty tree: "+emptyTree.countOccurrences(3));
		System.out.println("Count occurences of 2 in an empty tree: "+emptyTree.countOccurrences(2));
		System.out.println("Pre-order recursive in an empty tree");
		emptyTree.preOrderPrtRecursive();
		System.out.println("\nPre-order nonrecursive in an empty tree");
		emptyTree.preOrderPrtNonRecursive();
	}
}
