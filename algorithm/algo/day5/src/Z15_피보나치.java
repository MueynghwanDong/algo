/**
 * 피보나치 수열 : 0 1 1 2 3 5 8 11 ...
 * 1. 재귀함수 : 많은 중복 발생
 * 2. 메모이제이션 : 한번 연산한 결과를 저장해 중복 연산을 줄인다.
 * 3. DP : 작은해 부터 구해서 전체해를 구한다. (메모이제이션이 같은 것 아님...) 
 *
 */
public class Z15_피보나치 {
	public static void main(String[] args) {
		System.out.println(fibo(6));

		memo[0] = 0;
		memo[1] = 1;
		System.out.println(fibo1(6));

		System.out.println("-----dp-----");
		int n = 6;
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		System.out.println(f[n]);
		
		int a = 0; int b=1;
		for(int i =2; i<=n ; i++) {
			int temp = a +b;
			a = b;
			b = temp;
		}
		System.out.println(b);
	}

	public static int[] memo = new int[10];

	public static int fibo1(int n) {
		if (n >= 2 && memo[n] == 0) { // 계산이 한번도 안되었다면, 재귀 호출로 계산해 저장
			memo[n] = fibo1(n - 1) + fibo1(n - 2);
		}

		return memo[n];
	}

	public static int fibo(int n) {
		if (n <= 1) { // 종료 파트
			return n;
		} else { // 재귀 파트
			return fibo(n - 1) + fibo(n - 2);
		}
	}
} // end of class
