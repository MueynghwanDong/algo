package algo06.algo0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {

	static char[][] arr;
	static boolean[][] brr;
	static boolean[][] brr2;
	static int n;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());

		arr = new char[n][n];
		brr = new boolean[n][n];
		brr2 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'R' && !brr[i][j]) {
					dfs(i, j);
					cnt++;
				} else if (arr[i][j] == 'B' && !brr[i][j]) {
					dfs(i, j);
					cnt++;
				} else if (arr[i][j] == 'G' && !brr[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		int cnt2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((arr[i][j] == 'R' || arr[i][j] == 'G') && !brr2[i][j]) {
					dfs2(i, j);
					cnt2++;
				} else if (arr[i][j] == 'B' && !brr2[i][j]) {
					dfs2(i, j);
					cnt2++;
				}
			}
		}

		System.out.println(cnt + " " + cnt2);
	}

	public static void dfs(int x, int y) {
		brr[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= n || newy >= n)
				continue;
			if (arr[x][y] == 'R' && arr[newx][newy] == 'R' && !brr[newx][newy]) {
				dfs(newx, newy);
			} else if (arr[x][y] == 'B' && arr[newx][newy] == 'B' && !brr[newx][newy]) {
				dfs(newx, newy);
			} else if (arr[x][y] == 'G' && arr[newx][newy] == 'G' && !brr[newx][newy]) {
				dfs(newx, newy);
			}
		}
	}

	public static void dfs2(int x, int y) {
		brr2[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= n || newy >= n)
				continue;
			if ((arr[x][y] == 'R' || arr[x][y] == 'G') && (arr[newx][newy] == 'R' || arr[newx][newy] == 'G')
					&& !brr2[newx][newy]) {
				dfs2(newx, newy);
			} else if (arr[x][y] == 'B' && arr[newx][newy] == 'B' && !brr2[newx][newy]) {
				dfs2(newx, newy);
			}
		}
	}

}
