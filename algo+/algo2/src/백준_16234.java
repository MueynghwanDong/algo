

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_16234 {

	static int n;
	static int L;
	static int R;
	static int map[][];
	static boolean visited[][];

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
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int sec = 0;
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visited = new boolean[n][n]; // 방문 초기화
			if (!check()) {
				sec++; // 인구이동이 또 필요한 경우
			} else {
				break;
			}
		}
		System.out.println(sec);

	}

	// 인구 이동 필요한지 전체 지도 확인.
	public static boolean check() {		
		boolean isDone = true; // 이동이 더이상 필요하지 않을 경우 true. 필요한 경우 false
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 방문하지 않은 경우
				if (!visited[i][j]) {
					List<Node> list = new LinkedList<>();
					list.add(new Node(i, j));
					
					// sum - 리스트에 저장된 값의 합.
					int sum = dfs(i, j, list, 0);
					if (list.size() > 1) { // 인구이동이 필요한 데이터가 있을경우
						change(sum, list); // 평균값 계산해서 갱신.
						isDone = false;
					}
				}
			}
		}
		return isDone;
	}

	// 평균값으로 map 갱신.
	public static void change(int sum, List<Node> list) {
		int avg = sum / list.size();
		for (Node node : list) {
			map[node.x][node.y] = avg;
		}
	}

	public static int dfs(int x, int y, List<Node> list, int sum) {
		visited[x][y] = true;
		sum = map[x][y];

		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			if(visited[nx][ny]) continue;
			if (!visited[nx][ny]) {
				int d = Math.abs(map[x][y] - map[nx][ny]);
				if (d >= L && d <= R) {
					list.add(new Node(nx, ny));
					sum += dfs(nx, ny, list, sum);
				}
			}
		}
		return sum;
	}

}
