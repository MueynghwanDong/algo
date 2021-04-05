package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¹Ì³×¶ö_2933_1029 {

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int r;
	static int c;
	static char[][] crr;
	static ArrayList<Node> cluster;
	static boolean[][] brr;
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
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		for (int i = 0; i < n; i++) {

			int h = r - arr[i];
			if (i % 2 == 0) {// ¿Þ-> ¿À
				for (int j = 0; j < c; j++) {
					if (crr[h][j] == 'x') { // ¹Ì³×¶ö ¸¸³²
						crr[h][j] = '.'; // ºóÄ­À¸·Î..
						break;
					}
				}
			} else {// ¿À->¿Þ
				for (int j = c - 1; j >= 0; j--) {
					if (crr[h][j] == 'x') {
						crr[h][j] = '.';
						break;
					}
				}
			}
			findCluster();

			if (cluster.size() != 0)
				downMineral();
			cluster.clear();
		}
		for (int k = 0; k < r; k++) {
			for (int j = 0; j < c; j++) {
				System.out.print(crr[k][j]);
			}
			System.out.println();
		}
		// 1 2 3 4 5 1 2 3 4 5
	}

	public static void findCluster() {
		cluster = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		brr = new boolean[r][c];

		for (int i = 0; i < c; i++) {
			if (crr[r - 1][i] == 'x') {
				queue.offer(new Node(r - 1, i));
				brr[r - 1][i] = true;
			}
		}

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = cur.r + dirs[i][0];
				int ny = cur.c + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || crr[nx][ny] == '.' || brr[nx][ny])
					continue;

				brr[nx][ny] = true;
				queue.offer(new Node(nx, ny));
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!brr[i][j] && crr[i][j] == 'x') {
					cluster.add(new Node(i, j));
				}
			}
		}

	}

	public static void downMineral() {
		int cnt = 0;
		for (Node n : cluster) {
			crr[n.r][n.c] = '.';
		}

		outer: for (int i = 1; i < r; i++) {
			for (Node n : cluster) {
				if (n.r + i >= r || crr[n.r + i][n.c] == 'x') {
					break outer;
				}
			}
			cnt = i;
		}
		for (Node n : cluster) {
			crr[n.r + cnt][n.c] = 'x';
		}
	}

}
