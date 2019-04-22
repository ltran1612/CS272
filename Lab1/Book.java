/**
 * The Book class can create objects containing data of books.
 * @author longtran
 * @since 28 January 2019
 * @version 1.0
 * @note An object of this class contains: <br/>
 * + The title of a book. <br/>
 * + The number of authors of a book. <br/>
 * + The authors of a book. <br/>
 * + The isbn number of a book. 
 */
public class Book {
	// instance variables
	private String title;
	private int numOfAuthors;
	private String[] author;
	private String isbn;
	
	/**
	 * Initializes a new Book object with default values
	 * @author longtran 
	 * @param - none 
	 * @note
	 * title to null <br/>
	 * isbn to null <br/>
	 * numOfAuthors to 0 <br/>
	 * author to a String array of length 3
	 */
	// default value constructor
	public Book() {
	    title = null;
	    isbn = null;
	    numOfAuthors = 0;
	    author = new String[3];
	} // end Book
	
	/**
	 * Initializes title with an input value and other with default values
	 * @author longtran
	 * @param _title the input title of the book
	 * @note
	 * title to _title <br/>
	 * isbn to null <br/>
	 * numOfAuthors to 0 <br/>
	 * author to a String array of length 3
	 */
	// constructor with a title input
	public Book(String _title) {
		title = new String(_title);
		isbn = null;
		numOfAuthors = 0;
		author = new String[3];
	} // end Book
	
	/**
	 * Initialize the object with the data of another Book object
	 * @author 
	 * longtran
	 * @param 
	 * obj the object of data type Object from which this object will copy the data.
	 * @Precondition
	 * obj is not null and an instance of Book class.
	 * @throws 
	 * Exception if the input is either null or not an instance of a class. 
	 */
	
	// copy constructor
	public Book(Object obj){
		try { 
			if (obj == null) throw new Exception("NullValueInput"); // throw an Exception if the input is null

			if (obj instanceof Book) { // input has to be an instance of Book
				Book b = (Book)obj; //
				title = b.title;
				isbn = b.isbn;
				numOfAuthors = b.numOfAuthors;
				author = b.author.clone();	
			} // end if
			else throw new Exception("NotAnInstanceOfBookClassInput Caught"); // throw an Exception if the input is not an instance of Book
		} // end try
		
		catch (Exception e) {
			throw new RuntimeException(e.getMessage()+ "." + " Please check the input");
		} // end catch
	} // end Book
	
	
	// getter
	/**
	 * Get the title of the book
	 * @author longtran
	 * @param -none
	 * @return the title of the book 
	 */
	public String getTitle() {
		return title;
	} 
	
	/**
	 * Get the number of author of the book
	 * @author longtran
	 * @return the number of authors of the book
	 */
	public int getAuthorNumber() {  
		return numOfAuthors;
	} 
	
	/**
	 * Get the ISBN of the book
	 * @author longtran
	 * @return the ISBN of the book
	 */
	public String getISBN() {
		return isbn;
	} 
	
	// setter
	/**
	 * Set the title of the book
	 * @author longtran
	 * @param _title the title of the book
	 */
	public void setTitle(String _title) {
		title = new String(_title);
	} 
	
	/**
	 * Set the ISBN of the book
	 * @author longtran
	 * @param _isbn the isbn number of the book
	 */
	public void setISBN(String _isbn) {
		isbn = _isbn;
	} 
	
	//
	/**
	 * Add an author to the String array of authors
	 * @author longtran
	 * @param _author the name of the author of the book
	 * @return  true- if there is still a null slot in the author String array to add the author name. <br/> false- otherwise
	 * @note
	 * if there is still a null slot in the author String array:<br/>
	 * + add the name of the author to the String array.<br/>
	 * + increase the number of authors by one.<br/>
	 * + return true. <br/>
	 * else return false
	 */
	public boolean addAuthor(String _author) {
		for (int i = 0; i < author.length; ++i ) {
			if (author[i] == null) { // if there is an empty space in the array
				author[i] =  new String(_author); // assign the input to that slot
				numOfAuthors++; // increment the number of authors
				return true;
			} // end if
		} // end i loop
		return false;
	} // end addAuthor
	
	/**
	 * @author longtran
	 * @param obj an object of type Object which will be compared to the object calling this method.
	 * @return 
	 * true- if the isbn numbers of two objects are equal
	 * false- otherwise
	 * @Precondition
	 * Obj must not be null and should be an instance of Book class.
	 */
	//equals
	public boolean equals(Object obj) {
		try {
			if (obj == null) throw new Exception("NullValueInput"); // no null input
			if (obj instanceof Book) { // input has to be an instance of Book
				Book b = (Book)obj;
				return isbn == b.isbn;
			} // end if
			else throw new Exception("NotAnInstanceOfBookClassInput"); // if input is not an instance of Book, throw this Exception
		} // end try
		catch (Exception e) {
			throw new RuntimeException(e.getMessage()+ "." + " Please check the input");
		} // end catch
	} // end equals
	
