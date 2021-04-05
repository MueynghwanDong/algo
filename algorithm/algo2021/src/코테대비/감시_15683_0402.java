package ���״��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_15683_0402 {

	static class Node {
		int x, y, c;

		Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static int n, m, ans = Integer.MAX_VALUE, cnt;
	static int[][] arr;
	static Node[] narr = new Node[8];
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // �׻� ȸ���� 90�� ���� - ���� �� �б�
	static int[][] dirs = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } }; // ��ȣ�� ���� ����

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					narr[cnt++] = new Node(i, j, arr[i][j]);
				}
			}
		}
		fun(0, arr);
		System.out.println(ans);
	}

	public static void fun(int idx, int[][] arr) {
		if (cnt == idx) { // ��� cctv �۵��� ����
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 0)
						result++;
				}
			}
			if (result < ans)
				ans = result;
			return;
		}
		Node cur = narr[idx]; // ���� cctv �۵��� ��
		int[][] map = new int[n][m];
		for (int i = 0; i < dir.length; i++) {
			for (int j = 0; j < n; j++) {
				map[j] = arr[j].clone();
			}
			for (int j = 0; j < dirs[cur.c].length; j++) {
				int nx = cur.x;
				int ny = cur.y;
				int nd = (dirs[cur.c][j] - i + 3) % 4; // **
				while (true) {
					nx += dir[nd][0];
					ny += dir[nd][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 6) // �̺κ� ������ ���� 7�� ���� - �����ϴ� ���� ǥ��
						break;
					map[nx][ny] = 7;
				}
			}
			fun(idx + 1, map);
		}
	}

}
