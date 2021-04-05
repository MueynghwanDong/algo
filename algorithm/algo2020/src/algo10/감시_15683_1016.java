package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 감시_15683_1016 {

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

	static int r;
	static int c;
	static int min = Integer.MAX_VALUE;
	static int[][] arr;

	static Node[] nodes = new Node[8]; // 최대 8개를 넘지 않음
	static int cnt = 0;
	static int[][] dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } }; // c값에 따른 dirs의 방향, 이부분 핵심!!
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					nodes[cnt++] = new Node(i, j, arr[i][j]); // 노드나 리스트에 넣어서 차례대로 진행하기
				}
			}
		}
		solve(0, arr);
		System.out.println(min);

	}

	public static void solve(int idx, int[][] arr) {

		if (idx == cnt) { // 종료 조건..., 노드에 들어간 것을 다 진행하고 난후 
			// 0인것 숫자 카운트하기
			int result = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] == 0)
						result++;
				}
			}
			if (min > result)
				min = result;
			return;
		}

		Node node = nodes[idx]; // idx번 노드, idx값 증가하면서 node 값에 따라 진행!
		for (int i = 0; i < dirs.length; i++) { // 4방향에 따라 진행
			int map[][] = copy(arr); // 배열 복사
			for (int j = 0; j < dir[node.c].length; j++) { // 노드의 번호에 따라 진행
				int nx = node.x;
				int ny = node.y;
				int nd = (dir[node.c][j] - i + 3) % 4; // 이부분이 핵심!!!
				while (true) {
					nx += dirs[nd][0];
					ny += dirs[nd][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == 6)
						break; // 벽이나 범위를 벗어나면 break
					map[nx][ny] = 9; // #대신 9로..
				}
			}
			solve(idx + 1, map);
		}

	}

	public static int[][] copy(int arr[][]) { // 배열 복사
		int map[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = arr[i][j];
			}
		}
		return map;
	}

}
