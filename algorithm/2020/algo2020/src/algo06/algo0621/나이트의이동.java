package algo06.algo0621;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동 {

	static int n;
	static int sx, sy, ex, ey;
	static int[][] arr;
	static int[][] dirs = { { -1, -2 }, { -2, -1 }, { 2, -1 }, { 1, -2 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 } };
	static int result;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int testCase = 0; testCase < t; testCase++) {
			n = sc.nextInt();
			arr = new int[n][n];
			sx = sc.nextInt();
			sy = sc.nextInt();
			ex = sc.nextInt();
			ey = sc.nextInt();
			result = 0;
			bfs(sx, sy);
			System.out.println(result);
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		arr[x][y] = 1;
		queue.offer(new int[] { x, y, 0 });
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if(q[0]==ex && q[1]==ey) {
				result = q[2];
				return;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nx = q[0] + dirs[i][0];
				int ny = q[1] + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 1)
					continue;
				if (arr[nx][ny] == 0) {
					queue.offer(new int[] { nx, ny, q[2] + 1 });
					arr[nx][ny] = 1;
				}
			}
		}
	}

}
