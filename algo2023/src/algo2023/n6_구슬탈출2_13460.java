package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n6_구슬탈출2_13460 {
	static int r, c, rx, ry, bx, by, ans = -1;
	static char[][] arr;
	static boolean[][][][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		brr = new boolean[r][c][r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'B') { // 파란구슬 위치
					bx = i;
					by = j;
				} else if (arr[i][j] == 'R') { // 빨간구슬 위치
					rx = i;
					ry = j;
				}
			}
		}

		bfs();
		System.out.println(ans);

	}

	public static void bfs() {

		brr[bx][by][rx][ry] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { bx, by, rx, ry, 0 });

		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cbx = t[0];
			int cby = t[1];
			int crx = t[2];
			int cry = t[3];
			int cnt = t[4];

			if (cnt > 10 || arr[cbx][cby] == 'O') { // 카운트가 10이상이거나 파란구슬이 구멍에 있을 경우
				continue;
			}
			if (arr[crx][cry] == 'O') { // 빨간 구슬이 위치에 있는 경우
				ans = cnt;
				return;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nbx = cbx;
				int nby = cby;
				while (true) {
					if (arr[nbx][nby] != '#' && arr[nbx][nby] != 'O') {
						// 장애물이건 벽이 아니고 구멍이 아닌 경우 한칸 진행
						nbx += dirs[i][0];
						nby += dirs[i][1];
					} else { // 벽이나 이동할 수 없는 장애물일 경우 한칸 뒤로
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
						// 장애물이건 벽이 아니고 구멍이 아닌 경우 한칸 진행
						nrx += dirs[i][0];
						nry += dirs[i][1];
					} else { // 벽이나 이동할 수 없는 장애물일 경우 한칸 뒤로
						if (arr[nrx][nry] == '#') {
							nrx -= dirs[i][0];
							nry -= dirs[i][1];
						}
						break;
					}
				}

				if (nbx == nrx && nby == nry && arr[nbx][nby] != 'O') {
					// 구멍이아니고 같은위치 인경우 거리비용이 더 큰 알파벳이 감소
					int rcost = Math.abs(nrx - crx) + Math.abs(nry - cry);
					int bcost = Math.abs(nbx - cbx) + Math.abs(nby - cby);
					if (rcost < bcost) {
						nbx -= dirs[i][0];
						nby -= dirs[i][1];
					} else {
						nrx -= dirs[i][0];
						nry -= dirs[i][1];
					}
				}

				if (!brr[nbx][nby][nrx][nry]) {
					brr[nbx][nby][nrx][nry] = true;
					q.add(new int[] { nbx, nby, nrx, nry, cnt + 1 });
				}
			}

		}
	}

}
