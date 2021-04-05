package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2_13460_1016 {

	static int n;
	static int m;
	static char[][] arr;
	static boolean[][][][] brr;
	static int rx, ry, bx, by;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		brr = new boolean[n][m][n][m]; 
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j);
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
		System.out.println(fun());;
	}

	public static int fun() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { rx, ry, bx, by, 0 });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[4] > 10 || arr[q[2]][q[3]] == 'O') // 10번 넘어가거나 파란공이 있는 경우 XXX
				continue;
			if (arr[q[0]][q[1]] == 'O') // 빨간공이 O에 있으면 종료
				return q[4];
			for (int i = 0; i < dirs.length; i++) {
				
				// 파란공 움직이기
				int nbx = q[2];
				int nby = q[3];
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
				// 빨간공 움직이기
				int nrx = q[0];
				int nry = q[1];
				while (true) {
					if (arr[nrx][nry] != '#' && arr[nrx][nry] != 'O') { // 빈칸인 경우 
						nrx += dirs[i][0];
						nry += dirs[i][1];
					} else {
						if (arr[nrx][nry] == '#') { // 벽이면 한칸 이전으로
							nrx -= dirs[i][0];
							nry -= dirs[i][1];
						}
						break;
					}
				}
				
				if (nrx == nbx && nry == nby && arr[nbx][nby] != 'O') { //빨간공과 파란공이 같은 위치 일경우
					// cost가 큰 것을 한칸 뒤로 이동
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
				
				if (!brr[nrx][nry][nbx][nby]) { // 큐에 집어넣기
					queue.offer(new int[] { nrx, nry, nbx, nby, q[4] + 1 });
					brr[nrx][nry][nbx][nby] = true;
				}
			}

		}
		return -1;
	}

}
