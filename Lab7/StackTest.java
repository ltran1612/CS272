
public class StackTest {

	public static void main(String[] args) {
		System.out.println("Starting testing ArrayListStack:\n");
		
		testToStringArrayListStack();
		testPushArrayListStack();
		testPopArrayListStack();
		testTopArrayListStack();
		testSizeArrayListStack();
		
		System.out.println("********************"); 
		System.out.println("\nStart testing LinkListStack:\n");
		
		testToStringLinkStack();
		testPushLinkStack();
		testPopLinkStack();
		testTopLinkStack();
		testSizeLinkStack();
		testIsEmptyLinkStack();
		
		// Test error case of ArrayListStack and LinkStack
		System.out.println("********************"); 
		System.out.println("\nStart testing error cases of top and pop of the two stack types:\n");
		errorCaseOfTopAndPop_ArrayListStack_LinkStack();
	
	}
	
	public static void testToStringArrayListStack() {
		System.out.println("Test toString, ArrayListStack: ");
		ArrayListStack<Integer> emptyCase = new ArrayListStack<Integer>();
		ArrayListStack<Integer> normalCase = new ArrayListStack<Integer>();
		normalCase.push(1);
		normalCase.push(3);
		normalCase.push(7);
		
		System.out.println("ArrayList stack, empty case, toString: " + emptyCase);
		System.out.println("ArrayList stack, normal case, toString: " + normalCase);
	
		System.out.println();
	}
	
	
	public static void testPushArrayListStack() {
		ArrayListStack<Integer> normalCase = new ArrayListStack<Integer>();
		
		System.out.println("Testing push method, ArrayListStack: ");
		System.out.println("ArrayList stack before pushing " + normalCase);
		
		// pushing
		for (int i = 1; i < 9; i = i + 2)
			normalCase.push(i);
		
		System.out.println("ArrayList stack after pushing 1, 3, 5, 7: " + normalCase);
		System.out.println();
	}

	public static void testPopArrayListStack() {
		System.out.println("Test pop, ArrayListStack: ");
		ArrayListStack<Integer> normalCase = new ArrayListStack<Integer>();
	
		for (int i = 1; i < 10; i = i + 2) normalCase.push(i);
		
		System.out.println("Stack before popping: " + normalCase);
		System.out.println("Pop: " + normalCase.pop());
		System.out.println("Stack after popping: " + normalCase);
	
		System.out.println();
	}
	
	public static void testTopArrayListStack() {
		System.out.println("Test top, ArrayListStack");
		ArrayListStack<Integer> normalCase = new ArrayListStack<Integer>();
		
		for (int i = 1; i < 10; i = i + 2) normalCase.push(i);
		
		System.out.println("Stack before calling top: " + normalCase);
		System.out.println("Top: " + normalCase.top());
		System.out.println("Stack after calling top: " + normalCase);
	
		System.out.println();
	}
	
	public static void testSizeArrayListStack() {
		System.out.println("Test Size, ArrayListStackL: ");
		ArrayListStack<Integer> emptyCase = new ArrayListStack<Integer>();
		ArrayListStack<Integer> normalCase = new ArrayListStack<Integer>();
	
		for (int i = 2; i < 12; i++) normalCase.push(i);
		
		System.out.println("Size of empty stack, ArrayListStack: " + emptyCase.size());
		System.out.println("Size of non-empty stack, expecting 10, ArrayListStack: " + normalCase.size());
	
		System.out.println();
	}
	
	public static void testIsEmptyArrayListStack() {
		ArrayListStack<Integer> emptyCase = new ArrayListStack<Integer>();
		ArrayListStack<Integer> normalCase = new ArrayListStack<Integer>();
	
		normalCase.push(132);
		
		System.out.println("Is emptyCase empty: " + emptyCase.isEmpty());
		System.out.println("Is non-empty case empty: " + normalCase.isEmpty());
		
		System.out.println();
	}
	
	
	
