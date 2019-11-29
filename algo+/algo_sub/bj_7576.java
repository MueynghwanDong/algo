import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_7576 {

	static class Pos {
		int x;
		int y;
		int cnt;

		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int arr[][];
	static boolean visited[][];
	static int r;
	static int c;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Pos> q = new LinkedList<>();

	public static int bfs() {
		int result = 0;
		Pos temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = temp.x + dirs[i][0];
				int ny = temp.y + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= c || ny >= r)
					continue;
				if (!visited[nx][ny] && arr[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.offer(new Pos(nx, ny, temp.cnt + 1));
				}
			}
		}
		result = temp.cnt;
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		arr = new int[c][r];
		visited = new boolean[c][r];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					q.offer(new Pos(i, j, 0));
					visited[i][j] = true;
				} else if (arr[i][j] == -1) {
					visited[i][j] = true;
				}
			}
		} // 입력
		int t = 0;
		t = bfs();
		boolean check = false;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (!visited[i][j]) {
					check = true;
				}
			}
		}
		if (check)
			System.out.println(-1);
		else
			System.out.println(t);
	}

}
