package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_1010_0728 { // 점화식 찾는 것이 중요!!

	static long[][] dp = new long[31][31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 1; i < 31; i++) {
			dp[1][i] = i;
		} // 서쪽이 1개인 경우
		for (int i = 2; i < 31; i++) {
			for (int j = i; j < 31; j++) {
				if (i == j) // 두 값이 같은 경우 한가지 경우밖에 없음..
					dp[i][j] = 1;

				else { // i의 이전 값 	j의 i-2부터 j-1까지 값까지 더해줌 
					for (int k = j - 1; k > i - 2; k--)  {						
						dp[i][j] += dp[i - 1][k];
					}
				}
			}
		}
		for (int t = 0; t < testcase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			System.out.println(dp[n][m]);
		}

	}

}
