package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약_10026_0309 {

	static int n, cnt = 0;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!brr[i][j]) {
					brr[i][j] = true;
					dfs(i, j, arr[i][j]);
					cnt++;
				}
			}
		}
		System.out.print(cnt + " ");
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]=='R') {
					arr[i][j]='G';
				}
			}
		}
		
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!brr[i][j]) {
					brr[i][j] = true;
					dfs(i, j, arr[i][j]);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

	public static void dfs(int x, int y, char c) {
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || arr[nx][ny] != c)
				continue;
			brr[nx][ny] = true;
			dfs(nx, ny, c);
		}
	}

}
