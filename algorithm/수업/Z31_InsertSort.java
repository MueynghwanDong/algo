import java.util.ArrayList;
import java.util.Random;

public class Z31_InsertSort {
	public static void main(String[] args) {
//		int[] arr = {1, 4, 7, 0, 5, 6, 8, 2, 9, 3};
		int[] arr = new int[10000];
		
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(arr.length);
		}
		
		long time = System.currentTimeMillis();
		
//		LinkedList<Integer> ll = new LinkedList<Integer>();	//
		ArrayList<Integer> ll = new ArrayList<Integer>();	//
		
		for (int i = 0; i < arr.length; i++) {
			int j = 0;
			for (j = 0; j < i; j++) {
				if(arr[i] < ll.get(j)) {
					break;
				}
			}
			ll.add(j, arr[i]);
		}
		
		System.out.println(System.currentTimeMillis() - time + "ms");
		System.out.println(ll);
		
		
	}	// end of main
}	// end of class
