import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방_동명환 {

	private static int[][] arr;
	private static int n;
	private static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static int cnt;

	public static void fun(int x, int y, int data) {
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (arr[nx][ny] == data + 1) {
				cnt++;
				fun(nx, ny, data + 1);
			} else {
				continue;
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			int val = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt = 1;

					fun(i, j, arr[i][j]);
					if (max < cnt) {
						val = arr[i][j];
						max = cnt;
					}
					if (max == cnt) {
						if (val > arr[i][j]) {
							val = arr[i][j];
						}
					}
				}
			}
			System.out.println("#" + testCase + " " + val + " " + max);
		} // end testCase
	} // end of main

} // end of class
