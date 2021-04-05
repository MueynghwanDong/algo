package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2_13460_1228 {

	static int n, m;
	static char[][] arr;
	static int rx, ry, bx, by;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'B') {
					bx = i;
					by = j;
				} else if (arr[i][j] == 'R') {
					rx = i;
					ry = j;
				}
			}
		}
		// 입력

		System.out.println(bfs());

	}

	public static int bfs() {
		boolean[][][][] brr = new boolean[n][m][n][m];
		Queue<int[]> queue = new LinkedList<>();
		brr[rx][ry][bx][by] = true;
		queue.add(new int[] { rx, ry, bx, by, 0 });
		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			// 10번을 넘어가거나 파란공이 구멍에 있다면 continue;
			if (q[4] > 10 || arr[q[2]][q[3]] == 'O')
				continue;
			if (arr[q[0]][q[1]] == 'O') // 빨간공이 구멍을 때 종료
				return q[4];

			for (int i = 0; i < dirs.length; i++) {
				int nbx = q[2];
				int nby = q[3];
				while (true) { // 장애물이나 구멍이 아닌 경우 이동
					if (arr[nbx][nby] != '#' && arr[nbx][nby] != 'O') {
						nbx += dirs[i][0];
						nby += dirs[i][1];
					} else { // 장애물인 경우 한칸 뒤로
						if (arr[nbx][nby] == '#') {
							nbx -= dirs[i][0];
							nby -= dirs[i][1];
						}
						break;
					}
				}
				int nrx = q[0];
				int nry = q[1];
				while (true) {
					if (arr[nrx][nry] != '#' && arr[nrx][nry] != 'O') {
						nrx += dirs[i][0];
						nry += dirs[i][1];
					} else {
						if (arr[nrx][nry] == '#') {
							nrx -= dirs[i][0];
							nry -= dirs[i][1];
						}
						break;
					}
				}
				// 두 위치가 같을 경우 cost에 따라 위치 조정
				// 더 cost가 큰 것을 한칸 뒤로 이동 시킨다
				
				if (nrx == nbx && nry == nby && arr[nbx][nby] != 'O') {
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
				if (!brr[nrx][nry][nbx][nby]) {
					queue.add(new int[] { nrx, nry, nbx, nby, q[4] + 1 });
					brr[nrx][nry][nbx][nby] = true;
				}
			}

		}
		return -1;

	}
}
