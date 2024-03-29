package algo2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n5_탈출_3055 {

	static int r, c, sr, sc, ans = -1;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] arr;
	static boolean[][] brr;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		brr = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'S') { // 고슴도치 위치
					sr = i;
					sc = j;
				} else if (arr[i][j] == '*') { // 물이 차있는 위치 
					q.add(new int[] { i, j, -1 });
				}
			}
		}
		// 입력
		q.add(new int[] { sr, sc, 0 });
		brr[sr][sc] = true;
		bfs();
		if (ans == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(ans);
		}

	}

	public static void bfs() {

		while (!q.isEmpty()) {
			int t[] = q.poll();
			int cx = t[0];
			int cy = t[1];
			int cnt = t[2];
			if (arr[cx][cy] == 'D') { // 비버의 굴
				ans = cnt;
				return;
			}
			if (cnt == -1) { // 물인 경우
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny] || arr[nx][ny] == 'X'
							|| arr[nx][ny] == 'D')
						continue;
					arr[nx][ny] = '*'; // 물로 채우기
					q.add(new int[] { nx, ny, -1 });
					brr[nx][ny] = true;
				}
			} else {
				for (int i = 0; i < dirs.length; i++) {
					int nx = cx + dirs[i][0];
					int ny = cy + dirs[i][1];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || brr[nx][ny] || arr[nx][ny] == 'X'
							|| arr[nx][ny] == '*')
						continue;

					q.add(new int[] { nx, ny, cnt + 1 });
					brr[nx][ny] = true;
				}
			}
		}
	}
}
