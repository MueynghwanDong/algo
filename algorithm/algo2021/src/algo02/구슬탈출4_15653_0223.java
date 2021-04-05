package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ±∏ΩΩ≈ª√‚4_15653_0223 {

	static int n, m;
	static char[][] arr;
	static boolean[][][][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		brr = new boolean[n][m][n][m];
		int rx = 0, ry = 0, bx = 0, by = 0;
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
		brr[rx][ry][bx][by] = true;
		int result = bfs(rx, ry, bx, by);
		System.out.println(result);
	}

	public static int bfs(int rx, int ry, int bx, int by) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { rx, ry, bx, by, 0 });
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int crx = q[0];
			int cry = q[1];
			int cbx = q[2];
			int cby = q[3];
			int cnt = q[4];
			if (arr[cbx][cby] == 'O')
				continue;
			if (arr[crx][cry] == 'O')
				return cnt;

			for (int i = 0; i < dirs.length; i++) {

				int nrx = crx;
				int nry = cry;
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
				int nbx = cbx;
				int nby = cby;
				while (true) {
					if (arr[nbx][nby] != '#' && arr[nbx][nby] != 'O') {
						nbx += dirs[i][0];
						nby += dirs[i][1];
					} else {
						if (arr[nbx][nby] == '#') {
							nbx -= dirs[i][0];
							nby -= dirs[i][1];
						}
						break;
					}
				}

				if (nbx == nrx && nby == nry && arr[nrx][nry] != 'O') {
					int rcost = Math.abs(crx - nrx) + Math.abs(cry - nry);
					int bcost = Math.abs(cbx - nbx) + Math.abs(cby - nby);
					if (rcost > bcost) {
						nrx -= dirs[i][0];
						nry -= dirs[i][1];
					} else {
						nbx -= dirs[i][0];
						nby -= dirs[i][1];
					}
				}
				if (!brr[nrx][nry][nbx][nby]) {
					brr[nrx][nry][nbx][nby] = true;
					queue.add(new int[] { nrx, nry, nbx, nby, cnt + 1 });
				}
			}
		}
		return -1;
	}

}
