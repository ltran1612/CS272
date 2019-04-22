import java.util.Stack;
/**
 * Tree Node for AVL tree
 * 
 * @author Huiping Cao
 *
 */
class AVLNode{
	private int data; 	//the element value for this node
	private AVL left;	//the left child of this node
	private AVL right;	//the right child of this node
	private int height; //height of the tree rooted at this node 
		
	public AVLNode()				{	data = 0; left = new AVL(); right = new AVL(); height = 0;}
	public AVLNode(int initData)	{	data = initData; left = new AVL();	right = new AVL();	height = 0;}
	
	/**
	 * Constructor with the initial element, initial left and right children
	 * @param initData: the initial element
	 * @param initLeft: left child
	 * @param initRight: right child
	 */
	public AVLNode(int initData, AVL initLeft, AVL initRight){
		data = initData;
		left = initLeft;
		right = initRight;
		height = 1;
	}

	
	
	public int getData()	{ return data; }
	public AVL getLeft() 	{ return left; }
	public AVL getRight() 	{ return right; }
	public int getHeight()	{ return height;}
	public void setData(int data)	{this.data = data;}
	public void setLeft(AVL left)	{ this.left = left;}
	public void setRight(AVL right)	{ this.right = right;}

	/**
	 * Set the height of the tree rooted at this node
	 */
	public void setHeight()
	{
		this.height = 1+Math.max(getLeftHeight(), getRightHeight());
	}
	
	
	/**
	 * Convert this BTNode to a string
	 */
	public String toString()
	{
		String str="";
		if(left==null) str +="(null)";
		else str +="("+left.getRoot().getData()+")";
		
		str += data;
		
		if(right==null) str +="(null)";
		else str +="("+right.getRoot().getData()+")";
		
		return str;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	//Rebalancing related methods
	
	/**
	 * Get the height of the left subtree
	 */
	public int getLeftHeight(){
		if(left==null||left.getRoot()==null) 	return 0;
		else return left.getRoot().getHeight();
	}
	
	/**
	 * Get the height of the right subtree
	 * @return: the height of the right sub-tree
	 */
	public int getRightHeight(){
		if(right==null||right.getRoot()==null) 	return 0;
		else return right.getRoot().getHeight();
	}
	
}


public class AVL {
	private AVLNode	root; //instance variable to denote the root of the AVL tree
	
	//Constructors for the AVL tree
	public AVL()		{root = null;}
	public AVL(int e)	{root = new AVLNode(e,new AVL(),new AVL());}
	
	//Basic set and get methods
	public AVLNode getRoot() 			{return root;}
	public void setRoot(AVLNode _root) 	{this.root = _root;}
	public boolean isEmpty()			{return (root==null);}
	
	private AVL getLeftSubtree()	{ return root.getLeft();	}
	private AVL getRightSubtree()	{ return root.getRight();	}
	private void setHeight()		{root.setHeight(); }
	
	/**
	 * Check whether the tree (rooted at this node) is right heavy or not
	 * @return
	 */
	private boolean rightHeavy(){
		return (root.getLeftHeight() < root.getRightHeight());
	}
	
	/**
	 * Check whether the tree (rooted at this node) is left heavy or not
	 * @param node
	 * @return
	 */
	private boolean leftHeavy(){
		return (root.getLeftHeight() > root.getRightHeight());
	}
	
	/**
	 * Check whether the tree (rooted at this node) is right too heavy or not
	 * @return
	 */
	private boolean rightTooHeavy(){
		return ((root.getLeftHeight()+1)< root.getRightHeight());
	}
	
	/**
	 * Check whether the tree (rooted at this node) is left too heavy or not
	 * @param node
	 * @return
	 */
	private boolean leftTooHeavy(){
		return (root.getLeftHeight() > (root.getRightHeight()+1));
	}
	
	
	/**
	 * Traversal the tree in-order and print it
	 */
	public void inOrderTraversal(){
		inOrderTraversal(0);
	}
	
	/**
	 * Private function to print the tree with in-order traversal
	 * @param indentation: the number of space before the data, to make the printing more beautiful
	 */
	private void inOrderTraversal(int indentation){
		if(root!=null){
			if(root.getRight()!=null)root.getRight().inOrderTraversal(indentation+1);
			for(int i=0;i<indentation*2;i++)
				System.out.print(" ");
			System.out.println(root.getData());
			if(root.getLeft()!=null)root.getLeft().inOrderTraversal(indentation+1);
		}
	}
	
