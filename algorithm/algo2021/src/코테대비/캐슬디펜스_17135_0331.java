package ���״��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ĳ�����潺_17135_0331 {

	static class Node implements Comparable<Node> {
		int x, y, d;

		Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			if (this.d == o.d) {
				return this.y - o.y;
			} else {
				return this.d - o.d;
			}
		}
	}

	static int n, m, d, result = 0, ans = 0, enermy = 0;
	static int[][] arr;
	static int[] trr;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					enermy++; // ������ ����
				}
			}
		}
		for (int i = 0; i < m; i++) {
			arr[n][i] = 2; // ��
		}
		trr = new int[3];
		comb(m, 3, enermy);
		System.out.println(result);

	}

	public static void comb(int num, int gs, int e) {
		if (gs == 0) {
			ans = 0;
			// �������ִ� ���� - arr�� �ϸ� ������
			// trr�� ���Կ� ���� �ٸ��� �������־�� �ϴϱ�..
			map = new int[n + 1][m];
			for (int i = 0; i < arr.length; i++) {
				map[i] = arr[i].clone();
			}
			for (int i = 0; i < trr.length; i++) {
				arr[n][trr[i]] = 3; // ���õ� �ü��� �ִ� ��
			}
			enermy = e;
			// ������ �������� �� ��� ����...
			while (enermy > 0) {
				attack();
				downe();
			}
			if (result < ans) {
				result = ans;
				return;
			}

		} else if (num < gs) {
			return;
		} else {
			trr[gs - 1] = num - 1;
			comb(num - 1, gs - 1, e);
			comb(num - 1, gs, e);
		}
	}

	public static void downe() {
		// ������ ��ĭ �������� ���
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					if (i + 1 == n) { // ����ġ�� ������ ��� ���ܽ�Ŵ
						enermy--;
						map[i][j] = 0;
					} else { // ��ĭ �������� ���� ����
						map[i + 1][j] = 1;
						map[i][j] = 0;
					}
				}

			}
		}
	}

	public static void attack() {
		// ������ ��带 ���� ����
		Node[] nodes = new Node[3];
		int idx = 0;
		for (int i = 0; i < trr.length; i++) {
			int num = trr[i];
			// �� �ü��� �� �� �ִ� ���� ���� ����Ʈ
			List<Node> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k] == 1) {
						int dist = Math.abs(n - j) + Math.abs(num - k);
						if (dist <= d) {
							list.add(new Node(j, k, dist));
						}
					}
				}
			}
			// ���� ���� ������ ������ ��� ���� �켱 ���� ���� �� ���迭�� �־��ֱ�
			if (list.size() > 0) {
				Collections.sort(list);
				Node n = list.get(0);
				nodes[idx++] = n;
			}
		}
		// ���迭 �� ������ ��ġ 0���� ����� ���� �� ���̱�
		for (int i = 0; i < idx; i++) {
			Node n = nodes[i];
			if (map[n.x][n.y] == 1) { // ��ĥ �� �ִ� ��Ȳ�� ���� �� ����
				ans++;
				enermy--;
				map[n.x][n.y] = 0;
			}
		}
	}

}
