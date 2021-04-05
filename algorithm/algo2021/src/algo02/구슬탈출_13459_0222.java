package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출_13459_0222 {

	static int n, m;
	static char[][] arr;
	static boolean[][][][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int bx = 0, by = 0, rx = 0, ry = 0;
		arr = new char[n][m];
		brr = new boolean[n][m][n][m]; // 사중배열!!
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
		int result = bfs(bx, by, rx, ry);
		if (result == -1)
			System.out.println(0);
		else
			System.out.println(1);
	}

	public static int bfs(int bx, int by, int rx, int ry) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { rx, ry, bx, by, 0 });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int rcx = temp[0];
			int rcy = temp[1];
			int bcx = temp[2];
			int bcy = temp[3];
			int cnt = temp[4];
			if (cnt > 10 || arr[bcx][bcy] == 'O') // 파란구슬이 구멍에 들어간 경우, cnt 횟수가 10을 넘어간 경우 X
				continue;
			if (arr[rcx][rcy] == 'O' && cnt <= 10) // 종료 조건
				return cnt;
			for (int i = 0; i < dirs.length; i++) {

				// 파란 구 슬 이동
				int nbx = bcx;
				int nby = bcy;
				while (true) {
					// System.out.println(nbx+" " + nby);
					if (arr[nbx][nby] != '#' && arr[nbx][nby] != 'O') { // 구멍이 아니거나 벽이 아닌 경우 이동
						nbx += dirs[i][0];
						nby += dirs[i][1];
					} else {
						if (arr[nbx][nby] == '#') { // 벽인경우 한칸 뒤로
							nbx -= dirs[i][0];
							nby -= dirs[i][1];
						}
						break;
					}
				}
				// 빨간 구슬 이동
				int nrx = rcx;
				int nry = rcy;
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
				// 두 위치가 같을 때, 단 구멍이 아닌 경우
				// 먼쪽에 있는 게 한 칸 뒤로 이동
				if (nrx == nbx && nry == nby && arr[nrx][nry] != 'O') {
					int rcost = Math.abs(rcx - nrx) + Math.abs(rcy - nry);
					int bcost = Math.abs(bcx - nbx) + Math.abs(bcy - nby);
					if (rcost > bcost) {
						nrx -= dirs[i][0];
						nry -= dirs[i][1];
					} else {
						nbx -= dirs[i][0];
						nby -= dirs[i][1];
					}
				}
				// System.out.println(nrx + " " + nry + " " + nbx + " " + nby);
				if (!brr[nrx][nry][nbx][nby]) {
					brr[nrx][nry][nbx][nby] = true;
					queue.add(new int[] { nrx, nry, nbx, nby, cnt + 1 });
				}
			}
		}
		return -1;
	}

}
