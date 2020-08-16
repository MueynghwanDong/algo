package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 피사노 주기
 - 피보나치 수를 k로 나눈 나머지는 항상 주기를 가지게 되는데 이를 피사노 주기라고 함
 - ex 피보나치 수를 3으로 나누면 주기 길이는 8
 - 주기가 p이면 n 번째 피보나치 수를 m으로 나눈 나머지는 n%p 번재 피보나치 수를 m으로 나눈 나머지와 같음
 - m = 10^k 이면 주기는 항상 15*10^(k-1)
 문제에서 m-> 1000000 , k =6
 주기는 15 * 10^5
 
 */
public class 피보나치수3_2749_0724 {

	static long n;
	static long fibo[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		int pisano = 1500000; // 피사노 주기
		fibo = new long[pisano];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i < pisano && i <= n; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
		}
		// 피사노 주기 까지만 구하기
		// 이상일 때는 나머지 값으로 n 값 찾기
		if (n >= pisano) {
			n = n % pisano;
		}
		System.out.println(fibo[(int) n]);
	}

}
