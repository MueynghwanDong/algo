

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_119 {

	private static int[][] arr;
	private static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int min;
	private static int endy;
	private static int endx;
	private static boolean[][] brr;
	private static int m;
	private static int n;

	public static void fun(int x, int y, int cnt, int dir) {
		brr[x][y] = true;
		if (x == endx && y == endy) {
			if (min > cnt)
				min = cnt;
			return;
		}
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (!brr[nx][ny] && arr[nx][ny] == 1) {
				if (dir == -1 || dir == i) {
					fun(nx, ny, cnt, i); // 방향전환 x
				} else {
					fun(nx, ny, cnt + 1, i); // 방향전환
				}
				brr[nx][ny] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		endx = Integer.parseInt(st.nextToken());
		endy = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		fun(0, 0, 0, -1);
		System.out.println(min);
	}

}
