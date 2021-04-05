package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 인구이동_16234_1229 {

	static int n, l, r;
	static int[][] arr;
	static boolean[][] brr;
	static List<Node> list = new LinkedList<>();
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

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
		} // 입력
		int time = 0;
		while (true) {
			brr = new boolean[n][n];
			if (!check()) {
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
				if (!brr[i][j]) { // 방문하지 않은 경우
					list.clear();
					list = new LinkedList<>();
					list.add(new Node(i, j));
					int sum = dfs(i, j, 0);
					if (list.size() > 1) { // 리스트가 2개 이상이면 평균값으로
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

	public static int dfs(int x, int y,int sum) {
		brr[x][y] = true;
		sum = arr[x][y];
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny])
				continue;
			int d = Math.abs(arr[x][y] - arr[nx][ny]);
			if (d >= l && d <= r) { // l과r값 사이에 있으면 리스트에 추가하고
				list.add(new Node(nx, ny));
				sum += dfs(nx, ny, sum);
			}
		}
		return sum;
	}
}
