package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503_1014 {

	static int cnt;
	static int n;
	static int m;
	static int[][] arr;
	static int[][] brr;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		brr = new int[n][m];
		st = new StringTokenizer(br.readLine());
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
		clean(r, c, d);
		System.out.println(cnt);
	}

	public static void clean(int x, int y, int d) {
		brr[x][y] = 1; // 지나온 곳 체크 
		boolean c = false;
		if (d == 0) { // 방향이 북쪽인 경우 
			if (y - 1 >= 0) {
				if (arr[x][y - 1] == 0 && brr[x][y - 1] == 0) {
					cnt++;
					clean(x, y - 1, 3); // 왼쪽이동 
					c = true;
				}
			}
		} else {
			int nx = x + dirs[d - 1][0];
			int ny = y + dirs[d - 1][1];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (arr[nx][ny] == 0 && brr[nx][ny] == 0) {
					cnt++;
					clean(nx, ny, d - 1);
					c = true;
				}
			}
		}
		if (!c) { // 1번이 아닌 경우 2번의 경우로....
			boolean check = false;
			for (int i = 0; i < dirs.length; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (arr[nx][ny] == 0 && brr[nx][ny] == 0)
					check = true;
			}
			if (!check) {
				int nd = d + 2; // 반대 방향 이동
				if (nd >= 4)
					nd = nd - 4;
				int nx = x + dirs[nd][0];
				int ny = y + dirs[nd][1];
				if (arr[nx][ny] == 1) // 4
					return;
				else
					clean(nx, ny, d); // 3
			} else { // 4방향 중 이동할 곳이 있는 경우
				if (d == 0)
					clean(x, y, 3);
				else
					clean(x, y, d - 1);
			}
		}
	}
}
