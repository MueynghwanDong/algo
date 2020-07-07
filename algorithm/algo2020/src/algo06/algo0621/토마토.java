package algo06.algo0621;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ≈‰∏∂≈‰ {

	static int n;
	static int m;
	static int h;
	static int[][][] arr;
	static int[][] dirs = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[n][m][h];
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1)
						queue.offer(new int[] { i, j, k, 0 });
				}
			}
		}
		int result = bfs();
		System.out.println(result);

	} // end of main

	public static int bfs() {
		int day = -1;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			day = q[3];
			for (int i = 0; i < dirs.length; i++) {
				int nx = q[0] + dirs[i][0];
				int ny = q[1] + dirs[i][1];
				int nh = q[2] + dirs[i][2];
				if (nx < 0 || ny < 0 || nh < 0 || nx >= n || ny >= m || nh >= h)
					continue;
				if (arr[nx][ny][nh] == 0) {
					arr[nx][ny][nh] = 1;
					queue.offer(new int[] { nx, ny, nh, q[3] + 1 });
				}
			}
		}
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j][k] == 0) {
						return -1;
					}
				}
			}
		}
		return day;
	}

}
