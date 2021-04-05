package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503_0129 {
	static int n, m;
	static int cnt;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 1;
		dfs(r, c, d);
		System.out.println(cnt);
	}

	public static void dfs(int r, int c, int d) {
		brr[r][c] = true; // 현재 위치 청소 1번
		boolean check = false;
		// 2.a 왼쪽방향 체크
		if (d == 0) {
			if (c - 1 >= 0) {
				if (arr[r][c - 1] == 0 && !brr[r][c - 1]) {
					cnt++;
					check = true;
					dfs(r, c - 1, 3);
				}
			}
		} else {
			int nx = r + dirs[d - 1][0];
			int ny = c + dirs[d - 1][1];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (arr[nx][ny] == 0 && !brr[nx][ny]) {
					cnt++;
					check = true;
					dfs(nx, ny, d - 1);
				}
			}
		}
		if (!check) {
			//2.b 왼쪽 방향에 청소할 공간이 없는 경우 
			boolean cc = false;
			for (int i = 0; i < dirs.length; i++) {
				int nx = r + dirs[i][0];
				int ny = c + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				// 네면중 하나라도 청소할 공간 있을 경우 cc = true
				if (arr[nx][ny] == 0 && !brr[nx][ny])
					cc = true;
			}
			if (!cc) {
				// 2.c 후진한 후 2번으로 dfs
				int nd = d + 2;
				if (nd >= 4)
					nd = nd - 4;
				int nx = r + dirs[nd][0];
				int ny = c + dirs[nd][1];
				//2.d 작동 멈추는 경우
				if (arr[nx][ny] == 1) {
					return;
				} else
					dfs(nx, ny, d);

			} else {
				// 2.b 수행 dfs --> 왼쪽으로 이동하면서 진행
				if (d == 0) {
					dfs(r, c, 3);
				} else {
					dfs(r, c, d - 1);
				}
			}
		}
	}
}
