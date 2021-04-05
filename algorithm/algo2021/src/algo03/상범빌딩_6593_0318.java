package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class »ó¹üºôµù_6593_0318 {

	static int r, c, h, ans;
	static char[][][] arr;
	static boolean[][][] brr;
	static Queue<int[]> q;
	static int[][] dirs = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new char[r][c][h];
			brr = new boolean[r][c][h];
			if (h == 0 && r == 0 && c == 0)
				break;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < r; j++) {
					String str = br.readLine();
					for (int k = 0; k < c; k++) {
						arr[j][k][i] = str.charAt(k);
						if (arr[j][k][i] == 'S') {
							q.add(new int[] { j, k, i, 0 });
							brr[j][k][i] = true;
						} else if (arr[j][k][i] == '#') {
							brr[j][k][i] = true;
						}
					}
				}
				br.readLine();
			}

			ans = Integer.MAX_VALUE;
			bfs();
			if (ans == Integer.MAX_VALUE) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + ans + " minute(s).");
			}
		}
	}

	public static void bfs() {

		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			int ch = t[2];
			int cnt = t[3];

			if (arr[cx][cy][ch] == 'E') {
				ans = cnt;
				return;
			}

			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				int nh = ch + dirs[i][2];
				if (nx < 0 || ny < 0 || nh < 0 || nx >= r || ny >= c || nh >= h || brr[nx][ny][nh])
					continue;
				brr[nx][ny][nh] = true;
				q.add(new int[] { nx, ny, nh, cnt + 1 });
			}
		}

	}

}
