package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class บา_4179_0319 {

	static int r, c, sx, sy, ans = 0;
	static char[][] arr;
	static boolean[][] brr;
	static Queue<int[]> q = new LinkedList<>();
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		brr = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'J') {
					sx = i;
					sy = j;
				} else if (arr[i][j] == 'F') {
					brr[i][j] = true;
					q.add(new int[] { i, j, -1 });
				}
			}
		}
		ans = Integer.MAX_VALUE;
		brr[sx][sy] = true;
		q.add(new int[] { sx, sy, 0 });
		bfs();
		if (ans == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			int cnt = t[2];
			if (cnt == -1) {
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny] || arr[nx][ny] == '#')
						continue;
					if (arr[nx][ny] == '.') {
						brr[nx][ny] = true;
						arr[nx][ny] = 'F';
						q.add(new int[] { nx, ny, -1 });
					} else if (arr[nx][ny] == 'J') {
						ans = Integer.MAX_VALUE;
						return;
					}
				}
			} else {
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
						ans = cnt+1;
						return;
					}
					if (brr[nx][ny] || arr[nx][ny] == '#')
						continue;
					if (arr[nx][ny] == '.') {
						arr[nx][ny] = 'J';
						arr[cx][cy] = '.';
						q.add(new int[] { nx, ny, cnt + 1 });
						brr[nx][ny] = true;
					}
				}
			}

		}
	}

}
