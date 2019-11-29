package day10;

import java.util.Arrays;

public class Z36 {

	static int arr[] = { 5, 3, 1, 2, 3, 8, 9 };
	static int min;

	public static void main(String[] args) {
		for1(0); // 범위의 시작위치를 정하는 for
		System.out.println(Arrays.toString(arr));
	}

	public static void for1(int i) {
		if (i == arr.length) { // 종료
			return;
		} else { // 재귀파트
			// i~끝까지 범위, 범위내의 최소값 위치 찾기, i와 최소값 위치 교환
			min = i;
			for2(i);
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			for1(i + 1);
		}
	}

	public static void for2(int i) {
		if (i == arr.length) {
			return;
		} else {
			if (arr[min] > arr[i]) {
				min = i;
			}
			for2(i + 1);
		}
	}

}
