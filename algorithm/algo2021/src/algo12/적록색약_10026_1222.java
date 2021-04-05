package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약_10026_1222 {

	static int cnt = 0;
	static int n;
	static char[][] crr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		crr = new char[n][n];
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				crr[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!brr[i][j]) {
					brr[i][j] = true;
					dfs(i, j, crr[i][j]);
					cnt++;
				}
			}
		}
		System.out.print(cnt + " ");
		cnt = 0;
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (crr[i][j] == 'G')
					crr[i][j] = 'R';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!brr[i][j]) {
					brr[i][j] = true;
					dfs(i, j, crr[i][j]);
					cnt++;
				}
			}
		}
		System.out.print(cnt);

	}

	public static void dfs(int x, int y, char c) {
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || crr[nx][ny] != c)
				continue;
			if (!brr[nx][ny] && crr[nx][ny] == c) {
				brr[nx][ny] = true;
				dfs(nx, ny, c);
			}
		}
	}
}
