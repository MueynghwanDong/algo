package algo0624;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상범빌딩 {

	static int h;
	static int r;
	static int c;
	static char[][][] arr;
	static boolean[][][] brr;
	static int[][] dirs = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			 queue = new LinkedList<>();
			h = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			arr = new char[r][c][h];
			brr = new boolean[r][c][h];
			if (r == 0 && c == 0 && h == 0)
				break;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < r; j++) {
					String str = sc.next();
					for (int k = 0; k < c; k++) {
						arr[j][k][i] = str.charAt(k);
						if (arr[j][k][i] == 'S') {
							queue.offer(new int[] { j, k, i, 0 });
							brr[j][k][i] = true;
						} else if (arr[j][k][i] == '#')
							brr[j][k][i] = true;
					}
				}
//				if (i < h - 1)
//					sc.nextLine();
			} // 입력
			int result = bfs();
			if (result == 0) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + result + " minute(s).");
			}

		}
	}

	public static int bfs() {
		int cnt = 0;
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (arr[q[0]][q[1]][q[2]] == 'E') {
				cnt = q[3];
				return cnt;
			}
			for (int i = 0; i < dirs.length; i++) {
				int nx = q[0] + dirs[i][0];
				int ny = q[1] + dirs[i][1];
				int nh = q[2] + dirs[i][2];
				if (nx < 0 || ny < 0 || nh < 0 || nx >= r || ny >= c || nh >= h)
					continue;
				if (!brr[nx][ny][nh]) {
					brr[nx][ny][nh] = true;
					queue.offer(new int[] { nx, ny, nh, q[3] + 1 });
				}
			}
		}
		return cnt;

	}
}
