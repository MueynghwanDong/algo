package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoDots_16929_0305 {

	static int n, m, sx = 0, sy = 0;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		boolean c = false;
		outer: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				c = false;
				brr = new boolean[n][m];
				brr[i][j] = true;
				sx = i;
				sy = j;
				c = dfs(i, j, arr[i][j], 1);
				if (c) {
					break outer;
				}
			}
		}

		if (c) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static boolean dfs(int x, int y, char c, int cnt) {
//		 System.out.println(x + " " + y + " " + c + " " + cnt);
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] != c)
				continue;
			if (brr[nx][ny]) {
				if (nx == sx && ny == sy && cnt>=4) {
					return true;
				} else
					continue;
			}

			if (arr[nx][ny] == c && !brr[nx][ny]) {
				brr[nx][ny] = true;
				boolean ch = dfs(nx, ny, c, cnt + 1);
				if (ch)
					return true;
			}
		}
		return false;
	}

}
