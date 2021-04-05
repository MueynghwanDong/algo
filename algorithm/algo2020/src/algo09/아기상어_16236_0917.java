package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236_0917 {

	static int dirs[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int n, time = 0;
	static int arr[][];
	static int cnt = 0;
	static boolean[][] check;
	static ArrayList<shark> temp = new ArrayList<>();
	static Queue<shark> queue = new LinkedList<>();

	static class shark implements Comparable<shark> {
		int x;
		int y;
		int size;
		int eat;
		int step;

		shark(int x, int y, int size, int eat, int step) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.eat = eat;
			this.step = step;
		}

		@Override
		public int compareTo(shark o) {
			if (this.x != o.x) {
				return this.x - o.x;
			} else {
				return this.y - o.y;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 9 && arr[i][j] != 0) {
					cnt++;
				} else if (arr[i][j] == 9) {
					temp.add(new shark(i, j, 2, 0, 0));
				}
			}
		}
		if (cnt == 0) {
			System.out.println(0);
			return;
		}
		while (true) {

			init();

			bfs();
			if (temp.size() < 1)
				break;
		}
		System.out.println(time);
	}

	public static void init() {
		queue.clear();
		Collections.sort(temp);
		shark s = temp.get(0);
		time += s.step;
		// System.out.println(s.x +" " + s.y);
		if (s.size == s.eat) {
			queue.add(new shark(s.x, s.y, s.size + 1, 0, 0));
		} else {
			queue.add(new shark(s.x, s.y, s.size, s.eat, 0));
		}
		temp.clear();
		check = new boolean[n][n];
		check[s.x][s.y] = true;
		arr[s.x][s.y] = 0;
	}

	public static void bfs() {
		int limit = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			shark cur = queue.poll();
			if (cur.step > limit)
				return;

			int cx = cur.x;
			int cy = cur.y;
			int size = cur.size;
			int eat = cur.eat;

			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || check[nx][ny])
					continue;

				check[nx][ny] = true;
				if (arr[nx][ny] == cur.size || arr[nx][ny] == 0)
					queue.add(new shark(nx, ny, size, eat, cur.step + 1));
				else if (arr[nx][ny] != 0 && arr[nx][ny] < size) {
					temp.add(new shark(nx, ny, size, eat + 1, cur.step + 1));
					limit = cur.step;
				}
			}
		}
	}

}
