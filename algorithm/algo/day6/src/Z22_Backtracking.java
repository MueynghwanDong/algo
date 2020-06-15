/*
 * Backtracking 가지치기 _순열
 */
public class Z22_Backtracking {

	public static int[] arr = { 6, 7, 8, 9 };// 순열을 구할 원래 배열

	public static void main(String[] args) {
		// arr 순열을 모두 구해보자
		int[] a = new int[arr.length]; // 순열의 index 순번을 저장할 배열, 0번째 원소도 사용
		backtrack(a, 0, a.length); // 순열로 표현할 개수 (a.length),
	} // end of main
	/*
	 * @Param a : 순열을 구할 때 원소를 사용여부를 저장할 배열
	 * 
	 * @Param k : 현재단계, input과 같아질때까지 반복
	 * 
	 * @Param input : 마지막 단계
	 */

	public static void backtrack(int[] a, int k, int input) {

		if (k == input) { // 종료파트
			process_solution(a, k); // 각 완성 단계에서 하고 싶은 작업(출력)
		} else {// 재귀 파트
			int[] c = new int[a.length]; // 후보군을 저장할 배열
			int ncands = make_candidates(a, k, input, c); // 후보군을 만들어 오는 메서드
			for (int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k + 1, input); // 다음 단계 재귀 호출
			}
		}
	}

	public static int make_candidates(int[] a, int k, int input, int[] c) {
		boolean[] in_perm = new boolean[a.length]; // 각 인덱스가 사용했었는지 여부를 체크할 flag 배열
		for (int i = 0; i < k; i++) { // 현재 단계 이전까지 사용한 숫자들을 체크
			in_perm[a[i]] = true; // 사용함 -> 체크
		}
		// in_perm 배열에 false인 index는 사용안한 숫자임 - > 후보군으로 담아 보냄..
		int ncands = 0; // 후보군의 갯수 카운팅할 변수
		for (int i = 0; i < in_perm.length; i++) {
			if (!in_perm[i]) { // 사용하지 않은 숫자라면
				c[ncands++] = i;
			}
		}
		return ncands; // 후보군의 개수 리턴
	}

	// 각 단계에서 하고 싶은 작업
	public static void process_solution(int[] a, int k) {
		for (int i = 0; i < k; i++) {
			//System.out.print(a[i] + " ");
			System.out.print(arr[a[i]] + " "); // 저장된 순번을 출력해보기
		}
		System.out.println();
	}
} // end of class
