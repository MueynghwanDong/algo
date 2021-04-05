package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기_2146_0316 {

	static int n, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] temp;
	static boolean[][] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		temp = new int[n][n];
		brr = new boolean[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		// 구역 나누기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0 && !brr[i][j]) {
					dfs(i, j, cnt);
					cnt++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0 && check(i, j)) {
					bfs(i, j);
					// -1값을 원래대로 돌려놓기위함
					for (int k = 0; k < n; k++) {
						arr[k] = temp[k].clone();
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y, 0 });

		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			int cnt = t[2];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == arr[x][y] || arr[nx][ny] == -1)
					continue;
				if (arr[nx][ny] != 0) {
					if (ans > cnt)
						ans = cnt;
					return;
				}
				arr[nx][ny] = -1;
				q.add(new int[] { nx, ny, cnt + 1 });
			}

		}
	}

	public static boolean check(int x, int y) {
		// 바로 옆인 경우 다리를 놓을 수 없는 경우.. 상하좌우에 0이 있는지 확인하는 메서드
		boolean c = false;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (arr[nx][ny] == 0) {
				return true;
			}
		}
		return c;
	}

	public static void dfs(int x, int y, int cnt) {
		brr[x][y] = true;
		arr[x][y] = cnt;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || arr[nx][ny] == 0)
				continue;
			arr[nx][ny] = cnt;
			dfs(nx, ny, cnt);
		}
	}

}
