package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236_0210 {

	static class Shark implements Comparable<Shark> {
		int x, y, eat, size, step;

		Shark(int x, int y, int size, int eat, int step) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.eat = eat;
			this.step = step;
		}

		@Override
		public int compareTo(Shark o) {
			if (this.x != o.x) {
				return this.x - o.x;
			} else
				return this.y - o.y;
		}
	}

	static int n, cnt = 0, ans = 0;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] arr;
	static boolean[][] brr;
	static ArrayList<Shark> sh = new ArrayList<>();
	static Queue<Shark> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 9 && arr[i][j] != 0) {
					cnt++;
				} else if (arr[i][j] == 9) {
					sh.add(new Shark(i, j, 2, 0, 0));
				}
			}
		}
		if (cnt == 0) {
			System.out.println(0);
			return;
		}
		while (true) {
			bfs();
			if (sh.size() < 1)
				break;
		}
		System.out.println(ans);
	}

	public static void bfs() {
		queue.clear();
		Collections.sort(sh);
		Shark s = sh.get(0); // 가장 앞에있는 거
		ans += s.step;
		if (s.eat == s.size) {
			queue.add(new Shark(s.x, s.y, s.size + 1, 0, 0));
		} else {
			queue.add(new Shark(s.x, s.y, s.size, s.eat, 0));
		}
		brr = new boolean[n][n];
		brr[s.x][s.y] = true;
		arr[s.x][s.y] = 0;
		sh.clear();

		int len = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Shark cur = queue.poll();
			if (cur.step > len)
				return;
			for (int i = 0; i < dirs.length; i++) {
				int nx = cur.x + dirs[i][0];
				int ny = cur.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny])
					continue;
				brr[nx][ny] = true;
				if (arr[nx][ny] == cur.size || arr[nx][ny] == 0) {
					queue.add(new Shark(nx, ny, cur.size, cur.eat, cur.step + 1));
				} else if (arr[nx][ny] != 0 && arr[nx][ny] < cur.size) {
					sh.add(new Shark(nx, ny, cur.size, cur.eat + 1, cur.step + 1));
					len = cur.step;
				}
			}

		}

	}

}
