package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 감시_15683_0216 {

	static int[][] dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } };
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int n, m, cnt = 0;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static Node[] nodes;

	static class Node {
		int x, y, c;

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
		nodes = new Node[8]; // 최대 8을 넘지 않음
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

		Node node = nodes[idx];
		for (int i = 0; i < dirs.length; i++) {
			int[][] temp = copy(arr);
			for (int j = 0; j < dir[node.c].length; j++) {
				int nx = node.x;
				int ny = node.y;
				int nd = (dir[node.c][j] - i + 3) % 4;
				while (true) {
					nx += dirs[nd][0];
					ny += dirs[nd][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 6)
						break;
					temp[nx][ny] = 9;
				}
			}
			fun(idx + 1, temp);
		}
	}

	public static int[][] copy(int[][] arr) {
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = arr[i][j];
			}
		}
		return result;
	}
}
