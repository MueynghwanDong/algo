package algo06.algo0618;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 영역구하기_bfs {

	static PriorityQueue<Integer> pq;
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] brr;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		brr = new boolean[n][m];
		pq = new PriorityQueue<>();
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for (int j = ((n - 1) - y1); j >= (n - y2); j--) {
				for (int l = x1; l <= (x2 - 1); l++) {
					arr[j][l] = 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && !brr[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
	}

	public static void bfs(int x, int y) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		int count = 0;
		brr[x][y] = true;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			count++;
			brr[q[0]][q[1]] = true;
			for (int i = 0; i < dirs.length; i++) {
				int newx = q[0] + dirs[i][0];
				int newy = q[1] + dirs[i][1];
				if (newx < 0 || newy < 0 || newx >= n || newy >= m)
					continue;
				if (arr[newx][newy] == 0 && !brr[newx][newy]) {
					queue.offer(new int[] { newx, newy });
					brr[newx][newy] = true;
				}
			}
		}
		pq.offer(count);
	}
}