	/**
	 * Get a String array of the names of all the authors of two Book object.
	 * @author longtran
	 * @param b1 the first Book object
	 * @param b2 the second Book object
	 * @return String[] containing the name of all the authors from the two books.
	 * @Precondition neither b1 nor b2 are null.
	 */
	public static String[] getAllAuthors(Book b1, Book b2) {
		try {
			if (b1 == null || b2 == null) throw new Exception("NullValueInput"); // throw an exception if either of the input is null
			String[] _author1 = b1.author.clone();
			String[] _author2 = b2.author.clone();
			String[] mix = new String[_author1.length + _author2.length];
			
			for (int i = 0; i < _author1.length; ++i) // copy the list of authors of book 1 to mix
				mix[i] = _author1[i];
			
			for (int i = 0; i < (_author2.length); ++i) // copy the list of author of book 2 to mix
				mix[i + _author1.length] = _author2[i];
		
			return mix;
		} // end try
		catch(Exception e) {
			throw new RuntimeException(e.getMessage()+ "." + " Please check the input");
		} // end catch
	} // end getAllAuthors
	/**
	 * 
	 */
	public String toString() {
		return String.format("Title: %s, ISBN: %s, Number of authors: %d, Authors: %s %s %s", title, isbn, numOfAuthors, author[0], author[1], author[2]);
	} // end toString
	
	
	
	
	public static void main(String[] args) {
		// constructor test
		Book b1 = new Book(); // using no argument constructor
		Book b2 = new Book("Java"); // using one parameter constructor
		Book b3 = new Book(b2); // using copy constructor
		
		// test toString
		System.out.printf("Book 1: %s\nBook 2: %s\nBook 3: %s\n", b1, b2, b3);
		
		// test equals before change
		if (b3.equals(b2)) System.out.println("b2 and b3 are equal");
		else System.out.println("b2 and b3 are not equal"); 
		
		// test Setter method
		// test setTitle
		b1.setTitle("Python"); 
		
		// test setISBN
		b2.setISBN("1829031"); 
		
		// test addAuthor
		b3.addAuthor("Anonymous"); 
		b3.addAuthor("Anonymous");
		b3.addAuthor("Hello");
		
		
		
		// show results of the change and also test toString
		System.out.println("\nAfter change");
		System.out.printf("Book 1: %s\nBook 2: %s\nBook 3: %s\n", b1, b2, b3);
		
		// test equals after change
		if (b3.equals(b2)) System.out.println("b2 and b3 are equal");
		else System.out.println("b2 and b3 are not equal"); 
		
		// test getTitle
		System.out.println();
		System.out.println("Testing the getter using book 3.");
		System.out.println("Title: " + b3.getTitle());
		
		// test getISBN
		System.out.println("ISBN: " + b3.getISBN());
		
		// test getAuthorNumber
		System.out.println("Book 3 has " + b3.getAuthorNumber() + " authors"); 
		
		// test return value of addAuthor book 2 -> true because book2 still has empty slot in the author array
		System.out.println();
		System.out.println("The return value of author adding of book 2 is " + b2.addAuthor("John")); 
		
		// test return value of addAuthor using book 3 -> false because book 3 have already had 3 authors
		System.out.println("The return value of author adding of book 3 is " + b3.addAuthor("Mai")); 
		
		System.out.println(); // new line
		
		//Book 2 and Book 3 
		System.out.printf("Book 2: %s\nBook 3: %s\n\n", b2, b3);
		
		// test getAllAuthors
		String[] b = Book.getAllAuthors(b2, b3);
		// print out the results of getAllAuthors
		System.out.println("The reuslt of getAllAuthors calling using book 2 and book 3:");
		for(int i = 0; i < b.length; ++i) System.out.println(b[i]);
		
		// test error cases. Delete the double slashes to test each case.
		
		Book b4 = null;
		Book b5 = new Book();
		int[] testI = new int[4];
		
		// test equals error case. 
		//b5.equals(b4); // null error
		//b5.equals(testI); // not an instance of Book error
		
		// test getAllAuthors error case
		//String[] testS = Book.getAllAuthors(b4, b5); // null value error 
		
		// test copy constructor error case
		//Book b6 = new Book(b4); // null value error
		//Book b7 = new Book(testI); // not an instance of Book error
		
		
				
		
	} // end main
	
} // end class
