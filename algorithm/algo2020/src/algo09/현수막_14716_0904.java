package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Çö¼ö¸·_14716_0904 {

	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!brr[i][j] && arr[i][j] == 1) {
					bfs(i,j);
//					dfs(i, j);
					count++;
				}

			}
		}
		System.out.println(count);
	}
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x,y});
		brr[x][y] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cx=  temp[0];
			int cy = temp[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 0)
					continue;
				if (!brr[nx][ny]) {
					brr[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}
	public static void dfs(int x, int y) {
		brr[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 0)
				continue;
			if (!brr[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

}
