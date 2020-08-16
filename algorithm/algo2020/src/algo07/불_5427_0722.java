package algo07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ��_5427_0722 {

	static int m;
	static int n;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int sx, sy;
	static Queue<int[]> queue = new LinkedList<>();
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			arr = new char[n][m];
			brr = new boolean[n][m];
			result = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '@') {
						sx = i;
						sy = j;
					} else if (arr[i][j] == '*') {
						queue.offer(new int[] { i, j, -1 });
						brr[i][j] = true;
					}
				}
			}
			bfs(sx, sy);
			if (result == Integer.MAX_VALUE) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
			}
		}

	}

	public static void bfs(int x, int y) {

		brr[x][y] = true;
		queue.offer(new int[] { x, y, 1 });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int cnt = q[2];
			if (cnt != -1) { // �����..
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
						result = cnt;
						queue.clear();
						return;
					}
					if (brr[nx][ny] || arr[nx][ny] == '#')
						continue;

					if (!brr[nx][ny] && arr[nx][ny] == '.') {
						brr[nx][ny] = true;
						arr[cx][cy] = '.';
						arr[nx][ny] = '@';
						queue.offer(new int[] { nx, ny, cnt + 1 });
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
						arr[nx][ny] = '*';
						queue.offer(new int[] { nx, ny, -1 });
					} else if (arr[nx][ny] == '@') {
						return;
					}
				}
			}
		}

	}

}
