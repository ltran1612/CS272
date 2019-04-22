/**
 * A data structure containing String objects, whose space can grow automatically.
 * @author ltran1612	
 * @since 4th February 2019
 * @note possible amount of current objects is the same as space.
 */
public class StringSet {
	private String[] data;
	private int numItems;
	
	/**
	 * Initializes a newly created StringSet object whose capacity is 2 and the number of String objects is 0.
	 * @postcondition The set is empty and has a given initial capacity
	 */
	public StringSet() {
		numItems = 0;
		data = new String[2];
	} // end StringSet
	
	/**
	 * Initializes a newly created StringSet object whose capacity is the same as the argument and the number of String objects is 0.
	 * @param _capacity the initial capacity.
	 * @precondition _capacity is positive.
	 * @postcondition The set is empty and has a given initial capacity
	 * @exception IllegalArgumentException Indicate that _capacity is negative.
	 */
	public StringSet(int _capacity) {
		if (_capacity < 0) 
			throw new IllegalArgumentException("The input capacity is negative.");
		
		numItems = 0;
		data = new String[_capacity];
	} // end StringSet
	
	/**
	 * Initializes a newly created StringSet object that has the same data as the argument.
	 * @param obj 
	 * @precondition The argument is not null and is an instance of StringSet.
	 * @postcondition The bag has the same data as the argument.
	 * @exception IllegalArgumentException Indicate that the argument is null.
	 * @exception IllegalArgumentException Indicate that the argument is not an instance of StringSet.
	 */
	public StringSet(Object obj) {
		if (obj == null) throw new IllegalArgumentException("The input is null.");
		if (!(obj instanceof StringSet)) throw new IllegalArgumentException("The input is not an instance of StringSet.");
		
		StringSet set = (StringSet) obj;
		
		numItems = set.numItems;
		data = new String[set.data.length];
		System.arraycopy(set.data, 0, data, 0, numItems);
	} // end StringSet
	
	/**
	 * Return the current number of String objects.
	 * @return the current number of String objects of this StringSet object.
	 */
	public int size() {
		return numItems;
	} // end size
	
	/**
	 * Return the current possible amount of String objects. 
	 * @return the current possible number of String objects.
	 */
	public int capacity() {
		return data.length;
	} // end capacity
	
	/**
	 * Add a String object to this StringSet object.
	 * @param a The String object which may be added to this StringSet object.
	 * @precondition the String object is not null and no String objects with the same value has been added to this StringSet object before.
	 * @exception IllegalArgumentException Indicates that the String object input is null.
	 * @postcondition There are no duplications of any String objects in the StringSet objects after adding.
	 * @note If the current number of String objects is equal to the current possible String objects, the number of possible String objects will be expanded two times bigger.
	 */
	public void add(String a) {
		if (a == null) throw new IllegalArgumentException("The String input is null.");
		if (contains(a)) return; // already contain this -> end the method.
		if (numItems == data.length) ensureCapacity(data.length*2);
		
		data[numItems] = new String(a);
		numItems++;
	} // end add
	
	private void ensureCapacity(int minimumCapacity) {
		if (minimumCapacity < 0) throw new IllegalArgumentException("The capacity is negative.");
		if (minimumCapacity < data.length) return;
		
		String[] bigger = new String[minimumCapacity];
		System.arraycopy(data, 0, bigger, 0, numItems);
		
		data = bigger;
		
	} // end ensureCapacity
	
	/**
	 * Checking if this StringSet object has a String object with the same value with the String input.
	 * @param a The String input.
	 * @return true - An String object has been found. <br/>
	 * false - No String object has been found or the String input is null.
	 * @precondition The String input must not be null. If it is null, return false.
	 */
	public boolean contains(String a) {
		if (a != null) 
			for (int i = 0; i < numItems; ++i) 
				if (data[i].equals(a)) return true;
		
		return false;	
	} // end contains
	
	/**
	 * Remove a String object with the same value as the String input.
	 * @param a the String input.
	 * @return true - A String object has been removed. <br/>
	 * false - No String object has been removed.
	 */
	public boolean remove(String a) {
		if (a != null)
			for (int i = 0; i < numItems; ++i) 
				if (data[i].equals(a)) {
					data[i] = new String(data[numItems-1]);
					numItems--;
					return true;
				} // end if
		return false;
	} // end remove
	
	/**
	 * Add a String object to this StringSet object and sort all the String objects in this StringSet object in ascending order.
	 * @param a the String object which may be added.
	 * @precondition the String object must not be null and no String objects with the same value has been added to this StringSet object before.
	 * @exception IllegalArgumentException Indicates that the String object is null.
	 * @postcondition There are no duplications and the String objects are sorted in ascending order.
	 * {@add()}
	 */
	public void addOrdered(String a) {
		add(a);
		sort();
	} // end addOrdered
	
	// used to sort the String objects, bubble sort. Used for addOrdered()
	private void sort() {
		int b = numItems-1;
		boolean swapped  = true;
		while (swapped) {
			swapped = false;
			for (int j = 0; j < b; ++j) 
				if (data[j].compareToIgnoreCase(data[j+1]) > 0) { //
					String temp = new String(data[j]);
					data[j] = new String(data[j+1]);
					data[j+1] = new String(temp);
					swapped = true;
				} // end if
			b--;
		} // end while
	} // end sort
	
	// printing the values of all the String objects.
	private void print() { // for testing addOrdered and other methods
		for (int i = 0; i < numItems; ++i) 
			System.out.printf("%s ", data[i]);
	}
	
	public static void main(String[] args) {
		
		int[] integer = new int[1]; // to test error case
		String set0 = null; // to test error case
		
		StringSet set1 = new StringSet();
		set1.add("long");
		set1.add("long");
		set1.add("tran");
		set1.add("tran");
		set1.add("john");
		set1.add("john"); // if then size is 3, means no duplication.
		set1.add("john");
		
		// test one-argument construtor
		StringSet set2 = new StringSet(10);
		System.out.println("Set2: size - capacity " + set2.size()+" "+set2.capacity());
			//StringSet set3 = new StringSet(-1); // error case one-arguement constructor
		
		// test copy constructor
		StringSet set4 = new StringSet(set1);
			//set4 = new StringSet(integer); // error case
			//set4 = new StringSet(set0); // error case
		
		System.out.print("set1 == set4 ");
		System.out.println(set4.size()==set1.size() && set4.capacity()==set4.capacity());
		
		// test contains, size, capacity, add methods.
		System.out.println("Set1: size - capacity " + set1.size()+" "+set1.capacity());
		System.out.println("Set1: contain? \"long\" - \"A\" " + set1.contains("long")+" "+set1.contains("A"));
		
		// test remove
		System.out.println("\nAfter removing \"long\" ");
		set1.remove("long");
		System.out.println("Set1: contain? \"long\" - \"A\" " + set1.contains("long")+" "+set1.contains("A"));
		System.out.println("Set1: size - capacity " + set1.size()+" "+set1.capacity());
		set1.print();
		
		// test add, after remove
		System.out.println("\n\nAfter adding \"A\" ");
		set1.add("A");
		System.out.println("Set1: contain? \"long\" - \"A\" " + set1.contains("long")+" "+set1.contains("A"));
		System.out.println("Set1: size - capacity " + set1.size()+" "+set1.capacity());
		set1.print();
		
		// test addOrdered
		System.out.println("\n");
		for (char a = 'z'; a >= 'a'; --a) 
			set2.addOrdered(a+"");
		set2.addOrdered("Adam");
		System.out.println("Set2: size - capacity " + set2.size() + " " + set2.capacity());
		set2.print();	
		
	} // end main
} // end class
