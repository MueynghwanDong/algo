package algo06.algo0617;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기 {

	static int R;
	static int C;
	static int[][] arr;
	static int[][] check;
	static Queue<int[]> queue = new LinkedList<>();
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new int[R][C];
		check = new int[R][C];
		cnt = -1;
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j) - '0';
				check[i][j] = Integer.MAX_VALUE;
			}
		} // 입력
		queue.offer(new int[] { 0, 0, 0, 1 }); // x,y,break, cnt
		check[0][0] = 0;
		bfs();
		System.out.println(cnt);
	}

	public static void bfs() {

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[0] == R - 1 && q[1] == C - 1) {
				cnt = q[3];
				break;
			}
			for (int i = 0; i < dirs.length; i++) {
				int newx = q[0] + dirs[i][0];
				int newy = q[1] + dirs[i][1];
				if (newx < 0 || newy < 0 || newx >= R || newy >= C || check[newx][newy] <= q[2])
					continue;
				if (arr[newx][newy] == 1 && q[2] == 0) { // 벽 일경우
					check[newx][newy] = q[2] + 1;
					queue.offer(new int[] { newx, newy, q[2] + 1, q[3] + 1 });

				} else if (arr[newx][newy] == 0) {
					check[newx][newy] = q[2];
					queue.offer(new int[] { newx, newy, q[2], q[3] + 1 });
				}
			}

		}
	}
}
