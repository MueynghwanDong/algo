package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2023.01.01
 * ���� ���� 3��
 * 0 ��ĭ 1 �� 2 ���̷��� 
 */
public class n1_������_14502 {

	static int n, m, ans = 0;
	static int[][] arr, dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

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
			}
		}
		// �Է�
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(1);// �� �����
					arr[i][j] = 0;
				}
			}
		}
		System.out.println(ans);

	}

	public static int calc() {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		} // ���ο� �迭�� ���� �迭 ����

		Queue<int[]> q = new LinkedList<>(); // ���̷��� ��ġ�� ���� ť
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] t = q.poll(); // ť���� �ϳ� ������
			int cx = t[0];
			int cy = t[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || temp[nx][ny] != 0)
					continue;
				// 0�̾ƴ� ��� �ǳʶٱ�(���̰ų� ���̷����ΰ��) - ���� ���̷����� �̹� ť�� ����!
				temp[nx][ny] = 2;
				q.add(new int[] { nx, ny });
			}
		}
		// �������� ���ϱ�
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					result++;
				}
			}
		}

		return result;
	}

	public static void wall(int w) {

		if (w == 3) { // ���� �� �ִ� ���� ���� �Ϸ�
			int result = calc(); // �������� �� ���ϱ�
			if (ans < result)
				ans = result;
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(w + 1); 
					arr[i][j] = 0;
				}
			}
		}
	}

}
