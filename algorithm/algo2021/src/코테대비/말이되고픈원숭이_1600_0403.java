package 코테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이_1600_0403 {

	static int k, w, h, ans = Integer.MAX_VALUE;
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
		brr = new boolean[h][w][k + 1];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, k, 0 });
		brr[0][0][k] = true;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			int ck = t[2];
			int cnt = t[3];
			if (cx == h - 1 && cy == w - 1) {
				if (ans > cnt)
					ans = cnt;
				return;
			}
			for (int i = 8; i < 12; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w || brr[nx][ny][ck] || arr[nx][ny] == 1)
					continue;
				q.add(new int[] { nx, ny, ck, cnt + 1 });
				brr[nx][ny][ck] = true;

			}
			if (ck == 0)
				continue;
			for (int i = 0; i < 8; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w || brr[nx][ny][ck - 1] || arr[nx][ny] == 1)
					continue;
				q.add(new int[] { nx, ny, ck - 1, cnt + 1 });
				brr[nx][ny][ck - 1] = true;
			}
		}

	}
}
