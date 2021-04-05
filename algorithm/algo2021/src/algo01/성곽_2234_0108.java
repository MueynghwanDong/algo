package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����_2234_0108 {

	static int n, m;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] map;
	static int cnt, result, max = 0;
	static ArrayList<Integer> wd = new ArrayList<>();
	static int dirs[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		map = new int[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // �Է�
		cnt = 0;
		// cnt = ���� ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!brr[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
		result = 0;
		brr = new boolean[n][m];
		// ���� ���� ��ŭ �ݺ�!!
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k] == i && !brr[j][k]) {
						bfs2(j, k, i);
					}
				}
			}
		}
		System.out.println(result);
	}

	public static void bfs2(int x, int y, int val) {
		Queue<int[]> queue = new LinkedList<>();
		brr[x][y] = true;
		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int cx = q[0];
			int cy = q[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny])
					continue;
				// ** ���� ���� map ���� �ٸ� �� �ι��� ũ�⸦ ���� ���� �ִ밪�� ���ϱ�
				if (map[nx][ny] != val) {
					int value = wd.get(map[nx][ny]) + wd.get(val);
					if (result < value)
						result = value;
					continue;
				}
				brr[nx][ny] = true;
				queue.add(new int[] { nx, ny });
			}
		}

	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		brr[x][y] = true;
		queue.add(new int[] { x, y, arr[x][y] });
		int size = 0; // ���� ũ�⸦ ������� ����
		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int val = q[2];
			size++;
			map[cx][cy] = cnt; // map �迭�� cnt ���� �־� ���� ���̶�� ���� ��Ÿ��
			int d[] = { val & 1, val & 2, val & 4, val & 8 };
			// ��Ʈ����ŷ &������ ���������� �ش� ���� ��� ���� �� 1 �ƴϸ� 0�� ��ȯ - **
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || d[i] != 0)
					continue;
				brr[nx][ny] = true;
				queue.add(new int[] { nx, ny, arr[nx][ny] });
			}
		}
		wd.add(size); // list �迭�� �־��־� ���߿� 3�� ������ Ȱ��
		if (size > max)
			max = size;
	}

}
