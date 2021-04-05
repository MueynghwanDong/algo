package algo03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로만들기_2665_0319 {

	static int n, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] brr;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		brr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
				brr[i][j] = Integer.MAX_VALUE;
			}
		}

		bfs();
		System.out.println(brr[n - 1][n - 1]);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0 }); // x,y, 검은방 바꾼 횟수
		brr[0][0] = 0;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int cx = t[0];
			int cy = t[1];
			int cnt = t[2];

			for (int i = 0; i < dirs.length; i++) {
				int nx = cx + dirs[i][0];
				int ny = cy + dirs[i][1];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (brr[nx][ny] <= brr[cx][cy]) // 이전 값이 새로운 자리 값보다 크면 continue;
					continue;
				if (arr[nx][ny] == 1) { // 흰
					brr[nx][ny] = brr[cx][cy];
					q.add(new int[] { nx, ny, cnt });
				} else if (arr[nx][ny] == 0) { // 검
					brr[nx][ny] = brr[cx][cy] + 1;
					q.add(new int[] { nx, ny, cnt + 1 });
				}

			}

		}

	}

}
