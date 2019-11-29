package day10;

import java.util.Arrays;

/**
 * 순열 알고리즘 1. 반목분 작성(for문 )- 6중 
 * 2. Backtraking 단원 - 후보군 목록 구해옴. (사용 숫자 체크해 사용 안한 숫자의 목록을 만듦) 
 * 3. swap 방법으로 반복, 사용안한 숫자들은 뒤쪽에 남아 있도록 배치, 코드 간단
 */

public class Z36_순열 {

	public static int[] arr = { 6, 7, 8, 9 };

	public static void main(String[] args) {

		perm(arr.length, 0);

	} // end of main
		// n : 몇개 뽑을 지. k : 현재 단계

	public static void perm(int n, int k) {
		if (k == n) { // 종료 파트
			System.out.println(Arrays.toString(arr));
		} else { // 재귀 파트
			// 현재 0번째 단계 칸에 모든 숫자 채우고, 다음 단계로 사용하지 않은 숫자에 대해 주기적으로 반복하게 ....
			for (int i = k; i < n; i++) {
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				perm(n, k + 1);
				// 원상복귀
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}

		}
	}
} // end of class
