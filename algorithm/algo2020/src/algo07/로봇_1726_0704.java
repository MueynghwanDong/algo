package algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇_1726_0704 {

	static int dirs[][] = { {}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int arr[][];
	static boolean brr[][][];
	static int n;
	static int m;
	static int ex;
	static int ey;
	static int ed;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		brr = new boolean[n][m][5]; // 방향까지
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		ed = Integer.parseInt(st.nextToken());
		bfs(sx - 1, sy - 1, sd);

	}

	public static void bfs(int x, int y, int d) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y, d, 0 });
		brr[x][y][d] = true;

		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int cd = q[2];

			if (cx == ex - 1 && cy == ey - 1 && cd == ed) {
				System.out.println(q[3]);
				return;
			}
			for (int i = 1; i <= 3; i++) { // 거리에 따라 ...
				int nx = cx + (dirs[cd][0] * i);
				int ny = cy + (dirs[cd][1] * i);
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (arr[nx][ny] == 0 && !brr[nx][ny][cd]) {
					brr[nx][ny][cd] = true;
					queue.offer(new int[] { nx, ny, cd, q[3] + 1 });
				}
				if (arr[nx][ny] != 0)
					break;
			}
			// 현재 방향 에서 이동

			// 회전 ->< 이부분이 헷갈렸음..
			for (int i = 1; i < dirs.length; i++) {
				if (cd != i && !brr[cx][cy][i]) {
					brr[cx][cy][i] = true;
					if ((cd == 1 && i == 2) || (cd == 2 && i == 1) || (cd == 3 & i == 4) || (cd == 4 && i == 3)) {
						queue.offer(new int[] { cx, cy, i, q[3] + 2 });
					} else {
						queue.offer(new int[] { cx, cy, i, q[3] + 1 });
					}
				}
			}

		}
	}
}
