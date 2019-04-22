
public class Permutation {

	public static void main(String[] args) {
		// Permutation
		Integer[] test1 = new Integer[1];
		Integer[] test2 = new Integer[2];
		Integer[] test5 = new Integer[5];
		Integer[] test10 = new Integer[10];
		
		for (int i = 0; i < 1; ++i) test1[i] = i;
		for (int i = 0; i < 2; ++i) test2[i] = i;
		for (int i = 0; i < 5; ++i) test5[i] = i;
		for (int i = 0; i < 10; ++i) test10[i] = i;
		
		permutation(test1, 0);
		System.out.print("\n\n");
		permutation(test2, 0);
		System.out.print("\n\n");
		permutation(test5, 0);
		System.out.print("\n\n");
		permutation(test10, 0);
		
	}

	// Permutation
	public static <E> void permutation(E[] A, int prefix) {
		if (prefix == A.length-1) {
			for (int i = 0; i < A.length; ++i)
				System.out.print(A[i]);
			System.out.print("\n");
			return;
		}
		for (int i = prefix; i < A.length; ++i) {
			E temp = A[i];
			A[i] = A[prefix];
			A[prefix] = temp;
		
			permutation(A, prefix+1);
					
			temp = A[prefix];
			A[prefix] = A[i];
			A[i] = temp;
			
		}
	}
}
