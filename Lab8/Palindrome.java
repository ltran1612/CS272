import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Input: "); 
		String s = scan.nextLine();
		if (s.isEmpty()) {
			System.out.println("Invalid input");
			return;
		}
		
		LinkedQueue<String> one = new LinkedQueue<String>();
		Stack<String> two = new Stack<String>();
		
		// Some punctuation marks.
		String[] pMarks = new String[9];
		pMarks[0] = "."; 
		pMarks[1] = ",";
		pMarks[2] = ":";
		pMarks[3] = ";";
		pMarks[4] = "?";
		pMarks[5] = "/";
		pMarks[6] = "!";
		pMarks[7] = "-";
		pMarks[8] = "''";
		
		// Replace . , ; : ? / ! -, '' with a space.
		for (int i = 0; i < pMarks.length; ++i)
			s = s.replace(pMarks[i], " ");
		
		// Replace the double space with a space
		while (s.indexOf("  ") != -1)
			s = s.replace("  ", " ");
		
			//System.out.println(s);
		
		// Replace (*), [*], "*" into _*_ with _ is a space.
		for (int i = 0; i < s.length(); ++i) {
			if (s.substring(i, i+1).equals("(")) 
				s = trimSurrounded(s, "(", ")", i);
			else if (s.substring(i, i+1).equals("[")) 
				s = trimSurrounded(s, "[", "]", i);
			else if (s.substring(i, i+1).equals("\"")) 
				s = trimSurrounded(s, "\"", "\"", i);		
		}
		
		// Replace double space into only one space
		while (s.indexOf("  ") != -1)
			s = s.replace("  ", " ");
		
			//System.out.println(s);
		
		//Put each word separated by a space into a queue and a stack
		while (s.indexOf(" ") != -1) {
			int idx = s.indexOf(" ");
			one.enqueue(s.substring(0, idx));
			two.push(s.substring(0, idx));
			
			s = s.substring(idx+1);
		} // There is only a word with no space left in the string.
		// Add that the only word left in the string
		one.enqueue(s);
		two.push(s);
		
//			System.out.println(one);
//			System.out.println(two);
		
		// Check palindrome
		boolean result = true;
		for (int i = 0; i < one.size() && result == true; ++i) {
			if (!one.dequeue().equalsIgnoreCase(two.pop()))
				result = false; 	
		}
	   
		if (result) System.out.println("Palindrome");
		else System.out.println("Not Palindrome");
		
	}
	
	public static String trimSurrounded(String s, String d, String e, int i) {
		
		int a = s.indexOf(e, i+1);
		int b = s.indexOf(d, i+1);
		
		//System.out.println(a + " " + b);
		
		if ((a != -1 && b != -1 && b >= a) || (a != -1 && b == -1)) {
			s = s.substring(0, i) + " " + s.substring(i+1);
			int t = s.indexOf(e, i);
			s = s.substring(0, t) + " " + s.substring(t+1);
		}
		
		return s;
	}
	
}
