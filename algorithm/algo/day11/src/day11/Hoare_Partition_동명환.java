package day11;

import java.util.Arrays;

public class Hoare_Partition_동명환 {

	static int[] arr = { 100, 99, 81, 5, 2, 3, 6, 4, 8 };

	public static void quicksort(int[] arr, int l, int r) {

		if (l < r) {
			int s = partition(arr, l, r);
			quicksort(arr, l, s - 1);
			quicksort(arr, s + 1, r);
		}
	}

	public static int partition(int[] arr, int l, int r) {

		int p = arr[l];
		int i = l;
		int j = r;
		while (i <= j) {
			if (arr[i] <= p)
				i++;
			if (arr[j] >= p)
				j--;
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int ttemp = arr[l];
		arr[l] = arr[j];
		arr[j] = ttemp;
		return j;

	}

	public static void main(String[] args) {
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
