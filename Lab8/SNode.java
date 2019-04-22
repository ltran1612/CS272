public class SNode<E> {
    private E data;
    private SNode<E> link;
    
    /**
     * Create a new SNode object of data type E with no data and link to nothing.
     */
    public SNode() {
        data = null; link = null;
    }
    
    /**
     * Return the data the node has.
     * @return the data of the node
     */
    public E getData() {
        return data;
    }
    
    /**
     * Return a reference of the node that this node links to.
     * @return
     */
    public SNode<E> getLink(){
        return link;
    }
    
    /**
     * Set the data of this node to the input data.
     * @param _data the data that this node will have.
     */
    public void setData(E _data) {
        data = _data;
    }
    
    /**
     * Link this node to the input node.
     * @param _link the node that this node will link to.
     */
    public void setLink(SNode<E> _link) {
        link = _link;
    }

}
