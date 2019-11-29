import java.util.Arrays;

/*
 * 순열
 * 반복문 : 성능은 좋지만 , 원소개수에 따라 동적으로 구조를 변경하기 어렵다.
 * Backtracking - 후보군을 구하는 재귀함수
 * 완전탐색 - swap 재귀함수, 코드가 간단   
 */
public class TestPerm {

	public static int[] arr = { 4, 5, 6 };

	public static void perm(int n, int k) {
		if (n == k) { // 종료
			System.out.println(Arrays.toString(arr));
		} else { // 재귀
			for (int i = k; i < arr.length; i++) {
				// arr[k] <-> arr[i]
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				perm(n, k + 1); 
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		perm(arr.length, 0); // 전체원소의 갯수 , 현재 단계
	} // end of main
} // end of class
