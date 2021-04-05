package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¿¬±¸¼Ò_14502_0310 {

	static int n, m, ans = 0;
	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

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

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(1);
					arr[i][j] = 0;
				}
			}
		}
		System.out.println(ans);
	}

	public static int transaction() {
		Queue<int[]> q = new LinkedList<>();
		int[][] trr = new int[n][m];
		for (int i = 0; i < n; i++) {
			trr[i] = arr[i].clone();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || trr[nx][ny] != 0)
					continue;
				if (trr[nx][ny] == 0) {
					trr[nx][ny] = 2;
					q.add(new int[] { nx, ny });
				}
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (trr[i][j] == 0)
					result++;
			}
		}

		return result;
	}

	public static void wall(int cnt) {
		if (cnt == 3) {
			int result = transaction();
			if (ans < result)
				ans = result;
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(cnt + 1);
					arr[i][j] = 0;
				}
			}
		}

	}

}
