package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ДЎБо_2638_1027 {

	static int r;
	static int c;
	static int cnt = 0;
	static int[][] arr;
	static int[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

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
				if (arr[i][j] == 1)
					cnt++;
			}
		}
		int time = 0;
		while (true) {
			brr = new int[r][c];
			if (cnt == 0)
				break;
			bfs();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			time++;
		}
		System.out.println(time);
	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];

			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;
				if (arr[nx][ny] == 0 && brr[nx][ny] == 0) {
					queue.add(new int[] { nx, ny });
					brr[nx][ny] = 1;
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
