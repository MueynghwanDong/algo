package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n9_ġ��_2636 {

	static int n, m, cnt = 0;
	static int[][] arr, dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) { // ����  ġ���� ����
					cnt++;
				}
			}
		}

		int pre = 0, time = 0;
		while (true) {
			pre = cnt;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 9) { // ġ� ��� ������ ���, 0���� �����ϰ� cnt�� ���̱�
						arr[i][j] = 0;
						cnt--;
					}
				}
			}

			if (cnt == 0) { // ġ� 0�̵ɴ���� �ݺ�, 0�̵Ǹ� ����
				break;
			}
			brr = new boolean[n][m];
			bfs();
			time++;

		}
		System.out.println(time);
		System.out.println(pre);

	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		brr[0][0] = true;

		while (!q.isEmpty()) {
			int[] t = q.poll();

			int cx = t[0];
			int cy = t[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny])
					// ������ ����ų� �̹� �湮�� ���̶�� ����
					continue;
				if (arr[nx][ny] == 1) { // ġ���� ��� 9�� ġȯ
					arr[nx][ny] = 9;
				} else if (arr[nx][ny] == 0) {// ġ� �ƴ� ��� �湮 ǥ���ϰ� ť�� �־�α�
					brr[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

}
