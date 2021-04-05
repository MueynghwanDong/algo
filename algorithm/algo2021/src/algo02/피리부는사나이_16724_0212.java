package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피리부는사나이_16724_0212 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, ans = 0;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	// UDRL

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!brr[i][j]) {
					dfs(i, j, new Pos(i, j));
				}
			}
		}
		System.out.println(ans);
	}

	public static void dfs(int x, int y, Pos start) {
		int d = 0;
		if (arr[x][y] == 'U')
			d = 0;
		else if (arr[x][y] == 'D')
			d = 1;
		else if (arr[x][y] == 'R')
			d = 2;
		else if (arr[x][y] == 'L')
			d = 3;

		int nx = x + dirs[d][0];
		int ny = y + dirs[d][1];

		if (start.x == nx && start.y == ny) {
			ans++;
			brr[nx][ny] = true;
			return;
		}
		brr[nx][ny] = true;
		dfs(nx, ny, start);

	}
}
