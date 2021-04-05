package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �κ�û�ұ�_14503_0322 {

	static int n, m, cnt = 1;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // ��, ��, ��, ��

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
		}
		fun(r, c, d);
		System.out.println(cnt);
	}

	public static void fun(int x, int y, int d) {
		brr[x][y] = true; // û�� - �����ڸ�
		boolean check = false;
		if (d == 0) { // ���� ���� üũ
			if (y - 1 >= 0) {
				if (arr[x][y - 1] == 0 && !brr[x][y - 1]) {
					cnt++;
					check = true;
					fun(x, y - 1, 3);
				}
			}
		} else {
			int nx = x + dirs[d - 1][0];
			int ny = y + dirs[d - 1][1];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (!brr[nx][ny] && arr[nx][ny] == 0) {
					cnt++;
					check = true;
					fun(nx, ny, d - 1);
				}
			}
		}
		if (!check) { // ���� ���⿡ û���� ������ ���� ��� 4���� �˻�
			boolean cc = false;
			for (int i = 0; i < dirs.length; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == 1)
					continue;
				cc = true;
			}

			if (!cc) { // 4���� �˻� �� �̵� �Ұ� -> ���� or ����
				int nd = d + 2;
				if (nd >= 4)
					nd = nd - 4;
				int nx = x + dirs[nd][0];
				int ny = y + dirs[nd][1];
				if (arr[nx][ny] == 1) { // ������ �� ���� ���
					return;
				} else { // ���� , ���� ����
					fun(nx, ny, d);
				}
			} else { // ���� ȸ��
				if (d == 0) {
					fun(x, y, 3); 
				} else
					fun(x, y, d - 1);
			}
		}
	}

}
