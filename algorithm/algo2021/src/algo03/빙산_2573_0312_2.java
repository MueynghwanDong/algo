package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ºù»ê_2573_0312_2 {

	static int n, m, ans = 0;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

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
		int count = 0, time = 0;
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
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cnt = 0;
				if (temp[i][j] != 0) {
					for (int k = 0; k < dirs.length; k++) {
						int nx = i + dirs[k][0];
						int ny = j + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m)
							continue;
						if (arr[nx][ny] == 0)
							cnt++;
					}
					temp[i][j] = temp[i][j] - cnt;
					if (temp[i][j] < 0)
						temp[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			arr[i] = temp[i].clone();
		}
	}

	public static int check() {
		int result = 0;
		brr = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0 && !brr[i][j]) {
					q.add(new int[] { i, j });
					brr[i][j] = true;
					while (!q.isEmpty()) {
						int t[] = q.poll();
						int cx = t[0];
						int cy = t[1];
						for (int k = 0; k < dirs.length; k++) {
							int nx = cx + dirs[k][0];
							int ny = cy + dirs[k][1];
							if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == 0)
								continue;
							brr[nx][ny] = true;
							q.add(new int[] { nx, ny });
						}
					}
					result++;
				}
			}
		}
		return result;
	}
}
