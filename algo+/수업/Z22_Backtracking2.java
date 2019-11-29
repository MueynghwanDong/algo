/**
 * Backtracking 가지치기 _ 순열
 * 
 */
public class Z22_Backtracking2 {

	public static int[] arr = { 6, 7, 8, 9 }; // 부분집합을 구할 원래 배열

	public static void main(String[] args) {
		
		// arr 순열을 모두 구해보자
		int[] a = new int[arr.length]; // 순열의 index순번을 저장할 배열, 0번째 원소도 사용
		backtrack(a, 0, a.length); // a.length => 순열로 표현할 갯수
		
	} // end of main

	/**
	 * @param a     : 순열의 index순번을 저장할 배열
	 * @param k     : 현재 단계, input과 같아질 때까지 반복
	 * @param input : 순열로 표현할 개수
	 */
	public static void backtrack(int[] a, int k, int input) {
		
		if (k == input) { // 종료파트 (해인가?) isSolution()
			process_solution(a, k); // 각 완성단계에서 하고싶은 작업 (출력)
			
		} else { // 재귀파트
			
			int[] c = new int[a.length]; // a와 똑같으면 안됌...
			int ncands = make_candidates(a, k, input, c); // 후보군을 만들어오는 메서드, ncands 리턴
			
			for (int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k + 1, input);		// 다음단계 재귀호출
			}
		}
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
	public static int make_candidates(int[] a, int k, int input, int[] c) {

		boolean[] in_perm = new boolean[a.length]; // 각 index가 사용했었는지 여부를 체크할 flag배열
		
		for (int i = 0; i < k; i++) { // 현재 단계 이전까지 사용한 숫자들을 체크
			in_perm[a[i]] = true; // 사용함 체크
		}
		
		// in_perm 배열에 false인 index는 사용안한 숫자임 => 후보군으로 담아서 보내기
		int ncands = 0; // 후보군의 개수를 카운팅할 변수
		for (int i = 0; i < in_perm.length; i++) {

			if (!in_perm[i]) { // 사용하지 않은 숫자라면
				c[ncands++] = i;
			}
		}

		return ncands; // 후보군의 개수
	}

	/**
	 * 각 완성단게에서 하고싶은 작업 (출력)
	 * 
	 * @param a
	 * @param k
	 */
	public static void process_solution(int[] a, int k) {
		for (int i = 0; i < k; i++) {
			System.out.print(a[i]+" ");	// 저장된 순번을 출력해보기
		}
		System.out.println();
	}

} // end of class
