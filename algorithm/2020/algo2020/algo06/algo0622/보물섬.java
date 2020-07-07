package algo0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class º¸¹°¼¶ {

	static int n;
	static int m;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		} // ÀÔ·Â
		answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		System.out.println(answer);

	}

	public static void bfs(int x, int y) {
		brr = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		brr[x][y] = true;
		queue.offer(new int[] { x, y, 0 });
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[2] > answer)
				answer = q[2];

			for (int i = 0; i < dirs.length; i++) {
				int nx = q[0] + dirs[i][0];
				int ny = q[1] + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 'W' || brr[nx][ny])
					continue;
				if (!brr[nx][ny] && arr[nx][ny] == 'L') {
					brr[nx][ny] = true;
					queue.offer(new int[] { nx, ny, q[2] + 1 });
				}
			}
		}
	}
}
