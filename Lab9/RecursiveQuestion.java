
public class RecursiveQuestion {

	public static void main(String[] args) {
		//FibBinaryRecursive
		System.out.print("The first 10 fibonacci numbers: ");
		for (int i = 0; i < 10; ++i) 
			System.out.print(FibBinaryRecursive(i)+" ");		
		System.out.print("\n\n");
		
		//HanoiTower
		HanoiTower(3, 0, 1);
		
		//showCallLevel
		System.out.println(showCallLevel(8, 1));
	
		//BinaryPrint
		for (int i = 0; i < 10; ++i) {
			System.out.printf("Binary version of %d: ", i);
			BinaryPrint(i); 
			System.out.println();
		}	
		System.out.print("\n\n");		
		
		//Pattern
		pattern(0, 8);
			
	}
	
	// FibBinaryRecursive
	public static int FibBinaryRecursive(int k) {
		if (k == 0) return 0;
		if (k == 1) return 1;
		return FibBinaryRecursive(k-1) + FibBinaryRecursive(k-2);
	}
	
	// HanoiTower
	public static void makeMoves(int k, int s, int d) {
		if (k == 0) return;
		makeMoves(k-1, s, 3-d-s);
		System.out.printf("+Moving disk %d from post %d to post %d\n", k, s, d);
		makeMoves(k-1, 3-d-s, d);
	}
	
	public static void HanoiTower(int k, int s, int d) {
		System.out.println("The posts are post 0, post 1 and post 2");
		System.out.printf("The steps to move %d disk from post %d to post %d:\n", k, s, d);
		if (s < 0 || s > 2 || d < 0 || d > 2) return;
		makeMoves(k, s, d);
		System.out.println();
	}
	
	// showCallLevel
	public static String showCallLevel(int L, int curl) {
		String temp = "";
		for (int i = 1; i < curl; ++i) temp += "  ";
		if (curl == L) 		
			return String.format("%sThis was written by call number %dx\n", temp, curl)+String.format("%sThis was written by call number %dy\n", temp, curl);
		return String.format("%sThis was written by call number %dx\n", temp, curl)+showCallLevel(L, curl+1)+String.format("%sThis was written by call number %dy\n", temp, curl);
	}
	
	// BinaryPrint
	public static void BinaryPrint(int n) {
		if (n == 0) {System.out.print(0); return;}
		BinaryPrint(n/2);
		System.out.print(n%2);
	}
	
	// Pattern
	public static void pattern(int s, int l) {
		if (l == 1) {
			for (int i = 0; i < s; ++i)
				System.out.print(" ");
			System.out.println("*");
			return;
		}
		
		pattern(s, l / 2);
		for (int i = 0; i < s; ++i)
			System.out.print(" ");
		for (int i = 0; i < l; ++i)
			System.out.print("*");
		System.out.println();
		
		pattern(l/2+s, l/2);
	}
	
}
