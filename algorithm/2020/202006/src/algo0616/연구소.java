package algo0616;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ������ {

	static int n;
	static int m;
	static int max;
	static int[][] arr;
	static int[][] temp;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		} // �Է�
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (arr[j][k] == 0) { //
					for (int i = 0; i < n; i++) {
						temp[i] = arr[i].clone(); // �� �迭�� ���ΰ� ���ο� �迭���
					}
					temp[j][k] = 1;
					wall(1);
					temp[j][k] = 0;
				}
			}
		}
		System.out.println(max);
	} // end of main

	public static void wall(int cnt) { // ������� cnt�� 3�϶� ��������

		if (cnt == 3) {
			// ���̷��� �����ϱ�
			int count = translation();
			if (max < count)
				max = count;
			return;
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == 0) {
						temp[i][j] = 1;
						wall(cnt + 1);
						temp[i][j] = 0;
					}
				}
			} // �� �߰��ϱ�
		}
	}

	public static int translation() {

		int re[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			re[i] = temp[i].clone();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (re[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}
			}
		}

		int[] virus;
		while (!queue.isEmpty()) {
			virus = queue.poll();
			for (int i = 0; i < dirs.length; i++) {
				int newx = virus[0] + dirs[i][0];
				int newy = virus[1] + dirs[i][1];
				if (newx < 0 || newy < 0 || newx >= n || newy >= m)
					continue;
				if (re[newx][newy] == 0) {
					re[newx][newy] = 2; // ���̷��� ����
					queue.offer(new int[] { newx, newy });
				}
			}
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (re[i][j] == 0)
					count++;
			}
		}
		return count;
	}
}
