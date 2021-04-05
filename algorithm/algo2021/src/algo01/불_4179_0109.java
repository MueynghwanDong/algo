package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ºÒ_4179_0109 {

	static int n, m;
	static int ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		int jx = 0, jy = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'J') {
					jx = i;
					jy = j;
				} else if (arr[i][j] == 'F') {
					queue.add(new int[] { i, j, -1 });
					brr[i][j] = true;
				}
			}
		}
		brr[jx][jy] = true;
		queue.add(new int[] { jx, jy, 1 });
		bfs();
		if (ans == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int cx = q[0];
			int cy = q[1];
			if (q[2] != -1) { // ÁöÈÆÀÌ
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
						ans = q[2];
						return;
					}
					if (arr[nx][ny] == '#' || brr[nx][ny])
						continue;
					if (arr[nx][ny] == '.') {
						brr[nx][ny] = true;
						queue.add(new int[] { nx, ny, q[2] + 1 });
					}

				}
			} else {
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == '#')
						continue;
					if (arr[nx][ny] == '.') {
						brr[nx][ny] = true;
						arr[nx][ny] = 'F';
						queue.add(new int[] { nx, ny, -1 });
					} else if (arr[nx][ny] == 'J') {
						ans = Integer.MAX_VALUE;
						return;
					}
				}
			}
		}
	}
}
