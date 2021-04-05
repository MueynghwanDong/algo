package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇_1726_0320 {

	static int n, m, sx, sy, sd, ex, ey, ed, ans = 0;
	static int dirs[][] = { {}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
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
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		sd = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;
		ed = Integer.parseInt(st.nextToken());

		bfs();
		System.out.println(ans);
	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		// 초기 설정
		queue.add(new int[] { sx, sy, sd, 0 });
		brr[sx][sy][sd] = true;

		while (!queue.isEmpty()) {
			int[] t = queue.poll();
			int cx = t[0];
			int cy = t[1];
			int cd = t[2];
			int cnt = t[3];
			if (cx == ex && cy == ey && cd == ed) { // 종료조건
				ans = cnt;
				return;
			}
			for (int i = 1; i <= 3; i++) { // 명령 1
				int nx = cx + (dirs[cd][0] * i);
				int ny = cy + (dirs[cd][1] * i);
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny][cd])
					continue;
				if (arr[nx][ny] == 0) {
					brr[nx][ny][cd] = true;
					queue.add(new int[] { nx, ny, cd, cnt + 1 });
				}
				if (arr[nx][ny] != 0) // 1을만나면 방향 전환으로
					break;
			}

			// 명령2
			for (int i = 1; i < dirs.length; i++) {
				if (cd != i && !brr[cx][cy][i]) {
					brr[cx][cy][i] = true;
					if ((cd == 1 && i == 2) || (cd == 2 && i == 1) || (cd == 3 && i == 4) || (cd == 4 && i == 3)) { // 180도회전
						queue.add(new int[] { cx, cy, i, cnt + 2 });
					} else {
						queue.add(new int[] { cx, cy, i, cnt + 1 });
					}
				}
			}
		}
	}

}
