package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ±∏ΩΩ≈ª√‚2_13460_0310 {

	static int n, m, rx, ry, bx, by;
	static char[][] arr;
	static boolean[][][][] brr;
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
		brr = new boolean[n][m][n][m];
		int result = bfs();
		System.out.println(result);

	}

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { rx, ry, bx, by, 0 });
		brr[rx][ry][bx][by] = true;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int crx = t[0];
			int cry = t[1];
			int cbx = t[2];
			int cby = t[3];
			int cnt = t[4];
			if (cnt > 10 || arr[cbx][cby] == 'O')
				continue;
			if (arr[crx][cry] == 'O') {
				return cnt;
			}
			for (int i = 0; i < dirs.length; i++) {
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

				if (nrx == nbx && nry == nby && arr[nbx][nby] != 'O') {
					int rcost = Math.abs(nrx - crx) + Math.abs(nry - cry);
					int bcost = Math.abs(nbx - cbx) + Math.abs(nby - cby);
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
					q.add(new int[] { nrx, nry, nbx, nby, cnt + 1 });
				}

			}
		}

		return -1;
	}

}
