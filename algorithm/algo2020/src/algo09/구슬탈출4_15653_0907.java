package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����Ż��4_15653_0907 {

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
		// �̺κ��� �ٽ�!!
		brr = new boolean[n][m][n][m]; // 2�߹迭�� �ϸ� �νľȵ�, 4�� �迭�� boolean üũ�������.
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
			if (crr[cbx][cby] == 'O') // �Ķ� �� �������� �� ���
				continue;
			if (crr[crx][cry] == 'O') // ���� ����
				return cnt;
			for (int i = 0; i < dirs.length; i++) {
				int nbx = cbx;
				int nby = cby;
				
				// �Ķ��� �̵�
				while(true) {
					if(crr[nbx][nby] != '#' && crr[nbx][nby] !='O') { // �����̳� ���� �ƴ� �� ��� �̵�
						nbx += dirs[i][0];
						nby += dirs[i][1];
					}else {
						if(crr[nbx][nby]=='#') {
							nbx -= dirs[i][0];
							nby -= dirs[i][1];
						}break;
					}
				}
				
				// ������ �̵�
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
				// �������� �Ķ����� ���� ��ġ �� ���
				if(nbx == nrx && nby == nry && crr[nbx][nby] !='O') {  
					int rcost = Math.abs(crx - nrx) + Math.abs(cry-nry);
					int bcost = Math.abs(cbx - nbx) + Math.abs(cby-nby);
					// ù �Ÿ����� ���� ��ġ �Ÿ��� �հŸ� �ϳ� ����...
					if(rcost > bcost) {
						nrx -= dirs[i][0];
						nry -= dirs[i][1];
					}else {
						nbx -= dirs[i][0];
						nby -= dirs[i][1];
					}
				}
				
				if(!brr[nrx][nry][nbx][nby]) { // �湮�� �ڸ��� �ƴ� ��� ť�� �־���.
					brr[nrx][nry][nbx][nby] = true;
					queue.add(new int [] {nrx,nry, nbx, nby, cnt+1});
				}
			}
		}
		return -1;
	}
}
