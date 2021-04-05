package 코테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503_0406 {

	static int n, m, ans = 1;
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
		// 입력
		fun(r, c, d); // 로봇 청소 시작
		System.out.println(ans);

	}

	public static void fun(int x, int y, int d) {
		brr[x][y] = true; // 현재 자리 청소
		// 왼쪽 방향 체크 - a단계 수행
		boolean check = false; // 왼쪽에 청소할 방향이 있는지 체크하기 위한 변수 => 없으면 다음 단계 수행
		if (d == 0) {
			if (y - 1 >= 0) {
				if (arr[x][y - 1] == 0 && !brr[x][y - 1]) {
					check = true;
					ans++;
					fun(x, y - 1, 3);
				}
			}
		} else {
			int nx = x + dirs[d - 1][0];
			int ny = y + dirs[d - 1][1];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (arr[nx][ny] == 0 && !brr[nx][ny]) {
					check = true;
					ans++;
					fun(nx, ny, d - 1);
				}
			}
		}
		if (!check) {
			boolean c = false; // 4방향을 확인해서 청소할 곳이 있는지 확인하기 위한 변수
			// 4방향 중 청소할 곳이 있는지 체크
			for (int i = 0; i < dirs.length; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 1 || brr[nx][ny])
					continue;
				c = true;
			}

			if (!c) { // 4방향 청소할 곳이 없는 경우
				int nd = d + 2;
				if (nd >= 4)
					nd = nd - 4;
				int nx = x + dirs[nd][0];
				int ny = y + dirs[nd][1];
				if (arr[nx][ny] == 1) { // 후진 불가 -> 종료
					return;
				} else { // c번 수행
					fun(nx, ny, d);
				}

			} else { // 왼쪽 방향으로 회전 -> 4방향 중 청소할 곳이 있는 경우 b번 수행
				if (d == 0) {
					fun(x, y, 3);
				} else {
					fun(x, y, d - 1);
				}
			}
		}

	}

}
