import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj10026 {

	static class ax {
		int x;
		int y;

		public ax(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static char[][] arr;
	static boolean[][] brr;
	static boolean[][] brr2;
	// static Stack<ax> st;
	static int cnt = 0;
	static int cnt2 = 0;

	public static void dfs(int x, int y) {

		brr[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= arr.length || newy >= arr.length)
				continue;
			if (arr[x][y] == 'R' && arr[newx][newy] == 'R' && !brr[newx][newy]) {
				dfs(newx, newy);
			}
			if (arr[x][y] == 'B' && arr[newx][newy] == 'B' && !brr[newx][newy]) {
				dfs(newx, newy);
			}
			if (arr[x][y] == 'G' && arr[newx][newy] == 'G' && !brr[newx][newy]) {
				dfs(newx, newy);
			}
		}
	}

	public static void dfs2(int x, int y) {

		brr2[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			if (newx < 0 || newy < 0 || newx >= arr.length || newy >= arr.length)
				continue;
			if ((arr[x][y] == 'R' && arr[newx][newy] == 'R' || arr[x][y] == 'B' && arr[newx][newy] == 'B')
					&& !brr2[newx][newy]) {
				dfs2(newx, newy);
			}

			if (arr[x][y] == 'G' && arr[newx][newy] == 'G' && !brr2[newx][newy]) {
				dfs(newx, newy);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		// st = new Stack();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		brr = new boolean[n][n];
		brr2 = new boolean[n][n];
		arr = new char[n][n];
		for (int i = 0; i < arr.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
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
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((arr[i][j] == 'R' || arr[i][j] == 'G') && !brr2[i][j]) {
					dfs2(i, j);
					cnt2++;

				} else if (arr[i][j] == 'G' && !brr2[i][j]) {
					dfs2(i, j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(cnt2);

	}

}
