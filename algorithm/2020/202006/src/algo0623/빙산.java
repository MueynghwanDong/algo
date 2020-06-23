package algo0623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ºù»ê {

	static int n;
	static int m;
	static int[][] arr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] brr;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // ÀÔ·Â
		result = 0;
		// µ¢¾î¸® Ã¼Å©
		int count = 0;
		while (true) {
			count = check();
			if (count >= 2) {
				System.out.println(result);
				break;
			} else if (count == 0) {
				System.out.println(0);
				break;
			} else {
				down();
				result++;
			}
		}
		// 1³âÈÄ ºùÇÏ
	}

	public static void down() {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cnt =0;
				for (int k = 0; k < dirs.length; k++) {
					int nx = i + dirs[k][0];
					int ny = j + dirs[k][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m)
						continue;
					if (arr[nx][ny] == 0) {
						cnt++;
					}
				}
				temp[i][j] = temp[i][j] - cnt;
				if (temp[i][j] < 0)
					temp[i][j] = 0;

			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {				
				arr[i][j] = temp[i][j];
			}			
		}
		
	}

	public static int check() {
		int cnt = 0;
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0 && !brr[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void dfs(int x, int y) {
		brr[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 0 || brr[nx][ny])
				continue;
			if (!brr[nx][ny] && arr[nx][ny] != 0) {
				dfs(nx, ny);
			}
		}
	}
}
