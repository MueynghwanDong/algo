package 코테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2636_0330 {

	static int n, m, ans = 0, cnt = 0;
	static int[][] arr;
	static boolean[][] brr;
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
		int pre = 0;
		while (true) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 9) {
						cnt--;
						arr[i][j] = 0;
					}
				}
			}
			if (cnt == 0)
				break;
			pre = cnt;
			brr = new boolean[n][m];
			brr[0][0] = true;
			bfs(0, 0);
			ans++;
		}
		System.out.println(ans);
		System.out.println(pre);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny])
					continue;
				if (arr[nx][ny] == 1) {
					arr[nx][ny] = 9;
				} else if (arr[nx][ny] == 0) {
					brr[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}
}
