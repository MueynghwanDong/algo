package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n8_빙산_2573_2 {

	static int n, m;
	static int[][] arr, dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] brr;

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

		int time = 0;
		while (true) {
			brr = new boolean[n][m];
			int result = check();
			if (result >= 2) { // 두 덩어리 이상 분리된 경우
				System.out.println(time);
				break;
			} else if (result == 0) {
				System.out.println(0);
				break;
			} else {
				fun();
				time++;
			}
		}
	}

	public static void fun() {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] != 0) {
					int cnt = 0; // 빙산일 때 빙산이 아닌 바다의 갯수를 구함
					for (int k = 0; k < dirs.length; k++) {
						int nx = i + dirs[k][0];
						int ny = j + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m || temp[nx][ny] != 0)
							// 빙산이거나 범위를 벗어난 경우 제외
							continue;
						cnt++;
					}
					temp[i][j] -= cnt;
					if (temp[i][j] <= 0) {
						temp[i][j] = 0;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			arr[i] = temp[i].clone();
		}
	}

	public static int check() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0 && !brr[i][j]) { // 방문하지 않고 빙산인 경우
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
			dfs(nx, ny);
		}
	}

}
