import java.util.ArrayList;

/**
 * Heap data structure that stores the smallest value on top.
 * @author ltran
 *
 */
public class MinHeap {
	private ArrayList<Integer> data;
	
	/**
	 * Create an empty heap
	 */
	public MinHeap() {
		data = new ArrayList<Integer>();
	}
	
	/**
	 * Add a new value into the heap
	 * @param e the input value
	 */
	public void add(int e) {
		data.add(e);
		reheapUpward(data.size()-1);
	}
	
	/**
	 * Remove and return the top value of the heap
	 * @return the top value of the heap. If the heap is empty, return -1
	 */
	public int remove() {
		if (data.size() == 0) return -1; // error case
		int temp = data.get(0);
		int last = data.size()-1;
		data.set(0, data.get(last));
		data.remove(last);
		reheapDownward(0);
		return temp;
	}
	
	/**
	 * Return the top value of the heap
	 * @return the top value of the heap. If the heap is empty, return -1
	 */
	public int top() {
		if (data.size() == 0) return  -1;
		return data.get(0);
	}
	
	//****************************//
	/**
	 * Return the index of the left child of the root with the input index
	 * @param p the index of the root.
	 * @return the index of the left child of the root with the input index.
	 */
	private int getLeftChildIdx(int p) {
		int child = 2 * p + 1;
		if (child >= data.size()) return -1;
		return child;
	}
	
	/**
	 * Return the index of the right child of the root with the input index
	 * @param p the index of the root.
	 * @return the index of the right child of the root with the input index.
	 */
	private int getRightChildIdx(int p) {
		int child = 2 * p + 2;
		if (child >= data.size()) return -1;
		return child;
	}
	
	/**
	 * Return the index of the parent of the tree node with the input index 
	 * @param c the input index
	 * @return the index of the parent of the tree node with the input index 
	 */
	private int getParentIdx(int c) {
		int parent = (c - 1) / 2;
		if (parent < 0)  return -1;
		return parent;
	}
	
	private void reheapUpward(int pos) {
		if(pos <= 0) return;
		int parent = getParentIdx(pos);
			
		_switch(parent, pos);

		reheapUpward(parent);
	}
	
	private void reheapDownward(int pos) {
		if (pos < 0) return;
		int left = getLeftChildIdx(pos);
		int right = getRightChildIdx(pos);
		
		if (right < 0) _switch(pos, left);
		else {
			int leftValue = data.get(left); 
			int rightValue = data.get(right);
			int min = -1;
			if (leftValue < rightValue) min = left;
			else min = right;
			_switch(pos, min);
			reheapDownward(min);
		} //end else				
	} 
	
	private void _switch(int pos1, int pos2) {
		if (pos1 == -1 || pos2 == -1) return;
		if (data.get(pos1) > data.get(pos2)) {
			int temp = data.get(pos1);
			data.set(pos1, data.get(pos2));
			data.set(pos2, temp);
		} // end if   
	}
	
	/**
	 * Print the heap out. If the heap is empty, print nothing. 
	 */
	public void print() {	
		if (data.size() == 0) return;
		treePrint(0, 0);
	}
	
	private void treePrint(int idx, int space) {
		if (idx < 0) return; // base case
		
		treePrint(getRightChildIdx(idx), space + 1); // print the right subtree.
		
		// print the root
		for (int i = 0; i < space; ++i) System.out.print(" ");
		System.out.println(data.get(idx));
		
		treePrint(getLeftChildIdx(idx), space + 1); // print the left subtree
	}
	
	public static void main(String[] args) {
		testPrint();
		testAdd();
		testRemove();
		testTop();
	}
	
	public static void testPrint() {
		System.out.println("\ntest print function: ");
		MinHeap tree = new MinHeap();
		tree.add(2); System.out.println("\nAdd 2"); tree.print();
		tree.add(4); System.out.println("\nAdd 4"); tree.print();
		tree.add(5); System.out.println("\nAdd 5"); tree.print();
	}
	
	public static void testAdd() {
		System.out.println("\ntest add function: ");
		MinHeap tree = new MinHeap();
		tree.add(2); System.out.println("\nAdd 2"); tree.print();
		tree.add(4); System.out.println("\nAdd 4"); tree.print();
		tree.add(5); System.out.println("\nAdd 5"); tree.print();
		tree.add(3); System.out.println("\nAdd 3, reheapification upward needed"); tree.print();
		tree.add(6); System.out.println("\nAdd 6"); tree.print();
		tree.add(9); System.out.println("\nAdd 9"); tree.print();
		tree.add(1); System.out.println("\nAdd 1, reheapification upward needed"); tree.print();
	}
	
	public static void testRemove() {
		System.out.println("\ntest remove function: ");
		MinHeap tree = new MinHeap();
		MinHeap error = new MinHeap();
		int top;
		tree.add(3); System.out.println("\nAdd 3"); tree.print();
		tree.add(1); System.out.println("\nAdd 1 reheapification upward needed"); tree.print();
		tree.add(2); System.out.println("\nAdd 2"); tree.print();
		tree.add(4); System.out.println("\nAdd 4"); tree.print();
		tree.add(5); System.out.println("\nAdd 5"); tree.print();
		top = tree.remove(); System.out.println("\nremove "+top); tree.print();
		tree.add(6); System.out.println("\nAdd 6"); tree.print();
		tree.add(7); System.out.println("\nAdd 7"); tree.print();
		top = tree.remove(); System.out.println("\nremove "+top); tree.print();
		System.out.println("Calling remove on an empty tree, value is "+ error.remove()); error.print();
	}
	
	public static void testTop() {
		System.out.println("\ntest top function: ");
		MinHeap tree = new MinHeap();
		MinHeap error = new MinHeap();
		
		int top;
		tree.add(3); System.out.println("\nAdd 3"); tree.print();
		tree.add(2); System.out.println("\nAdd 2 reheapification upward needed"); tree.print();
		tree.add(1); System.out.println("\nAdd 1 reheapification upward needed"); tree.print();
		tree.add(4); System.out.println("\nAdd 4"); tree.print();
		tree.add(5); System.out.println("\nAdd 5"); tree.print();
		top = tree.top(); System.out.println("\nthe top value "+top); tree.print(); 
		System.out.println("Calling top on an empty tree, value is "+ error.top()); error.print();

	}
	
	
}
