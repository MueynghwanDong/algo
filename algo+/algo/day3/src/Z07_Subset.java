
/**
 * Subset : 부분집합 subset 구하는 방법
 * 1. 반복문 -> 동적으로 변경 불가 , 속도가 빠르지만 비효율적 
 * 2. 바이너리 카운팅 -> 타입의 한계/제한이 있다. 
 * 3. 재귀함수 -> 속도가 느리지만 효율적
 */
public class Z07_Subset {

	public static void main(String[] args) {

		// 1. 반복문
		int[] arr = { 6, 7, 8 };
		for (int i = 0; i < 2; i++) { // 첫번째 원소를 사용할지 여부
			for (int j = 0; j < 2; j++) { // 두번재 원소
				for (int k = 0; k < 2; k++) { // 세번째 원소
					// System.out.println(i + "," + j + "," +k);
					System.out.print(i == 1 ? arr[0] + " " : "");
					System.out.print(j == 1 ? arr[1] + " " : "");
					System.out.print(k == 1 ? arr[2] + " " : "");
					System.out.println();
				}
			}
		}
		// 정수의 진법 표현
		System.out.println();
		System.out.println(1234); // 10진수 0~9
		System.out.println(0b1011); // 2진수 0b 0~1
		System.out.println(01237); // 8진수 0~7
		System.out.println(0x1A2B); // 16진수 0~9 + A~F
		System.out.println(100);
		System.out.println(Integer.toBinaryString(100));// 2진수로 출력
		System.out.println(Integer.toString(100, 2));// 2진수로출력 뒤 숫자가 진법을 의미

		System.out.println();

		System.out.println("시프트 연산자");
		System.out.println(1 << 2);
		System.out.println(1 << 0);
		System.out.println("1<<0 : " + (1 << 0) + ": " + Integer.toBinaryString(1 << 0));
		System.out.println("1<<1 : " + (1 << 1) + ": " + Integer.toBinaryString(1 << 1));
		System.out.println("1<<2 : " + (1 << 2) + ": " + Integer.toBinaryString(1 << 2));
		System.out.println("1<<3 : " + (1 << 3) + ": " + Integer.toBinaryString(1 << 3));
		System.out.println("1<<4 : " + (1 << 4) + ": " + Integer.toBinaryString(1 << 4));
		System.out.println("1<<5 : " + (1 << 5) + ": " + Integer.toBinaryString(1 << 5));

		System.out.println();

		System.out.println("비트 마스킹");
		int n = 0b100110111;
		System.out.print((n & 0b1) == 0 ? 0 : 1);
		System.out.print((n & 0b10) == 0 ? 0 : 1);
		System.out.print((n & 0b100) == 0 ? 0 : 1);
		System.out.print((n & 0b1000) == 0 ? 0 : 1);
		System.out.print((n & 0b10000) == 0 ? 0 : 1);

		System.out.println("반복문으로 비트 마스킹");

		for (int i = 0; i < 9; i++) {
			System.out.println((n & (1 << i)) == 0 ? 0 : 1);
		}
		System.out.println();

		// 2. 바이너리 카운팅 으로 Power Set
		// 부분집합의 갯수, 비트마스킹, 시프트 연산자
		int[] brr = { -7, -3, -2, 5, 8 };
		for (int i = 0; i < (1 << brr.length); i++) { // 10진수로 숫자를 표현
			for (int j = 0; j < brr.length; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(brr[j] + "  ");
				}
			}
			System.out.println();
		}

		// 재귀 연습
		int v = 1;
		for (int i = 1; i < 4; i++) {
			v *= i;
		}
		System.out.println(v);
		System.out.println(a(4)); // 재귀함수로 팩토리얼 구현

		System.out.println();
		b(1);
		System.out.println();
		for (int i = 0; i <= 8; i = i + 2) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 5; i > 0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		c(0);
		d(5);
		e(2, 12, 3);

		System.out.println();
		System.out.println("재귀함수로 모든 부분집합을 구해보자");

		f(0); // 부분집합 출력 재귀함수
		
		// 3. 재귀함수

	} // end of main
		// 반복문 -> cpu만 사용, 실행속도가 빠르다(재귀함수에 비해) 단점 : 동적으로 바뀌는 구조를 반복문으로 표현이
		// 불가능하다.(권장하지않음)
		// 재귀함수 -> call stack 영역에 메모리를 사용, 메모리의 한계가 있음,
		// 실행속도가 느리다(메모리를 활용해 실행속도를 개선할 수있다-> 반복문 보다 빠른 결과를 나타내는 경우도 있음), 동적으로 바뀌는 구조를
		// 재귀함수로 표현가능
		// heap - 인스턴스 변수 / call stack - 지역변수 / class area - static 변수

	public static int[] crr = { -7, -3, -2, 5, 8 };

	public static boolean[] bit = new boolean[crr.length]; // 각 원소를 사용할지 여부를 판단할 배열

	/** 매개변수 n 번째 인덱스의 배열값을 사용할지 여부를 지정 후 재귀 호출, 마지막에 bit 배열을 보고 출력 */
	public static void f(int n) {
		if (n == crr.length) { // 종료 파트 : bit배열의 내용을 보고, crr 배열의 원소를출력
			//System.out.println(Arrays.toString(bit));
			int sum = 0;
			for (int i = 0; i < bit.length; i++) {
				// System.out.print(bit[i] ? crr[i] + " " : " ");
				if (bit[i])
					sum += crr[i];
			}
			// System.out.println();

			if (sum == 0) { // 합이 0인 원소들 출력하는 부분
				for (int i = 0; i < bit.length; i++) {
					System.out.print(bit[i] ? crr[i] + " " : " ");
				}
				 System.out.println();
			}
		} else { // 재귀 파트: bit 배열의 각 원소를 채우기
			bit[n] = false;
			f(n + 1);
			bit[n] = true;
			f(n + 1);
		}
	}

	public static int a(int n) {
		if (n <= 1) {// 종료파트
			return 1;
		} else {// 재귀파트
			return n * a(n - 1);
		}
	}

	public static void b(int n) {
		if (n > 5) {
			System.out.println();
			// System.out.println(Integer.toString(n));
		} else {
			System.out.print(n + " ");
			b(n + 1);
			// System.out.println(Integer.toString(n) + " " + b(n + 1);
		}
	}

	public static void c(int n) {
		if (n > 8) {
			System.out.println();
		} else {
			System.out.print(n + " ");
			c(n + 2);
		}
	}

	public static void d(int n) {
		if (n <= 0) {
			System.out.println();
		} else {
			System.out.print(n + " ");
			d(n - 1);
		}
	}

	public static void e(int start, int end, int step) {
		if (start > end) {
			System.out.println();
		} else {
			System.out.print(start + " ");
			e(start + step, end, step);
		}
	}
} // end of class
