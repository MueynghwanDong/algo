package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026_1222_2 {

	static int cnt = 0;
	static int n;
	static char[][] crr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		crr = new char[n][n];
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				crr[i][j] = str.charAt(j);
			}
		}
		System.out.print(bfs() + " ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (crr[i][j] == 'G')
					crr[i][j] = 'R';
			}
		}
		brr = new boolean[n][n];
		System.out.print(bfs());

	}

	public static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (brr[i][j])
					continue;
				brr[i][j] = true;
				char c = crr[i][j];
				q.offer(new int[] { i, j });
				while (!q.isEmpty()) {
					int t[] = q.poll();
					int cx = t[0];
					int cy = t[1];
					for (int k = 0; k < dirs.length; k++) {
						int nx = cx + dirs[k][0];
						int ny = cy + dirs[k][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || crr[nx][ny] != c)
							continue;
						brr[nx][ny] = true;
						q.offer(new int[] { nx, ny });
					}
				}
				cnt++;
			}
		}
		return cnt;
	}
}
