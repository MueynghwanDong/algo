package algo06.algo0629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이 {

	static int w;
	static int h;
	static int k;
	static int[][] arr;
	static boolean[][][] brr;
	static int mincnt;
	private static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1, -1, 1, 0, 0 };
	private static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		mincnt = Integer.MAX_VALUE;
		arr = new int[h][w];
		brr = new boolean[h][w][k + 1]; ///말처럼 이동할 수 있는 횟수 **
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, k, 0 });
		brr[0][0][k] = true;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1];
			int kk = q[2];
			int count = q[3];
			if (x == h - 1 && y == w - 1) {
				if (mincnt > count)
					mincnt = count;
				break;
			}
			for (int i = 8; i < 12; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				if (nx >= 0 && ny >= 0 && nx < h && ny < w && !brr[nx][ny][kk] && arr[nx][ny] == 0) {

					brr[nx][ny][kk] = true;
					queue.offer(new int[] { nx, ny, kk, count + 1 });
				}

			}
			if (kk == 0)
				continue;
			for (int i = 0; i < 8; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				if (nx >= 0 && ny >= 0 && nx < h && ny < w && !brr[nx][ny][kk - 1] && arr[nx][ny] == 0) {
					brr[nx][ny][kk - 1] = true;
					queue.offer(new int[] { nx, ny, kk - 1, count + 1 });
				}
			}
		}
		System.out.println(mincnt == Integer.MAX_VALUE ? -1 : mincnt);
	}
}
