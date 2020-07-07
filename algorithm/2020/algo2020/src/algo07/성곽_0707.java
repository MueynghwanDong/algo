package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼º°û_0707 {

	static int m;
	static int n;
	static int[][] arr;
	static boolean[][] brr;
	static int max;
	static int dirs[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		max = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // ÀÔ·Â
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!brr[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		brr[x][y] = true;
		queue.offer(new int[] { x, y, arr[x][y] });
		int size = 0;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int val = q[2];
			size++;
			int[] d = { val & 1, val & 2, val & 4, val & 8 };
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || d[i] != 0)
					continue;

				brr[nx][ny] = true;
				queue.offer(new int[] { nx, ny, arr[nx][ny] });
			}

		}
		if(size>max) max = size;

	}

}
