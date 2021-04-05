package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573_0105 {

	static int n, m;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int ans = 0;

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
			}
		}
		int time = 0;
		int count = 0;
		while (true) {
			count = check();
			if (count >= 2) {
				System.out.println(time);
				break;
			} else if (count == 0) {
				System.out.println(0);
				break;
			} else {
				down();
				time++;
			}
		}
	}

	public static void down() {
		// 원래 배열에 하지말고 temp 배열 만들어 연산 수행후 다시 arr 배열 변환
		// 안그러면 다른 결과값이 나옴*****
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cnt = 0;
				for (int k = 0; k < dirs.length; k++) {
					int nx = i + dirs[k][0];
					int ny = j + dirs[k][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m)
						continue;
					if (arr[nx][ny] == 0) {
						cnt++;
					}
				}
				temp[i][j] = temp[i][j] - cnt;
				if (temp[i][j] < 0)
					temp[i][j] = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}

	public static int check() {
//		 Queue<int[]> queue = new LinkedList<>();
		int cnt = 0;
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0 && !brr[i][j]) {
//					queue.add(new int[] { i, j });
//					brr[i][j] = true;
//					while (!queue.isEmpty()) {
//						int q[] = queue.poll();
//						for (int k = 0; k < dirs.length; k++) {
//							int nx = q[0] + dirs[k][0];
//							int ny = q[1] + dirs[k][1];
//							if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == 0)
//								continue;
//							if (!brr[nx][ny] && arr[nx][ny] != 0) {
//								queue.add(new int[] { nx, ny });
//								brr[nx][ny] = true;
//							}
//						}
//					}
					dfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void dfs(int x, int y) {
		brr[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == 0)
				continue;
			if (!brr[nx][ny] && arr[nx][ny] != 0) {
				dfs(nx, ny);
			}

		}
	}

}
