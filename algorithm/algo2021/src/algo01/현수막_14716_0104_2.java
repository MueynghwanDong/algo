package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Çö¼ö¸·_14716_0104_2 {

	static int n, m;
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
		count = bfs();
		System.out.println(count);
	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (brr[i][j] || arr[i][j] == 0)
					continue;
				brr[i][j] = true;
				queue.add(new int[] { i, j });
				while (!queue.isEmpty()) {
					int q[] = queue.poll();
					int cx = q[0];
					int cy = q[1];

					for (int k = 0; k < dirs.length; k++) {
						int nx = cx + dirs[k][0];
						int ny = cy + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 0 || brr[nx][ny])
							continue;
						brr[nx][ny] = true;
						queue.add(new int[] { nx, ny });

					}
				}
				cnt++;
			}
		}
		return cnt;
	}

}
