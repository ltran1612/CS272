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
	private int isbn;
	
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
	    isbn = -1;
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
		isbn = -1;
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
	public int getISBN() {
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
	public void setISBN(int _isbn) {
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
		String result = String.format("Title: %s, ISBN: %d, Number of authors: %d, Authors: ", title, isbn, numOfAuthors);
		for (int i = 0; i < numOfAuthors; ++i) result += author[i];
		return result;
	} // end toString
	
} // end class