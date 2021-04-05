package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2_17472_0328 {

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

		// 라벨링 작업
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
		// 다리 놓을 수 있는 모든 경우 bridge에 넣음
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] > 0) {
					q.add(new Node(i, j, 0));
					calc(arr[i][j]);
				}
			}
		}
		// kruskal 알고리즘을 이용하여 모든 섬을 연결하는 최소값을 찾는다
		parent = new int[label + 1];
		for (int i = 0; i <= label; i++) {
			parent[i] = i;
		}
		kruskal();
	}

	public static void kruskal() {
		// 거리가 짧은 것부터 정렬하기
		Collections.sort(bridge);

		int cnt = 0, dis = 0;
		for (Node n : bridge) {
			// parent 값이 다른 경우
			if (find(n.r) != find(n.c)) {
				union(n.r, n.c);
				dis += n.d;
				cnt++;
			}
		}
		// cnt가 label-1값이 아니면 모든 섬을 지나는 경우가 아닌 경우
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
					// 같은 라벨링인 경우 or 범위 밖에 넘은 경우
					if (nx >= n || nx < 0 || ny < 0 || ny >= m || arr[nx][ny] == s)
						break;
					// 섬이 s가 아닌 섬
					if (arr[nx][ny] != -1) {
						flag = true;
						break;
					}
					// 섬이 아닌 경우 
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
