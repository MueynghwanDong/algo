package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baaaaaaaaaduk2_Easy_16988_0205 {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, cnt, tcnt;
	static int ans = 0;
	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] brr;
	static List<Pos> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					list.add(new Pos(i, j));
				}
			}
		}
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				Pos a = list.get(i);
				Pos b = list.get(j);
				arr[a.x][a.y] = 1;
				arr[b.x][b.y] = 1;
				fun();
				arr[a.x][a.y] = 0;
				arr[b.x][b.y] = 0;
			}
		}

		System.out.println(ans);
	}

	public static void fun() {
		brr = new boolean[n][m];
		Queue<Pos> queue;
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 2 && !brr[i][j]) {
					queue = new LinkedList<>();
					brr[i][j] = true;
					queue.add(new Pos(i, j));
					int ncnt = 1;
					int empty = 0;
					while (!queue.isEmpty()) {
						Pos p = queue.poll();

						for (int d = 0; d < dirs.length; d++) {
							int nx = p.x + dirs[d][0];
							int ny = p.y + dirs[d][1];
							if (nx < 0 || ny < 0 || nx >= n || ny >= m || brr[nx][ny] || arr[nx][ny] == 1)
								continue;
							if (arr[nx][ny] == 0) {
								empty++;
							}
							if (arr[nx][ny] == 2) {
								brr[nx][ny] = true;
								queue.add(new Pos(nx, ny));
								ncnt++;
							}
						}
					}
					if (empty > 0)
						continue;
					total += ncnt;
				}
			}
		}
		if (total > ans)
			ans = total;

	}
}
