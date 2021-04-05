package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ≈ª√‚_3055_0311 {

	static int n, m, x, y, ans = -1;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[][] arr;
	static boolean[][] brr;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
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
				if (arr[i][j] == 'S') {
					x = i;
					y = j;
				} else if (arr[i][j] == '*') {
					q.add(new int[] { i, j, -1 });
				}
			}
		}
		q.add(new int[] { x, y, 0 });
		brr[x][y] = true;
		bfs();
		if (ans == -1) {
			System.out.println("KAKTUS");
		} else
			System.out.println(ans);
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			int time = t[2];
			if (arr[cx][cy] == 'D') {
				ans = time;
				return;
			}
			if (time == -1) {
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 'X' || arr[nx][ny] == 'D')
						continue;
					if (arr[nx][ny] == '.') {
						arr[nx][ny] = '*';
						q.add(new int[] { nx, ny, -1 });
					}
				}
			} else {
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 'X' || arr[nx][ny] == '*'
							|| brr[nx][ny])
						continue;
					brr[nx][ny] = true;
					q.add(new int[] { nx, ny, time + 1 });

				}
			}
		}
	}

}