	//
	//
	//
	//
	//
	

	public static void testToStringLinkStack() {
		LinkStack<Integer> emptyCase = new LinkStack<Integer>();
		LinkStack<Integer> normalCase = new LinkStack<Integer>();
		normalCase.push(2);
		normalCase.push(8);
		normalCase.push(19);
		normalCase.push(9999);
		
		System.out.println("Link stack, empty case, toString: " + emptyCase);
		System.out.println("Link stack, normal case, toString: " + normalCase);
	
		System.out.println();
	}
	
	public static void testPushLinkStack() {
		LinkStack<Integer> normalCase = new LinkStack<Integer>();
		
		System.out.println("Testing push method, LinkStack: ");
		System.out.println("Link stack before pushing " + normalCase);
		
		// pushing
		for (int i = 1; i < 10; i = i + 2)
			normalCase.push(i);
		
		System.out.println("Link stack after pushing 1, 3, 5, 7, 9: " + normalCase);
		System.out.println();
	}

	public static void testPopLinkStack() {
		System.out.println("Test pop, LinkStack: ");
		LinkStack<Integer> normalCase = new LinkStack<Integer>();
	
		for (int i = 1; i < 12; i = i + 2) normalCase.push(i);
		
		System.out.println("Stack before popping: " + normalCase);
		System.out.println("Pop: " + normalCase.pop());
		System.out.println("Stack after popping: " + normalCase);
	
		System.out.println();
	}
	
	public static void testTopLinkStack() {
		System.out.println("Test top, LinkStack: ");
		LinkStack<Integer> normalCase = new LinkStack<Integer>();
		
		for (int i = 1; i < 14; i = i + 2) normalCase.push(i);
		
		System.out.println("Stack before calling top: " + normalCase);
		System.out.println("Top: " + normalCase.top());
		System.out.println("Stack after calling top: " + normalCase);
	
		System.out.println();
	}
	
	public static void testSizeLinkStack() {
		System.out.println("Test Size, LinkStack: ");
		LinkStack<Integer> emptyCase = new LinkStack<Integer>();
		LinkStack<Integer> normalCase = new LinkStack<Integer>();
	
		for (int i = 2; i < 18; i++) normalCase.push(i);
		
		System.out.println("Size of empty stack, LinkStack: " + emptyCase.size());
		System.out.println("Size of non-empty stack, expecting 16, LinkStack: " + normalCase.size());
	
		System.out.println();
	}
	
	public static void testIsEmptyLinkStack() {
		LinkStack<Integer> emptyCase = new LinkStack<Integer>();
		LinkStack<Integer> normalCase = new LinkStack<Integer>();
	
		normalCase.push(132);
		
		System.out.println("Is emptyCase empty: " + emptyCase.isEmpty());
		System.out.println("Is non-empty case empty: " + normalCase.isEmpty());
		
		System.out.println();
	}
	
	public static void errorCaseOfTopAndPop_ArrayListStack_LinkStack() {
		ArrayListStack<Integer> error1 = new ArrayListStack<Integer>();
		LinkStack<Integer> error2 = new LinkStack<Integer>();
		
		// pop of ArrayListStack
		try {
			error1.pop();
		}
		catch(RuntimeException e) {
			System.out.println("Error of ArrayListStack for pop: " + e.getMessage());
		}
	
		// pop of LinkStack
		try {
			error2.pop();
		}
		catch(RuntimeException e) {
			System.out.println("Error of LinkStack for pop: " + e.getMessage());
		}
		
		// top of ArrayListStack
		try {
			error1.top();
		}
		catch(RuntimeException e) {
			System.out.println("Error of ArrayListStack for pop: " + e.getMessage());
		}
		
		// top of LinkStack
		try {
			error2.top();
		}
		catch(RuntimeException e) {
			System.out.println("Error of LinkStack for pop: " + e.getMessage());
		}
	}
}
