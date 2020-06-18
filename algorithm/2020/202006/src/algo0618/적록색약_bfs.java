package algo0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 적록색약_bfs {

	static char[][] arr;
	static boolean[][] brr;
	static boolean[][] brr2;
	static int n;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		arr = new char[n][n];
		brr = new boolean[n][n];
		queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		System.out.print(bfs() + " ");
		brr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'G')
					arr[i][j] = 'R';
			}
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (brr[i][j])
					continue;
				brr[i][j] = true;
				queue.offer(new int[] { i, j });
				while (!queue.isEmpty()) {
					int[] q = queue.poll();
					for (int k = 0; k < dirs.length; k++) {
						int newx = q[0] + dirs[k][0];
						int newy = q[1] + dirs[k][1];
						if (newx < 0 || newy < 0 || newx >= n || newy >= n || brr[newx][newy]
								|| arr[q[0]][q[1]] != arr[newx][newy])
							continue;
						brr[newx][newy] = true;
						queue.offer(new int[] { newx, newy });

					}
				}
				cnt++;

			}
		}
		return cnt;
	}

}