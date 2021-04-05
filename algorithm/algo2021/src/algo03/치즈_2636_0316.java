package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ДЎБо_2636_0316 {

	static int r, c, cnt = 0;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

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
				if (arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		int pre = 0;
		int time = 0;
		while (true) {
			if (cnt == 0) {
				break;
			}
			pre = cnt;
			bfs();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] == 9) {
						arr[i][j] = 0;
						cnt--;
					}
				}
			}
			time++;
		}
		System.out.println(time);
		System.out.println(pre);
	}

	public static void bfs() {
		brr = new boolean[r][c];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		brr[0][0] = true;

		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny])
					continue;
				if (arr[nx][ny] == 1) {
					arr[nx][ny] = 9;
				} else if (arr[nx][ny] == 0) {
					q.add(new int[] { nx, ny });
					brr[nx][ny] = true;
				}
			}
		}
	}

}
