import java.util.Arrays;

/**
 * Subset : 어떤 집합의 모든 부분집합을 원소로 하는 집합
 * Subset을 구하는 방법
 * 1. 반복문
 * 2. 바이너리 카운팅
 * 3. 재귀함수
 * @author student
 *
 */
public class Z07_Subset {
	
	static int [] arr = {-7, -3, -2, 5, 8};
	
	public static void main(String[] args) {
		
		// 1. 반복문
		for (int i = 0; i < 2; i++) { 	// 첫번째 원소를 사용할 지 여부
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
//					System.out.println(i + ", " + j + ", " + k);
					System.out.print(i == 1 ? arr[0] + " " : "");
					System.out.print(j == 1 ? arr[1] + " " : "");
					System.out.print(k == 1 ? arr[2] + " " : "");
					System.out.println();
				}
			}
		} 	// 단점 : 소스코드 바꿔야함
		
		// 정수의 진법 표현
		System.out.println(1234); 	// 10진수 0~9
		System.out.println(0b11); 	// 2진수 0~1
		System.out.println(0123); 	// 8진수 0~7
		System.out.println(0x123); 	// 16진수 0~9, a~f
		System.out.println(100);	// 10진수 100.
		System.out.println(Integer.toBinaryString(100));	// 2진수로 표현
		System.out.println(0b1100100);
		System.out.println(Integer.toString(100, 3));
		
		// 쉬프트 연산자
		System.out.println("1 << 0 : " + (1<<0) + " : " + Integer.toBinaryString(1<<0));
		System.out.println("1 << 1 : " + (1<<1) + " : " + Integer.toBinaryString(1<<1));
		System.out.println("1 << 2 : " + (1<<2) + " : " + Integer.toBinaryString(1<<2));
		System.out.println("1 << 3 : " + (1<<3) + " : " + Integer.toBinaryString(1<<3));
		System.out.println("1 << 4 : " + (1<<4) + " : " + Integer.toBinaryString(1<<4));
		
		// 비트 마스킹
		int n = 0b100110111;
		System.out.print((n & 0b1) == 0? 0 : 1);
		System.out.print((n & 0b10) == 0? 0 : 1);
		System.out.print((n & 0b100) == 0? 0 : 1);
		System.out.print((n & 0b1000) == 0? 0 : 1);
		System.out.print((n & 0b10000) == 0? 0 : 1);
		System.out.println( (n & 0b100000) == 0? 0 : 1);
		
		for (int i = 0; i < 9; i++) {
			System.out.println((n & (1<< i)) == 0 ? 0: 1 );
		}
		
		
		
		// 2. 바이너리 카운팅 Power Set
		// 부분집합의 갯수, 비트마스킹, 쉬프트연산자
		int [] brr = {-7, -3, -2};
		for (int i = 0; i < (1 << brr.length); i++) { // 숫자를 10
			for (int j = 0; j < brr.length; j++) {
				if (( i & (1<<j) )!= 0) {
					System.out.print(brr[j]+", ");
				}
			}
			System.out.println();
		}// 단점 : 비트..를 사용하므로 원소갯수 제한
		
		
		
		// 3. 재귀함수 연습
		int v = 1;
		for(int i=1; i<=4; i++) {
			v *= i;
		}
		System.out.println(a(4)); // 재귀함수로 팩토리얼 구현
		
		
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(b(1)); // 시작값을 보냄
		b2(1);
		System.out.println();
		c(0);
		System.out.println();
		d(5);
		
		e(2, 12, 3);
		
		/*
		 * [ 반복문 ]
		 * 	CPU만 점유함.
		 * 	실행속도가 빠르다. (재귀보다)
		 * 	단점 : 동적으로 바뀌는 구조를 반복문으로 표현 X
		 * 
		 * [재귀함수]
		 * 	callstack 영역에 메모리를 사용, 메모리의 한계가 있다.
		 *  실행속도가 느리다. ( 메모리를 활용해서 실행속도를 개선할 수 있다. 반복문보다 빠른 결과를 나타낼 수 있음 )
		 *  동적으로 바뀌는 구조를 재귀함수로 표현이 가능하다.
		 */
		
		
		System.out.println("////// 재귀함수로 모든 부분집합(powerSet) 을 구해보자//////");
		f(0);
		
		
	} // end of main
	public static boolean[] bit = new boolean[arr.length];	// 각 원소를 사용할지 여부를 판단할 배열
	
	/*
	 * 매개변수 n번재 인덱스 배열값을 사용할지 여부를 지정 후 재귀호출, 마지막에 bit 배열을 보고 출력
	 */
	public static void f (int n) {
		int temp = 0;
		if (n==arr.length) {	// 종료파트
			for (int i = 0; i < bit.length; i++) {
				temp += bit[i] ? arr[i] : 0;
			}
			if(temp == 0) {
				for (int j = 0; j < bit.length; j++) {
					System.out.print( bit[j] ? arr[j] + " " : "" );
				}
			}
			System.out.println();
		} else {	// 재귀파트 : bit배열의 각 원소를 
			bit[n] = false;
			f(n+1);
			bit[n] = true;
			f(n+1);
		}
	}
	
	public static int a(int n) {
		if(n<=1) { // 종료파트 ( 0! = 1 )
			return 1;
		} else { // 재귀파트
			return n * a(n-1);
		}
	}
	public static String b(int n) {
		if(n==5) {
			return "5";
		} else {
			return n + " " + b(n+1);
		}
	}
	public static void b2(int n) {
		if (n>=5)
			System.out.println(n);
		else {
			System.out.print(n + " ");
			b2(n+1);
		}
	}
	public static void c (int n) {
		if (n>=8) {
			System.out.print(n);
		} else {
			System.out.print(n + " ");
			c(n+2);
		}
	}
	public static void d (int n) {
		if(n <= 1) {
			System.out.println(n);
		} else {
			System.out.print(n + " ");
			d(n-1);
		}
	}
	public static void e(int start, int end, int step) {
		if( start >= end) {
			System.out.println();
		} else  {
			System.out.print( start + " " );
			e(start+step, end, step);
		}
	}
	
} // end of class
