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

public class 스타트택시_19238_0227 {

	static class Pos {
		int sx, sy, ex, ey;

		Pos(int sx, int sy, int ex, int ey) {
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}
	}

	static class Guest implements Comparable<Guest> {
		int x, y, dis;

		Guest(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		@Override
		public int compareTo(Guest o) {
			if (this.dis == o.dis) {
				if (this.x == o.x) {
					return this.y - o.y;
				} else
					return this.x - o.x;
			} else
				return this.dis - o.dis;
		}

	}

	static int n, m, f, dx, dy;
	static int[][] arr;
	static boolean[][] brr;
	static List<Pos> list = new ArrayList<>();
	static List<Guest> guest = new ArrayList<>();
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					arr[i][j] = -1; // 벽
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
			list.add(new Pos(sx - 1, sy - 1, ex - 1, ey - 1));
			// 승객 번호 표시
			arr[sx - 1][sy - 1] = i + 1;
		}
		while (true) {
			// System.out.println("시작: " +f);
			if (list.size() == 0) { // 승객이 없는 경우
				System.out.println(f);
				return;
			}
			guest.clear();
			brr = new boolean[n][n];
			getGuest(dx, dy); // 가장가까운 게스트 찾는 함수
			if (guest.size() == 0) {// 함수 후 가까운 손님을 찾지 못한 경우
				System.out.println(-1);
				return;
			}
			Guest g = guest.get(0); // 제일 가까운 게스트
			arr[g.x][g.y] = 0;
			f -= g.dis; // 가장 가까운 게스트까지 이동한 거리만큼 연료 제거
			// System.out.println("게스트 자리로 이동: " + f);

			if (f < 0) { // 연료부족
				System.out.println(-1);
				return;
			}
			int dist = 0;
			brr = new boolean[n][n]; // **
			for (int i = 0; i < list.size(); i++) {
				Pos p = list.get(i);
				if (p.sx == g.x && p.sy == g.y) {
					dist = getDist(p.sx, p.sy, p.ex, p.ey); // 승객 태우고 이동한 거리 산정
					// System.out.println("거리 산정 : "+dist);
					if (dist == -1) {
						System.out.println(-1);
						return;
					}
					dx = p.ex;
					dy = p.ey;
					list.remove(p);
					break;
				}
			}
			f -= dist; // 거리 만큼 연료 제거
			// System.out.println("승객 목적지 하차 후: "+f);
			if (f < 0) { // 연료부족
				System.out.println(-1);
				return;
			}
			f += dist * 2; // 성공시 거리만큼 2배 추가
			// System.out.println("성공 후 2배 추가 후: "+f);
		}

	}

	public static int getDist(int sx, int sy, int ex, int ey) {
		Queue<Guest> q = new LinkedList<>();
		q.add(new Guest(sx, sy, 0));
		while (!q.isEmpty()) {
			Guest g = q.poll();
			if (g.x == ex && g.y == ey) {
				return g.dis;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nx = g.x + dirs[i][0];
				int ny = g.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == -1 || brr[nx][ny])
					continue;
				brr[nx][ny] = true;
				q.add(new Guest(nx, ny, g.dis + 1));
			}
		}
		return -1;
	}

	public static void getGuest(int dx, int dy) {
		PriorityQueue<Guest> pq = new PriorityQueue<>();
		pq.add(new Guest(dx, dy, 0));
		while (!pq.isEmpty()) {
			Guest t = pq.poll();
			if (arr[t.x][t.y] >= 1) {
				guest.add(new Guest(t.x, t.y, t.dis));
				break;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nx = t.x + dirs[i][0];
				int ny = t.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || arr[nx][ny] == -1)
					continue;
				brr[nx][ny] = true;
				pq.add(new Guest(nx, ny, t.dis + 1));
			}

		}
	}

}
