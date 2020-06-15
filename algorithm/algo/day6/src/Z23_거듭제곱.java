
public class Z23_거듭제곱 {

	public static void main(String[] args) {

		// 반복문
		int base = 2; // 밑수
		int exp = 20; // 지수
		int result = 1;

		for (int i = 0; i < exp; i++) {
			result *= base;
		}
		System.out.println(result);

		// 재귀 함수
		System.out.println(power(base, exp));
		System.out.println(power2(base, exp));
	}// end of main
		// 분할 정복 -> O(log n)

	public static int power2(int base, int exp) {
		if (exp == 1) { // 종료 조건
			return base;
		} else if (exp == 0) {
			return 1;
		}
		int temp = power2(base, exp / 2);
		temp *=temp;
		if (exp % 2 == 1) {
			temp *= base;
		}
		return temp;
//		if (exp % 2 == 0) {
//			int temp = power2(base, exp / 2);
//			return temp * temp;
//		} else {
//			int temp = power2(base, exp / 2);
//			return temp * temp * base;
//		}
	}

	// 재귀 함수 -> O(N)
	public static int power(int base, int exp) {
		if (exp == 0) { // 종료 조건
			return 1;
		} else { // 반복 조건
			return 2 * power(base, exp - 1);
		}
	} // end of power
} // end of class
