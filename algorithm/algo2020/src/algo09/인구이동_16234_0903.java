package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 인구이동_16234_0903 {

	static int n;
	static int r;
	static int c;
	static int arr[][];
	static boolean brr[][];
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
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
				// for (int i = 0; i < n; i++) {
				// for (int j = 0; j < n; j++) {
				// System.out.print(arr[i][j]+ " ");
				// }
				// System.out.println();
				// }
				// System.out.println();
			} else {
				break;
			}
		}
		System.out.println(time);
	}

	public static boolean check() {
		boolean isDone = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {				
				if (!brr[i][j]) { // 방문하지 않은 경우, 한번 실행하면 거치는 곳은 방문 표시됨
					List<Node> list = new LinkedList<>();
					list.add(new Node(i, j));
					int sum = dfs(i, j, list, 0);
					if (list.size() > 1) {
						// 평균 값 계산해서 값 변경
						int avg = sum / list.size();
						for (Node node : list) {
							arr[node.x][node.y] = avg;
						}
						isDone = false;
					}
				}
			}
		}
		return isDone;
	}

	public static int dfs(int x, int y, List<Node> list, int sum) {

		brr[x][y] = true;
		sum = arr[x][y];
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny])
				continue;
			int d = Math.abs(arr[x][y] - arr[nx][ny]);
			if (r <= d && d <= c) { // 조건에 맞는 것을 list에 추가
				list.add(new Node(nx, ny));
				sum += dfs(nx, ny, list, sum);
			}

		}
		return sum;
	}
}
