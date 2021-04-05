package algo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트택시_19238_0206 {

	static class Guest {
		int sx, sy, ex, ey;

		Guest(int sx, int sy, int ex, int ey) {
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}
	}

	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int dist;

		Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pos o) {
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

	static int n, m, f, dx, dy;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<Pos> guest = new ArrayList<>();
	static List<Guest> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					arr[i][j] = -1;
			}
		}
		// 처음 시작위치
		st = new StringTokenizer(br.readLine(), " ");
		dx = Integer.parseInt(st.nextToken()) - 1;
		dy = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			list.add(new Guest(sx - 1, sy - 1, ex - 1, ey - 1));
			// 승객 번호 표시
			arr[sx - 1][sy - 1] = i + 1;
		}
		while (true) {
			if (list.size() == 0) {
				System.out.println(f);
				return;
			}
			guest.clear();
			brr = new boolean[n][n];
			// 가장 가까운 손님 찾기
			getGuest(dx, dy);
			if (guest.size() == 0) {
				System.out.println(-1);
				return;
			}
			Pos a = guest.get(0);
			arr[a.x][a.y] = 0;
			// 거리만큼 연료 제거
			f -= a.dist;

			if (f < 0) { // 연료부족
				System.out.println(-1);
				return;
			}
			int dist = 0;
			brr = new boolean[n][n];
			for (int i = 0; i < list.size(); i++) {
				Guest g = list.get(i);
				if (g.sx == a.x && g.sy == a.y) {
					dist = get_dist(g.sx, g.sy, g.ex, g.ey);
					if (dist == -1) {
						System.out.println(-1);
						return;
					}
					dx = g.ex;
					dy = g.ey;
					list.remove(g);
					break;
				}
			}
			// 거리만큼 연료 제거
			f -= dist;
			if (f < 0) {
				System.out.println(-1);
				return;
			}
			// 성공시 2배 추가
			f += dist * 2;
		}
	}

	public static int get_dist(int x, int y, int ex, int ey) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y, 0));
		while (!q.isEmpty()) {
			Pos a = q.poll();
			if (a.x == ex && a.y == ey) {
				return a.dist;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nx = a.x + dirs[i][0];
				int ny = a.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || arr[nx][ny] == -1)
					continue;
				brr[nx][ny] = true;
				q.add(new Pos(nx, ny, a.dist + 1));
			}
		}
		return -1;
	}

	public static void getGuest(int x, int y) {
		// 우선순위 큐를 통해 가장 가까운 손님찾기
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(x, y, 0));
		while (!q.isEmpty()) {
			Pos t = q.poll();
			if (arr[t.x][t.y] >= 1) {
				guest.add(new Pos(t.x, t.y, t.dist));
				break;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nx = t.x + dirs[i][0];
				int ny = t.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || arr[nx][ny] == -1)
					continue;
				brr[nx][ny] = true;
				q.add(new Pos(nx, ny, t.dist + 1));
			}
		}
	}
}
