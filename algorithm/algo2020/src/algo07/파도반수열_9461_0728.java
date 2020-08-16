package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열_9461_0728 {

	static long[] dp = new long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;

		for (int i = 5; i < 101; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}

		for (int testcase = 0; testcase < t; testcase++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}

	}

}
