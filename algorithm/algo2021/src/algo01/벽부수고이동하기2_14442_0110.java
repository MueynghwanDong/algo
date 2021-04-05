package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2_14442_0110 {

	static int n, m, k;
	static int cnt = -1;
	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new int[n][m];
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
		Queue<int[]> queue = new LinkedList<>();
		brr[0][0] = 0;
		queue.add(new int[] { 0, 0, 0, 1 }); // x,y,부쉈는지 ,cnt

		while (!queue.isEmpty()) {

			int[] q = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int check = q[2];
			int count = q[3];
			if (cx == n - 1 && cy == m - 1) {
				cnt = count;
				return;
			}

			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] <= check)
					continue;
				if (arr[nx][ny] == 0) {
					brr[nx][ny] = check;
					queue.add(new int[] { nx, ny, check, count + 1 });
				} else if (arr[nx][ny] == 1 && check < k && brr[nx][ny] > check + 1) {
					brr[nx][ny] = check + 1;
					queue.add(new int[] { nx, ny, check + 1, count + 1 });
				}
			}
		}
	}

}
