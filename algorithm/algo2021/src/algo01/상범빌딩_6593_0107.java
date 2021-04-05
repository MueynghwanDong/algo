package algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩_6593_0107 {

	static int h, r, c;
	static char[][][] arr;
	static boolean[][][] brr;
	static int[][] dirs = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new char[r][c][h];
			brr = new boolean[r][c][h];
			if (r == 0 && c == 0 && h == 0) // 종료 조건
				break;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < r; j++) {
					String str = br.readLine();
					for (int k = 0; k < c; k++) {
						arr[j][k][i] = str.charAt(k);
						if (arr[j][k][i] == 'S') { // 시작 위치 큐에 삽입
							queue.offer(new int[] { j, k, i, 0 });
							brr[j][k][i] = true;
						} else if (arr[j][k][i] == '#') // 갈수 없는 길
							brr[j][k][i] = true;
					}
				}
				br.readLine();
			}
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
//			System.out.println(q[0] + " " + q[1] + " " + q[2]);
			for (int i = 0; i < dirs.length; i++) {
				int nx = q[0] + dirs[i][0];
				int ny = q[1] + dirs[i][1];
				int nh = q[2] + dirs[i][2];
//				System.out.println(nx + " " + ny + " " + nh);
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
