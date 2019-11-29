package day10;

import java.util.Arrays;

public class Z38_재귀조합 {

	public static int[] arr = {6, 7, 8, 9 };
	public static int[] trr;

	public static void main(String[] args) {
		int r = 3; // nCr n은 전체갯수, r 은 뽑을 갯수
		trr = new int[r]; // 뽑은 수를 저장할 배열
		comb(arr.length, r);
	}

	public static void comb(int n, int r) {
		if (r == 0) { // 종료
			System.out.println(Arrays.toString(trr));
		} else if (n < r) {
			return; // 잘못된 경우는 제거
		} else { // 재귀

			trr[r - 1] = arr[n - 1];
			comb(n - 1, r - 1); // n-1번째 숫자를 사용한 경우
			comb(n - 1, r); // n-1번째 숫자를 사용 안한 경우
		}
	}
} // end of class
