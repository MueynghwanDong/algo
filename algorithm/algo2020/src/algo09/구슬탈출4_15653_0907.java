package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출4_15653_0907 {

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
		// 이부분이 핵심!!
		brr = new boolean[n][m][n][m]; // 2중배열로 하면 인식안됨, 4중 배열로 boolean 체크해줘야함.
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
		}
		brr[rx][ry][bx][by] = true;
		int result = bfs(rx, ry, bx, by);
		System.out.println(result);

	}

	public static int bfs(int rx, int ry, int bx, int by) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { rx, ry, bx, by, 0 });
		
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int crx = q[0];
			int cry = q[1];
			int cbx = q[2];
			int cby = q[3];
			int cnt = q[4];
			if (crr[cbx][cby] == 'O') // 파란 게 구멍으로 들어간 경우
				continue;
			if (crr[crx][cry] == 'O') // 종료 조건
				return cnt;
			for (int i = 0; i < dirs.length; i++) {
				int nbx = cbx;
				int nby = cby;
				
				// 파란거 이동
				while(true) {
					if(crr[nbx][nby] != '#' && crr[nbx][nby] !='O') { // 구멍이나 벽이 아닐 때 계속 이동
						nbx += dirs[i][0];
						nby += dirs[i][1];
					}else {
						if(crr[nbx][nby]=='#') {
							nbx -= dirs[i][0];
							nby -= dirs[i][1];
						}break;
					}
				}
				
				// 빨간거 이동
				int nrx = crx;
				int nry = cry;
				while(true) {
					if(crr[nrx][nry] != '#' && crr[nrx][nry] !='O') {
						nrx += dirs[i][0];
						nry += dirs[i][1];
					}else {
						if(crr[nrx][nry]=='#') {
							nrx -= dirs[i][0];
							nry -= dirs[i][1];
						}break;
					}
				}
				// 빨간공과 파란공이 같은 위치 일 경우
				if(nbx == nrx && nby == nry && crr[nbx][nby] !='O') {  
					int rcost = Math.abs(crx - nrx) + Math.abs(cry-nry);
					int bcost = Math.abs(cbx - nbx) + Math.abs(cby-nby);
					// 첫 거리부터 현재 위치 거리가 먼거를 하나 뻬줌...
					if(rcost > bcost) {
						nrx -= dirs[i][0];
						nry -= dirs[i][1];
					}else {
						nbx -= dirs[i][0];
						nby -= dirs[i][1];
					}
				}
				
				if(!brr[nrx][nry][nbx][nby]) { // 방문한 자리가 아닌 경우 큐에 넣어줌.
					brr[nrx][nry][nbx][nby] = true;
					queue.add(new int [] {nrx,nry, nbx, nby, cnt+1});
				}
			}
		}
		return -1;
	}
}
