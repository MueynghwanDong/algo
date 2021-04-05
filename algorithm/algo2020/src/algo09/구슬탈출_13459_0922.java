package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ±∏ΩΩ≈ª√‚_13459_0922 {

	static int n;
	static int m;
	static char[][] crr;
	static boolean[][][][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		crr = new char[n][m];
		brr = new boolean[n][m][n][m];

		int rx = 0, ry = 0, bx = 0, by = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				crr[i][j] = str.charAt(j);
				if (crr[i][j] == 'B') {
					bx = i;
					by = j;
				} else if (crr[i][j] == 'R') {
					rx = i;
					ry = j;
				}
			}
		}
		brr[rx][ry][bx][by] = true;
		int result = bfs(rx, ry, bx, by);
		if (result == -1)
			System.out.println(0);
		else
			System.out.println(1);
	}

	public static int bfs(int rx, int ry, int bx, int by) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { rx, ry, bx, by, 0 });

		while (!q.isEmpty()) {
			int temp[] = q.poll();
			int crx = temp[0];
			int cry = temp[1];
			int cbx = temp[2];
			int cby = temp[3];
			int cnt = temp[4];
			
//			System.out.println(crx +" " + cry +" " + cbx +" " + cby +" " + cnt);
			if (crr[cbx][cby] == 'O')
				continue;
			if (crr[crx][cry] == 'O' && cnt <= 10)
				return cnt;


			for (int i = 0; i < dirs.length; i++) {
				
				int nbx = cbx;
				int nby = cby;
				
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

				int nrx = crx;
				int nry = cry;
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

				if (nrx == nbx && nry == nby && crr[nbx][nby] != 'O') {
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
					q.offer(new int[] { nrx, nry, nbx, nby, cnt + 1 });
				}
			}
		}
		return -1;
	}
}
