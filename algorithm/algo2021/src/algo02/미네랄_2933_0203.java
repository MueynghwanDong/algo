package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¹Ì³×¶ö_2933_0203 {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int r, c, n;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] arr;
	static int[] h;
	static boolean[][] brr;
	static ArrayList<Node> cluster;

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
		n = Integer.parseInt(br.readLine());
		h = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int height = r - h[i];
			if (i % 2 == 0) {
				for (int j = 0; j < c; j++) {
					if (arr[height][j] == 'x') {
						arr[height][j] = '.';
						break;
					}
				}
			} else {
				for (int j = c - 1; j >= 0; j--) {
					if (arr[height][j] == 'x') {
						arr[height][j] = '.';
						break;
					}
				}
			}

			find();
			if (cluster.size() != 0) {
				downcl();
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
		Queue<Node> queue = new LinkedList<>();
		brr = new boolean[r][c];
		for (int i = 0; i < c; i++) {
			if (arr[r - 1][i] == 'x') {
				queue.add(new Node(r - 1, i));
				brr[r - 1][i] = true;
			}
		}

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = cur.x + dirs[i][0];
				int ny = cur.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny] || arr[nx][ny] == '.')
					continue;

				if (arr[nx][ny] == 'x') {
					brr[nx][ny] = true;
					queue.add(new Node(nx, ny));
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 'x' && !brr[i][j])
					cluster.add(new Node(i, j));
			}
		}
	}

	public static void downcl() {
		int cnt = 0;
		for (Node list : cluster) {
			arr[list.x][list.y] = '.';
		}

		outer: for (int i = 1; i < r; i++) {
			for (Node cur : cluster) {
				if (cur.x + i >= r || arr[cur.x + i][cur.y] == 'x') {
					break outer;
				}
			}
			cnt = i;
		}
		for (Node list : cluster) {
			arr[list.x + cnt][list.y] = 'x';
		}
	}

}
