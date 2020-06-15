import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 원자 {

	static class data {
		int x;
		int y;
		int energy;
		int direction;

		public data(int x, int y, int energy, int direction) {
			this.x = x;
			this.y = y;
			this.energy = energy;
			this.direction = direction;
		}
	}

	static int total;
	static int[][] arr;
	static Queue<data> q = new LinkedList<>();
	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static boolean check(int nx, int ny) {
		boolean check = false;
		for (int i = 0; i < dir.length; i++) {
			int newx = nx + dir[i][0];
			int newy = ny + dir[i][1];
			if (newx < 0 || newy < 0 || newx > arr.length || newy > arr.length)
				continue;
			if (arr[newx][newy] != 0) {
				check = true;
			}
		}
		return check;
	}

	public static void move() {

		data temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			int d = temp.direction;
			if (d == 0) {
				int nx = temp.x - 1;
				int ny = temp.y;
				if (nx < 0 || nx > 2000)
					continue;
				if (arr[nx][ny] != 0) {
					if (!check(nx, ny)) {
						total = arr[nx][ny] + temp.energy;
						arr[nx][ny] = 0;
						arr[temp.x][temp.y] = 0;
					} else {
						arr[nx][ny] = arr[nx][ny] + arr[temp.x][temp.y];
					}
				} else {
					arr[nx][ny] = arr[temp.x][temp.y];
					arr[temp.x][temp.y] = 0;
					temp.x = nx;
					temp.y = ny;
					q.offer(temp);
				}
			} else if (d == 1) {
				int nx = temp.x + 1;
				int ny = temp.y;
				if (nx < 0 || nx > 2000)
					continue;
				if (arr[nx][ny] != 0) {
					if (!check(nx, ny)) {
						total = arr[nx][ny] + temp.energy;
						arr[nx][ny] = 0;
						arr[temp.x][temp.y] = 0;
					} else {
						arr[nx][ny] = arr[nx][ny] + arr[temp.x][temp.y];
					}
				} else {

					arr[nx][ny] = arr[temp.x][temp.y];
					arr[temp.x][temp.y] = 0;
					temp.x = nx;
					temp.y = ny;
					q.offer(temp);
				}
			} else if (d == 2) {
				int nx = temp.x;
				int ny = temp.y - 1;
				if (ny < 0 || ny > 2000)
					continue;
				if (arr[nx][ny] != 0) {
					if (!check(nx, ny)) {
						total = arr[nx][ny] + temp.energy;
						arr[nx][ny] = 0;
						arr[temp.x][temp.y] = 0;
					} else {
						arr[nx][ny] = arr[nx][ny] + arr[temp.x][temp.y];
					}
				} else {

					arr[nx][ny] = arr[temp.x][temp.y];
					arr[temp.x][temp.y] = 0;
					temp.x = nx;
					temp.y = ny;
					q.offer(temp);
				}
			} else if (d == 3) {
				int nx = temp.x;
				int ny = temp.y + 1;
				if (ny < 0 || ny > 2000)
					continue;
				if (arr[nx][ny] != 0) {
					if (!check(nx, ny)) {
						total = arr[nx][ny] + temp.energy;
						arr[nx][ny] = 0;
						arr[temp.x][temp.y] = 0;
					} else {
						arr[nx][ny] = arr[nx][ny] + arr[temp.x][temp.y];
					}
				} else {

					arr[nx][ny] = arr[temp.x][temp.y];
					arr[temp.x][temp.y] = 0;
					temp.x = nx;
					temp.y = ny;
					q.offer(temp);
				}
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			total = 0;
			arr = new int[2001][2001];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int xx = Integer.parseInt(st.nextToken()) + 1000;
				int yy = Integer.parseInt(st.nextToken()) + 1000;
				int direction = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());

				arr[xx][yy] = energy;
				q.offer(new data(xx, yy, energy, direction));
			}
			move();
			System.out.println(total);
		}
	}
}