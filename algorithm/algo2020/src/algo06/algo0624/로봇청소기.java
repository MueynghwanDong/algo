package algo06.algo0624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ·Îº¿Ã»¼Ò±â {

	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] brr;
	static Queue<int[]> queue = new LinkedList<>();
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		st = new StringTokenizer(br.readLine(), " ");
		int rx = Integer.parseInt(st.nextToken());
		int ry = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // ÀÔ·Â
		cnt=1;
		clean(rx, ry, d);
		System.out.println(cnt);

	}

	public static void clean(int x, int y, int d) {
//		queue.offer(new int[] { x, y, d, 1 });
		brr[x][y] = true;
		// ¿ÞÂÊ ºÎÅÍ Å½»ö
		boolean c = false;
		if (d == 0) {
			if (y - 1 >= 0) {
				if (arr[x][y - 1] == 0 && !brr[x][y - 1]) {
					cnt++;
					clean(x, y - 1, 3);
					c = true;
				}
			}
		} else {
			int nx = x + dir[d - 1][0];
			int ny = y + dir[d - 1][1];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (arr[nx][ny] == 0 && !brr[nx][ny]) {
					cnt++;
					clean(nx, ny, d - 1);
					c = true;
				}
			}
		}
		if (!c) {

			boolean check = false;
			for (int i = 0; i < dir.length; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (arr[nx][ny] == 0 && !brr[nx][ny]) {
					check = true;
				}
			}
			if (!check) {
				int nd = d + 2;
				if (nd >= 4)
					nd = nd - 4;
				int nx = x + dir[nd][0];
				int ny = y + dir[nd][1];
				if (arr[nx][ny] == 1) {
					return;
				} else {
					clean(nx, ny, d);
				}
			}
			if (check) {
				if (d == 0)
					clean(x, y, 3);
				else {
					clean(x, y, d - 1);
				}
			}
		}

		//

	}

}
