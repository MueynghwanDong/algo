package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 소문난칠공주_1941_0216 {

	static char[][] arr = new char[5][5];
	static int ans = 0;
	static boolean[][] brr;
	static boolean[] v;
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
			v = new boolean[25];
			brr = new boolean[5][5];
			dfs(i, 1, 0);
		}
		System.out.println(ans);
	}

	public static void dfs(int n, int dep, int s) {
		if (arr[n / 5][n % 5] == 'S')
			s = s + 1;
		v[n] = true;
		brr[n / 5][n % 5] = true;
		
		if (dep == 7) {
			if (s >= 4)
				find(n / 5, n % 5);
		} else {
			for (int i = n + 1; i < 25; i++) {
				if (!v[i]) {
					dfs(i, dep + 1, s);
				}
			}
		}
		
		brr[n / 5][n % 5] = false;
		v[n] = false;
	}

	public static void find(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visit = new boolean[5][5];
		visit[x][y] = true;
		queue.add(new int[] { x, y });
		int num = 1;

		while (!queue.isEmpty()) {
			int[] tp = queue.poll();
			int cx = tp[0];
			int cy = tp[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visit[nx][ny] || !brr[nx][ny])
					continue;
				visit[nx][ny] = true;
				queue.add(new int[] { nx, ny });
				num++;
			}
		}
		if (num == 7)
			ans++;
	}

}
