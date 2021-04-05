package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �̳׶�_2933_0106 {

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int r, c;
	static char[][] arr;
	static ArrayList<Node> cluster;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		int n = Integer.parseInt(br.readLine());
		int[] height = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int h = r - height[i];
			if (i % 2 == 0) {// ��->��
				for (int j = 0; j < c; j++) {
					if (arr[h][j] == 'x') { // ó�� x ���� �� ��ĭ���� ����� break
						arr[h][j] = '.';
						break;
					}
				}
			} else { // ��-> ��
				for (int j = c - 1; j >= 0; j--) {
					if (arr[h][j] == 'x') {
						arr[h][j] = '.';
						break;
					}
				}
			}

			find(); // cluster ã���� ����
			if (cluster.size() != 0) {
				dcluster();
			}
			cluster.clear();
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void find() {
		cluster = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		boolean[][] brr = new boolean[r][c];

		// ���� �شܿ� �ִ� �� ���� ť�� �ֱ�
		for (int i = 0; i < c; i++) {
			if (arr[r - 1][i] == 'x') {
				q.offer(new Node(r - 1, i));
				brr[r - 1][i] = true;
			}
		}

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = node.r + dirs[i][0];
				int ny = node.c + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == '.' || brr[nx][ny])
					continue;
				// �����ϴ� x ���� ���� ť�� �ְ� boolean �迭 true
				q.offer(new Node(nx, ny));
				brr[nx][ny] = true;
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				// x������ �湮���� ���� ���� cluster ����Ʈ�� �־��ֱ�
				if (arr[i][j] == 'x' && !brr[i][j]) {
					cluster.add(new Node(i, j));
				}
			}
		}
	}

	public static void dcluster() {
		int cnt = 0;
		for (Node list : cluster) {
			// cluster�� �ִ� ��ġ ��ĭ���� �����
			arr[list.r][list.c] = '.';
		}
		outer: for (int i = 1; i < r; i++) {
			for (Node n : cluster) {
				if (n.r + i >= r || arr[n.r + i][n.c] == 'x') {
					// �迭 ������ �Ѿ�ų� x�� ������ break�ϱ�
					// ����i���� ���� x+i��ġ�� �̵��� ���̵�...
					break outer;
				}
			}
			cnt = i;
		}
		for (Node n : cluster) {
			arr[n.r + cnt][n.c] = 'x';
		}
	}
}
