package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ДЎБо_2638_0313_2 {

	static int n, m, cnt = 0;
	static int[][] arr;
	static int[][] brr;
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
				if (arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		int time = 0;
		while (true) {
			brr = new int[n][m];
			if (cnt == 0) {
				break;
			}
			bfs();
			time++;
		}
		System.out.println(time);
	}

	public static void bfs() {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		brr[0][0] = 1;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (arr[nx][ny] == 0 && brr[nx][ny] == 0) {
					brr[nx][ny] = 1;
					q.add(new int[] { nx, ny });

				}
				if (arr[nx][ny] == 1) {
					brr[nx][ny]++;
					if (brr[nx][ny] >= 2) {
						arr[nx][ny] = 0;
						cnt--;
					}
				}
			}
		}

	}
}
