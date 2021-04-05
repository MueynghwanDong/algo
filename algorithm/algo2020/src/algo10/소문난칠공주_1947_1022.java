package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 소문난칠공주_1947_1022 {

	static char[][] arr;
	static boolean[][] brr;
	static boolean[] visited;
	static int ans = 0;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];

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
		if (arr[n / 5][n % 5] == 'S')
			s = s + 1;

		brr[n / 5][n % 5] = true;
		visited[n] = true;

		if (depth == 7) {

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

		brr[n / 5][n % 5] = false;
		visited[n] = false;
	}

	public static void find(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { x, y });
		boolean[][] check = new boolean[5][5];
		check[x][y] = true;
		int num = 1;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cx = temp[0];
			int cy = temp[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if(nx < 0 || ny< 0 || nx>=5 || ny >=5) continue;
				
				if(brr[nx][ny] && !check[nx][ny]) {
					check[nx][ny] = true;
					queue.offer(new int[] {nx,ny});
					num++;
				}
			}			
		}
		if(num==7) ans++;
	}

}
