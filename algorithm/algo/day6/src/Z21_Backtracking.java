/*
 * Backtracking 가지치기 _powerset
 */
public class Z21_Backtracking {

	public static int[] arr = { 6, 7, 8 };// 부분집합을 구할 원래 배열

	public static void main(String[] args) {
		// arr 부분집합을 모두 구해보자(멱집합 : powerset)
		boolean[] a = new boolean[arr.length]; // 원소 사용여부를 저장할 배열, 0번째 원소도 사용
		backtrack(a, 0, a.length);
	} // end of main
	/*
	 * @Param a : 부분집합을 구할 때 원소를 사용여부를 저장할 배열
	 * 
	 * @Param k : 현재단계, input과 같아질때까지 반복
	 * 
	 * @Param input : 마지막 단계
	 */

	public static void backtrack(boolean[] a, int k, int input) {

		if (k == input) { // 종료파트
			process_solution(a, k); // 각 완성 단계에서 하고 싶은 작업(출력)
		} else {// 재귀 파트
			boolean[] c = new boolean[a.length]; // 후보군을 저장할 배열
			int ncands = make_candidates(a, k, input, c); // 후보군을 만들어 오는 메서드
			for (int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k + 1, input); // 다음 단계 재귀 호출
			}
		}
	}

	public static int make_candidates(boolean[] a, int k, int input, boolean[] c) {
		c[0] = false;
		c[1] = true;
		return 2;
	}

	// 각단계에서 하고 싶은 작업
	public static void process_solution(boolean[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			if (a[i]) {
				// System.out.print(i+" ");// 원소 / index
				System.out.print(arr[i] + " ");// 실제 부분집합 원소
			}
		}
		System.out.println();
	}
} // end of class
