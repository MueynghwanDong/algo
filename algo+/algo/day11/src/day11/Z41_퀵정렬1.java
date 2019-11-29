package day11;

import java.util.Arrays;

/**
 * QuickSort : O[NlogN] , 정렬할 원소의 개수가 많을 수록 성능이 좋다. 상용 소프트웨어에서 가장 많이 사용된다.
 * Hoare-Partition 알고리즘 피봇을 좌측 끝으로 지정
 *
 */
public class Z41_퀵정렬1 {
	public static int[] a = { 5, 1, 8, 9, 2, 7, 3, 6, 4 };

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		quickSort(0, a.length - 1);
		System.out.println(Arrays.toString(a));
	} // end of main
	/* 피봇을 기준으로 분할하는 메서드 */
	// 분할만 하면 정렬이 된다.

	private static void quickSort(int l, int r) {
		if (l >= r) { // 종료파트, 원소가 2개 이상일 때만 정렬을 진행
			return;
		}
		// int pivot = hoarepartition(l, r);
		int pivot = lomutopartition(l, r);
		quickSort(l, pivot - 1);
		quickSort(pivot + 1, r);
	}

	// 피봇을 기준으로 작거나 같은 값을 좌측, 큰 값을 우측에 i~j 인덱스 범위 안으로 지정, i위치는 큰 값 범위의 1칸전 인덱스,
	// j위치는 큰값 범위의 마지막 인덱스, a[i] < 큰값들 <= a[j]
	private static int lomutopartition(int l, int r) {
		int pivot = a[r];
		int i = l - 1;
		for (int j = l; j < r; j++) {
			if (a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp = a[i + 1]; // 큰 영역의 첫번째 숫자와 피봇을 교환
		a[i + 1] = a[r];
		a[r] = temp;
		return i + 1;
	}

	// l부터 r까지 범위에서 피봇을 기준으로 작거나 같은 값은 좌측, 큰 값은 우측으로 배치, 피봇의 위치를 리턴
	private static int hoarepartition(int l, int r) {
		int pivot = l; // 피봇을 좌측 끝으로 지정
		while (l <= r) { // 원소가 있으면 진행하기
			// 반드시 배열의 인덱스를 벗어나지 않는지 체크 필요..
			while (l < a.length && a[l] <= a[pivot]) // 좌측은 작거나 같은 값
				l++;
			while (0 <= r && a[r] > a[pivot]) // 우측은 큰 값
				r--;
			if (l < r) { // 인덱스가 교차했으면 반복 종료, 교차하지 않았으면 swap 후 다시 반복
				int temp = a[l];
				a[l] = a[r];
				a[r] = temp;
			}
		}
		int temp = a[r];
		a[r] = a[pivot];
		a[pivot] = temp;
		return r; // 피봇의 위치
	}
} // end of class
