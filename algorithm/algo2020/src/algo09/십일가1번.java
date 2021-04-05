package algo09;

public class 십일가1번 {

	public static void main(String[] args) {

		int[] temp = { 6, 2, 3, 5, 6, 3 };
		System.out.println(solution(temp));
	}

	static int[] cnt;
	static int result = 0;

	public static int solution(int[] A) {
		cnt = new int[A.length + 1];
		for (int i = 0; i < A.length; i++) {
			cnt[A[i]]++;
		}
		for (int i = 1; i <= A.length; i++) {
			if (cnt[i] == 0) {
				for (int j = i; j <= A.length; j++) {
					if (cnt[j] >1 ) {
						cnt[i]++;
						cnt[j]--;
						result += (j - i);
						// System.out.println(i-j);
					}
				}
				
			}
		}
		System.out.println(check(A, cnt));
		if (!check(A, cnt)) {
			for (int i = 1; i <= A.length; i++) {
				if (cnt[i] == 0) {
					for (int j = i; j >= 1; j--) {
						if (cnt[j] > 1) {
							cnt[i]++;
							cnt[j]--;
							result += (i - j);
							// System.out.println(i-j);
						}
					}

				}

			}
		}
		// if(!(check(A,cnt))) {
		// boolean c = false;
		// for (int i = 1; i <= A.length; i++) {
		// if(cnt[i]==0) c = true;
		// }
		// if(!c) {
		// result+=1;
		// }
		// }
		for (int i = 1; i <= A.length; i++) {
			System.out.println(i + " " + cnt[i]);
		}
		return result;
	}

	public static boolean check(int[] A, int[] cnt) {
		boolean c = true;
		for (int i = 1; i <= A.length; i++) {
			if (cnt[i] == 0)
				return false;
		}
		return c;
	}

}
