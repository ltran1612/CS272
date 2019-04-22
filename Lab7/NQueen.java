
public class NQueen {
	
	public static void main(String[] args){
		printTable(fillQ(1));
		System.out.println();
		printTable(fillQ(2));
		System.out.println();
		printTable(fillQ(3));
		System.out.println();
		printTable(fillQ(4));
		System.out.println();
		printTable(fillQ(5));
		
		
	}
	
	
	public static boolean checkConflict(int pos, LinkStack<Integer> S) {
		if (S.isEmpty()) return false;
			
		int[] copy = copyStack(S);

		for (int i = 0;  i < copy.length; ++i) {
			if (pos == copy[i]) return true;
			if (pos - (i+1) == copy[i]) return true;
			if (pos + (i+1) == copy[i]) return true;
		}
		return false;
				
	}
	
	public static int[] copyStack(LinkStack<Integer> S) {
		int[] result = new int[S.size()];
		
		for (int i = 0;  i < result.length; ++i) 
			result[i] = S.pop();
		
		for (int i = result.length-1; i >= 0; --i)
			S.push(result[i]);
		
		return result;
	}
	
	public static LinkStack<Integer> fillQ(int n) {
		LinkStack<Integer> S = new LinkStack<Integer>();
		
		int col = 1;
		while(S.size() < n && (!(S.isEmpty() && col > n))) {
			
			while(col <= n && S.size() < n) {
				if (!checkConflict(col, S)) {
					S.push(col);
					col = 1;
				}
				else col++;
			}
			
			while(!S.isEmpty() && col > n) col = S.pop() + 1;
			
 		}
		return S;
	}
	
	public static void printTable(LinkStack<Integer> S) {
		if (S.isEmpty()) {
			System.out.println("No result was found");
			return;
		}
		int length = S.size();
		for (int i = 0; i < length; ++i) {
			int location = S.pop();
			for (int j = 0; j < location-1; ++j)
				System.out.print("-");
			System.out.print("Q");
			for (int j = location+1; j < length+1; ++j)
				System.out.print("-");
			System.out.println();
		}	
	}
}
