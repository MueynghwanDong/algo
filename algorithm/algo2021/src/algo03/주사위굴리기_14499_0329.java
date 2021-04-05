package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기_14499_0329 {

	static class dice {
		int top, bottom, north, south, west, east;

		public void moveEast() {
			int temp = top;
			top = west;
			west = bottom;
			bottom = east;
			east = temp;
		}

		public void moveWest() {
			int temp = top;
			top = east;
			east = bottom;
			bottom = west;
			west = temp;
		}

		public void moveNorth() {
			int temp = top;
			top = south;
			south = bottom;
			bottom = north;
			north = temp;
		}

		public void moveSouth() {
			int temp = top;
			top = north;
			north = bottom;
			bottom = south;
			south = temp;
		}

	}

	static int n, m, sx, sy, k, cnt = 0;
	static int[][] arr;
	static int[] trr;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		trr = new int[k];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			trr[i] = Integer.parseInt(st.nextToken());
		}
		moving();
	}

	public static void moving() {
		dice d = new dice();
		for (int i = 0; i < k; i++) {
			int direct = trr[i] - 1;
			int nx = sx + dirs[direct][0];
			int ny = sy + dirs[direct][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (direct == 0) {
				d.moveEast();
			} else if (direct == 1) {
				d.moveWest();
			} else if (direct == 2) {
				d.moveNorth();
			} else
				d.moveSouth();

			// 주사위 값 지도에 적기
			if (arr[nx][ny] == 0) {
				arr[nx][ny] = d.bottom;
			} else { // 지도 값 주사위 bottom값에 적기
				d.bottom = arr[nx][ny];
				arr[nx][ny] = 0;
			}

			System.out.println(d.top);
			sx = nx;
			sy = ny;
		}

	}
}
