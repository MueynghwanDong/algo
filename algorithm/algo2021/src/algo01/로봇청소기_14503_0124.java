package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �κ�û�ұ�_14503_0124 {

	static int n, m;
	static int cnt;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0,-1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}// �Է�
		cnt = 1;
		dfs(r, c, d);
		System.out.println(cnt);

	}

	public static void dfs(int x, int y, int d) {
		brr[x][y] = true;
		boolean check = false; // a���� üũ�ϱ� ���� ����
		// a�� ����, ���ʿ� û���� ������ �ִ���..
		if (d == 0) { // ����
			if (y - 1 >= 0) {
				if (arr[x][y - 1] == 0 && !brr[x][y - 1]) {
					cnt++;
					check = true;
					dfs(x, y - 1, 3);
				}
			}
		} else { // �̿� ����
			int nx = x + dirs[d - 1][0];
			int ny = y + dirs[d - 1][1];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (arr[nx][ny] == 0 && !brr[nx][ny]) {
					cnt++;
					check = true;
					dfs(nx, ny, d - 1);
				}
			}
		}
		if (!check) {
			boolean c = false; // b���� ���� üũ ����
			for (int i = 0; i < dirs.length; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (arr[nx][ny] == 0 && !brr[nx][ny])
					c = true;
			}
			if (!c) {
				//���� ����
				int nd = d + 2;
				if (nd >= 4)
					nd = nd - 4;
				int nx = x + dirs[nd][0];
				int ny = y + dirs[nd][1];
				// ��� �������� �̵��Ҽ� ���ٸ� ����
				if (arr[nx][ny] == 1)
					return;
				// ���� �� 2�� ����..
				else
					dfs(nx, ny, d);
			} else {
				// b���� ������ ��� 
				if (d == 0)
					dfs(x, y, 3);
				else
					dfs(x, y, d - 1);
			}
		}

	}

}
