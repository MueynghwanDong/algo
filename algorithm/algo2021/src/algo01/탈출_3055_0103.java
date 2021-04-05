package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_3055_0103 {

	static int r;
	static int c;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<int[]> queue = new LinkedList<>();
	static int cnt = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		brr = new boolean[r][c];
		int x = 0;
		int y = 0;
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'S') {
					x = i;
					y = j;
					brr[i][j] = true;
				} else if (arr[i][j] == '*') {
					queue.offer(new int[] { i, j, -1 });
				}
			}
		}
		queue.offer(new int[] { x, y, 0 });
		bfs();
		if (cnt == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(cnt);
		}
	}

	public static void bfs() {

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int time = q[2];
			if (arr[cx][cy] == 'D') {
				cnt = time;
				return;
			}
			if (time == -1) { // 물인 경우
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == 'D' || arr[nx][ny] == 'X')
						continue;
					if (arr[nx][ny] == '.') {
						arr[nx][ny] = '*';
						queue.offer(new int[] { nx, ny, -1 });
					}
				}
			} else {
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == '*' || arr[nx][ny] == 'X'
							|| brr[nx][ny])
						continue;
					queue.offer(new int[] { nx, ny, time + 1 });
					brr[nx][ny] = true;
				}
			}
		}
	}
}