	public String inOrderStr()
	{
		if(root!=null)
			return  (root.getLeft().inOrderStr() + " " + root.getData() + " " + root.getRight().inOrderStr());
		else
			return "";
	}

	/**
	 * Print the tree using pre-order traversal strategy recursively.
	 */
	public void preOrderPrtRecursive(){
		if(root==null) return;
		
		System.out.print(root.getData()+" ");
		this.getLeftSubtree().preOrderPrtRecursive();
		this.getRightSubtree().preOrderPrtRecursive();
	}
	
	//////////////////////////////
	///The homework starts here///
	//////////////////////////////
	
	private void rotateLeft() {
		AVL temp = new AVL();
		temp.setRoot(getRightSubtree().getRoot());
		getRightSubtree().setRoot(getRightSubtree().getLeftSubtree().getRoot());
		temp.getLeftSubtree().setRoot(root);
		setRoot(temp.getRoot());
		getLeftSubtree().setHeight();
		setHeight();
	}
	
	private void rotateRight() {
		AVL temp = new AVL();
		temp.setRoot(getLeftSubtree().getRoot());
		getLeftSubtree().setRoot(getLeftSubtree().getRightSubtree().getRoot());
		temp.getRightSubtree().setRoot(root);
		setRoot(temp.getRoot());
		getRightSubtree().setHeight();
		setHeight();
	}
	
	private void rebalance() {
		
		if (rightTooHeavy()) {
			
			if (getRightSubtree().leftHeavy()) {
				getRightSubtree().rotateRight();
				rotateLeft();
			}
			else {
				rotateLeft();
			}
			
		}
		else if (leftTooHeavy()) {	
			if (getLeftSubtree().rightHeavy()) {
				getLeftSubtree().rotateLeft();
				rotateRight();
			}	
			else {
				rotateRight();
			}
			
		}
		else setHeight();
	} // end rebalance. 
	
	/**
	 * Insert a new element to the AVL tree
	 * @param e
	 */
	public void insert(int e) {
		if (root == null) {
			//System.out.println("Root node");
			root = new AVLNode(e);
			setHeight();
		}
		else if (e <= root.getData()) {
			//System.out.println("Go left");
			getLeftSubtree().insert(e);
			rebalance();
		}
		else {
			//System.out.println("Go Right");
			getRightSubtree().insert(e);
			rebalance();
		}
	} // end insert
	
	/**
	 * Remove from the AVL tree the element with the input value e.
	 * @param e the input value
	 * @return true if and only if the element with the value e is removed.
	 */
	public boolean remove(int e) {
		if (root == null) return false;
		if (root.getData() == e) {
			boolean left = getLeftSubtree().getRoot() == null;
			boolean right = getRightSubtree().getRoot() == null;
			if (left && right)
				root = null;
			else if (left && !right) {
				root = getRightSubtree().getRoot();
				
			}
			else if (!left && right) {
				root = getLeftSubtree().getRoot();
				
			}
			else {
				int max = getLeftSubtree().removeMax();
				root.setData(max);
				rebalance();
			} // end else
			return true;
		} // end if
		else if (e < root.getData()) {
			boolean temp = getLeftSubtree().remove(e);
			rebalance();
			return temp;
		}
		else {
			boolean temp = getRightSubtree().remove(e);
			rebalance();
			return temp;
		}
	} // end remove
	
	private int removeMax() {
		if (getRightSubtree().getRoot() == null) {
			int temp = root.getData();
			setRoot(getLeftSubtree().getRoot());
			return temp;
		}
		return getRightSubtree().removeMax();
	}
	
	/**
	 * Count the number of tree nodes that has the input value e.
	 * @param e the input value
	 * @return the number of the tree nodes that has the input value e.
	 */
	public int countOccurrences(int e) {
		if (root == null) return 0;
		if (root.getData() == e) return 1 + getLeftSubtree().countOccurrences(e) + getRightSubtree().countOccurrences(e);
		return getLeftSubtree().countOccurrences(e) + getRightSubtree().countOccurrences(e);
	}
	
	/**
	 * Print out the all of the tree nodes by travelling in pre-order.
	 */
	public void preOrderPrtNonRecursive() {
		if (root == null) return;
		Stack<AVLNode> order = new Stack<AVLNode>();
		order.push(root);
		while (!order.isEmpty()) {
			AVLNode temp = order.pop();
			System.out.print(temp.getData()+" ");
			AVLNode rightN = temp.getRight().getRoot();
			AVLNode leftN = temp.getLeft().getRoot();
			if (rightN != null) order.push(rightN);
			if (leftN != null) order.push(leftN);
			
		}
	}
	
}

