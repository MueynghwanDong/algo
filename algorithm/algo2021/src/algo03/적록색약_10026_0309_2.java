package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026_0309_2 {

	static int n, cnt = 0;
	static char[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		brr = new boolean[n][n];
		bfs();
		System.out.print(cnt + " ");
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}
			}
		}

		brr = new boolean[n][n];
		bfs();
		System.out.println(cnt);

	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (brr[i][j])
					continue;
				q.add(new int[] { i, j });
				while (!q.isEmpty()) {
					int[] t = q.poll();
					int cx = t[0];
					int cy = t[1];
					for (int k = 0; k < dirs.length; k++) {
						int nx = cx + dirs[k][0];
						int ny = cy + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || arr[nx][ny] != arr[cx][cy])
							continue;
						brr[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}
				cnt++;
			}
		}
	}

}
