package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n7_내리막길_1520 {

	static int n, m;
	static int[][] arr, dp, dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

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

		int result = dfs(0, 0);
		System.out.println(result);

	}

	public static int dfs(int x, int y) {

		if (x == n - 1 && y == m - 1) {
			return 1;
		}
		if (dp[x][y] != -1) { // 한번 방문한 경우
			return dp[x][y];
		}
		dp[x][y] =0; // 첫 방문 일 경우 
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] >= arr[x][y])
				// 범위를 벗어나거나 이전값보다 클 경우
				continue;
			dp[x][y] += dfs(nx, ny);
		}
		return dp[x][y];
	}
}
