package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 소문난칠공주_1941_0118 {

	static char[][] arr = new char[5][5];
	static boolean[][] brr;
	static boolean[] v;
	static int ans = 0;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < 25; i++) {
			brr = new boolean[5][5];
			v = new boolean[25];
			dfs(i, 1, 0); // n, depth, s
		}
		System.out.println(ans);
	}

	public static void dfs(int n, int depth, int s) {
		if (arr[n / 5][n % 5] == 'S') 
			s = s + 1;
		v[n] = true;
		brr[n / 5][n % 5] = true;
		if (depth == 7) {
			if (s >= 4) {
				find(n / 5, n % 5);
			}
		} else {
			for (int i = n + 1; i < 25; i++) {
				if (!v[i])
					dfs(i, depth + 1, s);
			}
		}
		v[n] = false;
		brr[n / 5][n % 5] = false;
	}

	public static void find(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] c = new boolean[5][5];
		c[x][y] = true;
		int num = 1;
		q.add(new int[] { x, y });
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int cx = temp[0];
			int cy = temp[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || c[nx][ny] || !brr[nx][ny])
					continue;
				if (brr[nx][ny] && !c[nx][ny]) {
					q.add(new int[] { nx, ny });
					c[nx][ny] = true;
					num++;
				}
			}
		}
		if (num == 7)
			ans++;
	}
}
