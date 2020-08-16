package algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class °íÃþºôµù_1328_0812 {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		long[][][] dp = new long[101][101][101];
		dp[1][1][1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= l; j++) {
				for (int k = 1; k <= r; k++) {

					long temp = dp[i - 1][j][k - 1] + dp[i - 1][j - 1][k] + (dp[i - 1][j][k] * (i - 2));
					dp[i][j][k] = temp % MOD;
				}
			}
		}
		System.out.println(dp[n][l][r]);
		// for (int i = 1; i <= n; i++) {
		// for (int j = 1; j <= l; j++) {
		// for (int k = 1; k <= r; k++) {
		// System.out.print(dp[i][j][k]);
		// }
		// System.out.println();
		// }
		// }

	}

}
