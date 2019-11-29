/**
 * Backtracking 가지치기 _ powerSet
 * 
 */
public class Z21_Backtracking {

	public static int[] arr = { 6, 7, 8 }; // 부분집합을 구할 원래 배열

	public static void main(String[] args) {
		
		// arr 부분집합을 모두 구해보자 ( 멱집합 : powerSet )
		
		boolean[] a = new boolean[arr.length]; // 원소의 사용여부를 저장할 배열, 0번째 원소도 사용한다
		backtrack(a, 0, a.length);

	} // end of main

	/**
	 * @param a     : 부분집합을 구할 때 원소의 사용여부를 저장할 배열
	 * @param k     : 현재 단계, input과 같아질 때까지 반복
	 * @param input : 마지막 단계
	 */
	public static void backtrack(boolean[] a, int k, int input) {
		
		if (k == input) { // 종료파트 (해인가?) isSolution()
			process_solution(a, k); // 각 완성단계에서 하고싶은 작업 (출력)
			
		} else { // 재귀파트
			
			boolean[] c = new boolean[a.length];
			int ncands = make_candidates(a, k, input, c); // 후보군을 만들어오는 메서드, ncands 리턴
			for (int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k + 1, input);
			}
		}
	}

	/**
	 * 각 완성단게에서 하고싶은 작업 (출력)
	 * 
	 * @param a
	 * @param k
	 */
	public static void process_solution(boolean[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			if(a[i]) {
				System.out.print(arr[i] + " ");	//원소출력
			}
		}
		System.out.println();
	}

	/**
	 * 후보군 만들어오는 메서드
	 * 
	 * @param a
	 * @param k
	 * @param input
	 * @param c
	 * @return
	 */
	public static int make_candidates(boolean[] a, int k, int input, boolean[] c) {
		c[0] = false;
		c[1] = true;
		return 2; // 후보군의 개수
	}

} // end of class
