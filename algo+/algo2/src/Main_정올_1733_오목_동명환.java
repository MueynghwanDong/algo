

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1733_오목_동명환 {

	private static int[][] arr;
	private static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 },
			{ -1, -1 } };
	private static int rx;
	private static int ry;
	private static int result;

	public static void fun(int x, int y, int d, int num, int cnt) {
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
				continue;
			if (arr[nx][ny] != num)
				continue;
			if (arr[nx][ny] == num) {
				fun2(nx, ny, i, num, cnt + 1);
			}
		}

	}

	public static boolean reverse(int x, int y, int d, int num) {
		int temp = 1;
		if (d % 2 == 0) {
			d = d + 1;
		} else {
			d = d - 1;
		}
		int tx = x + dirs[d][0];
		int ty = y + dirs[d][1];
		if (tx < 0 || ty < 0 || tx >= 19 || ty >= 19) {
			return false;
		}
		while (arr[tx][ty] == num) {
			if (arr[tx][ty] == num)
				temp++;
			tx = tx + dirs[d][0];
			ty = ty + dirs[d][1];
			if (tx < 0 || ty < 0 || tx >= 19 || ty >= 19) {
				break;
			}
		}
		if (temp == 5) {
			return true;
		} else
			return false;
	}

	public static void fun2(int x, int y, int d, int num, int cnt) {
		if (cnt == 5) {
			int tx = x + dirs[d][0];
			int ty = y + dirs[d][1];
			if (tx < 0 || ty < 0 || tx >= arr.length || ty >= arr.length)
				return;
			if (arr[tx][ty] != num) {
				if (ry > y) {
					if (reverse(x, y, d, num)) {
						result = num;
						if (d == 0) {
							rx = x - 4;
						} else {
							rx = x;
						}
						ry = y;
					}
				}
			}
		} else if (cnt >= 6) {
			return;
		}
		int nx = x + dirs[d][0];
		int ny = y + dirs[d][1];
		if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
			return;
		if (arr[nx][ny] != num)
			return;
		if (arr[nx][ny] == num) {
			fun2(nx, ny, d, num, cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		arr = new int[19][19];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rx = Integer.MAX_VALUE;
		ry = Integer.MAX_VALUE;
		result = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != 0) {
					fun(i, j, -1, arr[i][j], 1);
				}
			}
		}
		if (result == 0) {
			System.out.println(0);
		} else {
			System.out.println(result);
			System.out.println((rx + 1) + " " + (ry + 1));
		}
	}

}