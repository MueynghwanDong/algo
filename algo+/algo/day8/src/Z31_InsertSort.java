import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*
 * 삽입정렬 - 리스트 사용
 */
public class Z31_InsertSort {

	public static void main(String[] args) {

		 int arr[] = { 1, 4, 7, 0, 5, 6, 8, 2, 9, 3 };
//		int arr[] = new int[200000];
//		Random r = new Random();
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = r.nextInt(arr.length);
//		}
		long time = System.currentTimeMillis();
		// linkedlist 이용, 3천개 -> 2221ms
		// LinkedList<Integer> ll = new LinkedList<Integer>();
		// arraylist 20만개 => 23491ms / 3천개 10ms
		ArrayList<Integer> ll = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int j = 0;
			for (j = 0; j < i; j++) {
				if (arr[i] < ll.get(j)) // -> get 연산에서 시간을 많이 잡아먹음.. linkedlist가 더 오래걸림..
					break;
			}
			ll.add(j, arr[i]);
		}

		System.out.println(System.currentTimeMillis() - time + "ms");
		// System.out.println(ll);

	} // end of main
} // end of class