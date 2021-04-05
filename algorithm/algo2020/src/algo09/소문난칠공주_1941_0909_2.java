package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 소문난칠공주_1941_0909_2 {

	static char[][] arr = new char[5][5];
	static boolean[][] brr;
	static boolean[] visited;
	static int cnt, ans = 0;
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
			visited = new boolean[25];
			dfs(i, 1, 0);
		}
		System.out.println(ans);
	}

	public static void dfs(int n, int depth, int s) {
		if (arr[n / 5][n % 5] == 'S') // 다솜파 인 경우
			s = s + 1;
		visited[n] = true;
		brr[n / 5][n % 5] = true;

		if (7 == depth) {
			if (s >= 4) {
				find(n / 5, n % 5);
			}
		} else {
			for (int i = n + 1; i < 25; i++) {
				if (!visited[i]) {
					dfs(i, depth + 1, s);
				}
			}
		}

		// backtracking
		visited[n] = false;
		brr[n / 5][n % 5] = false;
	}

	public static void find(int x, int y) {
		boolean[][] check = new boolean[5][5];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check[x][y] = true;
		int num = 1;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = temp[0] + dirs[i][0];
				int ny = temp[1] + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
					continue;
				if (brr[nx][ny] && !check[nx][ny]) {
					q.add(new int[] { nx, ny });
					check[nx][ny] = true;
					num++;
				}
			}
		}
		if(num==7) ans++;
	}

}
