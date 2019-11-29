

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16234 {
	private static int n;
	private static int r;
	private static int l;
	private static int[][] arr;
	private static boolean[][] brr;
	public static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t = Integer.MAX_VALUE;
		int count = 0;
		int tt = 0;
		int i, j = 0;
		outer: while (true) {
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					System.out.println(i + " " + j);
					print();
					if (!brr[i][j]) {
						System.out.println(i + " " + j);
						fun(i, j);
						break;
					}
				}
			}
			t = calc();
			System.out.println(t);
			if (t == 0) {
				break outer;
			}
			if (t != 0)
				count++;
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					if (brr[i][j]) {
						brr[i][j] = false;
					}
				}
			}
		}
		System.out.println(count);
	}

	public static void fun(int x, int y) {
		// System.out.println(x + " " + y);
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (brr[nx][ny])
				continue;
			boolean c = check(arr[x][y], arr[nx][ny]);
			if (c) {
				brr[nx][ny] = true;
				fun(nx, ny);
			} else {
				//brr[nx][ny] = false;
			}
		}
		// .out.println(calc());
	}

	public static boolean check(int num1, int num2) {
		int d = Math.abs(num1 - num2);
		if (l <= d && r >= d)
			return true;
		else
			return false;
	}

	public static int calc() {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (brr[i][j]) {
					sum += arr[i][j];
					cnt++;
				}
			}
		}
		if (cnt != 0) {
			int temp = (sum / cnt);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (brr[i][j]) {
						arr[i][j] = temp;
					}
				}
			}
		}
		print();
		return cnt;
	}

	public static void print() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
				System.out.print(brr[i][j] + " ");
			}
			System.out.println();
		}
	}
}