package algo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2_14442_1005 {

	static int n;
	static int m;
	static int k;
	static int[][] arr;
	static boolean[][][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		brr = new boolean[n][m][k + 1];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 0, 1 });
		brr[0][0][0] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {

				int[] temp = queue.poll();
				int cx = temp[0];
				int cy = temp[1];
				int ck = temp[2];
				int cnt = temp[3];
				if (cx == n - 1 && cy == m - 1) {
					System.out.println(cnt);
					return;
				}
				for (int j = 0; j < dirs.length; j++) {
					int nx = cx + dirs[j][0];
					int ny = cy + dirs[j][1];
					if (nx >= n || ny >= m || nx < 0 || ny < 0 || brr[nx][ny][ck])
						continue;
					if (arr[nx][ny] == 0) {
						queue.add(new int[] { nx, ny, ck, cnt + 1 });
						brr[nx][ny][ck] = true;
					} else if (arr[nx][ny] == 1) {
						if (ck < k && !brr[nx][ny][ck + 1]) {
							queue.add(new int[] { nx, ny, ck + 1, cnt + 1 });
							brr[nx][ny][ck + 1] = true;
						} else
							continue;
					}
				}
			}

		}
		System.out.println("-1");
	}
}
