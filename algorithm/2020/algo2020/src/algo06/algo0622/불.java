package algo06.algo0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {

	static int n;
	static int m;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int result;
	static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		brr = new boolean[n][m];
		int jx = 0;
		int jy = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'J') {
					jx = i;
					jy = j;

				} else if (arr[i][j] == 'F') {
					queue.offer(new int[] { i, j, -1 });
					brr[i][j] = true;
				}
			}
		} // 입력
		brr[jx][jy] = true;
		queue.offer(new int[] { jx, jy, 1 });
		result = Integer.MAX_VALUE;
		bfs();
		if (result == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
		}
	}

	public static void bfs() {

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[2] != -1) { // 지훈이의 경우
				for (int i = 0; i < dirs.length; i++) {
					int nx = q[0] + dirs[i][0];
					int ny = q[1] + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
						result = (q[2]);
						queue.clear();
						return;
					}
					if (arr[nx][ny] == '#' || brr[nx][ny])
						continue;
					if (arr[nx][ny] == '.') {
						brr[nx][ny] = true;
						queue.offer(new int[] { nx, ny, q[2] + 1 });
					}
				}
			} else {
				for (int i = 0; i < dirs.length; i++) {
					int nx = q[0] + dirs[i][0];
					int ny = q[1] + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == '#' || brr[nx][ny])
						continue;
					if (arr[nx][ny] == '.') {
						brr[nx][ny] = true;
						arr[nx][ny] = 'F';
						queue.offer(new int[] { nx, ny, -1 });
					} else if (arr[nx][ny] == 'J') {
						result = Integer.MAX_VALUE;
						return;
					}
				}
			}
		}
	}
}
