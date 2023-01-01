package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n3_적록색약_10026 {

	static int n;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[][] arr;
	static boolean[][] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!brr[i][j]) {
					dfs(i, j, arr[i][j]);
					cnt++;
				}
			}
		}
		System.out.print(cnt + " ");
		cnt = 0;
		brr = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!brr[i][j]) {
					dfs(i, j, arr[i][j]);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

	public static void dfs(int x, int y, char ch) {
		brr[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || arr[nx][ny] != ch)
				continue;
			dfs(nx, ny, arr[nx][ny]);
		}
	}
}
