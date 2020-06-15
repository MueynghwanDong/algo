package day11;

import java.util.Arrays;

public class Z42_BinarySearch {

	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 3, 4, 6 };
		System.out.println(Arrays.binarySearch(a, 5));
		// binarySearch 정렬된 상태의 배열에서 찾을 key 값이 존재하는 index를 리턴, key 값이 존재하지 않으면, -(삽입해야할
		// 위치 +1) 값을 리턴

	}// end of main

	private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}
}// end of class
