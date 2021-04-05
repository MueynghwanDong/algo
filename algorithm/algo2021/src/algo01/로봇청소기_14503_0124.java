package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503_0124 {

	static int n, m;
	static int cnt;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0,-1 } };

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
		}// 입력
		cnt = 1;
		dfs(r, c, d);
		System.out.println(cnt);

	}

	public static void dfs(int x, int y, int d) {
		brr[x][y] = true;
		boolean check = false; // a문항 체크하기 위한 변수
		// a번 수행, 왼쪽에 청소할 공간이 있는지..
		if (d == 0) { // 북쪽
			if (y - 1 >= 0) {
				if (arr[x][y - 1] == 0 && !brr[x][y - 1]) {
					cnt++;
					check = true;
					dfs(x, y - 1, 3);
				}
			}
		} else { // 이외 방향
			int nx = x + dirs[d - 1][0];
			int ny = y + dirs[d - 1][1];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (arr[nx][ny] == 0 && !brr[nx][ny]) {
					cnt++;
					check = true;
					dfs(nx, ny, d - 1);
				}
			}
		}
		if (!check) {
			boolean c = false; // b번에 따른 체크 변수
			for (int i = 0; i < dirs.length; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (arr[nx][ny] == 0 && !brr[nx][ny])
					c = true;
			}
			if (!c) {
				//후진 연산
				int nd = d + 2;
				if (nd >= 4)
					nd = nd - 4;
				int nx = x + dirs[nd][0];
				int ny = y + dirs[nd][1];
				// 모든 방향으로 이동할수 없다면 종료
				if (arr[nx][ny] == 1)
					return;
				// 후진 후 2번 수행..
				else
					dfs(nx, ny, d);
			} else {
				// b번이 만족한 경우 
				if (d == 0)
					dfs(x, y, 3);
				else
					dfs(x, y, d - 1);
			}
		}

	}

}
