package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Á¡ÇÁ¿Õ¥f¸®_16174_0113 {

	static int[][] arr;
	static boolean[][] brr;
	static int n;
	static int[][] dirs = { { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		brr[0][0] = true;

		if (dfs(0, 0, arr[0][0])) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
		// if (bfs()) {
		// System.out.println("HaruHaru");
		// } else {
		// System.out.println("Hing");
		// }
	}

	public static boolean bfs() {

		Queue<int[]> queue = new LinkedList<>();
		brr[0][0] = true;
		queue.add(new int[] { 0, 0, arr[0][0] });
		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int cx = q[0];
			int cy = q[1];
			int val = q[2];
			if (cx == n - 1 && cy == n - 1) {
				return true;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + (dirs[i][0] * val);
				int ny = cy + (dirs[i][1] * val);
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny]) {
					continue;
				}
				brr[nx][ny] = true;
				queue.add(new int[] { nx, ny, arr[nx][ny] });
			}
		}
		return false;
	}

	public static boolean dfs(int x, int y, int val) {
		 brr[x][y] = true;
		if (val == -1) {
			return true;
		}
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + (dirs[i][0] * val);
			int ny = y + (dirs[i][1] * val);
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny])
				continue;
			boolean c = dfs(nx, ny, arr[nx][ny]);
			if (c)
				return true;
		}
		return false;
	}
}
