
public class BookTableTest {

	public static void main(String[] args) {
		testPutSearch();
		testPutSearchRemove();
		
	}
	
	public static void testPutSearch() {
		System.out.println("Test Put Search");
		BookTable table = new BookTable();
		
		Book book1 = new Book(), book2 = new Book(), book3 = new Book(), book4 = new Book(), book5 = new Book(), book6 = new Book(), book7 = new Book();
		book1.setISBN(800688074); book1.setTitle("Book 1");
		book2.setISBN(1011); book2.setTitle("Book 2");
		book3.setISBN(1001); book3.setTitle("Book 3");
		book4.setISBN(168); book4.setTitle("Book 4");
		book5.setISBN(212); book5.setTitle("Book 5");
		book6.setISBN(1000); book6.setTitle("Book 6");
		book7.setISBN(101); book7.setTitle("Book 7");
		
		table.put(book1); table.put(book2); table.put(book3); table.put(book4); table.put(book5); 
		table.put(book6); table.put(book7);
		
		System.out.println("Search for book 1: "); table.printValue(table.search(800688074));
		System.out.println("Search for book 2: "); table.printValue(table.search(1011));
		System.out.println("Search for book 3: "); table.printValue(table.search(1001));
		System.out.println("Search for a book that is not in table with isbn: 45612378"); table.printValue(table.search(45612378)); 
		System.out.println("Search for book 4: "); table.printValue(table.search(168));
		System.out.println("Search for book 5: "); table.printValue(table.search(212));
		System.out.println("Search for book 6: "); table.printValue(table.search(1000));
		System.out.println("Search for book 7: "); table.printValue(table.search(101));

	}
	
	public static void testPutSearchRemove() {
		System.out.println("\nTest Put Search Remove");
		BookTable table = new BookTable();
		
		Book book1 = new Book(), book2 = new Book(), book3 = new Book(), book4 = new Book();
		book1.setISBN(1478932); book1.setTitle("Book 1");
		book2.setISBN(159951159); book2.setTitle("Book 2");
		book3.setISBN(753357753); book3.setTitle("Book 3");
		book4.setISBN(987013601); book4.setTitle("Book 4");
		table.put(book1); table.put(book2); table.put(book3); table.put(book4);
		
		boolean rc = false; 
		System.out.println("Search for book 1: "); table.printValue(table.search(1478932));
		System.out.println("Search for book 2: "); table.printValue(table.search(159951159));
		System.out.println("Search for book 3: "); table.printValue(table.search(753357753));
		rc = table.remove(159951159); System.out.println("Search for book 2 that has been removed: "+rc); table.printValue(table.search(159951159));
		System.out.println("Search for book 4: "); table.printValue(table.search(987013601));
		rc = table.remove(1478932); System.out.println("Search for book 1 that has been removed: "+rc); table.printValue(table.search(1478932));
		rc = table.remove(123456789); System.out.println("Removed the book that is not in the table: "+rc); table.printValue(table.search(123456789));
		System.out.println("Try to put in a book without ISBN: ");
		Book bookError = new Book("Book without ISBN");
		table.put(bookError);
	}
}
