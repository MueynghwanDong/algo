package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 인구이동_16234_0311 {

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, l, r;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력
		int time = 0;
		while (true) {
			brr = new boolean[n][n];
			if (!check()) { // 이동 할수 있는 경우
				time++;
			} else {
				break;
			}
		}
		System.out.println(time);
	}

	public static boolean check() {
		boolean c = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!brr[i][j]) {
					List<Node> list = new ArrayList<>();
					list.add(new Node(i, j));
					int sum = dfs(i, j, list, arr[i][j]);
					if (list.size() > 1) {
						int avg = sum / list.size();
						for (Node node : list) {
							arr[node.x][node.y] = avg;
						}
						c = false;
					}
				}
			}
		}
		return c;
	}

	public static int dfs(int x, int y, List<Node> list, int sum) {
		brr[x][y] = true;
		sum = arr[x][y];
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny])
				continue;
			int d = Math.abs(arr[nx][ny] - arr[x][y]);
			if (l <= d && d <= r) {
				list.add(new Node(nx, ny));
				brr[nx][ny] = true;
				sum += dfs(nx, ny, list, sum);
			}
		}
		return sum;
	}

}
