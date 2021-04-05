package algo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206_1224 {

	static int n;
	static int m;
	static int cnt;
	static int[][] arr;
	static int[][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new int[n][m];
		cnt = -1;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
				brr[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(cnt);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0, 0, 1 }); // x,y,부수고 갔는지, cnt
		brr[0][0] = 0;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int cx = temp[0];
			int cy = temp[1];
			int check = temp[2];
			int c = temp[3];

			if (cx == n - 1 && cy == m - 1) {
				cnt = c;
				return;
			}

			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] <= check)
					continue;
				if (arr[nx][ny] == 1 && check == 0) {
					q.add(new int[] { nx, ny, 1, c + 1 });
					brr[nx][ny] = check + 1;
				} else if (arr[nx][ny] == 0) {
					q.add(new int[] { nx, ny, check, c + 1 });
					brr[nx][ny] = check;
				}
			}
		}
	}
}
