package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n6_����Ż��2_13460 {
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
				if (arr[i][j] == 'B') { // �Ķ����� ��ġ
					bx = i;
					by = j;
				} else if (arr[i][j] == 'R') { // �������� ��ġ
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

			if (cnt > 10 || arr[cbx][cby] == 'O') { // ī��Ʈ�� 10�̻��̰ų� �Ķ������� ���ۿ� ���� ���
				continue;
			}
			if (arr[crx][cry] == 'O') { // ���� ������ ��ġ�� �ִ� ���
				ans = cnt;
				return;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nbx = cbx;
				int nby = cby;
				while (true) {
					if (arr[nbx][nby] != '#' && arr[nbx][nby] != 'O') {
						// ��ֹ��̰� ���� �ƴϰ� ������ �ƴ� ��� ��ĭ ����
						nbx += dirs[i][0];
						nby += dirs[i][1];
					} else { // ���̳� �̵��� �� ���� ��ֹ��� ��� ��ĭ �ڷ�
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
						// ��ֹ��̰� ���� �ƴϰ� ������ �ƴ� ��� ��ĭ ����
						nrx += dirs[i][0];
						nry += dirs[i][1];
					} else { // ���̳� �̵��� �� ���� ��ֹ��� ��� ��ĭ �ڷ�
						if (arr[nrx][nry] == '#') {
							nrx -= dirs[i][0];
							nry -= dirs[i][1];
						}
						break;
					}
				}

				if (nbx == nrx && nby == nry && arr[nbx][nby] != 'O') {
					// �����̾ƴϰ� ������ġ �ΰ�� �Ÿ������ �� ū ���ĺ��� ����
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
