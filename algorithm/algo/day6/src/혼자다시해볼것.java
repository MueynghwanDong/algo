
public class 혼자다시해볼것 {
	public static int[] arr = { 3, 4, 5, 6, 7, 8, 9 };

	public static void main(String[] args) {

		int[] a = new int[arr.length]; // 순번 저장 배열
		backtrack(a, 0, a.length);
	}

	public static void backtrack(int[] a, int k, int input) {
		if (k == input) {
			process_solution(a, k);
		} else {
			int[] c = new int[a.length]; // 후보군 저장
			int ncands = make_candidates(a, k, input, c);
			for (int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k + 1, input);
			}
		}
	}

	public static int make_candidates(int[] a, int k, int input, int[] c) {
		boolean[] in_perm = new boolean[a.length];
		for (int i = 0; i < k; i++) {
			in_perm[a[i]] = true;
		}
		int ncands = 0;
		for (int i = 0; i < in_perm.length; i++) {
			if (!in_perm[i])
				c[ncands++] = i;
		}
		return ncands;
	}

	public static void process_solution(int[] a, int k) {
		for (int i = 0; i < k; i++) {
			// System.out.print(a[i] + " ");
			System.out.print(arr[a[i]] + " "); // 저장된 순번을 출력해보기
		}
		System.out.println();
	}
}
