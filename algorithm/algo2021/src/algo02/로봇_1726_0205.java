package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇_1726_0205 {

	static int dirs[][] = { {}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int n, m, ex, ey, ed, sx, sy, sd;
	static int[][] arr;
	static boolean[][][] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m][5];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		ed = Integer.parseInt(st.nextToken());
		bfs(sx - 1, sy - 1, sd);
	}

	public static void bfs(int x, int y, int d) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, d, 0 });
		brr[x][y][d] = true;
		while (!queue.isEmpty()) {
			int[] tp = queue.poll();
			int cx = tp[0];
			int cy = tp[1];
			int cd = tp[2];
			int cnt = tp[3];
			if (cx == ex - 1 && cy == ey - 1 && ed == cd) {
				System.out.println(cnt);
				return;
			}
			// 거리만
			for (int i = 1; i <= 3; i++) {
				int nx = cx + (dirs[cd][0] * i);
				int ny = cy + (dirs[cd][1] * i);
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny][cd])
					continue;
				if (arr[nx][ny] == 0 && !brr[nx][ny][cd]) {
					brr[nx][ny][cd] = true;
					queue.add(new int[] { nx, ny, cd, cnt + 1 });
				}
				if (arr[nx][ny] != 0)
					break;
			}
			// 방향만
			for (int i = 1; i < dirs.length; i++) {
				if (cd != i && !brr[cx][cy][i]) {
					brr[cx][cy][i] = true;
					if ((cd == 1 && i == 2) || (cd == 2 && i == 1) || (cd == 3 && i == 4) || (cd == 4 && i == 3))
						queue.add(new int[] { cx, cy, i, cnt + 2 });
					else
						queue.add(new int[] { cx, cy, i, cnt + 1 });
				}
			}
		}
	}
}