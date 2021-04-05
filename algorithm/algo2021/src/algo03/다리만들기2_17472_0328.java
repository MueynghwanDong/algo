package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �ٸ������2_17472_0328 {

	static class Node implements Comparable<Node> {
		int r, c, d;

		Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			return this.d - o.d;
		}

	}

	static int n, m, label = 0;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] arr;
	static boolean[][] brr;
	static int[] parent;
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Node> bridge = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		// �󺧸� �۾�
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && !brr[i][j]) {
					label++;
					brr[i][j] = true;
					arr[i][j] = label;
					q.add(new Node(i, j, 0));
					labeling();
				}
			}
		}
		// �ٸ� ���� �� �ִ� ��� ��� bridge�� ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] > 0) {
					q.add(new Node(i, j, 0));
					calc(arr[i][j]);
				}
			}
		}
		// kruskal �˰����� �̿��Ͽ� ��� ���� �����ϴ� �ּҰ��� ã�´�
		parent = new int[label + 1];
		for (int i = 0; i <= label; i++) {
			parent[i] = i;
		}
		kruskal();
	}

	public static void kruskal() {
		// �Ÿ��� ª�� �ͺ��� �����ϱ�
		Collections.sort(bridge);

		int cnt = 0, dis = 0;
		for (Node n : bridge) {
			// parent ���� �ٸ� ���
			if (find(n.r) != find(n.c)) {
				union(n.r, n.c);
				dis += n.d;
				cnt++;
			}
		}
		// cnt�� label-1���� �ƴϸ� ��� ���� ������ ��찡 �ƴ� ���
		if (cnt != label - 1)
			System.out.println(-1);
		else
			System.out.println(dis);
	}

	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	public static void union(int a, int b) {
		int rA = find(a);
		int rB = find(b);

		parent[rB] = rA;
	}

	public static void calc(int s) {
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = cur.r + dirs[i][0];
				int ny = cur.c + dirs[i][1];

				int distance = 0;
				boolean flag = false;
				while (true) {
					// ���� �󺧸��� ��� or ���� �ۿ� ���� ���
					if (nx >= n || nx < 0 || ny < 0 || ny >= m || arr[nx][ny] == s)
						break;
					// ���� s�� �ƴ� ��
					if (arr[nx][ny] != -1) {
						flag = true;
						break;
					}
					// ���� �ƴ� ��� 
					distance++;
					nx += dirs[i][0];
					ny += dirs[i][1];
				}
				if (flag) {
					if (distance < 2)
						continue;
					bridge.add(new Node(s, arr[nx][ny], distance));
				}
			}
		}
		q.clear();
	}

	public static void labeling() {
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = cur.r + dirs[i][0];
				int ny = cur.c + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny])
					continue;
				if (arr[nx][ny] == 0) {
					brr[nx][ny] = true;
					arr[nx][ny] = label;
					q.add(new Node(nx, ny, 0));
				}
			}
		}
		q.clear();
	}
}
