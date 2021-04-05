package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 감시_15683_0128 {

	static int n, m;
	static int[][] arr;
	static int[][] dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } };
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int cnt = 0;
	static int min = Integer.MAX_VALUE;
	static Node[] nodes = new Node[8];

	static class Node {
		int x;
		int y;
		int c;

		Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

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
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					nodes[cnt++] = new Node(i, j, arr[i][j]);
				}
			}
		}
		fun(0, arr);
		System.out.println(min);

	}

	public static void fun(int idx, int[][] arr) {
		if (idx == cnt) {
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 0)
						result++;
				}
			}
			if (result < min)
				min = result;
			return;
		}
		// 방향 잘 맞춰야함!!!
		Node node = nodes[idx];
		for (int i = 0; i < dirs.length; i++) {
			int[][] map = copy(arr);
			int cd = node.c;
			for (int j = 0; j < dir[cd].length; j++) {
				int nx = node.x;
				int ny = node.y;
				int nd = (dir[cd][j] - i + 3) % 4;
				while (true) {
					nx += dirs[nd][0];
					ny += dirs[nd][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 6)
						break;
					map[nx][ny] = 9;
				}
			}
			fun(idx + 1, map);
		}

	}

	public static int[][] copy(int[][] arr) {
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = arr[i][j];
			}
		}
		return map;
	}

}
