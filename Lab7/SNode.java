
public class SNode<E> {
	private E data;
	private SNode<E> link;
	
	/**
	 * Create a new SNode object with default value.
	 */
	public SNode() {
		data = null;
		link = null;
	}
	
	/**
	 * Create a new SNode object with input values.
	 * @param _data input data
	 * @param _link input link
	 */
	public SNode(E _data, SNode<E> _link) {
		data = _data;
		link = _link;
	}
	
	/**
	 * Set the value of data of the node to the input data.
	 * @param _data input data
	 */
	public void setData(E _data) {
		data = _data;
	}
	
	/**
	 * Set the link of the node to the input link
	 * @param _link the input link
	 */
	public void setLink(SNode<E> _link) {
		link = _link;
	}
	
	/**
	 * Get the data of the node
	 * @return
	 */
	public E getData() {
		return data;
	}
	
	/**
	 * Get the link of the node
	 * @return
	 */
	public SNode<E> getLink() {
		return link;
	}
	
	/**
	 * Return the length of the list
	 * @param head
	 * @return
	 */
	public static int listLength(SNode head) {
		if (head == null) return 0;
		return 1 + listLength(head.link);
	}
	
}
