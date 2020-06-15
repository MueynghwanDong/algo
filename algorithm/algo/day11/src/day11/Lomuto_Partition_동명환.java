package day11;

import java.util.Arrays;

public class Lomuto_Partition_동명환 {

	static int[] arr = { 100, 99, 81, 5, 2, 3, 6, 4, 8 };

	public static void quicksort(int[] arr, int l, int r) {

		if (l < r) {
			int s = partition(arr, l, r);
			quicksort(arr, l, s - 1);
			quicksort(arr, s + 1, r);
		}
	}

	public static int partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (arr[j] <= x) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int ttemp = arr[i + 1];
		arr[i + 1] = arr[r];
		arr[r] = ttemp;
		return i + 1;
	}

	public static void main(String[] args) {
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
