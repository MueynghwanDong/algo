package algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 내리막길_1520_0810 {

	static int[][] dp;
	static int[][] arr;
	static int n;
	static int m;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));

	}

	public static int dfs(int x, int y) {

		if (x == n - 1 && y == m - 1)
			return 1;
		if (dp[x][y] != -1)
			return dp[x][y];
		else {
			dp[x][y] = 0;
			for (int i = 0; i < dirs.length; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (arr[x][y] > arr[nx][ny]) {
					int tmp = dfs(nx, ny);
					// System.out.println(nx+" " + ny);
					// System.out.println(tmp);
					dp[x][y] += tmp;
				}
			}
			return dp[x][y];
		}
	}
}
