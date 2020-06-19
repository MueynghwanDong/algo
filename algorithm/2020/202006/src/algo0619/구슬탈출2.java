package algo0619;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2 {

	static int n;
	static int m;
	static char[][] crr;
	static boolean[][][][] visited;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		crr = new char[n][m];
		visited = new boolean[n][m][n][m]; // 2중 배열로하면 안됨!! 체크 못하는 부분 발생
		int rx = 0, ry = 0, bx = 0, by = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				crr[i][j] = str.charAt(j);
				if (crr[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (crr[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		} // 입력
		visited[rx][ry][bx][by] = true;
		int reuslt = bfs(rx, ry, bx, by);
		System.out.println(reuslt);

	}

	public static int bfs(int rx, int ry, int bx, int by) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { rx, ry, bx, by, 0 });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[4] > 10 || crr[q[2]][q[3]] == 'O') // 파란공이 구멍에 있거나 10번 넘은 경우 제외
				continue;
			if (crr[q[0]][q[1]] == 'O') // 삘간 공잉 구멍일 때 종료
				return q[4];

			for (int i = 0; i < dirs.length; i++) {

				// 파란공 이동
				int nbx = q[2];
				int nby = q[3];
				while (true) {
					if (crr[nbx][nby] != '#' && crr[nbx][nby] != 'O') {
						nbx += dirs[i][0];
						nby += dirs[i][1];
					} else {
						if (crr[nbx][nby] == '#') {
							nbx -= dirs[i][0];
							nby -= dirs[i][1];
						}
						break;
					}
				}

				// 빨간 공 이동
				int nrx = q[0];
				int nry = q[1];
				while (true) {
					if (crr[nrx][nry] != '#' && crr[nrx][nry] != 'O') {
						nrx += dirs[i][0];
						nry += dirs[i][1];
					} else {
						if (crr[nrx][nry] == '#') {
							nrx -= dirs[i][0];
							nry -= dirs[i][1];
						}
						break;
					}
				}
				// 같은 값을 경우 멀리있는 거를 하나 뒤로이동
				if (nbx == nrx && nby == nry && crr[nbx][nby] != 'O') {
					int rcost = Math.abs(q[0] - nrx) + Math.abs(q[1] - nry);
					int bcost = Math.abs(q[2] - nbx) + Math.abs(q[3] - nby);
					if (rcost > bcost) {
						nrx -= dirs[i][0];
						nry -= dirs[i][1];
					} else {
						nbx -= dirs[i][0];
						nby -= dirs[i][1];
					}
				}

				if (!visited[nrx][nry][nbx][nby]) {
					visited[nrx][nry][nbx][nby] = true;
					queue.offer(new int[] { nrx, nry, nbx, nby, q[4] + 1 });
				}

			}
		}
		return -1;
	}
}
