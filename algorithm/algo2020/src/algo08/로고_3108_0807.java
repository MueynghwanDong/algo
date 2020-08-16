package algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ·Î°í_3108_0807 {

	static int n;
	static int cnt;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] arr = new int[1001][1001];
	static boolean[][] brr;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		int idx = 0;
		brr = new boolean[1001][1001];
		check = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			idx = i + 1;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()) + 500;
			int y1 = Integer.parseInt(st.nextToken()) + 500;
			int x2 = Integer.parseInt(st.nextToken()) + 500;
			int y2 = Integer.parseInt(st.nextToken()) + 500;
			for (int j = x1; j <= x2; j++) {
				if (arr[j][y1] != 0 && arr[j][y1] != idx) {
					check[idx] = true;
					check[arr[j][y1]] = true;
				} else {
					arr[j][y1] = idx;
				}
				if (arr[j][y2] != 0 && arr[j][y2] != idx) {
					check[idx] = true;
					check[arr[j][y2]] = true;
				} else {
					arr[j][y2] = idx;
				}

			}
			for (int j = y1; j <= y2; j++) {
				if (arr[x1][j] != 0 && arr[x1][j] != idx) {
					check[idx] = true;
					check[arr[x1][j]] = true;
				} else {
					arr[x1][j] = idx;
				}

				if (arr[x2][j] != 0 && arr[x2][j] != idx) {
					check[idx] = true;
					check[arr[x2][j]] = true;
				} else {
					arr[x2][j] = idx;
				}

			}
		}

		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (arr[i][j] != 0 && !brr[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	public static void dfs(int x, int y) {
		brr[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx > 1000 || ny > 1000 || brr[nx][ny])
				continue;
			if (arr[nx][ny] != 0) {
				if ((arr[x][y] != arr[nx][ny]) && check[arr[nx][ny]]) {
					dfs(nx, ny);
				} else if (arr[x][y] == arr[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

}
