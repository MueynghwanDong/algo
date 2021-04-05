package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class บา_4719_0204 {

	static int r, c, ans;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		brr = new boolean[r][c];
		int jx = 0, jy = 0;
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'J') {
					jx = i;
					jy = j;
				} else if (arr[i][j] == 'F') {
					brr[i][j] = true;
					queue.add(new int[] { i, j, -1 });
				}
			}
		}
		ans = Integer.MAX_VALUE;
		queue.add(new int[] { jx, jy, 1 });
		brr[jx][jy] = true;
		bfs();
		if (ans == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] tp = queue.poll();
			int cx = tp[0];
			int cy = tp[1];
			int cnt = tp[2];
			if (cnt == -1) {
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == '#' || brr[nx][ny])
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
			} else {
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
						ans = cnt;
						return;
					}
					if (arr[nx][ny] == '#' || brr[nx][ny])
						continue;
					if (arr[nx][ny] == '.') {
						brr[nx][ny] = true;
						queue.add(new int[] { nx, ny, cnt + 1 });
					}

				}
			}

		}
	}

}
