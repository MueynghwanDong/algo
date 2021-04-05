package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ºù»ê_2573_0204 {

	static int n, m;
	static int[][] arr;
	static boolean[][] brr;
	static int ans = 0;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		int time = 0;
		while (true) {
			count = check();
			if (count >= 2) {
				System.out.println(time);
				break;
			} else if (count == 0) {
				System.out.println(0);
				break;
			} else {
				down();
				time++;
			}
		}
	}

	public static void down() {
		int[][] tp = new int[n][m];
		for (int i = 0; i < n; i++) {
			tp[i] = arr[i].clone();
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cnt = 0;
				if (arr[i][j] != 0) {
					for (int k = 0; k < dirs.length; k++) {
						int nx = i + dirs[k][0];
						int ny = j + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m)
							continue;
						if (arr[nx][ny] == 0)
							cnt++;
					}
					tp[i][j] = tp[i][j] - cnt;
					if (tp[i][j] < 0)
						tp[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			arr[i] = tp[i].clone();
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
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == 0)
				continue;
			if (!brr[nx][ny] && arr[nx][ny] != 0) {
				dfs(nx, ny);
			}
		}
	}
}
