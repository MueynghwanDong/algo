package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class »ó¹üºôµù_6593_0130 {

	static class Node {
		int x;
		int y;
		int height;
		int cnt;

		Node(int x, int y, int height, int cnt) {
			this.x = x;
			this.y = y;
			this.height = height;
			this.cnt = cnt;
		}
	}

	static int h, r, c;
	static char[][][] arr;
	static boolean[][][] brr;
	static Queue<Node> queue;
	static int[][] dirs = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new char[r][c][h];
			brr = new boolean[r][c][h];
			if (r == 0 && c == 0 && h == 0)
				break;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < r; j++) {
					String str = br.readLine();
					for (int k = 0; k < c; k++) {
						arr[j][k][i] = str.charAt(k);
						if (arr[j][k][i] == 'S') {
							brr[j][k][i] = true;
							queue.add(new Node(j, k, i, 0));
						} else if (arr[j][k][i] == '#') {
							brr[j][k][i] = true;
						}

					}
				}
				br.readLine();
			}
			int result = bfs();
			if (result == 0) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + result + " minute(s).");

			}
		}
	}

	public static int bfs() {
		int cnt = 0;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			int cx = temp.x;
			int cy = temp.y;
			int ch = temp.height;
			int count = temp.cnt;
			if (arr[cx][cy][ch] == 'E') {
				cnt = count;
				return cnt;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				int nh = ch + dirs[i][2];
				if (nx < 0 || ny < 0 || nh < 0 || nx >= r || ny >= c || nh >= h || brr[nx][ny][nh])
					continue;
				brr[nx][ny][nh] = true;
				queue.add(new Node(nx, ny, nh, count + 1));
			}
		}
		return cnt;
	}
}
