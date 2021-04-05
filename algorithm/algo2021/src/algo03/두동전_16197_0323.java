package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �ε���_16197_0323 {

	static int n, m;
	static Queue<int[]> q = new LinkedList<>();
	static char[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'o') {
					q.add(new int[] { i, j, 0 });
				}
			}
		}
		bfs();
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int[] t1 = q.poll();
			int[] t2 = q.poll();
			int cnt = t1[2];
			if (cnt >= 10) { // Ƚ�� 10 �� �̻��� ���
				System.out.println(-1);
				return;
			}
			for (int i = 0; i < dirs.length; i++) {
				boolean b1 = false;
				boolean b2 = false;
				int r1 = t1[0] + dirs[i][0];
				int c1 = t1[1] + dirs[i][1];
				int r2 = t2[0] + dirs[i][0];
				int c2 = t2[1] + dirs[i][1];
				if (r1 < 0 || c1 < 0 || r1 >= n || c1 >= m)
					b1 = true;
				if (r2 < 0 || c2 < 0 || r2 >= n || c2 >= m)
					b2 = true;
				if (b1 && b2) // �Ѵ� ���� ���� ���
					continue;
				if (b1 || b2) { // �ϳ��� ������ ���� ���
					System.out.println(cnt + 1);
					return;
				}
				if (arr[r1][c1] == '#' && arr[r2][c2] == '#') { // ���� ���������
					continue;
				}
				if (arr[r1][c1] == '#') { // ���� �ڸ��� �̵�
					r1 = t1[0];
					c1 = t1[1];
				}
				if (arr[r2][c2] == '#') { // ���� �ڸ��� �̵�, �̵����� ����
					r2 = t2[0];
					c2 = t2[1];
				}
				q.add(new int[] { r1, c1, cnt + 1 });
				q.add(new int[] { r2, c2, cnt + 1 });
			}
		}
		System.out.println(-1);
	}

}
