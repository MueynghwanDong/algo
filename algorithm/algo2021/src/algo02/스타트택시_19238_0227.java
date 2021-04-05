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

public class ��ŸƮ�ý�_19238_0227 {

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
					arr[i][j] = -1; // ��
			}
		}
		// ó�� ������ġ
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
			// �°� ��ȣ ǥ��
			arr[sx - 1][sy - 1] = i + 1;
		}
		while (true) {
			// System.out.println("����: " +f);
			if (list.size() == 0) { // �°��� ���� ���
				System.out.println(f);
				return;
			}
			guest.clear();
			brr = new boolean[n][n];
			getGuest(dx, dy); // ���尡��� �Խ�Ʈ ã�� �Լ�
			if (guest.size() == 0) {// �Լ� �� ����� �մ��� ã�� ���� ���
				System.out.println(-1);
				return;
			}
			Guest g = guest.get(0); // ���� ����� �Խ�Ʈ
			arr[g.x][g.y] = 0;
			f -= g.dis; // ���� ����� �Խ�Ʈ���� �̵��� �Ÿ���ŭ ���� ����
			// System.out.println("�Խ�Ʈ �ڸ��� �̵�: " + f);

			if (f < 0) { // �������
				System.out.println(-1);
				return;
			}
			int dist = 0;
			brr = new boolean[n][n]; // **
			for (int i = 0; i < list.size(); i++) {
				Pos p = list.get(i);
				if (p.sx == g.x && p.sy == g.y) {
					dist = getDist(p.sx, p.sy, p.ex, p.ey); // �°� �¿�� �̵��� �Ÿ� ����
					// System.out.println("�Ÿ� ���� : "+dist);
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
			f -= dist; // �Ÿ� ��ŭ ���� ����
			// System.out.println("�°� ������ ���� ��: "+f);
			if (f < 0) { // �������
				System.out.println(-1);
				return;
			}
			f += dist * 2; // ������ �Ÿ���ŭ 2�� �߰�
			// System.out.println("���� �� 2�� �߰� ��: "+f);
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
