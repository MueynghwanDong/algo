package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �̳׶�_2933_1203 {

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int r, c;
	static char[][] crr;
	static boolean[][] brr;
	static ArrayList<Node> cluster;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		crr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				crr[i][j] = str.charAt(j);
			}
		}
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			int h = r - arr[i];
			if (i % 2 == 0) { // ���ʿ��� ����������
				for (int j = 0; j < c; j++) {
					if (crr[h][j] == 'x') {
						crr[h][j] = '.';
						break;
					}
				}
			} else { // �����ʿ��� �������� �̵�
				for (int j = c - 1; j >= 0; j--) {
					if (crr[h][j] == 'x') {
						crr[h][j] = '.';
						break;
					}
				}
			}
			find();
			// cluster ����� 0�� �ƴϸ� ����߷����� ���� �����Ѵٴ� �ǹ�
			if (cluster.size() != 0) {
				downcluster();
			}
			cluster.clear();
			
		}
		for (int j = 0; j < r; j++) {
			for (int k = 0; k < c; k++) {
				System.out.print(crr[j][k]);
			}
			System.out.println();
		}

	}

	public static void downcluster() {
		int cnt = 0;
		for (Node n : cluster) {
			crr[n.r][n.c] = '.'; // ���� ��ġ ��ĭ �����
		}
		outer: for (int i = 1; i < r; i++) {
			for (Node n : cluster) {
				if (n.r + i >= r || crr[n.r + i][n.c] == 'x') {
					break outer;
				}
			}
			// ���� ��ġ���� ��ĭ.�� �� ã�Ƽ� cnt���� ���̰� �־��ֱ�
			cnt = i;
		}
		for (Node n : cluster) {
			crr[n.r + cnt][n.c] = 'x'; // �������� �� ��ŭ ���ؼ� x �����
		}
	}

	public static void find() {
		cluster = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		brr = new boolean[r][c];
		
		// �ش��� x���� �̵��Ҽ� ������ cluster �������� �ʾƵ� �ȴٴ� �ǹ�
		for (int i = 0; i < c; i++) {
			if (crr[r - 1][i] == 'x') { // ���� �ش�
				q.offer(new Node(r - 1, i));
				brr[r - 1][i] = true;
			}
		}
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = cur.r + dirs[i][0];
				int ny = cur.c + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || crr[nx][ny] == '.' || brr[nx][ny])
					continue;
				brr[nx][ny] = true;
				q.offer(new Node(nx, ny));
			}
		}
		// brr�� true �� ���� ���߿� ������ ���� ��
		// x������ brr�� false�� ���� ���߿� ���ִ� ���̹Ƿ� �������� ���� �����ؾ���.
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!brr[i][j] && crr[i][j] == 'x') {
					cluster.add(new Node(i, j));
				}
			}
		}
	}

}
