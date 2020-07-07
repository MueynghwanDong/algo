package algo06.algo0615;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ¿Ø±‚≥ÛπË√ﬂ_bfs {

	static int r;
	static int c;
	static int k;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static Queue<int[]> que = new LinkedList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			r = sc.nextInt();
			c = sc.nextInt();
			k = sc.nextInt();
			arr = new int[r][c];
			visited = new boolean[r][c];
			for (int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = 1;
			}
			int count = 0;

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						que.offer(new int[] { i, j });
						visited[i][j] = true;
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);

		} // end of testcase
	}// end of main

	public static void bfs(int x, int y) {
		int[] q = null;
		while (!que.isEmpty()) {
			q = que.poll();
			visited[q[0]][q[1]] = true;
			for (int i = 0; i < dirs.length; i++) {
				int newx = q[0] + dirs[i][0];
				int newy = q[1] + dirs[i][1];
				if (newx < 0 || newy < 0 || newx >= r || newy >= c)
					continue;
				if (!visited[newx][newy] && arr[newx][newy] == 1) {
					que.offer(new int[] { newx, newy });
					visited[newx][newy] = true;
				}	
			}

		}
	}

}
