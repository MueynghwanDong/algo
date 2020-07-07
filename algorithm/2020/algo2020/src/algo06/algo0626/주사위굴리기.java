package algo0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기 {

	static class dice {
		int top;
		int bottom;
		int west;
		int east;
		int north;
		int south;

		public void moveeast() {
			int temp = top;
			top = west;
			west = bottom;
			bottom = east;
			east = temp;
		}

		public void movewest() {
			int temp = top;
			top = east;
			east = bottom;
			bottom = west;
			west = temp;
		}

		public void movenorth() {
			int temp = top;
			top = south;
			south = bottom;
			bottom = north;
			north = temp;
		}

		public void movesouth() {
			int temp = top;
			top = north;
			north = bottom;
			bottom = south;
			south = temp;

		}

	}

	private static int[][] arr;
	private static int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	private static int[] trr;
	private static int cnt;
	private static int sy;
	private static int sx;
	private static int m;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken()); // 시작 위치
		sy = Integer.parseInt(st.nextToken()); // 시작 위치
		cnt = Integer.parseInt(st.nextToken()); // 명령 갯수
		arr = new int[n][m];
		trr = new int[cnt];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < cnt; i++) {
			trr[i] = Integer.parseInt(st.nextToken());
		}
		moving();
	}

	public static void moving() {
		dice d = new dice();
		for (int i = 0; i < cnt; i++) {
			int direct = trr[i] - 1;
			int nx = sx + dirs[direct][0];
			int ny = sy + dirs[direct][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;

			if (direct == 0) {
				d.moveeast();
			} else if (direct == 1) {
				d.movewest();
			} else if (direct == 2) {
				d.movenorth();
			} else {
				d.movesouth();
			}

			if (arr[nx][ny] == 0) {
				arr[nx][ny] = d.bottom;
			} else {
				d.bottom = arr[nx][ny];
				arr[nx][ny] = 0;
			}
			System.out.println(d.top);
			sx = nx;
			sy = ny;

		}
	}
}
