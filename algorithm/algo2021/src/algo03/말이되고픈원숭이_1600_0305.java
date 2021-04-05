package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¸»ÀÌµÇ°íÇÂ¿ø¼þÀÌ_1600_0305 {

	static int w, h, k, mincnt = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[][][] brr;
	static int[][] dirs = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
			{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		brr = new boolean[h][w][k + 1];
		bfs();
		if (mincnt == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(mincnt);
		}

	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, k, 0 });
		brr[0][0][k] = true;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1];
			int kk = q[2];
			int cnt = q[3];
			if (x == h - 1 && y == w - 1) {
				if (mincnt > cnt)
					mincnt = cnt;
				return;
			}
			for (int i = 8; i < 12; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx >= 0 && ny >= 0 && nx < h && ny < w && !brr[nx][ny][kk] && arr[nx][ny] == 0) {
					brr[nx][ny][kk] = true;
					queue.add(new int[] { nx, ny, kk, cnt + 1 });
				}
			}
			if (kk == 0)
				continue;
			for (int i = 0; i < 8; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				if (nx >= 0 && ny >= 0 && nx < h && ny < w && !brr[nx][ny][kk - 1] && arr[nx][ny] == 0) {
					brr[nx][ny][kk - 1] = true;
					queue.add(new int[] { nx, ny, kk - 1, cnt + 1 });
				}
			}

		}
	}
}
