/**
 * 피보나치 수열 : 0 1 1 2 3 5 8 11 . . . .
 * 1. 재귀함수		: 많은 중복이 일어난다. (시간이 많이 걸림)
 * 2. 메모이제이션	: 한번 연산한 결과를 저장해서 중복을 줄임. 하지만 호출은 존재함.
 * 3. DP			: 
 * @author student
 *
 */
public class Z15_피보나치 {
	
	public static int[] arr = new int[10];

	public static void main(String[] args) {
		
		arr[0] = 0;
		arr[1] = 1;
		
		int n = 6;
		System.out.println(fibo1(n));
		System.out.println(fibo2(n));
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
		
		int a = 0;
		int b = 1;
		
		for (int i = 2; i <= n ; i++ ) {
			int temp = a+b;
			a = b;
			b = temp;
		}
		
		System.out.println(b);
		
	}

	public static int fibo1(int n) {
		if( n == 0 || n == 1 ) return n;
		else 
			return fibo1(n-1) + fibo1(n-2);
	}
	public static int fibo2(int n) {
		if (n >= 2 && arr[n] == 0) {
			arr[n] = fibo2(n-1) + fibo2(n-2);			
		}
		return arr[n];
	}
}
