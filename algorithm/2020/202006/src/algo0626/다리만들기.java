package algo0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기 {

	static int n;
	static int min;
	static int[][] arr;
	static int[][] temp; // arr값을 reset시켜주기위해 임시로 설정한 배열
	static boolean[][] brr;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		arr = new int[n][n];
		brr = new boolean[n][n];
		temp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력

		// 영역별 번호 붙여주기
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0 && !brr[i][j]) {
					bridge(cnt, i, j);
					cnt++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i].clone();
		}

		// 거리 측정 - 0이 아닌 부분 나올 때
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0 && checking(i, j)) {
					shortpath(i, j);
					for (int k = 0; k < n; k++) { // 리셋하는 부분
						arr[k] = temp[k].clone();
					}
				}
			}
		}
		System.out.println(min);

	}

	public static void bridge(int cnt, int x, int y) {
		arr[x][y] = cnt;
		brr[x][y] = true;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || brr[nx][ny] || arr[nx][ny] == 0)
				continue;
			if (arr[nx][ny] != 0 && !brr[nx][ny]) {
				arr[nx][ny] = cnt;
				bridge(cnt, nx, ny);
			}
		}
	}

	public static void shortpath(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y, 0 });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int i = 0; i < dirs.length; i++) {
				int nx = q[0] + dirs[i][0];
				int ny = q[1] + dirs[i][1];
				int ncount = q[2] + 1;
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == -1 || arr[nx][ny] == arr[x][y])
					continue;
				if (arr[nx][ny] != 0) {
					if (ncount - 1 < min) {
						min = ncount - 1;
					}
					return;
				}
				arr[nx][ny] = -1;
				queue.offer(new int[] { nx, ny, ncount });
			}
		}
	}
	public static boolean checking(int x, int y) {
		boolean c = false;
		for (int i = 0; i < dirs.length; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (arr[nx][ny] == 0) {
				c = true;
			}
		}
		return c;
	}
}