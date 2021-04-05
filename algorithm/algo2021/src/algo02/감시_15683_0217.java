package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 감시_15683_0217 {

	static class Node {
		int x, y, c;

		Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static int min = Integer.MAX_VALUE;
	static int n, m, cnt = 0;
	static int[][] arr;
	static int[][] dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } };
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Node[] nodes = new Node[8];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5)
					nodes[cnt++] = new Node(i, j, arr[i][j]);
			}
		}
		// 입력 - 1~5 사이의 값 nodes 배열에 넣어주기 --> cctv 작동할 것들
		fun(0, arr);
		System.out.println(min);
	}

	public static void fun(int idx, int[][] arr) {

		if (cnt == idx) { // 모든 cctv 작동을 마칠 때
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 0)
						result++;
				}
			}
			if (min > result)
				min = result;
			return;
		} else {
			Node node = nodes[idx];
			for (int i = 0; i < dirs.length; i++) { // 네방향
				int[][] temp = copy(arr);
				for (int j = 0; j < dir[node.c].length; j++) { // node.c -> 번호에 따라 탐색할 경로 다름, dir[node.c]만큼 반복
					int nx = node.x;
					int ny = node.y;
					int nd = (dir[node.c][j] - i + 3) % 4;
					while (true) { // 벽이나 범위를 벗어나면 종료, 나머지는 9로채 움
						nx += dirs[nd][0];
						ny += dirs[nd][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 6)
							break;
						temp[nx][ny] = 9;
					}
				}
				fun(idx + 1, temp); // 다음 idx로 넘어감..
			}
		}
	}

	public static int[][] copy(int[][] arr) {
		int[][] tp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tp[i][j] = arr[i][j];
			}
		}
		return tp;
	}
}
