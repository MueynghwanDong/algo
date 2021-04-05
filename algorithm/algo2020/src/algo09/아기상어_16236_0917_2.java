package algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236_0917_2 {

	static int dirs[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int n, time = 0;
	static int sx;
	static int sy;
	static int arr[][];
	static int cnt = 0;
	static int fishs[];
	static boolean[][] check;
	static int ssize = 2;
	static int seat = 0;
	static ArrayList<fish> tempFish = new ArrayList<>();

	static ArrayList<shark> temp = new ArrayList<>();
	static Queue<shark> queue = new LinkedList<>();

	static class fish implements Comparable<fish> {
		int x;
		int y;
		int dist;

		fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(fish o) {
			if (this.dist != o.dist) {
				return this.dist - o.dist;
			} else {
				if (this.x != o.x) {
					return this.x - o.x;
				} else {
					return this.y - o.y;
				}
			}
		}
	}

	static class shark {
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
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new boolean[n][n];
		sx = 0;
		sy = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 9 && arr[i][j] != 0) {
					cnt++;
				} else if (arr[i][j] == 9) {
					sx = i;
					sy = j;
					arr[i][j] = 0;
					check[sx][sy] = true;
				}
			}
		}
		if (cnt == 0) {
			System.out.println(0);
			return;
		}
		int x = sx;
		int y = sy;
		int s = 2;
		int e = 0;
		while (true) {
//			System.out.println(x + " " + y + " " + s + " " + e);
			bfs(x, y, s, e);

			if (tempFish.size() < 1)
				break;
			queue.clear();
			Collections.sort(tempFish);			
			check = new boolean[n][n];
			time += tempFish.get(0).dist;
			x = tempFish.get(0).x;
			y = tempFish.get(0).y;
			arr[x][y] = 0;
			seat++;
			if (ssize == seat) {
				ssize++;
				seat = 0;
			}
			s = ssize;
			e = seat;

			tempFish.clear();

		}
		System.out.println(time);
	}

	public static void bfs(int x, int y, int s, int e) {
		queue.add(new shark(x, y, s, e, 0));

		while (!queue.isEmpty()) {
			shark cur = queue.poll();

			int cx = cur.x;
			int cy = cur.y;
			int ss = cur.size;
			int eat = cur.eat;

			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || check[nx][ny] || ss< arr[nx][ny])
					continue;
				check[nx][ny] = true;
				if (arr[nx][ny] == cur.size || arr[nx][ny] == 0)
					queue.add(new shark(nx, ny, ss, eat, cur.step + 1));
				else if (arr[nx][ny] != 0 && arr[nx][ny] < ss) {
					tempFish.add(new fish(nx, ny, cur.step+1));
				}
			}
		}
	}

}
