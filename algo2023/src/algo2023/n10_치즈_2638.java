package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n10_ДЎБо_2638 {

	static int n, m, cnt = 0;
	static int[][] arr, brr, dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

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
		int time = 0;
		while (true) {
			brr = new int[n][m];
			if (cnt == 0) {
				break;
			}
			dfs(0, 0);
			time++;
		}
		System.out.println(time);

	}

	public static void dfs(int x, int y) {
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (arr[nx][ny] == 0 && brr[nx][ny] == 0) {
				brr[nx][ny] = 1;
				dfs(nx, ny);
			} else if (arr[nx][ny] == 1) {
				brr[nx][ny]++;
				if (brr[nx][ny] >= 2) {
					arr[nx][ny] = 0;
					cnt--;
				}
			}
		}
	}

}
