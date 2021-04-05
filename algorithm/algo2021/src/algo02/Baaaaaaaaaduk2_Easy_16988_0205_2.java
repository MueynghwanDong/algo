package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baaaaaaaaaduk2_Easy_16988_0205_2 {

	static int n, m, cnt, tcnt;
	static int ans = 0;
	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] brr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 2 && !brr[i][j]) {
					cnt = 0;
					tcnt = 1;
					brr[i][j] = true;
					bfs(i, j, 0);
					System.out.println(cnt + " " + tcnt);
					if (cnt <= 2) {
						if (ans < tcnt)
							ans = tcnt;
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static void bfs(int x, int y, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, c });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int check = q[2];
			if (arr[cx][cy] == 2) {		
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == 1)
						continue;
					if (arr[nx][ny] == 2) {
						queue.add(new int[] { nx, ny, check });
						brr[nx][ny] = true;
						tcnt++;
					}
					if (arr[nx][ny] == 0) {
//						System.out.println(nx+" " + ny);
						cnt++;
						queue.add(new int[] { nx, ny, check+1 });
						brr[nx][ny] = true;
					}
				}
			} else if (arr[cx][cy] == 0) {
//				System.out.println(cx+" " + cy);
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == 1)
						continue;
					if (arr[nx][ny] == 2) {
						queue.add(new int[] { nx, ny, check });
						brr[nx][ny] = true;
						tcnt++;
					}
					if (arr[nx][ny] == 0 && check + 1 <= 2) {
						queue.add(new int[] { nx, ny, check+1});
						brr[nx][ny] = true;
						cnt++;
					}
				}
			}
		}
	}
}
