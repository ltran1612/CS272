
public class search {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	
	public static int binarySearch(int[] A, int e) {
		return binary(A, 0, A.length -1, e);
	}
	
	private static int binary(int[] A, int sIdx, int eIdx, int e) {
		if (sIdx > eIdx) return -1;
		int mid = (sIdx + eIdx) / 2;
		if(A[mid] == e) return mid;
		else if (A[mid] > e) return binary(A, sIdx, mid-1, e);
		else return binary(A, mid+1, eIdx, e);
	}
	
	public static void test1() {
		System.out.println("Test 1");
		int[] test = new int[5];
		test[0] = 1; test[1] = 3; test[2] = 4; test[3]  = 6; test[4] = 9;
		System.out.println("Looking for 1, expected index is 0, index is: "+binarySearch(test, 1));
		System.out.println("Looking for 9, expected index is 4, index is: "+binarySearch(test, 9));
		System.out.println("Looking for 4, expected index is 2, index is: "+binarySearch(test, 4));
		System.out.println("Looking for 3, expected index is 1, index is: "+binarySearch(test, 3));
		System.out.println("Looking for 6, expected index is 3, index is: "+binarySearch(test, 6));
		System.out.println("Looking for 19, which is not in the array, expected index is -1, index is: "+binarySearch(test, 19));
		System.out.println("Looking for 8, which is not in the array, expected index is -1, index is: "+binarySearch(test, 8));

	}
	
	public static void test2() {
		System.out.println("Test 2");
		int[] test = new int[0];
		System.out.println("Looking for 1 in an empty array, expected -1, index is: "+binarySearch(test, 1));
		System.out.println("Looking for 0 in an empty array, expected -1, index is: "+binarySearch(test, 0));
	}
	
}
