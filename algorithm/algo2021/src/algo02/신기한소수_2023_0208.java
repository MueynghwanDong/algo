package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신기한소수_2023_0208 {

	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		dfs("", 0);
	}

	public static void dfs(String s, int cnt) {

		if (cnt == n) {
			System.out.println(s);
		}
		for (int i = 1; i <= 9; i++) {
			if (isPrime(Integer.parseInt(s + i))) {
				dfs(s + i, cnt + 1);
			}
		}
	}

	public static boolean isPrime(int num) {
		if (num == 1)
			return false;
		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
