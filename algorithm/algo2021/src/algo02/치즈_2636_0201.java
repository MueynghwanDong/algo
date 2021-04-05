package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ġ��_2636_0201 {

	static int n, m;
	static int[][] arr;
	static boolean[][] brr;
	static int cnt = 0;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					cnt++;
			}
		}
		int pre = 0;
		int time = 0;
		while (true) {
			brr = new boolean[n][m];
			if (cnt == 0)
				break;
			pre = cnt;
			dfs(0, 0);
			fun();
			time++;
		}
		System.out.println(time);
		System.out.println(pre);
	}

	public static void fun() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 9) {
					arr[i][j] = 0;
					cnt--;
				}
			}
		}
	}

	public static void dfs(int x, int y) {
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (arr[nx][ny] == 1)
				arr[nx][ny] = 9;
			if (arr[nx][ny] == 0 && !brr[nx][ny]) {
				brr[nx][ny] = true;
				dfs(nx, ny);
			}
		}

	}
}
