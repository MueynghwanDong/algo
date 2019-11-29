
public class Z23_거듭제곱 {

	public static void main(String[] args) {
		int base = 2; // 밑수
		int exp = 10; // 지수
		int result = 1;

		for (int i = 0; i < exp; i++) {
			result *= base;
		}
		System.out.println(result);
		System.out.println(power(base, exp));
		System.out.println(power2(base, exp));
	} // end of main

	public static int power(int base, int exp) {
		if (exp == 0) { // 종료 조건
			return 1;

		} else { // 반복 조건
			return base * power(base, exp - 1);
		}
	}

	public static int power2(int base, int exp) {
		if (exp == 1) { // 종료조건
			return base;
		} else if (exp == 0) {
			return 1;
		}
		int temp = power2(base, exp / 2);
		temp *= temp;
		if(exp % 2 == 1) {
			temp *= base;
		}
		return temp;
//		if (exp % 2 == 0) { // 짝수냐
//			return temp * temp;
//		} else { // 홀수냐
//			return temp * temp * base;
//		}
	}
	
} // end of class
