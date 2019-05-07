/**
 * A hash table data structure to store Book objects with the key is the object ISBN
 * @author ltran
 *
 */
public class BookTable {
	private int[] ISBN;
	private Book[] data;
	private boolean[] used;
	private int num;
	
	/**
	 * Create a new BookTable object.
	 */
	public BookTable() {
		ISBN = new int[1];
		data = new Book[1];
		used = new boolean[1];
		num = 0;
	}
	
	/**
	 * Get the hash value of the ISBN.
	 * @param key the ISBN
	 * @return the hash value of key.
	 */
	private int hash(int key) {
		return (Math.abs(key) % data.length);
	}
	
	/**
	 * Put a new Book object into the BookTable object with the key is the book ISBN
	 * @param e the book object to be put in.
	 * @throws IllegalArgumentException Indicates that the book to be put in does not have ISBN.
	 */
	public void put(Book e) {		
		if (e == null)return;
		if (e.getISBN() < 0) throw new IllegalArgumentException("The book does not have ISBN");
		
		if (num == data.length) ensureCapacity(num * 2);
		
		int idx = search(e.getISBN());
		if (idx >= 0) {
			data[idx] = e;
		}
		else {
			idx = hash(e.getISBN());
			while (used[idx]) // collisions
 				idx = (idx + 1) % data.length;
			
			data[idx] = e;
			ISBN[idx] = e.getISBN();
			used[idx] = true;
			num++;
		}
		
	}
	
	/**
	 * Remove the Book object with the input ISBN from the table.
	 * @param isbn the input ISBN
	 * @return true if and only if a book is removed.
	 */
	public boolean remove(int isbn) {
		int idx = search(isbn);
		if (idx < 0) return false;
		
		data[idx] = null;
		ISBN[idx] = 0;
		used[idx] = false;
		num--;
				
		return true;
	}
	
	/**
	 * Search for the object with the input ISBN and return its hash value.
	 * @param isbn the input ISBN
	 * @return the hash value of the Book with the input ISBN if the the ISBN exists in the table and return -1 otherwise.
	 */
	public int search(int isbn) {
		int idx = hash(isbn);
		int count = 0;
		while (count < data.length && used[idx]) {
			if (isbn == ISBN[idx]) return idx;
			idx = (idx + 1) % data.length;
			count++;
		}
		
		return -1;
	}
	
	/**
	 * 
	 */
	private void ensureCapacity(int length) {
		int[] _ISBN = new int[length];
		Book[] _data = new Book[length];
		boolean[] _used = new boolean[length];
		
		for (int i = 0; i < data.length && used[i]; ++i) {
			
			int newIdx = (Math.abs(ISBN[i]) % length);
			
			while (_used[newIdx]) // collisions
 				newIdx = (newIdx + 1) % data.length;
			
			_ISBN[newIdx] = ISBN[i];
			_data[newIdx] = data[i];
			_used[newIdx] = used[i];
		}
		
		ISBN = _ISBN;
		data = _data;
		used = _used;
	}
	
	// For testing
	/**
	 * Print the content of the book at the given index.
	 * @param idx
	 */
	public void printValue(int idx) {
		if (idx < 0) {
			System.out.println("Not in the table"); 
			return;
		}
		System.out.println(data[idx]);
	}
	
	public static void main(String[] args) {

	}

}
